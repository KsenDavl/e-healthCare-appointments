package com.example.ehealthcarepatient.controller;

import com.example.ehealthcarepatient.entity.Doctor;
import com.example.ehealthcarepatient.entity.DoctorAvailableTimeSlot;
import com.example.ehealthcarepatient.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/doctor/all/{specialization}")
    public List<Doctor> getAllDoctorsBySpecialization(@PathVariable String specialization) {
        return doctorService.getAllDoctorsBySpecialization(specialization);
    }

    @GetMapping("/doctor/all-specializations")
    public List<String> getAllSpecializations() {
        return doctorService.getAllSpecializations();
    }

    @GetMapping("/doctor/{doctorId}/timeslots/{date}")
    public List<DoctorAvailableTimeSlot> getAvailableTimeSlots(@PathVariable long doctorId, @PathVariable LocalDate date) {
        return doctorService.getAvailableTimeSlots(doctorId, date);
    }

}
