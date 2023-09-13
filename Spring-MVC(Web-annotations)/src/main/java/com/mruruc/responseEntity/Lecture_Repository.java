package com.mruruc.responseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Lecture_Repository extends JpaRepository<Lecture,Integer> {
}
