package com.mruruc;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.hibernate.Transaction;
import org.hibernate.sql.exec.spi.JdbcOperationQueryMutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootJpaStarterApplication {

/*	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	*/
/*	@PersistenceContext
	private EntityManager entityManager;*/

	@Autowired
	private EmployeeRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaStarterApplication.class, args);
	}
	@PostConstruct            //with this annotation our method will run when application start.
	public void start(){
		Employee employee=new Employee();
		employee.setId(UUID.fromString("762598d5-115c-48dd-a46d-4224c27a8e97"));
		employee.setName("Nello");
		employee.setDate_of_birth(new Date());

	//	EntityManager entityManager =  entityManagerFactory.createEntityManager();

	/*	EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.persist(employee);

		transaction.commit();

		entityManager.close();*/

		//find the employee:
	/*	Employee employee1 = entityManager.find(Employee.class, UUID.fromString("762598d5-115c-48dd-a46d-4224c27a8e97"));
		System.out.println(employee1);*/

	//	repo.save(employee);
	//	saveEmployee(employee);

		Optional<Employee> employee1 = repo.findById(UUID.fromString("3e4f014c-4148-480d-bac2-2accc0d04345"));
		if(employee1.isPresent()){
			System.out.println(employee1);
		}
		else{
			System.out.println("Employee does not exists");
		}
	}
	@Transactional // the way spring handle the transaction
	public void saveEmployee(Employee employee){
		repo.save(employee);
	}




}
