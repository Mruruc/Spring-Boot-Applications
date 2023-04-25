package com.mruruc.repository;

import com.mruruc.model.CashCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CashCardRepository extends CrudRepository<CashCard,Long> {

}