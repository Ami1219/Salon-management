package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customexception.ServiceNotFoundException;
import com.example.model.Services;
import com.example.repository.ServicesRepository;
@Service
public class ServicesService {

	@Autowired
    private ServicesRepository servicesRepository;

    // Get all services
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }
    // Get a service by ID
    public Services getServiceById(Long id) {
        return servicesRepository.findById(id)
            .orElseThrow(() -> new ServiceNotFoundException("Service with id " + id + " not found"));
    }


    // Create a new service
    public Services createService(Services services) {
        return servicesRepository.save(services);
    }

    // Update an existing service
    public Services updateService(Long id, Services services) {
        Optional<Services> existingService = servicesRepository.findById(id);
        if (existingService.isPresent()) {
            Services updatedService = existingService.get();
            updatedService.setServiceName(services.getServiceName());
            updatedService.setDescription(services.getDescription());
            updatedService.setPrice(services.getPrice());
            updatedService.setInventoryItems(services.getInventoryItems()); // Update associated inventory
            return servicesRepository.save(updatedService);
        } else {
            return null; // Or throw an exception for service not found
        }
    }

    // Delete a service by ID
    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }
}

