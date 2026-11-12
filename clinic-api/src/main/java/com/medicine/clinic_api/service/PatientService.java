package com.medicine.clinic_api.service;

import com.medicine.clinic_api.dto.request.PatientRequestDTO;
import com.medicine.clinic_api.dto.response.OkResponseDTO;
import com.medicine.clinic_api.dto.response.PatientResponseDTO;
import com.medicine.clinic_api.entity.Patient;
import com.medicine.clinic_api.exception.PatientNotFoundException;
import com.medicine.clinic_api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;


    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //    public List<PatientResponseDTO> getAllPatients() {
//        return patientRepository
//                .findAll()
//                .stream()
//                .map(patient -> new PatientResponseDTO(
//                        patient.getId(),
//                        patient.getFullName(),
//                        patient.getEmail(),
//                        patient.getGender(),
//                        patient.getCreatedAt()
//                )).toList();
//    }
    public Page<PatientResponseDTO> getAllPatients(
            Integer page,
            Integer size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Patient> result = patientRepository.findAll(pageable);

        return result.map(patient -> new PatientResponseDTO(
                                patient.getId(),
                                patient.getFullName(),
                                patient.getEmail(),
                                patient.getGender(),
                                patient.getCreatedAt()
                        )
                );
    }

    public PatientResponseDTO getPatientById(Integer id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        return new PatientResponseDTO(
                patient.getId(),
                patient.getFullName(),
                patient.getEmail(),
                patient.getGender(),
                patient.getCreatedAt()
        );
    }

    public OkResponseDTO addPatient(PatientRequestDTO request) {
        Patient patient = Patient.builder()
                .fullName(request.getFullName())
                .address(request.getAddress())
                .birthDate(request.getBirthDate())
                .bloodType(request.getBloodType())
                .email(request.getEmail())
                .phone(request.getPhone())
                .gender(request.getGender())
                .emergencyContact(request.getEmergencyContact())
                .build();
        patientRepository.save(patient);
        return new OkResponseDTO("success", "Patient created successfully");
    }

    public OkResponseDTO updatePatient(
            Integer id,
            PatientRequestDTO request
    ) {
        Patient found = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        found.setFullName(request.getFullName());
        found.setAddress(request.getAddress());
        found.setBirthDate(request.getBirthDate());
        found.setBloodType(request.getBloodType());
        found.setEmail(request.getEmail());
        found.setPhone(request.getPhone());
        found.setGender(request.getGender());
        found.setEmergencyContact(request.getEmergencyContact());
        patientRepository.save(found);
        return new OkResponseDTO("success", "Patient updated successfully");
    }

    public OkResponseDTO deletePatient(Integer id) {
        Patient found = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        patientRepository.delete(found);
        return new OkResponseDTO("success", "Patient deleted successfully");
    }

    public OkResponseDTO patchPatient(
            Integer id,
            PatientRequestDTO request
    ) {
        Patient found = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

        if (request.getFullName() != null)
            found.setFullName(request.getFullName());

        if (request.getEmail() != null)
            found.setEmail(request.getEmail());

        if (request.getPhone() != null)
            found.setPhone(request.getPhone());

        if (request.getAddress() != null)
            found.setAddress(request.getAddress());

        if (request.getBloodType() != null)
            found.setBloodType(request.getBloodType());

        if (request.getEmergencyContact() != null)
            found.setEmergencyContact(request.getEmergencyContact());

        patientRepository.save(found);

        return new OkResponseDTO("success", "Patient updated successfully");
    }

}
