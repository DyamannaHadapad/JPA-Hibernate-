package com.xworkz.hostel;

import com.xworkz.hostel.entity.HostelEntity;
import com.xworkz.hostel.repository.HostelRepository;
import com.xworkz.hostel.repository.HostelRepositoryImpl;
import com.xworkz.hostel.service.HostelService;
import com.xworkz.hostel.service.HostelServiceImpl;

public class HostelRunner {

	public static void main(String[] args) {

		HostelEntity entity = new HostelEntity(1, "BCM Hostel", "Mudhol", 2010, 150);

		HostelRepository repository = new HostelRepositoryImpl();

		HostelService hostelService = new HostelServiceImpl(repository);
		hostelService.validateAndSave(entity);
	}

}
