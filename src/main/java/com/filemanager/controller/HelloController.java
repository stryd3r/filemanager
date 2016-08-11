package com.filemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.service.interfaces.QuestionService;
import com.filemanager.service.interfaces.UserService;
import com.filemanager.transporters.dto.QuestionDto;
import com.filemanager.transporters.dto.UserDto;
import com.filemanager.transporters.dto.WorkDetailsDto;
import com.filemanager.transporters.transformers.QuestionTransformer;
import com.filemanager.transporters.transformers.UserTransformer;

@RestController
public class HelloController {

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

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

		UserDto userDto = UserTransformer.modelToDto(userService.findById(1));

		return userDto;
	}

	@RequestMapping(value = "/getQuestions", produces = "application/json")
	@ResponseBody
	public List<QuestionDto> getQuestions(@RequestBody boolean onlyUsed) {

		List<QuestionDto> questionsList = QuestionTransformer.getInstance().modelToDtoAsList(questionService.getQuestions(onlyUsed));

		return questionsList;
	}

	@RequestMapping(value = "/insertQuestion")
	@ResponseBody
	public boolean insertQuestion(@RequestBody QuestionDto questionDto) {

		boolean success = questionService.insertQuestion(QuestionTransformer.getInstance().dtoToModel(questionDto));

		return success;
	}

	@RequestMapping(value = "/updateQuestion")
	@ResponseBody
	public boolean updateQuestion(@RequestBody QuestionDto questionDto) {

		boolean success = questionService.updateQuestion(QuestionTransformer.getInstance().dtoToModel(questionDto));

		return success;
	}
	
	@RequestMapping(value = "/removeQuestion")
	@ResponseBody
	public boolean removeQuestion(@RequestBody int questionId) {

		boolean success = questionService.removeQuestion(questionId);

		return success;
	}
}