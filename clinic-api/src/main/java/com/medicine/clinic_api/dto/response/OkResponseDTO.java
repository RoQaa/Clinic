package com.medicine.clinic_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OkResponseDTO {
    private String status;
    private String message;
}
