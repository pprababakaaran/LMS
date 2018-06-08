package com.inno.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.inno.bean.Book;
import com.inno.bean.Registration;
import com.inno.constants.Constants;
import com.inno.utils.PMF;
import com.inno.utils.Utility;

public class ProvideApprovalManager {

	PersistenceManager persistenceManager;

	
	@SuppressWarnings("unchecked")
	public Map<String, Registration> getInActiveAccounts(String sType,Registration user,int accValue){
		Map<String, Registration> inActiveUserMap= new HashMap<String, Registration>();
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Registration.class,"type==pType && course==pCourse && dept==pDept && section==pSection && year==pYear && isActive==pIsActive");
		query.declareParameters("String pType, String pCourse, String pDept, String pSection, int pYear, int pIsActive");
		List<Registration> inActiveList = (List<Registration>) query.executeWithArray(sType, user.getCourse(), user.getDept(), user.getSection(),user.getYear(),accValue);
		if(!Utility.isListEmpty(inActiveList) ){
			for(Registration regObj : inActiveList ){
				inActiveUserMap.put(regObj.getUserId(), regObj);
			}
		}
		inActiveList.size();
		persistenceManager.close();
		return inActiveUserMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Registration> getInActiveAccounts(String sType,int accValue){
		Map<String, Registration> inActiveUserMap= new HashMap<String, Registration>();
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Registration.class,"type==pType && isActive==pIsActive");
		query.declareParameters("String pType, int pIsActive");
		List<Registration> inActiveList = (List<Registration>) query.executeWithArray(sType, accValue);
		if(!Utility.isListEmpty(inActiveList) ){
			for(Registration regObj : inActiveList ){
				inActiveUserMap.put(regObj.getUserId(), regObj);
			}
		}
		inActiveList.size();
		persistenceManager.close();
		return inActiveUserMap;
	}
	
	@SuppressWarnings("unchecked")
	public Registration activateAccount(String sUserId){
		Registration reg = null;
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Registration.class,"userId == pUserId");
		query.declareParameters("String pUserId");
		List<Registration> userList = (List<Registration>) query.executeWithArray(sUserId);
		if(!Utility.isListEmpty(userList) ){
			for(Registration regObj : userList ){
				regObj.setIsActive(Constants.ACC_ACTIVE);
				persistenceManager.makePersistent(regObj);
				reg = regObj;
			}
		}
		userList.size();
		persistenceManager.close();
		return reg;
	}
	
	@SuppressWarnings("unchecked")
	public Registration deleteAccounts(String userName){
		Registration reg = null;
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Registration.class,"userId == userIdParam");
		query.declareParameters("String userIdParam");
		List<Registration> userList = (List<Registration>) query.execute(userName);
		if(!Utility.isListEmpty(userList)){
			for(Registration regObj : userList){
				persistenceManager.deletePersistent(regObj);
				reg = regObj;
			}
		}
		userList.size();
		persistenceManager.close();
		return reg;
	}
	
	@SuppressWarnings("unchecked")
	public Map<Long, Book> getBooks(String sCourse,String sDept,String sSection, int year){
		Map<Long, Book> booksMap= new HashMap<Long, Book>();
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Book.class,"course==pCourse && dept==pDept && section==pSection && year==pYear");
		query.declareParameters("String pCourse, String pDept, String pSection, int pYear");
		List<Book> booksList = (List<Book>) query.executeWithArray(sCourse, sDept, sSection, year);
		if(!Utility.isListEmpty(booksList) ){
			for(Book bookObj : booksList ){
				booksMap.put(bookObj.getbId(),bookObj);
			}
		}
		booksList.size();
		persistenceManager.close();
		return booksMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<Long, Book> getBooks(){
		Map<Long, Book> booksMap= new HashMap<Long, Book>();
		persistenceManager = PMF.get().getPersistenceManager();
		List<Book> booksList = (List<Book>) persistenceManager.newQuery(Book.class).execute();
		if(!Utility.isListEmpty(booksList) ){
			for(Book bookObj : booksList ){
				booksMap.put(bookObj.getbId(),bookObj);
			}
		}
		booksList.size();
		persistenceManager.close();
		return booksMap;
	}
	
	@SuppressWarnings("unchecked")
	public void deleteBooks(Long bId){
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Book.class,"bId == bIdParam");
		query.declareParameters("Long bIdParam");
		List<Book> bookList = (List<Book>) query.execute(bId);
		if(!Utility.isListEmpty(bookList)){
			for(Book bookObj : bookList){
				persistenceManager.deletePersistent(bookObj);
			}
		}
		bookList.size();
		persistenceManager.close();
	}
	
}
