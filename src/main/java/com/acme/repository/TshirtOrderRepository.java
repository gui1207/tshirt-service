package com.acme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acme.entity.TshirtOrder;

@Repository
public interface TshirtOrderRepository extends CrudRepository<TshirtOrder, Long> {

}
