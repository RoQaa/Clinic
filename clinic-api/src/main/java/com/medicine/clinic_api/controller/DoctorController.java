package com.medicine.clinic_api.controller;

import com.medicine.clinic_api.dto.request.DoctorRequestDTO;
import com.medicine.clinic_api.dto.response.DoctorResponseDTO;
import com.medicine.clinic_api.entity.Doctor;
import com.medicine.clinic_api.service.DoctorService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    //  @GetMapping
//    public List<Doctor> getAllDoctors() {
//        return doctorService.getAllDoctors();
//    }
    @GetMapping
    public Page<DoctorResponseDTO> getAllDoctors(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(100) Integer size,
            @RequestParam(defaultValue = "id") List<String> sortBy,
            @RequestParam(defaultValue = "desc") List<String> directions
    ) {
        return doctorService.getAllDoctors(page, size, sortBy, directions);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorByid(@PathVariable("id") Integer id){
        return doctorService.getDoctorById(id);
    }
    @GetMapping("/count")
    public long getDoctorsCount() {
        return doctorService.getDoctorsCount();
    }

    //@RequestParam(required = false) String name
    @GetMapping("/search")
    public List<Doctor> searchDoctorsByName(
            @RequestParam(defaultValue = "") String name
    ) {
        return doctorService.searchDoctorsByName(name);
    }

    @GetMapping("/search/salary")
    public List<Doctor> searchDoctorsBySalaryGreaterThan(@RequestParam BigDecimal min) {
        return doctorService.searchDoctorsBySalaryGreaterThan(min);
    }

    @GetMapping("/specialty/{specility_id}")
    public List<Doctor> getDoctorInSpeciality(@PathVariable Integer specility_id) {
        return doctorService.getDoctorInSpeciality(specility_id);
    }
    @PostMapping
    public DoctorResponseDTO createDoctor(@RequestBody DoctorRequestDTO request) {
        return doctorService.createDoctor(request);
    }
}
