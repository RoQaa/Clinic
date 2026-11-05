package com.medicine.clinic_api.service;

import com.medicine.clinic_api.dto.DoctorResponseDTO;
import com.medicine.clinic_api.entity.Doctor;
import com.medicine.clinic_api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.math.BigDecimal;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

//    public List<Doctor> getAllDoctors() {
//        return doctorRepository.findAll();
//    }
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

    public List<Doctor> getDoctorInSpeciality(Integer specility_id){
        return doctorRepository.findAllBySpecialty_Id(specility_id);
    }

}
