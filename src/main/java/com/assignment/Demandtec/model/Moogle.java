package com.assignment.Demandtec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import com.sun.istack.NotNull;

@Entity
@Indexed
@Table(name="moogle_table")
public class Moogle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Field(termVector = TermVector.YES)
	private String heading;
	
	@NotNull
	@Field(termVector = TermVector.YES)
	private String shortDescription;
	
	@NotNull
	@Column(length = 1000)
	@Field(termVector = TermVector.YES)
	private String longDescription;
	
	@NotNull
	@Field(termVector = TermVector.YES)
	private String url;
	
	@NotNull
	@Field(termVector = TermVector.YES)
	private String contentType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Moogle(int id, String heading, String shortDescription, String longDescription, String url,
			String contentType) {
		super();
		this.id = id;
		this.heading = heading;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.url = url;
		this.contentType = contentType;
	}

	public Moogle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
