package com.inno.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.inno.bean.Course;
import com.inno.bean.Department;
import com.inno.bean.Registration;
import com.inno.utils.PMF;
import com.inno.utils.Utility;

public class RegistrationManager {

	PersistenceManager persistenceManager;

	public void addRegistration(Registration register){
		persistenceManager = PMF.get().getPersistenceManager();
		//register.setType("Admin");
		//register.setIsActive(1);
		persistenceManager.makePersistent(register);
		persistenceManager.close();
	}
	
	public void addCourse(Course course){
		persistenceManager = PMF.get().getPersistenceManager();
		persistenceManager.makePersistent(course);
		persistenceManager.close();
	}

	public void addDepartment(Department dept){
		persistenceManager = PMF.get().getPersistenceManager();
		persistenceManager.makePersistent(dept);
		persistenceManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Course> getCourses(){
		Map<String, Course> courseMap= new HashMap<String, Course>();
		persistenceManager = PMF.get().getPersistenceManager();
		List<Course> courseList = (List<Course>) persistenceManager.newQuery(Course.class).execute();
		if(!Utility.isListEmpty(courseList)){
			for(Course courseObj : courseList){
				courseMap.put(courseObj.getCourseName(), courseObj);
			}
		}
		courseList.size();
		persistenceManager.close();
		return courseMap;
	}
	
	@SuppressWarnings("unchecked")
	public List<Department> getDepartment(String courseName){
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Department.class,"courseName == courseNameParam");
		query.declareParameters("String courseNameParam");
		List<Department> deptList = (List<Department>) query.execute(courseName);
		deptList.size();
		persistenceManager.close();
		return deptList;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isExistingUser(String userId){
		boolean isUserExists = false;
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Registration.class,"userId == userIdParam");
		query.declareParameters("String userIdParam");
		List<Registration> userList = (List<Registration>) query.execute(userId);
		if(!Utility.isListEmpty(userList)){
			isUserExists = true;
		}
		userList.size();
		persistenceManager.close();
		return isUserExists;
	}
	
	//Method to modify the machinery details to Machinery table
	@SuppressWarnings("unchecked")
	public void modifyAccounts(String userName, Registration reg){
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Registration.class,"userId == userIdParam");
		query.declareParameters("String userIdParam");
		List<Registration> userList = (List<Registration>) query.execute(userName);
		if(!Utility.isListEmpty(userList)){
			for(Registration regObj : userList){
				regObj.setPwd(reg.getPwd());
				regObj.setEmailId(reg.getEmailId());
				regObj.setName(reg.getName());
				regObj.setCourse(reg.getCourse());
				regObj.setDept(reg.getDept());
				regObj.setSection(reg.getSection());
				regObj.setYear(reg.getYear());
				regObj.setMobileNo(reg.getMobileNo());
				regObj.setPosition(reg.getPosition());
				persistenceManager.makePersistent(regObj);
			}
		}
		userList.size();
		persistenceManager.close();
	}
}
