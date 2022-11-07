package com.xworkz.human.repository;

import java.util.Optional;

import com.xworkz.human.entiy.HumanEntity;

public interface HumanRepository {

	boolean create(HumanEntity etity);

	Optional<HumanEntity> findById(int id);

	void updateByName(int id, String name);

	void deleteById(int id);

}
