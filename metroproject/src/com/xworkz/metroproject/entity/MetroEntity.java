package com.xworkz.metroproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "metro")
public class MetroEntity {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "noOfMetro")
	private int noOfMetro;
	@Column(name = "metroStations")
	private int metroStations;
	@Column(name = "noOfStops")
	private int noOfStops;
	@Column(name = "since")
	private int since;
	@Column(name = "name")
	private String name;
	@Column(name = "place")
	private String place;
	@Column(name = "type")
	private String type;
	@Column(name = "collection")
	private double collection;
	@Column(name = "budget")
	private double budget;

}
