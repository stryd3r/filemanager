package com.filemanager.dto;

import java.io.Serializable;

public class QuestionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7903184187281503757L;

	private int id;
	private String question;
	private String answer;
	private boolean used;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
}
