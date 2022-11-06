package com.xworkz.metroproject.repository;

import java.util.Optional;

import com.xworkz.metroproject.entity.MetroEntity;

public interface MetroRepository {

	boolean create(MetroEntity entity);

	Optional<MetroEntity> findById(int id);

}
