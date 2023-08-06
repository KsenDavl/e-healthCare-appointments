package com.example.ehealthcarepatient.service;

import com.example.ehealthcarepatient.entity.Appointment;
import com.example.ehealthcarepatient.entity.DoctorAvailableTimeSlot;
import com.example.ehealthcarepatient.entity.Patient;
import com.example.ehealthcarepatient.mapper.TimeSlotMapper;
import com.example.ehealthcarepatient.repository.AppointmentRepository;
import com.example.ehealthcarepatient.repository.DoctorAvailableTimeSlotRepository;
import com.example.ehealthcarepatient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorAvailableTimeSlotRepository timeSlotRepository;
    private final PatientRepository patientRepository;

    private final TimeSlotMapper timeSlotMapper;


    @Transactional
    public void createAppointment(long patientId, long timeSlotId) {
        DoctorAvailableTimeSlot timeSlot = timeSlotRepository.findById(timeSlotId)
                .orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Appointment appointment = timeSlotMapper.toAppointment(timeSlot);
        appointment.setPatient(patient);
        appointmentRepository.save(appointment);
        timeSlotRepository.delete(timeSlot);
    }
}
