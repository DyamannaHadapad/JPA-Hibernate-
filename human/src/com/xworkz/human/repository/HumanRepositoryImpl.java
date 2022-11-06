package com.xworkz.human.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.human.entiy.HumanEntity;
import com.xworkz.human.util.HumanUtil;

public class HumanRepositoryImpl implements HumanRepository {

	EntityManagerFactory factory = HumanUtil.getFactory();
	private EntityManager manager = null;

	@Override
	public boolean create(HumanEntity etity) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(etity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public Optional<HumanEntity> findById(int id) {
		manager = factory.createEntityManager();
		HumanEntity entity = manager.find(HumanEntity.class, id);
		if (entity != null) {
			System.out.println("Entity found in table   :" + entity);
			return Optional.of(entity);
		} else {
			System.err.println("Entity is not found  :" + id);
		}
		return Optional.empty();
	}

}
