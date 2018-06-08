package com.inno.staff.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inno.bean.Registration;
import com.inno.constants.Constants;
import com.inno.manager.ProvideApprovalManager;


@Controller
@RequestMapping("/lms/approvalstaff")
public class StaffApprovalController {
	
	private ProvideApprovalManager approveMgr = new ProvideApprovalManager();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String showStudentApproveForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "ApproveStaff";
		Map<String,Registration> unApprovedMap = approveMgr.getInActiveAccounts(Constants.STAFF_TYPE,Constants.ACC_INACTIVE);
		model.put("unApprovedMap",unApprovedMap);
		return forwardView;
	}
}
