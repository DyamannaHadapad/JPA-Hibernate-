package com.xworkz.goldjewellery.service;

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

}
