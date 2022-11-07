package com.xworkz.postoffice.repository;

import java.util.Optional;

import com.xworkz.postoffice.entity.PostOfficeEntity;

public interface PostOfficeRepository {

	boolean create(PostOfficeEntity entity);

	Optional<PostOfficeEntity> findById(int id);

	void updateNameAndPlaceById(int id, String newName, String newPlace);

	void deleteById(int id);

}
