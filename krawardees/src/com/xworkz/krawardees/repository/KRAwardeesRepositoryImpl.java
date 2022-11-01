package com.xworkz.krawardees.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.krawardees.DTO.KRAwardeesDTO;

public class KRAwardeesRepositoryImpl implements KRAwardeesRepository {

	EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");

	@Override
	public boolean save(KRAwardeesDTO dto) {

		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(dto);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

}
