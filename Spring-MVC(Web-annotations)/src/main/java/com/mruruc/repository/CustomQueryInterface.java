package com.mruruc.repository;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CustomQueryInterface <Student>{
   List<Student> findStudentByName(String name);

}
