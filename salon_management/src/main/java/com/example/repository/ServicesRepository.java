package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Services;

public interface ServicesRepository extends JpaRepository<Services, Long> {
}
