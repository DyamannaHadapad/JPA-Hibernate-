package com.xworkz.human.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import com.xworkz.human.entiy.HumanEntity;
import com.xworkz.human.util.HumanUtil;

public class HumanRepositoryImpl implements HumanRepository {

	EntityManagerFactory factory = HumanUtil.getFactory();

	@Override
	public boolean create(HumanEntity entity) {
		try {
			EntityManager manager = this.factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public Optional<HumanEntity> findById(int id) {
		EntityManager manager = this.factory.createEntityManager();
		HumanEntity entity = manager.find(HumanEntity.class, id);
		if (entity != null) {
			System.out.println("Entity found in table   :" + entity);
			return Optional.of(entity);
		} else {
			System.err.println("Entity is not found  :" + id);
		}
		return Optional.empty();
	}

	@Override
	public void updateByName(int id, String name) {
		EntityManager entityManager = this.factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		HumanEntity entity = entityManager.find(HumanEntity.class, id);
		if (entity != null) {
			entity.setName(name);
			entityManager.merge(entity);
			System.out.println("Entity found  ,can update   :" + id);
		} else {
			System.err.println("Entity is not found,not update ");

		}
		transaction.commit();
		entityManager.close();

	}

	@Override
	public void deleteById(int id) {
		EntityManager entityManager = this.factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		HumanEntity entity = entityManager.find(HumanEntity.class, id);
		if (entity != null) {

			System.out.println("Entity is removed from table   :" + id);
			entityManager.remove(entity);

		} else {
			System.err.println("Entity is not found....");
		}
		transaction.commit();
		entityManager.close();
	}

}
