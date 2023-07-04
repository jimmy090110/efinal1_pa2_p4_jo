package com.example.demo.repository;

import org.springframework.stereotype.Repository;


import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepositoryImpl implements PacienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);
		
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
		
	}

	@Override
	public Paciente buscar(String cedula) {
		
		TypedQuery<Paciente>myQuery = this.entityManager.createQuery("Select p from Paciente p WHERE p.cedula =:datoCedula", Paciente.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
		
	}

}
