package com.xworkz.mobile.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.util.MobileUtil;

public class MobileRepositoryImpl implements MobileRepository {

	EntityManagerFactory factory = MobileUtil.getFactory();

	@Override
	public boolean create(MobileEntity entity) {

		EntityManager entityManager = this.factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entityManager);
		transaction.commit();

		return true;
	}

	@Override
	public Optional<MobileEntity> findById(int id) {
		EntityManager entityManager = this.factory.createEntityManager();
		MobileEntity find = entityManager.find(MobileEntity.class, id);
		if (find != null) {
			System.out.println("Entity is found..." + find);
			return Optional.of(find);
		}

		return Optional.empty();
	}

	@Override
	public void updateNameAndPrice(int id, String newName, double newPrice) {
		EntityManager entityManager = this.factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		MobileEntity find = entityManager.find(MobileEntity.class, id);
		if (find != null) {
			System.out.println("Entity is found,u can update...." + find);
			find.setName(newName);
			find.setPrice(newPrice);
			entityManager.merge(find);
		} else {
			System.err.println("Not found..not update" + id);
		}
		transaction.commit();

	}

	@Override
	public void deleteById(int id) {
		EntityManager entityManager = this.factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		MobileEntity find = entityManager.find(MobileEntity.class, id);
		if (find != null) {
			System.out.println("Removed..." + find);
			entityManager.remove(find);
		} else {
			System.err.println("Not present... " + id);
		}
		transaction.commit();
	}

}
