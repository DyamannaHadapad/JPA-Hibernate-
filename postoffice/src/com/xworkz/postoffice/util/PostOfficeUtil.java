package com.xworkz.postoffice.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PostOfficeUtil {

	private static EntityManagerFactory factory;

	public static EntityManagerFactory getFactory() {
		return factory;
	}

	static {
		factory = Persistence.createEntityManagerFactory("com.xworkz");
		System.out.println(factory);
	}

}
