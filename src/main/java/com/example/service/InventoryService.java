package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customexception.ResourceNotFoundException;
import com.example.model.Inventory;
import com.example.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public Inventory saveInventoryItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory getInventoryItemById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id " + id));
    }

    public Inventory updateInventoryItem(Long id, Inventory updatedInventory) {
        Inventory existingInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id " + id));

        existingInventory.setItemName(updatedInventory.getItemName());
        existingInventory.setQuantity(updatedInventory.getQuantity());
        // Set other fields as needed

        return inventoryRepository.save(existingInventory);
    }

    public void deleteInventoryItem(Long id) {
        Inventory existingInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id " + id));

        inventoryRepository.delete(existingInventory);
    }
}