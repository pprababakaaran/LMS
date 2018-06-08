package com.inno.staff.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/lms/uploadsuccess")
public class UploadSuccessController{
	
	// Display the form on the get request
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String uploadSuccess(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "AccessDenied";
		forwardView = "UploadSuccess";
		return forwardView;
	}
}
