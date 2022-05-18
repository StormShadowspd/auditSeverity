package com.audit.severity.model;


public class AuditQuestion{
	
	private int questionId;
	
	private String auditType;
	
	private String question;
	
	private String response;
	
	@Override
	public String toString() {
		return question;
	}

	
	public AuditQuestion() {
		super();
	}


	public AuditQuestion(int questionId, String auditType, String question, String response) {
		super();
		this.questionId = questionId;
		this.auditType = auditType;
		this.question = question;
		this.response = response;
	}


	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestions(String question) {
		this.question = question;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	
}
