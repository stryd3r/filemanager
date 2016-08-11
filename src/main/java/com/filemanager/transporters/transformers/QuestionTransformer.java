package com.filemanager.transporters.transformers;

import com.filemanager.transporters.dto.QuestionDto;
import com.filemanager.transporters.model.QuestionModel;
import com.filemanager.utils.BeanMapper;

public class QuestionTransformer extends BeanMapper<QuestionModel, QuestionDto>{
	
	private static volatile QuestionTransformer instance;

	private QuestionTransformer() {
	}

	public static QuestionTransformer getInstance() {
		if (instance == null) {
			synchronized (QuestionTransformer.class) {
				if (instance == null) {
					instance = new QuestionTransformer();
				}
			}
		}
		return instance;
	}


	@Override
	public QuestionDto modelToDto(QuestionModel model) {

		QuestionDto dto = new QuestionDto();

		dto.setId(model.getId());
		dto.setQuestion(model.getQuestion());
		dto.setAnswer(model.getAnswer());
		dto.setUsed(model.isUsed());

		return dto;

	}

	@Override
	public  QuestionModel dtoToModel(QuestionDto dto) {

		QuestionModel model = new QuestionModel();

		model.setId(dto.getId());
		model.setQuestion(dto.getQuestion());
		model.setAnswer(dto.getAnswer());
		model.setUsed(dto.isUsed());

		return model;

	}

}
