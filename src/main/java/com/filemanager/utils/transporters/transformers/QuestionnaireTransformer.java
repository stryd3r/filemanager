package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.QuestionnaireDto;
import com.filemanager.utils.transporters.entities.Questionnaire;

public class QuestionnaireTransformer extends BeanMapper<Questionnaire, QuestionnaireDto> {

	private static volatile QuestionnaireTransformer instance;

	private QuestionnaireTransformer() {
	}

	public static QuestionnaireTransformer getInstance() {
		if (instance == null) {
			synchronized (QuestionnaireTransformer.class) {
				if (instance == null) {
					instance = new QuestionnaireTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public Questionnaire dtoToEntity(QuestionnaireDto dto) {
		Questionnaire entity = new Questionnaire();
		if (dto != null) {
			entity.setId(QuestionnairePKTransformer.getInstance().dtoToEntity(dto.getId()));
			entity.setQuestion(dto.getQuestion());
			entity.setQuestionnaireAnswer(QuestionnaireAnswerTransformer.getInstance().dtoToEntityAsList(dto.getQuestionnaireAnswer()));
		}
		return entity;
	}

	@Override
	public QuestionnaireDto entityToDto(Questionnaire entity) {
		QuestionnaireDto dto = new QuestionnaireDto();
		if (entity != null) {
			dto.setId(QuestionnairePKTransformer.getInstance().entityToDto(entity.getId()));
			dto.setQuestion(entity.getQuestion());
			dto.setQuestionnaireAnswer(QuestionnaireAnswerTransformer.getInstance().entityToDtoAsList(entity.getQuestionnaireAnswer()));
		}
		return dto;
	}

}