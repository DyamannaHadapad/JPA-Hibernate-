package com.xworkz.projects.service;

import java.util.Optional;

import com.xworkz.projects.credentials.StadiumCredentials;
import com.xworkz.projects.entity.StadiumEntity;
import com.xworkz.projects.repository.StadiumRepository;

public class StadiumServiceImpl implements StadiumService {

	private StadiumRepository repository;

	public StadiumServiceImpl(StadiumRepository repository) {
		this.repository = repository;

	}

	@Override
	public boolean validateAndSave(StadiumEntity entity) {

		int id = entity.getId();
		String name = entity.getName();
		int foundedYear = entity.getFoundedYear();
		double capacity = entity.getCapacity();
		double entryFees = entity.getEntryFees();
		StadiumCredentials credentials = entity.getCredentials();

		if (id > 0 && id < 30) {
			System.out.println("id is valid");
		} else if (name != null && name.length() > 3 && name.length() < 50) {
			System.out.println("name is valid");
		} else if (foundedYear > 1960 && foundedYear < 2000) {
			System.out.println("FoundedYear is valid");
		} else if (capacity > 100000.0 && capacity < 200000.0) {
			System.out.println("Capacity is valid");
		} else if (entryFees > 500 && entryFees < 2000) {
			System.out.println("EntryFees is valid");
		} else if (foundedYear > 1960 && foundedYear < 2000) {
			System.out.println("name is valid");
		} else if (credentials != null && credentials.getValue().length() > 3 && credentials.getValue().length() < 50) {
			System.out.println("Credentials is valid");
		} else {

			System.out.println("Invalid");
		}

		this.repository.create(entity);
		System.out.println(entity);
		return true;
	}

	@Override
	public Optional<StadiumEntity> findById(int id) {
		if (id > 0) {
			return this.repository.findById(id);
		}
		return Optional.empty();
	}

}
