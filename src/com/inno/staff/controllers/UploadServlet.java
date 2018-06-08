package com.inno.staff.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.inno.bean.Book;
import com.inno.utils.BookDao;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private BookDao dao = new BookDao();
    
    @SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    	
        Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
        BlobKey blobKey = blobs.get(blobs.keySet().iterator().next());
        
        String sCategory = req.getParameter("category");
        String sCourse = req.getParameter("course");
        String sDept = req.getParameter("dept");
        String sSection = req.getParameter("section");
        int year = Integer.parseInt(req.getParameter("year"));
        String sBookUrl = blobKey.getKeyString();
        String sBookName = req.getParameter("bookName");
        System.out.println("bookName::"+sBookName);
        Book book = new Book();
        book.setCategory(sCategory);
        book.setCourse(sCourse);
        book.setDept(sDept);
        book.setSection(sSection);
        book.setYear(year);
        book.setBookUrl(sBookUrl);
        book.setBookName(sBookName);
        dao.save(book);
        res.sendRedirect("/lms/uploadsuccess.htm");
        //res.sendRedirect("/serve?bid="+book.getbId());
    }
}
