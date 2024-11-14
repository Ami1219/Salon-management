package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Staff;
import com.example.repository.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        Optional<Staff> existingStaff = staffRepository.findById(id);
        if (existingStaff.isPresent()) {
            Staff staff = existingStaff.get();
            staff.setName(updatedStaff.getName());
            staff.setRole(updatedStaff.getRole());
            // Set other fields as needed
            return staffRepository.save(staff);
        } else {
            return null; // Or throw an exception if preferred
        }
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}