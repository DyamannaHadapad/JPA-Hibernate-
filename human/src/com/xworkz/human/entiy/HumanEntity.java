package com.xworkz.human.entiy;

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
@Table(name = "human")
public class HumanEntity {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "name")
	private String name;
	@Column(name = "place")
	private String place;
	@Column(name = "color")
	private String color;
	@Column(name = "companyName")
	private String companyName;
	@Column(name = "hieght")
	private double hieght;
	@Column(name = "salary")
	private double salary;
	@Column(name = "alive")
	private boolean alive;
	@Column(name = "married")
	private boolean married;

}
