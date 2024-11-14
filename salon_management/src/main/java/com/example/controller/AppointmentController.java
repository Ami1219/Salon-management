package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Appointment;
import com.example.service.AppointmentServices;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

	@Autowired
    private AppointmentServices appointmentServices;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentServices.getAllAppointments();
    }

    @PostMapping//Creates a new appointment.
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentServices.saveAppointment(appointment);
    }

    @GetMapping("/{id}")////Retrieves all appointments or a specific one by ID.
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentServices.getAppointmentById(id);
    }

    @PutMapping("/{id}")//Updates an existing appointment.
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        return appointmentServices.updateAppointment(id, updatedAppointment);
    }

    @DeleteMapping("/{id}")//Deletes an appointment by ID.
    public void deleteAppointment(@PathVariable Long id) {
        appointmentServices.deleteAppointment(id);
    }
}
   




/*@GetMapping("/appointments")
public ResponseEntity<List<Appointment>> getAppointments() {
    // Mock list of appointments, in a real-world scenario you would fetch this from a database
    List<Appointment> appointments = new ArrayList<>();
    appointments.add(new Appointment(1L, "John Doe", "2024-11-15", "10:00 AM"));
    appointments.add(new Appointment(2L, "Jane Smith", "2024-11-16", "11:00 AM"));
    appointments.add(new Appointment(3L, "Bob Johnson", "2024-11-17", "02:00 PM"));

    // Return appointments wrapped in ResponseEntity
    return ResponseEntity.ok(appointments); // 200 OK with the list of appointments
}*/