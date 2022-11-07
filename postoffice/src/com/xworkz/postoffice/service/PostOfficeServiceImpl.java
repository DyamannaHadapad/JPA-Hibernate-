package com.xworkz.postoffice.service;

import java.util.Optional;

import com.xworkz.postoffice.entity.PostOfficeEntity;
import com.xworkz.postoffice.repository.PostOfficeRepository;

public class PostOfficeServiceImpl implements PostOfficeService {

	private PostOfficeRepository repository;

	public PostOfficeServiceImpl(PostOfficeRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateAndSave(PostOfficeEntity entity) {
		if (entity != null) {
			this.repository.create(entity);
			System.out.println(entity);
		} else {
			System.out.println("not found");
		}

		return true;
	}

	@Override
	public Optional<PostOfficeEntity> findById(int id) {
		if (id > 0) {
			System.out.println("id is valid");
			this.repository.findById(id);
		}

		return Optional.empty();
	}

	@Override
	public void updateNameAndPlaceById(int id, String newName, String newPlace) {
		this.repository.updateNameAndPlaceById(id, newName, newPlace);
	}

	@Override
	public void deleteById(int id) {
		this.repository.deleteById(id);
	}
}
