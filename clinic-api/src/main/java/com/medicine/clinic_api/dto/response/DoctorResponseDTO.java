package com.medicine.clinic_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DoctorResponseDTO {
    private Integer id;
    private String fullName;
    private String email;
    private String specialtyName;
    private boolean active;
}
