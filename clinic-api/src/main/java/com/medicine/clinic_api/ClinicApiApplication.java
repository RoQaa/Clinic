package com.medicine.clinic_api;

import com.medicine.clinic_api.entity.Doctor;
import com.medicine.clinic_api.repository.DoctorRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ClinicApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(DoctorRepository doctorRepository) {
        return args -> {
            List<Doctor> doctors = doctorRepository.findAll();
            doctors.forEach(doctor -> {
                        System.out.println(doctor.getId());
                        System.out.println(doctor.getFullName());
                        System.out.println(doctor.getEmail());
                    }
            );
        };
    }
}
