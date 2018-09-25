package com.acme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acme.entity.InventoryItem;

@Repository
public interface InventoryItemRepository extends CrudRepository<InventoryItem, Integer> {

}
