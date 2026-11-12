package com.medicine.clinic_api.exception;


public class PatientNotFoundException
        extends ResourceNotFoundException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}

