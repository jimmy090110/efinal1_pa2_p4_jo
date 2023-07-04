package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.modelo.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public void insertar(Doctor doctor) {
		this.doctorRepository.insertar(doctor);
		
	}

	@Override
	public Doctor buscar(String cedula) {
		
		return this.doctorRepository.buscar(cedula);
	}

}
