package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.QuestionnaireAnswersDto;
import com.filemanager.utils.transporters.entities.QuestionnaireAnswers;

public class QuestionnaireAnswerTransformer extends BeanMapper<QuestionnaireAnswers, QuestionnaireAnswersDto> {

	private static volatile QuestionnaireAnswerTransformer instance;

	private QuestionnaireAnswerTransformer() {
	}

	public static QuestionnaireAnswerTransformer getInstance() {
		if (instance == null) {
			synchronized (QuestionnaireAnswerTransformer.class) {
				if (instance == null) {
					instance = new QuestionnaireAnswerTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public QuestionnaireAnswers dtoToEntity(QuestionnaireAnswersDto dto) {
		QuestionnaireAnswers entity = new QuestionnaireAnswers();
		if (dto != null) {
			entity.setAnswer(dto.getAnswer());
			entity.setPacient(PacientTransformer.getInstance().dtoToEntity(dto.getPacient()));
			entity.setQuestionnaire(QuestionnaireTransformer.getInstance().dtoToEntity(dto.getQuestionnaire()));
			entity.setQuestionnaireAnswerId(dto.getQuestionnaireAnswerId());
		}
		return entity;
	}

	@Override
	public QuestionnaireAnswersDto entityToDto(QuestionnaireAnswers entity) {
		QuestionnaireAnswersDto dto = new QuestionnaireAnswersDto();
		if (entity != null) {
			dto.setAnswer(entity.getAnswer());
			dto.setPacient(PacientTransformer.getInstance().entityToDto(entity.getPacient()));
			dto.setQuestionnaire(QuestionnaireTransformer.getInstance().entityToDto(entity.getQuestionnaire()));
			dto.setQuestionnaireAnswerId(entity.getQuestionnaireAnswerId());
		}
		return dto;
	}

}