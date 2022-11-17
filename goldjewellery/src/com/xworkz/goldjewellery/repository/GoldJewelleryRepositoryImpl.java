package com.xworkz.goldjewellery.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;
import com.xworkz.goldjewellery.util.GoldJewelleryUtil;

public class GoldJewelleryRepositoryImpl implements GoldJewelleryRepository {

	EntityManagerFactory factory = GoldJewelleryUtil.getFactory();

	@Override
	public boolean save(GoldJewelleryEntity entity) {

		EntityManager manager = this.factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(entity);
			transaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return true;
	}

	@Override
	public boolean save(List<GoldJewelleryEntity> list) {
		EntityManager manager = this.factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			for (GoldJewelleryEntity entityGoldJewelleryEntity : list) {
				manager.persist(entityGoldJewelleryEntity);
				transaction.commit();
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName) {
		EntityManager manager = this.factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByShopNameAndId");
			query.setParameter("shop", shopName);
			query.setParameter("time", id);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				System.out.println("Running findByShopNameAndId");
				GoldJewelleryEntity entity = (GoldJewelleryEntity) singleResult;
				return Optional.of(entity);
			} else {
				System.err.println("data is invalid ...:" + id + shopName);
			}

		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<String> findShopNameByid(int id) {
		EntityManager manager = this.factory.createEntityManager();
		Query query = manager.createNamedQuery("findShopNameByid");
		try {
			query.setParameter("time", id);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				String string = (String) singleResult;
				return Optional.of(string);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Double> findMakingChargesByShopName(String shopName) {

		EntityManager manager = this.factory.createEntityManager();
		Query query = manager.createNamedQuery("findMakingChargesByShopName");
		try {
			query.setParameter("shop", shopName);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				Double double1 = (Double) singleResult;
				return Optional.of(double1);
			}

		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Object[]> findMakingChargesAndWastageChargesByShopName(String shopName) {
		EntityManager manager = this.factory.createEntityManager();
		Query query = manager.createNamedQuery("findMakingChargesAndWastageChargesByShopName");
		try {
			query.setParameter("shop", shopName);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				Object[] objects = (Object[]) singleResult;
				return Optional.of(objects);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Double> findTotalPriceByGramAndShopName(double grams, String shopName) {
		EntityManager manager = this.factory.createEntityManager();
		Query query = manager.createNamedQuery("findTotalPriceByGramAndShopName");
		try {
			query.setParameter("gr", grams);
			query.setParameter("shop", shopName);
			Object singleResult = query.getSingleResult();
			if (singleResult != null) {
				Double double1 = (Double) singleResult;
				System.out.println(double1);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}
}
