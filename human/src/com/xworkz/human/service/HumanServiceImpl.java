package com.xworkz.human.service;

import com.xworkz.human.entiy.HumanEntity;
import com.xworkz.human.repository.HumanRepository;

public class HumanServiceImpl implements HumanService {

	private HumanRepository repository;

	public HumanServiceImpl(HumanRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean create(HumanEntity entity) {

		return true;
	}

}
