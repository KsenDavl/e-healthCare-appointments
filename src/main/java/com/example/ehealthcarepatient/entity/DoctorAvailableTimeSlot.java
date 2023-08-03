package com.example.ehealthcarepatient.entity;

import com.example.ehealthcarepatient.enums.TimeSlot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "timeslots")
@NoArgsConstructor
@AllArgsConstructor
public class DoctorAvailableTimeSlot {

    @Id
    private long id;

    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private Doctor doctor;

    @Column(name = "app_date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_spot")
    private TimeSlot timeSpot;



}
