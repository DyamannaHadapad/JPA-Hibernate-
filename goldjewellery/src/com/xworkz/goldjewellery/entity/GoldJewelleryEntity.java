package com.xworkz.goldjewellery.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.xworkz.goldjewellery.enumclass.JewelleryType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gold_jewellery")
@NamedQuery(name = "findByShopNameAndId", query = "select gold from GoldJewelleryEntity gold where gold.shopName=:shop and gold.id=:time")
@NamedQuery(name = "findShopNameByid", query = "select gold.shopName from GoldJewelleryEntity gold where gold.id=:time")
@NamedQuery(name = "findMakingChargesByShopName", query = "select gold.makingCharges from GoldJewelleryEntity gold where gold.shopName=:shop")
@NamedQuery(name = "findMakingChargesAndWastageChargesByShopName",query = "select gold.makingCharges,gold.wastageCharges from GoldJewelleryEntity gold where gold.shopName=:shop")
@NamedQuery(name = "findTotalPriceByGramAndShopName",query = "select sum(goldPrice+gstPrice+makingCharges+wastageCharges)from GoldJewelleryEntity gold where gold.grams=:gr and gold.shopName=:shop")
public class GoldJewelleryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private JewelleryType type;
	@NotEmpty
	@NotNull
	@Length(min = 3, max = 50)
	private String shopName;
	@DecimalMin(value = "0.0", message = "value is invalid")
	private double goldPrice;
	@DecimalMin(value = "0.0", message = "value is invalid")
	private double gstPrice;
	@DecimalMin(value = "0.0", message = "value is invalid")
	private double grams;
	@DecimalMin(value = "0.0", message = "value is invalid")
	private double makingCharges;
	@DecimalMin(value = "0.0", message = "value is invalid")
	private double wastageCharges;
	private boolean copper;

	public GoldJewelleryEntity(JewelleryType type, String shopName, double goldPrice, double gstPrice, double grams,
			double makingCharges, double wastageCharges, boolean copper) {
		super();

		this.type = type;
		this.shopName = shopName;
		this.goldPrice = goldPrice;
		this.gstPrice = gstPrice;
		this.grams = grams;
		this.makingCharges = makingCharges;
		this.wastageCharges = wastageCharges;
		this.copper = copper;
	}

}
