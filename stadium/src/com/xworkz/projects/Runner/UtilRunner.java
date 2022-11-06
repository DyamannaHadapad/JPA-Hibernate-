package com.xworkz.projects.Runner;

import java.util.Optional;

import com.xworkz.projects.entity.StadiumEntity;
import com.xworkz.projects.repository.StadiumRepository;
import com.xworkz.projects.repository.StadiumRepositoryImpl;

public class UtilRunner {

	public static void main(String[] args) {

		StadiumRepository repository = new StadiumRepositoryImpl();
		//Optional<StadiumEntity> entity = repository.findById(1);
		//System.out.println(entity);
		Optional<StadiumEntity> entity1 = repository.findById(2);
		

	}

}
