package com.xworkz.postoffice.entity;

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
@Table(name = "postOffice")
public class PostOfficeEntity {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "branch")
	private String branch;
	@Column(name = "place")
	private String place;
	@Column(name = "employees")
	private int employees;
	@Column(name = "startingTime")
	private double startingTime;
	@Column(name = "closingTime")
	private double closingTime;

}
