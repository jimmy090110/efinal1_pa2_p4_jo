package com.example.demo.service;

import com.example.demo.repository.modelo.Doctor;

public interface DoctorService {
	public void insertar(Doctor doctor);
	
	public Doctor buscar(String cedula);

}
