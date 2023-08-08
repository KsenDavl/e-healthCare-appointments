package com.example.ehealthcarepatient.controller;

import com.example.ehealthcarepatient.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    //todo get patientId from principal
    @PostMapping("appointment/{patientId}/{timeSlotId}")
    public ResponseEntity<Void> createAppointment(@PathVariable long patientId, @PathVariable long timeSlotId) {
        appointmentService.createAppointment(patientId, timeSlotId);
        return ResponseEntity.ok().build();
    }

}
