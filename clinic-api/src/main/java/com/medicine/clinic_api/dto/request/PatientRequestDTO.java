package com.medicine.clinic_api.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class PatientRequestDTO {

    @NotBlank
    @Size(max=150)
    private String fullName;

    @Email
    @Size(max = 150)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String phone;

    @NotNull
    @Past
    private LocalDate birthDate;

    @NotBlank
    @Pattern(regexp = "[MF]")
    private String gender;

    @Size(max = 250)
    private String address;

    @Pattern(regexp = "(O|A|B|AB)[+-]")
    private String bloodType;

    @Size(max = 20)
    private String emergencyContact;
}
