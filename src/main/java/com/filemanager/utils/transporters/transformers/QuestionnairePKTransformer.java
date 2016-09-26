package com.filemanager.utils.transporters.transformers;

import com.filemanager.utils.transporters.dto.QuestionnairePKDto;
import com.filemanager.utils.transporters.entities.QuestionnairePK;

public class QuestionnairePKTransformer extends BeanMapper<QuestionnairePK, QuestionnairePKDto> {

	private static volatile QuestionnairePKTransformer instance;

	private QuestionnairePKTransformer() {
	}

	public static QuestionnairePKTransformer getInstance() {
		if (instance == null) {
			synchronized (QuestionnairePKTransformer.class) {
				if (instance == null) {
					instance = new QuestionnairePKTransformer();
				}
			}
		}
		return instance;
	}

	@Override
	public QuestionnairePK dtoToEntity(QuestionnairePKDto dto) {
		QuestionnairePK entity = new QuestionnairePK();
		if (dto != null) {
			entity.setQuestionId(dto.getQuestionId());
			entity.setQuestionnaireId(dto.getQuestionnaireId());
		}
		return entity;
	}

	@Override
	public QuestionnairePKDto entityToDto(QuestionnairePK entity) {

		QuestionnairePKDto dto = new QuestionnairePKDto();
		if (entity != null) {
			dto.setQuestionId(entity.getQuestionId());
			dto.setQuestionnaireId(entity.getQuestionnaireId());
		}
		return dto;
	}

}