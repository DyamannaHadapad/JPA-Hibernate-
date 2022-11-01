package com.xworkz.krawardees.DTO;

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
@Table(name = "krawardees")
public class KRAwardeesDTO {

	@Id
	private int id;
	private String name;
	private int year;
	private String achivement;
	private boolean alive;
	private int age;
	private String place;

}
