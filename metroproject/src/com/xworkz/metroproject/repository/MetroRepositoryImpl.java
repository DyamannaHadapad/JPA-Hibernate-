package com.xworkz.metroproject.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.metroproject.entity.MetroEntity;
import com.xworkz.metroproject.util.MetroUtil;

public class MetroRepositoryImpl implements MetroRepository {

	public EntityManagerFactory factory = MetroUtil.getFactory();
	private EntityManager manager = null;

	@Override
	public boolean create(MetroEntity entity) {

		// EntityManagerFactory createEntityManagerFactory =
		// Persistence.createEntityManagerFactory("com.xworkz");
		// System.out.println(createEntityManagerFactory);
		this.manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();

		return true;
	}

	@Override
	public Optional<MetroEntity> findById(int id) {
		this.manager = factory.createEntityManager();
		MetroEntity entity = manager.find(MetroEntity.class, id);
		if (entity != null) {
			System.out.println("Entity table is found  :" + entity);
			return Optional.of(entity);
		} else {
			System.out.println("Entity table is not found   :" + id);
		}

		return Optional.empty();
	}

}
