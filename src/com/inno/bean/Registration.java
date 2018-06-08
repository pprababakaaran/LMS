package com.inno.bean;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.hibernate.validator.constraints.Email;

@SuppressWarnings("serial")
@PersistenceCapable
public class Registration implements Serializable{

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long Id;
	
	//Student ID/Staff ID	
	@Persistent
	private String userId;
	
	//Student name/Staff name
	@Persistent
	private String name;
	
	//Student/Staff
	@Persistent
	private String type;
	
	//BE, BTECH, BSC etc  
	@Persistent
	private String course;
	
	//ECE,IT,EEE,Mech etc.
	@Persistent
	private String dept;

	//Section -A, Section B etc.
	@Persistent
	private String section;
	
	//HOD, Ass.proffesor, lecturer etc.
	@Persistent
	private String position;
	
	@Persistent
	private int year;
	
	@Persistent
	private String mobileNo;
	
	@Email
	@Persistent
	private String emailId;
	
	@Persistent
	private String pwd;

	@NotPersistent
	private String confirmPwd;
	
	//1-Active, 0-InActive
	@Persistent
	private int isActive;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getId() {
		return Id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
