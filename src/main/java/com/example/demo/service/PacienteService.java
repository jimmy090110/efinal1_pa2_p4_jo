package com.example.demo.service;

import com.example.demo.repository.modelo.Paciente;


public interface PacienteService {
	
	public void insertar(Paciente paciente);
	
	public void actualizar(Paciente paciente);
	
	public Paciente buscar(String cedula);

}
