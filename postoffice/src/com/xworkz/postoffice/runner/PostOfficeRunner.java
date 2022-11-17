package com.xworkz.postoffice.runner;

import java.util.Optional;

import com.google.protobuf.Service;
import com.xworkz.postoffice.entity.PostOfficeEntity;
import com.xworkz.postoffice.repository.PostOfficeRepository;
import com.xworkz.postoffice.repository.PostOfficeRepositoryImpl;
import com.xworkz.postoffice.service.PostOfficeService;
import com.xworkz.postoffice.service.PostOfficeServiceImpl;
import com.xworkz.postoffice.util.PostOfficeUtil;

public class PostOfficeRunner {

	public static void main(String[] args) {
		try {
			PostOfficeEntity entity = new PostOfficeEntity(1, "Guledgudda", "Gld", 30, 9.0, 2.0);
			PostOfficeEntity entity1 = new PostOfficeEntity(2, "Bagalkot", "Bgk", 30, 9.0, 2.0);
			PostOfficeEntity entity2 = new PostOfficeEntity(3, "Badami", "Bdm", 30, 9.0, 2.0);
			PostOfficeEntity entity3 = new PostOfficeEntity(4, "Badami", "Bdm", 30, 9.0, 2.0);

			PostOfficeRepository repository = new PostOfficeRepositoryImpl();

			PostOfficeService service = new PostOfficeServiceImpl(repository);
//		service.validateAndSave(entity);
//		service.validateAndSave(entity1);
//		service.validateAndSave(entity2);
	//		service.validateAndSave(entity3);

			System.out.println("==============================================================");

			Optional<PostOfficeEntity> findById = service.findById(1);
			if (findById.isPresent()) {
				System.out.println("Id is present...");
				PostOfficeEntity postOfficeEntity = findById.get();
				System.out.println(postOfficeEntity);
			} else {
				System.out.println("Id is not present...");
			}

			System.out.println("==============================================================");

			service.updateNameAndPlaceById(2, "MudholBranch", "Mudhol");

			System.out.println("==============================================================");

			service.deleteById(2);
			
			
		} finally {
			PostOfficeUtil.getFactory().close();
		}
	}

}
