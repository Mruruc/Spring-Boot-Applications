package com.mruruc.repository;

import com.mruruc.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomQuery implements CustomQueryInterface<Student>{
    @PersistenceContext
    EntityManager entityManager ;

    @Override
    public List<Student> findStudentByName(String name) {
        TypedQuery<Student> query=
                entityManager.createQuery
                        ("SELECT e FROM Student e WHERE e.name= :InputName ",Student.class);

        query.setParameter("InputName",name);

        return query.getResultList();
    }
}
