package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.modelo.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public void insertar(Paciente paciente) {
		this.pacienteRepository.insertar(paciente);
		
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.pacienteRepository.actualizar(paciente);
		
	}

	@Override
	public Paciente buscar(String cedula) {
		
		return this.pacienteRepository.buscar(cedula);
	}

}
