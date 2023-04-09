package com.zakaria.patientmanagement.services;

import com.zakaria.patientmanagement.models.Appointment;
import com.zakaria.patientmanagement.models.Consultation;
import com.zakaria.patientmanagement.models.Doctor;
import com.zakaria.patientmanagement.models.Patient;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Doctor saveDoctor(Doctor doctor);
    Appointment saveAppointment(Appointment appointment);
    Consultation saveConsultation(Consultation consultation);
}
