package com.assignment.Demandtec.model;

public class PhrasePerPageRequest {

	private int pageNumber;
	private String keywords;
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public PhrasePerPageRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhrasePerPageRequest(int pageNumber, String keywords) {
		super();
		this.pageNumber = pageNumber;
		this.keywords = keywords;
	}
	
}
