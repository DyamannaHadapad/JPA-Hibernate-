package com.xworkz.projects.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.xworkz.projects.entity.StadiumEntity;
import com.xworkz.projects.util.StadiumUtil;

public class StadiumRepositoryImpl implements StadiumRepository {

	EntityManagerFactory factory = StadiumUtil.getFactory();
	private EntityManager entityManager = null;

	@Override
	public boolean create(StadiumEntity entity) {

		this.entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
		entityManager.close();

		return true;
	}

	@Override
	public Optional<StadiumEntity> findById(int id) {
		this.entityManager = factory.createEntityManager();
		StadiumEntity entity = entityManager.find(StadiumEntity.class, id);
		if (entity != null) {
			System.out.println("Entity table is found   :" + entity);
			return Optional.of(entity);
		} else {
			System.err.println("Entity table is not found   :" + id);
		}

		return Optional.empty();
	}

}
