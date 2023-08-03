package com.example.ehealthcarepatient.repository;

import com.example.ehealthcarepatient.entity.Doctor;
import com.example.ehealthcarepatient.enums.DocSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

    List<Doctor> findAllBySpecialization(DocSpecialization specialization);
}
