package com.xworkz.krawardees.service;

import com.xworkz.krawardees.DTO.KRAwardeesDTO;
import com.xworkz.krawardees.repository.KRAwardeesRepository;
import com.xworkz.krawardees.repository.KRAwardeesRepositoryImpl;

public class KRAwardeesServiceImpl implements KRAwardeesService {

	KRAwardeesRepository repository = new KRAwardeesRepositoryImpl();

	@Override
	public boolean validateAndSave(KRAwardeesDTO dto) {

		int id = dto.getId();
		String name = dto.getName();
		int year = dto.getYear();
		String achivement = dto.getAchivement();
		boolean alive = dto.isAlive();
		int age = dto.getAge();
		String place = dto.getPlace();
		if (id > 0 && id <= 50) {
			System.out.println("id is valid");
			if (name != null && name.length() > 2 && name.length() < 50) {
				System.out.println("name is valid");
				if (year > 1970 && year < 2040) {
					System.out.println("year is valid");
					if (achivement != null && achivement.length() > 2 && achivement.length() < 50) {
						System.out.println("achivement is valid");
						if (alive == false) {
							System.out.println("alive property is valid");
							if (age > 20 && age < 100) {
								System.out.println("age is valid");
								if (place != null && place.length() > 2 && place.length() < 50) {
									System.out.println("place is valid");								
									this.repository.save(dto);
									System.out.println("saved dto   :"+dto );

								} else {
									System.err.println("place is invalid");
								}
							} else {
								System.out.println("age is invalid");
							}
						} else {
							System.err.println("alive property is invalid");
						}
					} else {
						System.err.println("achivement is invalid");
					}
				} else {
					System.err.println("year is invalid");
				}
			} else {
				System.err.println("name is invalid");
			}
		} else {
			System.err.println("id is inavid");
		}

		return true;

	}

}
