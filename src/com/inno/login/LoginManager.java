package com.inno.login;

import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.inno.bean.Registration;
import com.inno.utils.PMF;
import com.inno.utils.Utility;

public class LoginManager {

	PersistenceManager persistenceManager;
	private Logger log = Logger.getLogger(LoginManager.class.getName());

	@SuppressWarnings("unchecked")
	public Registration getUserDetails(String userId, String userPwd){
		Registration reg = null;
		persistenceManager = PMF.get().getPersistenceManager();
		Query query = persistenceManager.newQuery(Registration.class,"userId == userIdParam");
		query.declareParameters("String userIdParam");
		List<Registration> userList = (List<Registration>) query.execute(userId);
		try{
			if(!Utility.isListEmpty(userList)){
				for(Registration loginObj : userList ){
					if(loginObj.getUserId().equals(userId) && loginObj.getPwd().equals(userPwd)){
						reg = loginObj;
						break;
					}
				}
			}
		}catch(Exception ex){
			log.info("Exception occured in getUserDetails::"+ex);
			reg = null;	
		}finally{
			userList.size();
			persistenceManager.close();
		}
		return reg;
	}
}
