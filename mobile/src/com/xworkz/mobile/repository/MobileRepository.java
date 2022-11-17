package com.xworkz.mobile.repository;

import java.util.Optional;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileRepository {

	boolean create(MobileEntity entity);

	Optional<MobileEntity> findById(int id);
	
	void updateNameAndPrice(int id, String newName, double newPrice);

	void deleteById(int id);




}
