package com.filemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filemanager.model.UserModel;
import com.filemanager.repository.TestRepository;

@Controller
public class HelloController {

	@Autowired
	private TestRepository repository;

	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		return "Hello, world.";
	}

	@RequestMapping("/index")
	public String userList() {

		System.out.println("in index");
		return "test/index";
	}

	@RequestMapping("/findByID/{id}")
	@ResponseBody
	public UserModel findUser(@PathVariable("id") int id) {

		return repository.findById(id);
	}

}