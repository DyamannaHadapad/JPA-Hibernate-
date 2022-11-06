package com.xworkz.metroproject.service;

import java.util.Optional;

import com.xworkz.metroproject.entity.MetroEntity;
import com.xworkz.metroproject.repository.MetroRepository;

import lombok.Getter;

public class MetroServiceImpl implements MetroService {

	@Getter
	private MetroRepository repository;

	public MetroServiceImpl(MetroRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateAndSave(MetroEntity entity) {

		int id = entity.getId();
		int noOfMetro = entity.getNoOfMetro();
		int metroStations = entity.getMetroStations();
		int noOfStops = entity.getNoOfStops();
		int since = entity.getSince();
		String name = entity.getName();
		String place = entity.getPlace();
		entity.getType();
		double budget = entity.getBudget();
		double collection = entity.getCollection();

		if (id > 0 && id < 40) {
			System.out.println("id is valid");
			if (noOfMetro > 2 && noOfMetro < 100) {
				System.out.println("noOfMetro is valid");
				if (metroStations > 2 && metroStations < 100) {
					System.out.println("metroStations is valid");
					if (noOfStops > 2 && noOfStops < 100) {
						System.out.println("noOfStops is valid");
						if (since > 1990 && since < 2020) {
							System.out.println("since is valid");
							if (name != null && name.length() > 3 && name.length() < 50) {
								System.out.println("name is valid");
								if (place != null && place.length() > 3 && place.length() < 50) {
									System.out.println("place is valid");
									if (budget > 2 && budget <= 200000) {
										System.out.println("budget is valid");
										if (collection > 2 && collection < 1000000) {
											System.out.println("collection is valid");

											System.out.println(this.repository.create(entity));

										} else {
											System.err.println("collection is invalid");
										}
									} else {
										System.err.println("budget is invalid");
									}
								} else {
									System.err.println("place is invalid");
								}
							} else {
								System.err.println("name is invalid");
							}
						} else {
							System.err.println("since is invalid");
						}
					} else {
						System.err.println("noOfStops is invalid");
					}
				} else {
					System.err.println("metroStations is invalid");
				}
			} else {
				System.err.println("noOfMetro is invalid");
			}
		} else {
			System.err.println("id is invalid");
		}

		return true;
	}

	@Override
	public Optional<MetroEntity> findById(int id) {
		if (id > 0) {
			return this.repository.findById(id);
		}
		return Optional.empty();
	}

}
