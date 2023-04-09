package com.zakaria.patientmanagement;

import com.zakaria.patientmanagement.models.*;
import com.zakaria.patientmanagement.repositories.AppointmentRepository;
import com.zakaria.patientmanagement.repositories.DoctorRepository;
import com.zakaria.patientmanagement.repositories.PatientRepository;
import com.zakaria.patientmanagement.services.IHospitalService;
import com.zakaria.patientmanagement.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagementApplication.class, args);
	}
	/*@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							DoctorRepository doctorRepository,
							AppointmentRepository appointmentRepository) {
		return args -> {
			Stream.of("Mohamed", "Zakaria", "Hamza")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setName(name);
						patient.setBirthdate(new Date());
						patient.setSick(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("ayman", "Hamza", "mouad")
					.forEach(name -> {
						Doctor doctor = new Doctor();
						doctor.setName(name);
						doctor.setEmail(name + "@gmail.com");
						doctor.setSpecialty(Math.random() > 0.5 ? "Cardio" : "Dentiste");
						hospitalService.saveDoctor(doctor);
					});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByName("zakaria");

			Doctor doctor = doctorRepository.findByName("mouad");

			Appointment appointment = new Appointment();
			appointment.setDate(new Date());
			appointment.setStatus(Status.PENDING);
			appointment.setPatient(patient);
			appointment.setDoctor(doctor);
			Appointment savedAppointment = hospitalService.saveAppointment(appointment);
			Appointment appointment1 = appointmentRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDate(new Date());
			consultation.setAppointment(appointment1);
			consultation.setRapport("Rapport of the consultation");
			hospitalService.saveConsultation(consultation);
		};
	}*/
		@Bean
		CommandLineRunner start2(UserService userService){
			return args -> {
				User u = new User();
				u.setName("user1");
				u.setPassword("123456");
				userService.addNewUser(u);

				User u2=new User();
				u2.setName("admin");
				u2.setPassword("123456");
				userService.addNewUser(u2);

				Stream.of("DOCTOR", "USER", "ADMIN").forEach(r->{
					Role role1=new Role();
					role1.setName(r);
					userService.addNewRole(role1);
				});

				userService.addRoleToUser("user1", "DOCTOR");
				userService.addRoleToUser("user1", "USER");
				userService.addRoleToUser("admin", "USER");
				userService.addRoleToUser("admin", "ADMIN");

				try {
					User user=userService.authenticate("user1", "123456");
					System.out.println(user.getId());
					System.out.println(user.getName());
					System.out.println("Roles ==> ");
					user.getRoles().forEach(r -> {
						System.out.println("Role => " + r);
					});
				}
				catch (Exception e){
					e.printStackTrace();
				}

			};
	}
}
