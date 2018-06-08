package com.inno.staff.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inno.bean.Book;
import com.inno.manager.RegistrationManager;


@Controller
@RequestMapping("/lms/uploadbooks")
public class UploadBookController{
	
	private RegistrationManager regMgr = new RegistrationManager();

	// Display the form on the get request
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public String uploadBookForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "AccessDenied";
		Book book = new Book();
		model.put("courseMap", regMgr.getCourses());
		model.put("book", book);
		forwardView = "UploadBook";
		return forwardView;
	}
}
