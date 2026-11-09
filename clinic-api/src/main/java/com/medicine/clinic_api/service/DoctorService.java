package com.medicine.clinic_api.service;

import com.medicine.clinic_api.dto.request.DoctorRequestDTO;
import com.medicine.clinic_api.dto.response.DoctorResponseDTO;
import com.medicine.clinic_api.entity.Doctor;
import com.medicine.clinic_api.entity.Specialty;
import com.medicine.clinic_api.repository.DoctorRepository;
import com.medicine.clinic_api.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository) {
        this.doctorRepository = doctorRepository;
        this.specialtyRepository = specialtyRepository;
    }

    public DoctorResponseDTO createDoctor(DoctorRequestDTO request) {
        Specialty specialty = specialtyRepository
                .findById(request.getSpecialtyId())
                .orElseThrow(() -> new RuntimeException("Specialty not found"));

        Doctor doctor = Doctor.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .salary(request.getSalary())
                .specialty(specialty)
                .build();

        Doctor saved = doctorRepository.save(doctor);
        DoctorResponseDTO res = new DoctorResponseDTO(
                saved.getId(),
                saved.getFullName(),
                saved.getEmail(),
                saved.getSpecialty().getName(),
                saved.isActive());
        return res;

    }

    public List<DoctorResponseDTO> getAllDoctors() {

        return doctorRepository.findAll()
                .stream()
                .map(doctor -> new DoctorResponseDTO(
                        doctor.getId(),
                        doctor.getFullName(),
                        doctor.getEmail(),
                        doctor.getSpecialty().getName(),
                        doctor.isActive()
                ))
                .toList();
    }

    public long getDoctorsCount() {
        return doctorRepository.count();
    }

    public List<Doctor> searchDoctorsByName(String name) {
        return doctorRepository.findByFullNameContaining(name);
    }

    public List<Doctor> searchDoctorsBySalaryGreaterThan(BigDecimal salary) {
        return doctorRepository.findAllBySalaryGreaterThanAndActiveTrueOrderBySalaryDesc(salary);
    }

    public List<Doctor> getDoctorInSpeciality(Integer specility_id) {
        return doctorRepository.findAllBySpecialty_Id(specility_id);
    }

}
