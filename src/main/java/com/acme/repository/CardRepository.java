package com.acme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acme.entity.CardEntity;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Integer> {

}
