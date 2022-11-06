package com.xworkz.projects.credentials;

import lombok.Getter;

public enum StadiumCredentials {

	INDOOR("Indoor Stadium"), OUTDOOR("Outdoor Stadium");
@Getter
	private String value;

	private StadiumCredentials(String value) {
		this.value = value;

	}

}
