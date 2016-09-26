package com.filemanager.utils.transporters.dto;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the chestionare database table.
 * 
 */
@Embeddable
public class QuestionnairePKDto implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int questionnaireId;

	private int questionId;

	public QuestionnairePKDto() {
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuestionnairePKDto)) {
			return false;
		}
		QuestionnairePKDto castOther = (QuestionnairePKDto) other;
		return (this.getQuestionnaireId() == castOther.questionnaireId) && (this.questionId == castOther.questionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.questionnaireId;
		hash = hash * prime + this.questionId;

		return hash;
	}
}