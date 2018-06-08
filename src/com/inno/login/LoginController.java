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
import com.inno.utils.Utility;


@Controller
@RequestMapping("/lms/loginform")
public class LoginController {
	private LoginManager loginMgr = new LoginManager();
	private RegistrationManager regMgr = new RegistrationManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	public String processLoginForm(HttpServletRequest request, HttpServletResponse response,Map model){
		HttpSession ses = request.getSession(true);
		String forwardView = "Home";
		String loginId = request.getParameter("login_userid");
		String pwd = request.getParameter("login_pwd");
		Registration reg = loginMgr.getUserDetails(loginId, pwd);
		if (Utility.isEmpty(loginId) || Utility.isEmpty(pwd) || null == reg) {
			request.setAttribute("err_msg", Constants.LOGIN_ERR_MSG);
		}else if (null != reg && reg.getIsActive()==Constants.ACC_ACTIVE){
			ses.setAttribute("userBean", reg);
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
		}else{
			request.setAttribute("err_msg", Constants.INACTIVE_MSG);
		}
		return forwardView;
	}
}
