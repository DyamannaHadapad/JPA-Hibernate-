package com.xworkz.human.service;

import java.util.Optional;
import com.xworkz.human.entiy.HumanEntity;

public interface HumanService {

	boolean validateAndSave(HumanEntity entity);

	Optional<HumanEntity> findById(int id);
}
