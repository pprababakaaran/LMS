package com.inno.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inno.bean.Registration;
import com.inno.constants.Constants;
import com.inno.manager.RegistrationManager;


@Controller
@RequestMapping("/lms/changeprofile")
public class ModifyController {
	private RegistrationManager regMgr = new RegistrationManager();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String callModify(HttpServletRequest request, HttpServletResponse response,Map model){
		HttpSession ses = request.getSession(true);
		String forwardView = "";
		Registration reg = (Registration)ses.getAttribute("userBean");
		model.put("registration", reg);
		model.put("courseMap", regMgr.getCourses());
		if(null!=reg){
			if(Constants.STUDENT_TYPE.equalsIgnoreCase(reg.getType())){
				forwardView = "StudentProfile";
			}else if(Constants.STAFF_TYPE.equalsIgnoreCase(reg.getType())){
				forwardView = "StaffProfile";
			}else if(Constants.ADMIN_TYPE.equalsIgnoreCase(reg.getType())){
				forwardView = "AdminProfile";
			}
		}
		return forwardView;
	}
}
