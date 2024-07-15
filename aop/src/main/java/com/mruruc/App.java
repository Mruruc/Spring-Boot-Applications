package com.mruruc;


import com.mruruc.app_config.Config;
import com.mruruc.custom_aop.Aspect;
import com.mruruc.custom_aop.AspectInvocationHandler;
import com.mruruc.jpa_util.JPAUtil;
import com.mruruc.model.Employee;
import com.mruruc.repository.GenericRepository;
import com.mruruc.repository.GenericRepositoryImpl;
import com.mruruc.repository.GenericRepositoryImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Employee employee = new Employee("Bob", "Doe", "bob@doe2121", 2500.0, LocalDate.now());

//        Aspect aspect = new Aspect();
//        GenericRepository<Employee,Long> repository = new GenericRepositoryImpl<>(Employee.class,aspect);
//
//        GenericRepository<Employee, Long> proxyRepo = AspectInvocationHandler.createProxy(repository, aspect);
//        proxyRepo.findAll().forEach(System.out::println);
//
//        JPAUtil.shutDown();

        var applicationContext = new AnnotationConfigApplicationContext(Config.class);

        GenericRepositoryImpl2<Employee,Long> bean =
                applicationContext.getBean(GenericRepositoryImpl2.class);
      //  System.out.println(bean.save(employee));
      //  System.out.println(bean.findById(3L));
        bean.findAll().forEach(System.out::println);

        applicationContext.close();

    }
}
