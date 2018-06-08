package com.inno.staff.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inno.bean.Book;
import com.inno.bean.Registration;
import com.inno.manager.ProvideApprovalManager;


@Controller
@RequestMapping("/lms/deletebooksuccess")
public class DeleteBookCallController {
	
	private ProvideApprovalManager approveMgr = new ProvideApprovalManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	public String approveForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "DeleteBook";
		HttpSession ses = request.getSession(true);
		Registration userBean = (Registration)ses.getAttribute("userBean");
		final String[] sBId = request.getParameterValues("bId");
		if(null != sBId && sBId.length > 0){
			for(String bId : sBId){
				approveMgr.deleteBooks(Long.parseLong(bId));
			}
			forwardView = "DeleteBookSuccess";
		}else{
			Map<Long,Book> booksMap = approveMgr.getBooks(userBean.getCourse(), userBean.getDept(), userBean.getSection(), userBean.getYear());
			model.put("booksMap",booksMap);
		}
		return forwardView;
	}
}
