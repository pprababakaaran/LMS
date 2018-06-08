package com.inno.staff.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.inno.bean.Book;
import com.inno.utils.BookDao;

@SuppressWarnings("serial")
public class ServeServlet extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private BookDao dao = new BookDao();
    
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException {
		Long id = Long.parseLong(req.getParameter("bid"));
		Book book = dao.findById(id);
		res.setHeader("Content-Disposition", "inline; filename=\"" + book.getBookName() + "\"");
		String sBookUrl = book.getBookUrl();
		blobstoreService.serve(new BlobKey(sBookUrl), res);
    }
}
