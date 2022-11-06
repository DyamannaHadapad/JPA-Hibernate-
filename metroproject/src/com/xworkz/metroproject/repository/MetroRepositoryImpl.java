package com.xworkz.metroproject.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.metroproject.entity.MetroEntity;

public class MetroRepositoryImpl implements MetroRepository {

	@Override
	public boolean create(MetroEntity entity) {

		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		System.out.println(createEntityManagerFactory);
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
		entityManager.close();
		return true;
	}

}
