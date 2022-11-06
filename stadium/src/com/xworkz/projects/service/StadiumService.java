package com.xworkz.projects.service;

import java.util.Optional;

import com.xworkz.projects.entity.StadiumEntity;

public interface StadiumService {

	boolean validateAndSave(StadiumEntity entity);

	Optional<StadiumEntity> findById(int id);

}
