package com.xworkz.human.Runner;

import java.util.Optional;

import javax.persistence.EntityManager;

import com.xworkz.human.entiy.HumanEntity;
import com.xworkz.human.repository.HumanRepository;
import com.xworkz.human.repository.HumanRepositoryImpl;
import com.xworkz.human.service.HumanService;
import com.xworkz.human.service.HumanServiceImpl;

public class HumanRunner {

	public static void main(String[] args) {

		HumanEntity entity1 = new HumanEntity(1, 25, "Nandesh Channal", "Bagalkot", "TCS Tech", "Brown", 173, 10.0,
				true, false);
		HumanEntity entity2 = new HumanEntity(2, 25, "Sachin M", "Bagalkot", "Open Text", "Brown", 167, 15.0, true,
				false);
		HumanEntity entity3 = new HumanEntity(3, 28, "Dyamanna H", "Bagalkot", "Google", "Black", 168, 5.0, true,
				false);

		HumanRepository repository = new HumanRepositoryImpl();
		HumanService service = new HumanServiceImpl(repository);
//		service.validateAndSave(entity1);
//		service.validateAndSave(entity2);
//		service.validateAndSave(entity3);

		System.out.println("=====================================================");

		Optional<HumanEntity> entity = service.findById(3);
		if (entity.isPresent()) {
			System.out.println("id is found  ");
			entity.isPresent();
		} else {
			System.err.println("id is null");
		}
		// System.out.println(entity);S
		System.out.println("=====================================================");
		service.updateByName(3, "Dadasaheba");

		System.out.println("=====================================================");
		service.deleteById(3);

	}

}
