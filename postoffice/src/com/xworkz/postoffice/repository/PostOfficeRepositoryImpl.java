package com.xworkz.postoffice.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.xworkz.postoffice.entity.PostOfficeEntity;
import com.xworkz.postoffice.util.PostOfficeUtil;

public class PostOfficeRepositoryImpl implements PostOfficeRepository {

	EntityManagerFactory factory = PostOfficeUtil.getFactory();

	@Override
	public boolean create(PostOfficeEntity entity) {
		EntityManager entityManager = this.factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();
		return true;
	}

	@Override
	public Optional<PostOfficeEntity> findById(int id) {
		EntityManager entityManager = this.factory.createEntityManager();
		PostOfficeEntity officeEntity = entityManager.find(PostOfficeEntity.class, id);
		if (officeEntity != null) {
			System.out.println("Entity is found   :" + officeEntity);
			return Optional.of(officeEntity);
		} else {
			System.err.println("Entity is not found  :" + id);
		}

		return Optional.empty();
	}

	@Override
	public void updateNameAndPlaceById(int id, String newName, String newPlace) {
		EntityManager entityManager = this.factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		PostOfficeEntity officeEntity = entityManager.find(PostOfficeEntity.class, id);
		if (officeEntity != null) {
			System.out.println("Entity is found , can update..." + officeEntity);
		} else {
			System.err.println("Entity is not found ,not update..." + id);
		}
		officeEntity.setBranch(newName);
		officeEntity.setPlace(newPlace);
		entityManager.merge(officeEntity);
		transaction.commit();

	}

	@Override
	public void deleteById(int id) {
		EntityManager entityManager = this.factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		PostOfficeEntity officeEntity = entityManager.find(PostOfficeEntity.class, id);
		if (officeEntity != null) {
			System.out.println("Entity found ,delete table..." + id);
		} else {
			System.err.println("Not found");
		}
		entityManager.remove(officeEntity);
		transaction.commit();

	}

}
