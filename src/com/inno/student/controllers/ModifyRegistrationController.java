package com.inno.student.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inno.bean.Registration;
import com.inno.constants.Constants;
import com.inno.manager.RegistrationManager;
import com.inno.utils.Utility;
import com.inno.validations.ModifyRegistrationValidation;


@Controller
@RequestMapping("/lms/modifyregistration")
public class ModifyRegistrationController {
	@Autowired
	private ModifyRegistrationValidation modifyRegistrationValidation;
	private RegistrationManager regMgr = new RegistrationManager();

	public void setRegistrationValidation(ModifyRegistrationValidation modifyRegistrationValidation) {
		this.modifyRegistrationValidation = modifyRegistrationValidation;
	}

	// Process the Inquiry Form
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.POST)
	public String modifyRegistrationForm(HttpServletRequest request, HttpServletResponse response,@Valid Registration registration, BindingResult result, Map model) {
		HttpSession ses = request.getSession(true);
		String forwardView = "";
		modifyRegistrationValidation.validate(registration, result);
		if (result.hasErrors()) {
			model.put("courseMap", regMgr.getCourses());
			if(!Utility.isEmpty(registration.getType()) && Constants.STUDENT_TYPE.equalsIgnoreCase(registration.getType())){
				forwardView =  "StudentProfile";
			}else if(!Utility.isEmpty(registration.getType()) && Constants.STAFF_TYPE.equalsIgnoreCase(registration.getType())){
				forwardView =  "StaffProfile";
			}else if(!Utility.isEmpty(registration.getType()) && Constants.ADMIN_TYPE.equalsIgnoreCase(registration.getType())){
				forwardView =  "AdminProfile";
			}
		}else{
			regMgr.modifyAccounts(registration.getUserId(),registration);
			ses.setAttribute("userBean", registration);
			forwardView = "ModifyAccountSuccess";
		}
		return forwardView;
	}
}
