package com.filemanager.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/*@Autowired
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
	}*/
}