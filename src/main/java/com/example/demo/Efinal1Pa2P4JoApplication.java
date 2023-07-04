package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.CitaMedicaService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PacienteService;

@SpringBootApplication
public class Efinal1Pa2P4JoApplication implements CommandLineRunner {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired 
	private PacienteService pacienteService;
	
	@Autowired
	private CitaMedicaService citaMedicaService;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P4JoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//1. Insertar Doctor
		
		Doctor doct = new Doctor();
		doct.setNombre("Jimmy");
		doct.setApellido("Ortega");
		doct.setCedula("0105966337");
		doct.setFechaNacimiento(LocalDateTime.now());
		doct.setGenero("M");
		doct.setNumeroConsultorio("2a");
		doct.setCodigoSenescyt("abc");
		
		this.doctorService.insertar(doct);
		
		//2. Insertar y actualizar Paciente
		//2.1 InsertarPaciente 
		
		Paciente paci = new Paciente();
		paci.setNombre("Fabricio");
		paci.setCedula("333");
		paci.setCodigoSeguro("xyz");
		paci.setEstatura("1.65");
		paci.setGenero("M");
		paci.setPeso("50 kg");
		paci.setFechaNacimiento(LocalDateTime.now());
		
		
		this.pacienteService.insertar(paci);
		//2.2 Actualizar
		
		
		paci.setApellido("Salinas");
		paci.setEstatura("1.67");
		paci.setPeso("55 Kg");
		paci.setGenero("F");
		paci.setCedula("2222");
		paci.setId(1);
		this.pacienteService.actualizar(paci);
		
		
		//3. Agendar Cita
		this.citaMedicaService.agendar("2", LocalDateTime.now(), new BigDecimal(12), "Centro", "0105966337", "2222");
		
		//4.Actualizar agendamiento
		
		
		this.citaMedicaService.actualizarCita("2", "Leve dolor en la cabeza", "Paracetamol", LocalDateTime.now());
		
	}

}
