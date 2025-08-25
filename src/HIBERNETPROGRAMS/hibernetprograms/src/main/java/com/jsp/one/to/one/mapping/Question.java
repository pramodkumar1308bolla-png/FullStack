package com.jsp.one.to.one.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name="questin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String question;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="answer_id")
	private Answer answer;
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public Question(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + "]";
	}
	

}
