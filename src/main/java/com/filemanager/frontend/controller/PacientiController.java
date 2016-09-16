package com.filemanager.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.backend.entities.Pacienti;
import com.filemanager.backend.service.interfaces.PacientiService;

@RestController
public class PacientiController {

	@Autowired
	private PacientiService service;

	@RequestMapping(value = "/getPacienti", produces = "application/json")
	public List<Pacienti> getPacienti() {
		List<Pacienti> result = service.getPacienti();
		System.out.println("ok");

		return result;
	}

}
