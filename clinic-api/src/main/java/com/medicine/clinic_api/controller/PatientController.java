package com.medicine.clinic_api.controller;

import com.medicine.clinic_api.entity.Patient;
import com.medicine.clinic_api.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    List<Patient> getAllPatients(){
      return patientService.getAllPatients();
    }

    @GetMapping("/{patient_id}")
    public Optional<Patient> getPatientById(@PathVariable Integer patient_id) {
        return patientService.getPatientById(patient_id);
    }
    // TODO: create,update,delete
}
