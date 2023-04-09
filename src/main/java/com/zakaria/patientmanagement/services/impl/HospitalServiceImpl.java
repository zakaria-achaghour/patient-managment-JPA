package com.zakaria.patientmanagement.services.impl;

import com.zakaria.patientmanagement.models.Appointment;
import com.zakaria.patientmanagement.models.Consultation;
import com.zakaria.patientmanagement.models.Doctor;
import com.zakaria.patientmanagement.models.Patient;
import com.zakaria.patientmanagement.repositories.AppointmentRepository;
import com.zakaria.patientmanagement.repositories.ConsultaionRepository;
import com.zakaria.patientmanagement.repositories.DoctorRepository;
import com.zakaria.patientmanagement.repositories.PatientRepository;
import com.zakaria.patientmanagement.services.IHospitalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
   private PatientRepository patientRepository;
   private DoctorRepository doctorRepository;
   private ConsultaionRepository consultaionRepository;
   private AppointmentRepository appointmentRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository, ConsultaionRepository consultaionRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.consultaionRepository = consultaionRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        appointment.setId(UUID.randomUUID());
        return appointmentRepository.save(appointment);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultaionRepository.save(consultation );
    }
}
