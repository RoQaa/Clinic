package com.medicine.clinic_api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class DoctorRequestDTO {
    private String fullName;
    private String email;
    private String phone;
    private String licenseNumber;
    private LocalDate birthDate;
    private String gender;
    private String address;
    private LocalDate hireDate;
    private BigDecimal salary;
    private Integer specialtyId;
}
