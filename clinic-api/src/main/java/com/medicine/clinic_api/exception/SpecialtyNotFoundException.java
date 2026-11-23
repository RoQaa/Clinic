package com.medicine.clinic_api.exception;

public class SpecialtyNotFoundException extends ResourceNotFoundException {
    public SpecialtyNotFoundException(String message) {
        super(message);
    }
}
