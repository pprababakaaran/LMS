package com.inno.bean;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Department {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long deptId;
	
	@Persistent
	private String deptName;
	
	@Persistent
	private String courseName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getDeptId() {
		return deptId;
	}
	public Department() {
		super();
	}
	public Department(String deptName, String courseName) {
		this.deptName = deptName;
		this.courseName = courseName;
	}
	
}
