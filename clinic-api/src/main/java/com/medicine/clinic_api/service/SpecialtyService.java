package com.medicine.clinic_api.service;

import com.medicine.clinic_api.entity.Specialty;
import com.medicine.clinic_api.exception.SpecialtyNotFoundException;
import com.medicine.clinic_api.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    public Page<Specialty> getAll(
            Integer page,
            Integer size,
            String sortBy,
            String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return specialtyRepository.findAll(pageable);
    }

    public Specialty getSpecialityById(Integer id) {
        return specialtyRepository.findById(id).orElseThrow(() -> new SpecialtyNotFoundException("Specialty not found"));
    }

}
