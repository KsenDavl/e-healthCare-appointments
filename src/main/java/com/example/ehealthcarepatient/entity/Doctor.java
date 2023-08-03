package com.example.ehealthcarepatient.entity;

import com.example.ehealthcarepatient.enums.DocSpecialization;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "specialization")
    private DocSpecialization specialization;
    @Column(name = "room_no")
    private int roomNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Appointment> appointments;
}
