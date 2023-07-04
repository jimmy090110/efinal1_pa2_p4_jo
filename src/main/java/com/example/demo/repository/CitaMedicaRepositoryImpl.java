package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements CitaMedicaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
		
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		this.entityManager.merge(citaMedica);
		
	}
	//String numeroCita

	@Override
	public CitaMedica buscar(String numeroCita) {
		TypedQuery<CitaMedica>myQuery = this.entityManager.createQuery("Select c from CitaMedica c WHERE c.numeroCita =:datonumeroCita", CitaMedica.class);
		myQuery.setParameter("datonumeroCita", numeroCita);
		return myQuery.getSingleResult();
	}

}
