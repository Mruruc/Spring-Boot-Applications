package com.mruruc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

//	@PostConstruct
//	public void run(){
//		StudentCard studentCard1 = new StudentCard(true, LocalDate.of(2023, 12, 29),
//				LocalDate.of(2026, 12, 29));
//
//		Student student1 = new Student("John", "Doe", Gender.MALE, "Computer Science",studentCard1);
//		service.addStudent(student1);
//
//
//		service.addStudent(new Student("Jane", "Doe", Gender.FEMALE, "Biology",
//				new StudentCard(true, LocalDate.of(2023, 1, 15), LocalDate.of(2026, 1, 15))));
//
//
//		service.addStudent(new Student("Alice", "Smith", Gender.FEMALE, "Mathematics",
//				new StudentCard(true, LocalDate.of(2023, 5, 10), LocalDate.of(2026, 5, 10))));
//
//
//		service.addStudent(new Student("Bob", "Johnson", Gender.MALE, "Physics",
//				new StudentCard(true, LocalDate.of(2023, 7, 7), LocalDate.of(2026, 7, 7))));
//
//
//		service.addStudent(new Student("Charlie", "Brown", Gender.MALE, "Literature",
//				new StudentCard(true, LocalDate.of(2023, 11, 20), LocalDate.of(2026, 11, 20))));
//	}
}
