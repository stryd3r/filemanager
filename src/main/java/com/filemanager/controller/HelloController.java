package com.filemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.filemanager.dto.QuestionDto;
import com.filemanager.dto.UserDto;
import com.filemanager.dto.WorkDetailsDto;
import com.filemanager.repositoryInterfaces.QuestionRepository;
import com.filemanager.repositoryInterfaces.UserRepository;
import com.filemanager.transformers.QuestionTransformer;
import com.filemanager.transformers.UserTransformer;

@Controller
public class HelloController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private QuestionRepository questionRepository;

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

		UserDto userDto = UserTransformer.modelToDto(userRepository.findById(1));

		return userDto;
	}

	@RequestMapping(value = "/getQuestions", produces = "application/json")
	@ResponseBody
	public List<QuestionDto> getQuestions(@RequestBody boolean onlyUsed) {

		List<QuestionDto> questionsList = QuestionTransformer.getInstance().modelToDtoAsList(questionRepository.getQuestions(onlyUsed));

		return questionsList;
	}

	@RequestMapping(value = "/insertQuestion")
	@ResponseBody
	public boolean insertQuestion(@RequestBody QuestionDto questionDto) {

		boolean success = questionRepository.insertQuestion(QuestionTransformer.getInstance().dtoToModel(questionDto));

		return success;
	}

	@RequestMapping(value = "/updateQuestion")
	@ResponseBody
	public boolean updateQuestion(@RequestBody QuestionDto questionDto) {

		boolean success = questionRepository.updateQuestion(QuestionTransformer.getInstance().dtoToModel(questionDto));

		return success;
	}
	
	@RequestMapping(value = "/removeQuestion")
	@ResponseBody
	public boolean removeQuestion(@RequestBody int questionId) {

		boolean success = questionRepository.removeQuestion(questionId);

		return success;
	}
}