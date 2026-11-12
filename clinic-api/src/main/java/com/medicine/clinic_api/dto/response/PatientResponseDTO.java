package com.medicine.clinic_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class PatientResponseDTO {
    private int id;
    private String fullName;
    private String email;
    private String gender;
    private LocalDateTime createdAt;
}
