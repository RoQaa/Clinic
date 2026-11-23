package com.medicine.clinic_api.repository;

import com.medicine.clinic_api.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Page<Patient> findByGender(String gender, Pageable pageable);

    Page<Patient> findByBloodType(String bloodType,Pageable pageable);
}
