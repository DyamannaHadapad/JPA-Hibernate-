package com.xworkz.hostel.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.hostel.entity.HostelEntity;

public class HostelRepositoryImpl implements HostelRepository {

	@Override
	public boolean create(HostelEntity entity) {
		System.out.println("Running create method ");

		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		System.out.println(createEntityManagerFactory);
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
		entityManager.close();

		return false;
	}

}
