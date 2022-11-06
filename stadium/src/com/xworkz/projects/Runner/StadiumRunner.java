package com.xworkz.projects.Runner;

import com.xworkz.projects.credentials.StadiumCredentials;
import com.xworkz.projects.entity.StadiumEntity;
import com.xworkz.projects.repository.StadiumRepository;
import com.xworkz.projects.repository.StadiumRepositoryImpl;
import com.xworkz.projects.service.StadiumService;
import com.xworkz.projects.service.StadiumServiceImpl;

public class StadiumRunner {

	public static void main(String[] args) {

		StadiumEntity entity = new StadiumEntity(3, "Chinaswami ", 1975, 190000, 1200,
				StadiumCredentials.OUTDOOR);
		StadiumEntity entity1 = new StadiumEntity(2, " Stadium", 1970, 150008, 1000,
				StadiumCredentials.INDOOR);

		StadiumRepository repository = new StadiumRepositoryImpl();

		StadiumService service = new StadiumServiceImpl(repository);
		service.validateAndSave(entity);
		service.validateAndSave(entity1);
	}

}
