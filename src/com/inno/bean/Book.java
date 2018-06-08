package com.inno.bean;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Id;

@SuppressWarnings("serial")
@PersistenceCapable
public class Book implements Serializable{

	@Id
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long bId;
	
	//BE, BTECH, BSC etc  
	@Persistent
	private String course;
	
	//ECE,IT,EEE,Mech etc.
	@Persistent
	private String dept;

	//Section -A, Section B etc.
	@Persistent
	private String section;
	
	@Persistent
	private int year;
	
	@Persistent
	private String category;
	
	@Persistent
	private String bookUrl;
	
	@Persistent
	private String bookName;

	public Book() {
		super();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookUrl() {
		return bookUrl;
	}

	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}

	public Long getbId() {
		return bId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
