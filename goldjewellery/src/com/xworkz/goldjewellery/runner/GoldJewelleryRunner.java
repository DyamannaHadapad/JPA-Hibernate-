package com.xworkz.goldjewellery.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;
import com.xworkz.goldjewellery.enumclass.JewelleryType;
import com.xworkz.goldjewellery.service.GoldJewelleryService;
import com.xworkz.goldjewellery.service.GoldJewelleryServiceImpl;
import com.xworkz.goldjewellery.util.GoldJewelleryUtil;

public class GoldJewelleryRunner {

	public static void main(String[] args) {

		GoldJewelleryEntity entity = new GoldJewelleryEntity(JewelleryType.BANGLE, "Lalitha Jewellerys", 55000d, 2000d,
				12d, 3000d, 0.5d, true);
		GoldJewelleryEntity entity1 = new GoldJewelleryEntity(JewelleryType.EARRING, "latha Jewellerys", 54000d, 2200d,
				14d, 3700d, 0.8d, true);
		GoldJewelleryEntity entity2 = new GoldJewelleryEntity(JewelleryType.BRACELET, "smitha Jewellerys", 53000d,
				2300d, 18d, 3600d, 0.9d, true);
		GoldJewelleryEntity entity3 = new GoldJewelleryEntity(JewelleryType.NECKLACE, "kavitha Jewellerys", 52000d,
				2500d, 15d, 3300d, 0.4d, true);

		try {

			GoldJewelleryService service = new GoldJewelleryServiceImpl();
			// service.validateAndSave(entity);
			List<GoldJewelleryEntity> list = new ArrayList<GoldJewelleryEntity>();
			list.add(entity1);
			list.add(entity2);
			list.add(entity3);

			// service.validateAndSave(list);
			Optional<GoldJewelleryEntity> optional = service.findByShopNameAndId(2, "latha Jewellerys");
			if (optional.isPresent()) {
				GoldJewelleryEntity goldJewelleryEntity = optional.get();
				System.out.println(goldJewelleryEntity);
			} else {
				System.err.println("not present.....findByShopNameAndId");
			}

			System.out.println("==============================================================");

			Optional<String> optional2 = service.findShopNameByid(4);
			if (optional2.isPresent()) {
				String string = optional2.get();
				System.out.println(string);
			} else {
				System.err.println("id is not present...findShopNameByid");
			}

			System.out.println("==============================================================");

			Optional<Double> optional3 = service.findMakingChargesByShopName("kavitha Jewellerys");
			if (optional3.isPresent()) {
				Double double1 = optional3.get();
				System.out.println(double1);
			} else {
				System.err.println("invalid...findMakingChargesByShopName");

			}

			System.out.println("==============================================================");

			Optional<Object[]> optional4 = service.findMakingChargesAndWastageChargesByShopName("smitha Jewellerys");
			if (optional4.isPresent()) {
				Object[] objects = optional4.get();
				for (Object object : objects) {
					System.out.println(object);
				}
			} else {
				System.err.println("invalid ....findMakingChargesAndWastageChargesByShopName");
			}

			System.out.println("==============================================================");

			Optional<Double> optional5 = service.findTotalPriceByGramAndShopName(12, "Lalitha Jewellerys");
			if (optional5.isPresent()) {
				GoldJewelleryEntity double1 = optional.get();
				System.out.println(double1);
			} else {
				System.err.println("invalid ....findTotalPriceByGramAndShopName");
			}

			System.out.println("==============================================================");

		} finally {
			GoldJewelleryUtil.getFactory().close();
		}
	}

}
