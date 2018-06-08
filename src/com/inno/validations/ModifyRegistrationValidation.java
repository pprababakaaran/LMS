package com.inno.validations;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.inno.bean.Registration;
import com.inno.utils.Utility;

@Component("modifyRegistrationValidator")
public class ModifyRegistrationValidation {
	 
		private static final String ALPHABETS_PATTERN = "^[a-zA-Z]+$";
		private static final String PHONE_PATTERN = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		
		private Pattern pattern ;
		private Matcher matcher ;
		public boolean supports(Class<?> klass) {
			return Registration.class.isAssignableFrom(klass);
		}

		public void validate(Object register, Errors errors) {
			Registration registration = (Registration)register;
			String sUserId = !Utility.isEmpty(registration.getUserId())?registration.getUserId():"";
			String sPwd = !Utility.isEmpty(registration.getPwd())?registration.getPwd():"";
			String sConfirmPwd = !Utility.isEmpty(registration.getConfirmPwd())?registration.getConfirmPwd():"";
			String sName = !Utility.isEmpty(registration.getName())?registration.getName():"";
			String sDept = !Utility.isEmpty(registration.getDept())?registration.getDept():"";
			String sMobileNo = !Utility.isEmpty(registration.getMobileNo())?registration.getMobileNo():"";
			
			//Checking all the values for Empty or Whitespace - STARTS
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "NotEmpty.registration.userId");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pwd","NotEmpty.registration.pwd");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confirmPwd","NotEmpty.registration.confirmPwd");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"emailId","NotEmpty.registration.emailId");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","NotEmpty.registration.name");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mobileNo","NotEmpty.registration.mobileNo");
			//Checking all the values for Empty or Whitespace - ENDS
			
			//User ID field validation
			if(sUserId.trim().length() > 0 && sUserId.trim().length() < 2){
				errors.rejectValue("userId","MinLength.registration.userId");
			}else if(sUserId.trim().length() > 0 && sUserId.trim().length() > 30){
				errors.rejectValue("userId","MaxLength.registration.userId");
			}
			
			//Name field validation
			if(sName.trim().length() > 0 && sName.trim().length() < 2){
				errors.rejectValue("name","MinLength.registration.name");
			}else if(sName.trim().length() > 0 && sName.trim().length() > 30){
				errors.rejectValue("name","MaxLength.registration.name");
			}else if(sName.trim().length() > 0){
				pattern = Pattern.compile(ALPHABETS_PATTERN);;
				matcher = pattern.matcher(sName);
				if(!matcher.matches()){
					errors.rejectValue("name","Pattern.registration.name");
				}
			}
			
			//Mobile Number field validation
			pattern = Pattern.compile(PHONE_PATTERN);
			matcher = pattern.matcher(sMobileNo);
			if(sMobileNo.trim().length() > 0 && !(sMobileNo.trim().length() == 10) && !matcher.matches()){
				errors.rejectValue("mobileNo","NumberFormat.registration.mobileNo");
			}
			//Password field validation	
			if(sPwd.trim().length() > 0 && sPwd.trim().length() < 4){
				errors.rejectValue("pwd","MinLength.registration.pwd");
			}else if(sPwd.trim().length() > 0 && sPwd.trim().length() > 30){
				errors.rejectValue("pwd","MaxLength.registration.pwd");
			}
			//Confirm Password field validation
			if(sConfirmPwd.trim().length() > 0 && !sConfirmPwd.equals(sPwd)){
				errors.rejectValue("confirmPwd","NotMatch.registration.confirmPwd");
			}
			//Department field validation
			if(!Utility.isEmpty(sDept) && "N/A".equalsIgnoreCase(sDept)){
				errors.rejectValue("dept","Selection.registration.dept");
				
			}
		}
		
}
