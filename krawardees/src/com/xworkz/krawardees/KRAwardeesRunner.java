package com.xworkz.krawardees;

import com.xworkz.krawardees.DTO.KRAwardeesDTO;
import com.xworkz.krawardees.service.KRAwardeesService;
import com.xworkz.krawardees.service.KRAwardeesServiceImpl;

public class KRAwardeesRunner {
	public static void main(String[] args) {

		KRAwardeesDTO dto = new KRAwardeesDTO(1, "PunitRajkumar", 2022, "Film", false, 50, "Bangalore");
		KRAwardeesDTO dto1 = new KRAwardeesDTO(2, "Punit", 2025, "FilmIndustry", false, 58, "Guledgudd");

		KRAwardeesService awardeesService = new KRAwardeesServiceImpl();
		awardeesService.validateAndSave(dto);
		awardeesService.validateAndSave(dto1);

	}

}
