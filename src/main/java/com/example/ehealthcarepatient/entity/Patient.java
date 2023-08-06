package com.example.ehealthcarepatient.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    private long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "pass_no", unique = true)
    private String passNo;
    @Column(name = "address")
    private String address;
    @Column(name = "work_info")
    private String workInfo;
    @Column(name = "phone_number")
    private long phoneNumber;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "blood_group")
    private int bloodGroup;
    @Column(name = "rh_factor")
    private boolean rhFactor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Appointment> appointments;
}
