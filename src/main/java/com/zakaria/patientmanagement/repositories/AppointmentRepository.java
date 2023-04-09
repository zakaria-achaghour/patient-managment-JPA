package com.zakaria.patientmanagement.repositories;

import com.zakaria.patientmanagement.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
}
