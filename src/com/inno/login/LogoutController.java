package com.inno.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lms/logout")
public class LogoutController {
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET)
	public String sessionInvalidate(HttpServletRequest request, HttpServletResponse response,Map model){
		HttpSession ses = request.getSession(true);
		ses.setAttribute("userBean", null);
		if(null != ses) {
			ses.invalidate();
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control","no-store");
			response.setDateHeader("Expires", 0);
		}
		return "Home";
	}
}
