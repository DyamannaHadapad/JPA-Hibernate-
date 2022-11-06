package com.xworkz.metroproject.service;

import java.util.Optional;

import com.xworkz.metroproject.entity.MetroEntity;

public interface MetroService {

	boolean validateAndSave(MetroEntity entity);

	Optional<MetroEntity> findById(int id);

}
