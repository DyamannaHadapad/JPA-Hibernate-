package com.xworkz.projects.repository;

import java.util.Optional;

import com.xworkz.projects.entity.StadiumEntity;

public interface StadiumRepository {
	boolean create(StadiumEntity entity);

	Optional<StadiumEntity> findById(int id);
}
