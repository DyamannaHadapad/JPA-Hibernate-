package com.xworkz.goldjewellery.repository;

import java.util.List;
import java.util.Optional;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;

public interface GoldJewelleryRepository {

	default boolean save(GoldJewelleryEntity entity) {

		return true;

	}

	boolean save(List<GoldJewelleryEntity> list);

	Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName);

	Optional<String> findShopNameByid(int id);

	Optional<Double> findMakingChargesByShopName(String shopName);
	
	Optional<Object[]> findMakingChargesAndWastageChargesByShopName(String shopName);
	
	Optional<Double> findTotalPriceByGramAndShopName(double grams, String shopName);

}
