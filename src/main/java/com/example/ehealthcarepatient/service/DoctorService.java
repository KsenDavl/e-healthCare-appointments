package com.example.ehealthcarepatient.service;

import com.example.ehealthcarepatient.entity.Doctor;
import com.example.ehealthcarepatient.entity.DoctorAvailableTimeSlot;
import com.example.ehealthcarepatient.enums.DocSpecialization;
import com.example.ehealthcarepatient.repository.DoctorAvailableTimeSlotRepository;
import com.example.ehealthcarepatient.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorAvailableTimeSlotRepository timeSlotRepository;

    public List<Doctor> getAllDoctorsBySpecialization(String specialization) {
        DocSpecialization docSpecialization =
                DocSpecialization.getByName(specialization).orElseThrow();
        return doctorRepository.findAllBySpecialization(docSpecialization);
    }
    public List<String> getAllSpecializations() {
        return Arrays.stream(DocSpecialization.values()).map(DocSpecialization::getFullName).toList();
    }

    public List<DoctorAvailableTimeSlot> getAvailableTimeSlots(long doctorId, LocalDate date) {
        return timeSlotRepository.getDoctorAvailableTimeSlotByDoctorIdAndDate(doctorId, date);
    }

}
