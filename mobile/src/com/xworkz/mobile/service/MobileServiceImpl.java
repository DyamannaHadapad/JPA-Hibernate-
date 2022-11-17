package com.xworkz.mobile.service;

import java.util.Optional;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.repository.MobileRepository;

public class MobileServiceImpl implements MobileService {

	private MobileRepository repository;

	public MobileServiceImpl(MobileRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean ValidateAndSave(MobileEntity entity) {
		if (entity != null) {
			System.out.println("u can save Entity ...");
			this.repository.create(entity);
		} else {
			System.err.println("not found...");
		}
		return true;
	}

	@Override
	public Optional<MobileEntity> findById(int id) {
		if (id > 0) {
			System.out.println("Id is Finded.....");
			this.repository.findById(id);
		}
		return Optional.empty();

	}

	@Override
	public void updateNameAndPrice(int id, String newName, double newPrice) {
		this.repository.updateNameAndPrice(id, newName, newPrice);
	}

	@Override
	public void deleteById(int id) {
		this.repository.deleteById(id);
	}

}
