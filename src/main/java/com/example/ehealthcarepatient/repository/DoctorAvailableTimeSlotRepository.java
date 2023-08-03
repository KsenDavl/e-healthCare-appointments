package com.example.ehealthcarepatient.repository;

import com.example.ehealthcarepatient.entity.DoctorAvailableTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorAvailableTimeSlotRepository extends JpaRepository<DoctorAvailableTimeSlot, Long> {

    List<DoctorAvailableTimeSlot> getDoctorAvailableTimeSlotByDoctorIdAndDate(long doctorId, LocalDate date);
}
