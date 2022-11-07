package com.xworkz.postoffice.service;

import java.util.Optional;

import com.xworkz.postoffice.entity.PostOfficeEntity;

public interface PostOfficeService {

	boolean validateAndSave(PostOfficeEntity entity);

	Optional<PostOfficeEntity> findById(int id);

	void updateNameAndPlaceById(int id, String newName, String newPlace);

	void deleteById(int id);

}
