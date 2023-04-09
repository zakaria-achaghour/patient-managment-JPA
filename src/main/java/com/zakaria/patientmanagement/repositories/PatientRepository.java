package com.zakaria.patientmanagement.repositories;

import com.zakaria.patientmanagement.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
}
