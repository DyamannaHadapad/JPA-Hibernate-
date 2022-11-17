package com.xworkz.mobile.runner;

import java.util.Optional;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.repository.MobileRepository;
import com.xworkz.mobile.repository.MobileRepositoryImpl;
import com.xworkz.mobile.service.MobileService;
import com.xworkz.mobile.service.MobileServiceImpl;
import com.xworkz.mobile.util.MobileUtil;

public class MobileRunner {

	public static void main(String[] args) {

		try {
			MobileEntity entity = new MobileEntity(1, "Note 8 pro", "redmi", 20000, 12.5);
			MobileEntity entity1 = new MobileEntity(2, "Note 8 pro max", "redmi", 23000, 15.5);
			MobileEntity entity2 = new MobileEntity(3, "Note 8", "redmi", 16000, 11.5);

			MobileRepository repository = new MobileRepositoryImpl();

			MobileService service = new MobileServiceImpl(repository);
			service.ValidateAndSave(entity);
			service.ValidateAndSave(entity1);
			service.ValidateAndSave(entity2);

			System.out.println("=============================================");

			Optional<MobileEntity> findById = service.findById(1);
			if (findById.isPresent()) {
				System.out.println("Id is present");
				MobileEntity mobileEntity = findById.get();
				System.out.println(mobileEntity);
			} else {
				System.err.println("Id is not present");
			}

			System.out.println("=============================================");

			service.updateNameAndPrice(1, "Asus", 25000);

			System.out.println("=============================================");

			service.deleteById(2);

			System.out.println("=============================================");
			
			
		} finally {
			MobileUtil.getFactory().close();
		}
	}

}
