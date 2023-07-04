package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CitaMedicaRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;



@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {
	
	@Autowired
	private CitaMedicaRepository citaMedicaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired 
	private DoctorRepository doctorRepository;
	
	

	@Override
	public void agendar(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		
		Paciente paci = this.pacienteRepository.buscar(cedulaPaciente);
		Doctor doct = this.doctorRepository.buscar(cedulaDoctor);
		
		

		CitaMedica cime = new CitaMedica();
		cime.setNumeroCita(numeroCita);
		cime.setFechaCita(fechaCita);
		cime.setValorCita(valorCita);
		cime.setLugarCita(lugarCita);
		cime.setDoctor(doct);
		cime.setPaciente(paci);
		
		this.citaMedicaRepository.insertar(cime);
		
		
	}



	@Override
	public void actualizarCita(String numeroCita, String Diagnostico, String receta, LocalDateTime fechaProxima) {
		
		// (Número de cita, Diagnóstico, Receta y Fecha próxima cita).
		
		CitaMedica cime = this.citaMedicaRepository.buscar(numeroCita);
		cime.setDiagnostico(Diagnostico);
		cime.setReceta(receta);
		cime.setFechaCita(fechaProxima);
		
		this.citaMedicaRepository.actualizar(cime);
		
		
		
		
	}

}
