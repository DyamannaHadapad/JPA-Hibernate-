package com.xworkz.hostel.service;

import com.xworkz.hostel.entity.HostelEntity;
import com.xworkz.hostel.repository.HostelRepository;

public class HostelServiceImpl implements HostelService {

	private HostelRepository repository;

	public HostelServiceImpl(HostelRepository repository) {
		this.repository=repository;
		System.out.println("HostelServiceImpl parameterised constr");
	}

	@Override
	public boolean validateAndSave(HostelEntity entity) {

		this.repository.create(entity);
		return false;
	}

}
