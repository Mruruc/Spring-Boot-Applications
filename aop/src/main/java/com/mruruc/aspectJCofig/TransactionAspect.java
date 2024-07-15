package com.mruruc.aspectJCofig;

import com.mruruc.exceptions.DAOException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {
    private final EntityManagerFactory emf;
    private  EntityManager entityManager;
    private EntityTransaction entityTransaction;

    @Autowired
    public TransactionAspect(@Qualifier("entityManagerFactory") EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Before(value = "execution(public * com.mruruc.repository.GenericRepositoryImpl2.*(..))")
    public void before() {
        this.entityManager = emf.createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
        this.entityTransaction.begin();
        System.out.println("Transaction starting ... ");
    }

    @After(value = "execution(public * com.mruruc.repository.GenericRepositoryImpl2.*(..))")
    public void after() {
        if (entityTransaction != null && entityTransaction.isActive())
            entityTransaction.commit();
        entityManager.close();
        System.out.println("Transaction Committed.");
    }

    @AfterThrowing(throwing = "t", pointcut = "execution(public * com.mruruc.repository.GenericRepositoryImpl2.*(..))")
    public void onException(Throwable t) throws DAOException {
        if (entityTransaction != null && entityTransaction.isActive()) {
            entityTransaction.rollback();
            System.out.println("Transaction Rolled Back.");
        }
        entityManager.close();
        throw new DAOException(t);
    }

    public EntityManager getEntityManager(){
        return this.entityManager;
    }
}
