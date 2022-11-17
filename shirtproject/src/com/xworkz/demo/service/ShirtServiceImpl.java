package com.xworkz.demo.service;

import java.util.List;
import com.xworkz.demo.entity.ShirtEntity;
import com.xworkz.demo.repository.ShirtRepository;
import com.xworkz.demo.repository.ShirtRepositoryImpl;

public class ShirtServiceImpl implements ShirtService {

	ShirtRepository repository = new ShirtRepositoryImpl();

	@Override
	public List<ShirtEntity> save(ShirtEntity entity) {
	
		return null;
	}

}
