package com.xworkz.goldjewellery.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

//	

	public Collection<GoldJewelleryEntity> getAll() {
		EntityManager manager = factory.createEntityManager();
		try {
			return manager.createNamedQuery("getAll").getResultList();
		} finally {
			manager.close();
		}

	}

	@Override
	public Collection<String> getAllShopName() {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return createEntityManager.createNamedQuery("getAllShopName").getResultList();
		} finally {
			createEntityManager.close();
		}

	}

	@Override
	public Collection<Object[]> getAllShopNameAndType() {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return createEntityManager.createNamedQuery("getAllShopNameAndType").getResultList();
		} finally {
			createEntityManager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges) {

		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return Optional.of(createEntityManager.createNamedQuery("findAllByMakingChargesGreaterThan")
					.setParameter("ch", charges).getResultList());
		} finally {
			createEntityManager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesLessThan(double charges) {
		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return Optional.of(createEntityManager.createNamedQuery("findAllByWasteageChargesLessThan")
					.setParameter("ch", charges).getResultList());
		} finally {
			createEntityManager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan(
			double wasteAgecharges, double makingCharges) {

		EntityManager createEntityManager = factory.createEntityManager();
		try {
			return Optional.of(createEntityManager
					.createNamedQuery("findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan")
					.setParameter("wa", wasteAgecharges).setParameter("mk", makingCharges).getResultList());
		} finally {
			createEntityManager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAll() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<GoldJewelleryEntity> query = manager.createNamedQuery("findAll", GoldJewelleryEntity.class);
		List<GoldJewelleryEntity> resultList = query.getResultList();
		if (resultList != null) {
			System.out.println("data is valid");
			return Optional.of(resultList);
		}
		return Optional.empty();
	}

	@Override
	public Optional<GoldJewelleryEntity> displayByShopName(String name) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("displayByShopName");
		query.setParameter("shop", name);
		Object singleResult = query.getSingleResult();
		if (singleResult != null) {
			System.out.println("data is valid");
			GoldJewelleryEntity ref = (GoldJewelleryEntity) singleResult;
			return Optional.of(ref);
		}
		return Optional.empty();
	}

	@Override
	public Collection<GoldJewelleryEntity> allItems() {
		EntityManager manager = this.factory.createEntityManager();
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<GoldJewelleryEntity> createQuery = criteriaBuilder.createQuery(GoldJewelleryEntity.class);
		Root<GoldJewelleryEntity> root = createQuery.from(GoldJewelleryEntity.class);
		createQuery.select(root);
		TypedQuery<GoldJewelleryEntity> createQuery2 = manager.createQuery(createQuery);
		Collection<GoldJewelleryEntity> result = createQuery2.getResultList();
		if (result != null) {
			System.out.println("data is valid");
			return result;
		}

		return null;
	}
}
