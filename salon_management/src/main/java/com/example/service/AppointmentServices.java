package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customexception.ResourceNotFoundException;
import com.example.model.Appointment;
import com.example.repository.AppointmentRepository;

@Service
public class AppointmentServices {

	@Autowired
    private AppointmentRepository appointmentRepository;

    // Retrieve all appointments
	public List<Appointment> getAllAppointments() {
		        return appointmentRepository.findAll();
    }

    // Save an appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Retrieve an appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    // Update an appointment by ID
 // Method to update appointment
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        // Retrieve the appointment by id
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);

        if (existingAppointment.isPresent()) {
            // If the appointment exists, update it
            Appointment appointment = existingAppointment.get();
            appointment.setDateTime(updatedAppointment.getDateTime());
            appointment.setClient(updatedAppointment.getClient());
            appointment.setStaff(updatedAppointment.getStaff());
            // Set any other fields you want to update
            return appointmentRepository.save(appointment);  // Save the updated appointment
        } else {
            // If the appointment doesn't exist, handle the case (e.g., throw an exception)
            throw new ResourceNotFoundException("Appointment not found with id " + id);
        }
    }


    // Delete an appointment by ID
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

	
}

