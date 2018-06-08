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
@RequestMapping("/lms/admindeletebooksuccess")
public class AdminDeleteBookCallController {
	
	private ProvideApprovalManager approveMgr = new ProvideApprovalManager();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	public String approveForm(HttpServletRequest request, HttpServletResponse response,Map model) {
		String forwardView = "DeleteBook";
		final String[] sBId = request.getParameterValues("bId");
		if(null != sBId && sBId.length > 0){
			for(String bId : sBId){
				approveMgr.deleteBooks(Long.parseLong(bId));
			}
			forwardView = "DeleteBookSuccess";
		}else{
			Map<Long,Book> booksMap = approveMgr.getBooks();
			model.put("booksMap",booksMap);
		}
		return forwardView;
	}
}
