package com.example.demo.repository;

import com.example.demo.repository.modelo.Doctor;

public interface DoctorRepository {
	
	public void insertar(Doctor doctor);
	
	public Doctor buscar(String cedula);
	

}
