package com.xworkz.metroproject.runner;

import java.util.Optional;

import com.xworkz.metroproject.entity.MetroEntity;
import com.xworkz.metroproject.repository.MetroRepository;
import com.xworkz.metroproject.repository.MetroRepositoryImpl;

public class UtilRunner {

	public static void main(String[] args) {

		MetroRepository repository = new MetroRepositoryImpl();

		Optional<MetroEntity> entity = repository.findById(1);
		Optional<MetroEntity> entity1 = repository.findById(15);

	}

}
