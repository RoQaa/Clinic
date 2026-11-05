package com.medicine.clinic_api.repository;

import com.medicine.clinic_api.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findBySalaryLessThan(BigDecimal salaryIsLessThan);

    List<Doctor> findAllBySalaryGreaterThan(BigDecimal salaryIsGreaterThan);

    List<Doctor> findByFullNameContaining(String keyword);

    List<Doctor> findAllByEmailContaining(String email);

    Optional<Doctor> findByLicenseNumber(String licenseNumber);

    List<Doctor> findAllBySpecialty_Id(Integer specialtyId);

    List<Doctor> findAllByActiveOrderByHireDateDesc(boolean active);

    List<Doctor> findAllBySalaryGreaterThanAndActiveTrueOrderBySalaryDesc(
            BigDecimal salary
    );

    // JBQL && @Query
    @Query("SELECT d FROM Doctor d WHERE d.specialty.id = :specialtyId")
    List<Doctor> findDoctorsBySpecialtyId(
            @Param("specialtyId") Integer specialtyId
    );

    @Query("""
            SELECT d
            FROM Doctor d
            WHERE d.salary > :salary
              AND d.active = true
            ORDER BY d.salary DESC
            """)
    List<Doctor> findBySalaryRange(@Param("salary") BigDecimal salary);

    @Query(value = "SELECT * FROM Doctors", nativeQuery = true)
    List<Doctor> findAllDoctorsNative();
}
