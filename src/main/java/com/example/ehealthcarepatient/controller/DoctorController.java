package com.example.ehealthcarepatient.controller;

import com.example.ehealthcarepatient.dto.response.AvailableTimeSlotsForTheDayDto;
import com.example.ehealthcarepatient.entity.Doctor;
import com.example.ehealthcarepatient.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/doctor/all/{specialization}")
    public ResponseEntity<List<Doctor>> getAllDoctorsBySpecialization(@PathVariable String specialization) {
        return ResponseEntity.ok().body(doctorService.getAllDoctorsBySpecialization(specialization));
    }

    @GetMapping("/doctor/all-specializations")
    public ResponseEntity<List<String>> getAllSpecializations() {
        return ResponseEntity.ok().body(doctorService.getAllSpecializations());
    }

    @GetMapping("/doctor/{doctorId}/timeslots")
    public ResponseEntity<List<AvailableTimeSlotsForTheDayDto>> getAvailableTimeSlotsForTheDay(@PathVariable long doctorId,
                                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok().body(doctorService.getAvailableTimeSlots(doctorId, date));
    }

}
