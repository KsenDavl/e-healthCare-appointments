package com.example.ehealthcarepatient.controller;

import com.example.ehealthcarepatient.entity.Doctor;
import com.example.ehealthcarepatient.enums.DocSpecialization;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorsController {

    public List<Doctor> getAllDoctorsBySpecialization(String specialization) {
        return null;
    }

    public List<DocSpecialization> getAllAvailableSpecializations() {
        return null;
    }
}
