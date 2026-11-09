package com.medicine.clinic_api.repository;

import com.medicine.clinic_api.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
