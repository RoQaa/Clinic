package com.medicine.clinic_api.repository;

import com.medicine.clinic_api.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty,Integer> {
}
