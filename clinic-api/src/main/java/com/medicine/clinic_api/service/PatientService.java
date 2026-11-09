package com.medicine.clinic_api.service;

import com.medicine.clinic_api.entity.Patient;
import com.medicine.clinic_api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;


    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public void createPatient(Patient patient) {
        patientRepository.save(patient);
        System.out.println("Patient Created Successfully");
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
        System.out.println("Patient deleted Successfully");
    }


}
