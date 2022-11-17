package com.xworkz.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shirt-info")
@NamedQueries({ @NamedQuery(name = "save", query = "") })
public class ShirtEntity {
	@Id
	@GenericGenerator(name = "save", strategy = "increment")
	@GeneratedValue(generator = "save")
	@Column
	private int id;
	@Column
	private String colour;
	@Column
	private String type;
	@Column
	private String brand;
	@Column
	private double price;
}
