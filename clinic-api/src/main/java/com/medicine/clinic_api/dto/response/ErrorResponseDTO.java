package com.medicine.clinic_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorResponseDTO {
    private int status;
    private List<String> errors;
    private LocalDateTime timestamp;
}
