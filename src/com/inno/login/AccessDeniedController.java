package com.inno.login;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/accessdenied")
public class AccessDeniedController {
	// Display the form on the get request
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public String accessDenied(Map model) {
		return "AccessDenied";
	}
}
