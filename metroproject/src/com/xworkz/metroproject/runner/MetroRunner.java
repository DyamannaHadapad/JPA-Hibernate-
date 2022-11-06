package com.xworkz.metroproject.runner;

import com.xworkz.metroproject.entity.MetroEntity;
import com.xworkz.metroproject.repository.MetroRepository;
import com.xworkz.metroproject.repository.MetroRepositoryImpl;
import com.xworkz.metroproject.service.MetroService;
import com.xworkz.metroproject.service.MetroServiceImpl;

public class MetroRunner {

	public static void main(String[] args) {

		MetroEntity entity3 = new MetroEntity(3, 20, 30, 40, 2010, "Namma Metro", "Bangalore", "Green Metro", 20000.0,
				100000.0);
		MetroEntity entity1= new MetroEntity(2, 20, 30, 40, 2010, "Namma Metro", "Bangalore", "Green Metro", 20000.0,
				100000.0);

		MetroRepository repository = new MetroRepositoryImpl();

		MetroService service = new MetroServiceImpl(repository);
		service.validateAndSave(entity1);
		service.validateAndSave(entity3);
		
	}

}
