package com.zakaria.patientmanagement.services;

import com.zakaria.patientmanagement.models.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    Patient add(Patient patient);
    Patient edit(Long id, Patient patient);
    Patient get(Long id);
    List<Patient> all();
    boolean delete(Long id);

}
