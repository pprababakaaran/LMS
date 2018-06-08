package com.inno.staff.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inno.bean.Registration;
import com.inno.constants.Constants;
import com.inno.manager.ProvideApprovalManager;


@Controller
@RequestMapping("/lms/deletestudentform")
public class DeleteStudentController {
	
	private ProvideApprovalManager approveMgr = new ProvideApprovalManager();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String showStudentDeleteForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "DeleteStudent";
		HttpSession ses = request.getSession(true);
		Registration userBean = (Registration)ses.getAttribute("userBean");
		Map<String,Registration> approvedMap = approveMgr.getInActiveAccounts(Constants.STUDENT_TYPE,userBean,Constants.ACC_ACTIVE);
		model.put("approvedMap",approvedMap);
		return forwardView;
	}
}
