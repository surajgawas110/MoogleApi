package com.assignment.Demandtec.model;

import java.util.List;

public class MoogleDataReturned {

	private List<Moogle> moogles;
	private int pages;
	public List<Moogle> getMoogles() {
		return moogles;
	}
	public void setMoogles(List<Moogle> moogles) {
		this.moogles = moogles;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public MoogleDataReturned() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MoogleDataReturned(List<Moogle> moogles, int pages) {
		super();
		this.moogles = moogles;
		this.pages = pages;
	}
	
}
