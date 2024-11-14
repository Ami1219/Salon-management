package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	 // Custom query methods for Inventory (if needed) can go here
}
