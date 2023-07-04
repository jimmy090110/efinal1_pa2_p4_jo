package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface CitaMedicaService {
	


	public void agendar(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita, String cedulaDoctor, String cedulaPaciente);

	//(Número de cita, Diagnóstico, Receta y Fecha próxima cita
	
	public void actualizarCita(String numeroCita, String Diagnostico, String receta, LocalDateTime fechaProxima);
	
}
