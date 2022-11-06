package com.xworkz.projects.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xworkz.projects.credentials.StadiumCredentials;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stadium")
public class StadiumEntity {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "foundedYear")
	private int foundedYear;
	@Column(name = "capacity")
	private double capacity;
	@Column(name = "entryFees")
	private double entryFees;
	@Column(name = "credentials")
	private StadiumCredentials credentials;

}
