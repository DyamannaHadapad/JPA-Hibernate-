package com.xworkz.human.service;

import java.util.Optional;

import com.xworkz.human.entiy.HumanEntity;
import com.xworkz.human.repository.HumanRepository;

public class HumanServiceImpl implements HumanService {

	private HumanRepository repository;

	public HumanServiceImpl(HumanRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateAndSave(HumanEntity entity) {
		int id = entity.getId();
		int age = entity.getAge();
		String name = entity.getName();
		String place = entity.getPlace();
		String companyName = entity.getCompanyName();
		String color = entity.getColor();
		double hieght = entity.getHieght();
		double salary = entity.getSalary();
		boolean alive = entity.isAlive();
		boolean married = entity.isMarried();

		if (id > 0) {
			System.out.println("id  is valid");

			if (age > 22) {
				System.out.println("age is valid");
				if (name != null && name.length() > 3 && name.length() < 40) {
					System.out.println("name is valid");
					if (place != null && place.length() > 3 && place.length() < 40) {
						System.out.println("place is valid");
						if (companyName != null && companyName.length() > 3 && companyName.length() < 40) {
							System.out.println("companyName is valid");
							if (color != null && color.length() > 3 && color.length() < 40) {
								System.out.println("color is valid");
								if (hieght > 140 && hieght < 200) {
									System.out.println("hieght is valid");
									if (salary > 3.0 && salary < 50.0) {
										System.out.println("salary is valid");
										if (alive == true) {
											System.out.println("alive is valid");
											if (married == false) {
												System.out.println("married is valid");
												this.repository.create(entity);
												//System.out.println("Saved data  :" + entity);
											} else {
												System.err.println("married is invalid");
											}
										} else {
											System.err.println("alive is invalid");
										}
									} else {
										System.err.println("salary is invalid");
									}
								} else {
									System.out.println("hieght is invalid");
								}
							} else {
								System.err.println("color is invalid");
							}
						} else {
							System.err.println("companyName is invalid");
						}
					} else {
						System.err.println("place is invalid");
					}
				} else {
					System.err.println("name is invalid");
				}
			} else {
				System.err.println("age is invalid");
			}
		} else {
			System.err.println("id is invalid");
		}

		return true;
	}

	@Override
	public Optional<HumanEntity> findById(int id) {
		if (id > 0) {
			System.out.println("id is valid");
			return this.repository.findById(id);
		}
		return Optional.empty();
	}
}
