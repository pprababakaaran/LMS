package com.inno.bean;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Course {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long courseId;
	
	@Persistent
	private String courseName;
	
	@Persistent
	private int year;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Long getCourseId() {
		return courseId;
	}
	public Course() {
		super();
	}
	
	public Course(String courseName,int year ) {
		this.courseName = courseName;
		this.year = year;
	}
	
}
