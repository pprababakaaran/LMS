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
import com.inno.manager.MailingManager;
import com.inno.manager.ProvideApprovalManager;
import com.inno.utils.Utility;


@Controller
@RequestMapping("/lms/approvestudent")
public class StudentApproveCallController {
	
	private ProvideApprovalManager approveMgr = new ProvideApprovalManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	public String approveForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "ApproveStudent";
		HttpSession ses = request.getSession(true);
		Registration userBean = (Registration)ses.getAttribute("userBean");
		final String[] sUserId = request.getParameterValues("userId");
		if(null != sUserId && sUserId.length > 0){
			Registration reg = null;
			for(String user : sUserId){
				reg = approveMgr.activateAccount(user);
				if(null!=reg && !Utility.isEmpty(reg.getEmailId())){
					MailingManager.sendActivationMail(reg);
				}
			}
			forwardView = "AccountActivationSuccess";
		}else{
			Map<String,Registration> unApprovedMap = approveMgr.getInActiveAccounts(Constants.STUDENT_TYPE,userBean,Constants.ACC_INACTIVE);
			model.put("unApprovedMap",unApprovedMap);
		}
		return forwardView;
	}
}
