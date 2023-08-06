package com.example.ehealthcarepatient.entity;

import com.example.ehealthcarepatient.enums.TimeSlot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_generator")
    @SequenceGenerator(name = "app_generator", sequenceName = "appointments_seq", allocationSize = 1)
    private long id;

    @JoinColumn(name = "patient_id")
    @ManyToOne
    private Patient patient;

    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private Doctor doctor;

    @Column(name = "app_date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_slot")
    private TimeSlot timeSlot;

}
