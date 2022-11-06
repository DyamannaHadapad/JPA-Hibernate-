package com.xworkz.human.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.human.entiy.HumanEntity;

public class HumanRepositoryImpl implements HumanRepository {

	@Override
	public boolean create(HumanEntity etity) {

		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("co.xworkz");
		System.out.println(createEntityManagerFactory);
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(etity);
		transaction.commit();
		entityManager.close();
		return true;
	}
}
