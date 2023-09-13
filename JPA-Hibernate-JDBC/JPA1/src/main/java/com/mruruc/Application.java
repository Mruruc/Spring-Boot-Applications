package com.mruruc;

import com.mruruc.student.Student;
import com.mruruc.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
    CommandLineRunner commandLineRunner(StudentRepository repo){
		return args ->{
			Student student1=new Student(
					"Shipo",
					"Mipo",
					8,
					"shipoo@gmail.com"
			);
			repo.save(student1);
		};
	}

}
