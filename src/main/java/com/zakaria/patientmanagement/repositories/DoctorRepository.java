package com.zakaria.patientmanagement.repositories;

import com.zakaria.patientmanagement.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByName(String name);
}
