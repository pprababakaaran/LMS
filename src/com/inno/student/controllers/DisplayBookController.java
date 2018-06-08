package com.inno.student.controllers;

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
@RequestMapping("/lms/displaybooks")
public class DisplayBookController{
	
	private ProvideApprovalManager approveMgr = new ProvideApprovalManager();

	// Display the form on the get request
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String displayBookForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "DisplayBook";
		HttpSession ses = request.getSession(true);
		Registration userBean = (Registration)ses.getAttribute("userBean");
		Map<Long,Book> booksMap = approveMgr.getBooks(userBean.getCourse(), userBean.getDept(), userBean.getSection(), userBean.getYear());
		model.put("booksMap",booksMap);
		return forwardView;
	}
}
