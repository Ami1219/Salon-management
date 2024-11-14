package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Services;
import com.example.service.ServicesService;

@RestController
@RequestMapping("/api/services")
public class ServicesController {
	
	@Autowired
    private ServicesService serviceService;

    @GetMapping
    public List<Services> getAllServices() {
        return serviceService.getAllServices();
    }

    @PostMapping
    public Services createService(@RequestBody Services services) {
        return serviceService.createService(services);
    }

    @PutMapping("/{id}")
    public Services updateService(@PathVariable Long id, @RequestBody Services services) {
        return serviceService.updateService(id, services);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }
}


