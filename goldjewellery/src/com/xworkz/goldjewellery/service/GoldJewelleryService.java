package com.xworkz.goldjewellery.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;

public interface GoldJewelleryService {

	boolean validateAndSave(GoldJewelleryEntity entity);

	boolean validateAndSave(List<GoldJewelleryEntity> list);

	Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName);

	Optional<String> findShopNameByid(int id);

	Optional<Double> findMakingChargesByShopName(String shopName);

	Optional<Object[]> findMakingChargesAndWastageChargesByShopName(String shopName);

	Optional<Double> findTotalPriceByGramAndShopName(double grams, String shopName);

	Collection<GoldJewelleryEntity> getAll();

	Collection<String> getAllShopName();

	Collection<Object[]> getAllShopNameAndType();

	Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges);

	Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesLessThan(double charges);

	Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan(
			double wasteAgecharges, double makingCharges);

	Optional<Collection<GoldJewelleryEntity>> findAll();

	Optional<GoldJewelleryEntity> displayByShopName(String name);

	Collection<GoldJewelleryEntity> allItems();
}
