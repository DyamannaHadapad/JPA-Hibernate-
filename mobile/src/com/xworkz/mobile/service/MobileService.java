package com.xworkz.mobile.service;

import java.util.Optional;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileService {

	boolean ValidateAndSave(MobileEntity entity);

	Optional<MobileEntity> findById(int id);

	void updateNameAndPrice(int id, String newName, double newPrice);

	void deleteById(int id);

}
