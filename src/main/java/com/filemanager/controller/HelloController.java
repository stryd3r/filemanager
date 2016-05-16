package com.filemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filemanager.dto.UserDto;
import com.filemanager.model.UserModel;
import com.filemanager.repository.TestRepository;

@Controller
public class HelloController {

	@Autowired
	private TestRepository repository;

	@RequestMapping(value = "hi", produces = "application/json")
	@ResponseBody
	public String hi() {
		return "Hello, world.";
	}

	@RequestMapping("/index")
	public String userList() {

		System.out.println("in index");
		return "test/index";
	}

	@RequestMapping("/findById/{id}")
	@ResponseBody
	public UserModel findUser(@PathVariable("id") int id) {

		return repository.findById(id);
	}

	@RequestMapping(value = "/getUserDetails", produces = "application/json")
	public @ResponseBody UserDto getUser() {

		UserDto user = new UserDto();
		user.setSurname("Adrian");
		user.setName("Sorin");

		return user;
	}

}