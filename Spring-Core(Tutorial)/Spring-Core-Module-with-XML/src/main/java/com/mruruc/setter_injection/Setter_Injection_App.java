package com.mruruc.setter_injection;


import com.mruruc.setter_injection.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class Setter_Injection_App {

	public static void main(String[] args) {

		var context=
				new ClassPathXmlApplicationContext("spring.xml");

		Triangle triangle =(Triangle) context.getBean("triangle");
		System.out.println(triangle.getType());
		triangle.draw();

		Triangle triangle2=(Triangle) context.getBean("triangle2");
		triangle2.draw();
		System.out.println(triangle2.getType());

		System.out.println("========List Of Bean ============");
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


		context.close();
	}

}
