package com.zakaria.patientmanagement.services.impl;

import com.zakaria.patientmanagement.models.Patient;
import com.zakaria.patientmanagement.repositories.PatientRepository;
import com.zakaria.patientmanagement.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient add(Patient patient) {
       return this.patientRepository.save(patient);
    }

    @Override
    public Patient edit(Long id, Patient patient) {
        Patient patient1 = this.patientRepository.findById(id).orElse(null);
        if (patient1 == null){
            throw new RuntimeException("Patient not found");
        }
        patient1.setBirthdate(patient.getBirthdate());
        patient1.setName(patient.getName());
        patient1.setScore(patient.getScore());
        patient1.setSick(patient.isSick());
        return this.patientRepository.save(patient1);
    }

    @Override
    public Patient get(Long id) {
        Patient patient = this.patientRepository.findById(id).orElse(null);
        if (patient == null){
            throw new RuntimeException("Patient not found");
        }
        return patient;
    }

    @Override
    public List<Patient> all() {
        return this.patientRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        Patient patient = this.patientRepository.findById(id).orElse(null);
        if (patient == null){
            throw new RuntimeException("Patient not found");
        }
        this.patientRepository.delete(patient);
        return true;
    }
}
