package com.inno.staff.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inno.bean.Book;
import com.inno.manager.ProvideApprovalManager;


@Controller
@RequestMapping("/lms/admindeletebooks")
public class AdminDeleteBookController{
	
	private ProvideApprovalManager approveMgr = new ProvideApprovalManager();

	// Display the form on the get request
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String deleteBookForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "DeleteBook";
		Map<Long,Book> booksMap = approveMgr.getBooks();
		model.put("booksMap",booksMap);
		return forwardView;
	}
}
