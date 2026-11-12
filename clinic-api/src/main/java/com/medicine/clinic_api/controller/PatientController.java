package com.medicine.clinic_api.controller;

import com.medicine.clinic_api.dto.request.PatientRequestDTO;
import com.medicine.clinic_api.dto.response.OkResponseDTO;
import com.medicine.clinic_api.dto.response.PatientResponseDTO;
import com.medicine.clinic_api.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@Validated
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    Page<PatientResponseDTO> getAllPatients(
            @RequestParam(value = "page", defaultValue = "0") @Min(0) Integer page,
            @RequestParam(value = "size", defaultValue = "10") @Min(1) @Max(100) Integer size,
            @RequestParam(value = "sortBy", defaultValue = "id") @Pattern(regexp = "^(id|fullName|email|gender|createdAt)$") String sortBy,
            @RequestParam(value = "direction", defaultValue = "desc") @Pattern(regexp = "(?i)^(asc|desc)$") String direction
    ) {
        return patientService.getAllPatients(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public PatientResponseDTO getPatientById(@PathVariable("id") Integer id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public OkResponseDTO addPatient(@Valid @RequestBody PatientRequestDTO request) {
        return patientService.addPatient(request);
    }

    @PutMapping("/{id}")
    public OkResponseDTO updatePatient(
            @PathVariable("id") Integer id,
            @Valid @RequestBody PatientRequestDTO request
    ) {
        return patientService.updatePatient(id, request);
    }

    @DeleteMapping("/{id}")
    public OkResponseDTO deletePatient(@PathVariable("id") Integer id) {
        return patientService.deletePatient(id);
    }

    @PatchMapping("/{id}")
    public OkResponseDTO patchPatient(
            @PathVariable Integer id,
            @RequestBody PatientRequestDTO request
    ) {
        return patientService.patchPatient(id, request);
    }

}
