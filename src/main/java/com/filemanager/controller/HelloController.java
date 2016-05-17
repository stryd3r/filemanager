package com.filemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filemanager.dto.UserDto;
import com.filemanager.dto.WorkDetailsDto;
import com.filemanager.model.UserModel;
import com.filemanager.repository.TestRepository;
import com.filemanager.transformers.UserTransformer;

@Controller
public class HelloController {

	@Autowired
	private TestRepository repository;

	@RequestMapping(value = "hi")
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

		UserDto userDto = new UserDto();

		userDto.setId(1);
		userDto.setName("Barna");
		userDto.setSurname("Adrian");

		return userDto;
	}

	@RequestMapping(value = "/getUserById", produces = "application/json")
	public @ResponseBody UserDto getUserById(@RequestBody WorkDetailsDto workDetails) {

		UserDto userDto = UserTransformer.modelToDto(repository.findById(1));

		return userDto;
	}

}