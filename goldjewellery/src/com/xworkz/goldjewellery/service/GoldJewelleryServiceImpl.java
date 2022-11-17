package com.xworkz.goldjewellery.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;
import com.xworkz.goldjewellery.repository.GoldJewelleryRepository;
import com.xworkz.goldjewellery.repository.GoldJewelleryRepositoryImpl;

public class GoldJewelleryServiceImpl implements GoldJewelleryService {

	GoldJewelleryRepository repository = new GoldJewelleryRepositoryImpl();

	@Override
	public boolean validateAndSave(GoldJewelleryEntity entity) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<GoldJewelleryEntity>> validate = validator.validate(entity);
		if (validate.size() > 0) {
			System.err.println("data invalid ,,can't save");
		} else {
			System.out.println("data is vlaid ,,can save...");
			// this.repository.save(entity);

		}
		return this.repository.save(entity);

	}

	@Override
	public boolean validateAndSave(List<GoldJewelleryEntity> list) {
		ValidatorFactory buildDefaultValidatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = buildDefaultValidatorFactory.getValidator();
		for (GoldJewelleryEntity entity : list) {
			Set<ConstraintViolation<Object>> validate = validator.validate(list);
			if (validate.size() > 0) {
				System.err.println("data is invalid,,can't save");
			} else {
				System.out.println("data is valid ,,can save....");
				this.repository.save(entity);
			}
		}
		return true;
	}

	@Override
	public Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName) {

		return this.repository.findByShopNameAndId(id, shopName);
	}

	@Override
	public Optional<String> findShopNameByid(int id) {
		if (id > 1) {
			System.out.println("data is valid.....");
			return this.repository.findShopNameByid(id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Double> findMakingChargesByShopName(String shopName) {
		if (shopName != null) {
			return this.repository.findMakingChargesByShopName(shopName);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Object[]> findMakingChargesAndWastageChargesByShopName(String shopName) {
		if (shopName != null) {
			return this.repository.findMakingChargesAndWastageChargesByShopName(shopName);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Double> findTotalPriceByGramAndShopName(double grams, String shopName) {
		return this.repository.findTotalPriceByGramAndShopName(grams, shopName);
	}
}
