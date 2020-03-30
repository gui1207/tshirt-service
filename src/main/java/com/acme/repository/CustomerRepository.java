    
package com.acme.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.acme.entity.CustomerEntity;


@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {


}