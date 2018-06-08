package com.inno.student.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.inno.bean.Department;
import com.inno.bean.Registration;
import com.inno.constants.Constants;
import com.inno.manager.RegistrationManager;
import com.inno.utils.Utility;
import com.inno.validations.RegistrationValidation;


@Controller
@RequestMapping("/lms/registration")
public class RegistrationController {
	@Autowired
	private RegistrationValidation registrationValidation;
	private RegistrationManager regMgr = new RegistrationManager();

	public void setRegistrationValidation(RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String registrationForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String userType = request.getParameter("type");
		//Uncomment below line add Course & Department details
		//regMgr.addCourse(new Course("B.Sc",3));
		//regMgr.addDepartment(new Department("Computer Science and Engineering","B.E"));
		String forwardView = "AccessDenied";
		if(!Utility.isEmpty(userType)){
			Registration registration = new Registration();
			model.put("courseMap", regMgr.getCourses());
			model.put("registration", registration);
			if(Constants.STUDENT_TYPE.equalsIgnoreCase(userType)){
				forwardView = "StudentRegister";
			}else if(Constants.STAFF_TYPE.equalsIgnoreCase(userType)){
				forwardView = "StaffRegister";
			}else{
				forwardView = "AccessDenied";
			}
		}
		return forwardView;
	}

	// Process the Inquiry Form
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistrationForm(@Valid Registration registration, BindingResult result, Map model) {
		// set custom Validation by user
		String forwardView = "StudentRegister";
		registrationValidation.validate(registration, result);
		if (result.hasErrors()) {
			model.put("courseMap", regMgr.getCourses());
			if(!Utility.isEmpty(registration.getType()) && Constants.STUDENT_TYPE.equalsIgnoreCase(registration.getType())){
				forwardView =  "StudentRegister";
			}else if(!Utility.isEmpty(registration.getType()) && Constants.STAFF_TYPE.equalsIgnoreCase(registration.getType())){
				forwardView =  "StaffRegister";
			}
			
		}else{
			//Calling methods to insert records into DataStore
			model.put("regMessage", Constants.REG_MSG);
			registration.setIsActive(0);
			regMgr.addRegistration(registration);
			forwardView = "RegistrationSuccess";
		}
		return forwardView;
	}

	@RequestMapping(value="/dept", method = RequestMethod.POST)
	public void getDept(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String course = request.getParameter("course");
		List<Department> deptList = null;
		try {
			Gson gson = new Gson();
			deptList = regMgr.getDepartment(course);
			out = response.getWriter();
			String messages = gson.toJson(deptList);
			out.println("{\"Messages\":"+messages+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
