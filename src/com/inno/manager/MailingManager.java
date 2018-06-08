package com.inno.manager;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.inno.bean.Registration;
import com.inno.constants.Constants;


public class MailingManager {
	
	public static void sendActivationMail(Registration reg){
		Logger log = Logger.getLogger(MailingManager.class.getName());
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        StringBuffer msgBody = new StringBuffer();
        msgBody.append("Dear").append(reg.getName()).append("<br/>&nbsp;&nbsp;");
        msgBody.append(Constants.ACC_MAIL).append("<br/>&nbsp;&nbsp;User ID: &nbsp;&nbsp;").append(reg.getUserId());
        msgBody.append("<br/>&nbsp;&nbsp;Password: &nbsp;").append(reg.getPwd());
        msgBody.append("<br/><br/>Regards,<br/>InnoTigers - GAE Developers");
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(Constants.ADMIN_EMAIL,"InnoTigers Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(reg.getEmailId(), reg.getName()));
            msg.addRecipient(Message.RecipientType.CC,
                    new InternetAddress(Constants.ACC_CC_MAIL, Constants.ACC_CC_NAME));
            msg.setSubject("VCEW LMS:: Activation mail");
            Multipart multiPart = new MimeMultipart();
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(msgBody.toString(),"text/html");
            multiPart.addBodyPart(bodyPart);
            msg.setContent(multiPart);
            Transport.send(msg);
    
        } catch (AddressException e) {
        	log.warning("AddressException occured in sendInquiryMail() "+e.getMessage());
        } catch (MessagingException e) {
        	log.warning("MessagingException occured in sendInquiryMail() "+e.getMessage());
        } catch (UnsupportedEncodingException e) {
        	log.warning("MessagingException occured in sendInquiryMail() "+e.getMessage());
		}catch (Exception e) {
			log.warning("MessagingException occured in sendInquiryMail() "+e.getMessage());
		}
	}
	
	public static void sendAccountDeleteMail(Registration reg){
		Logger log = Logger.getLogger(MailingManager.class.getName());
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        StringBuffer msgBody = new StringBuffer();
        msgBody.append("Dear").append(reg.getName()).append("<br/>&nbsp;&nbsp;");
        msgBody.append(Constants.ACC_DEL_MAIL).append("<br/>&nbsp;&nbsp;User ID: &nbsp;&nbsp;").append(reg.getUserId());
        msgBody.append("<br/>&nbsp;&nbsp;Password: &nbsp;").append(reg.getPwd());
        msgBody.append("<br/><br/>Regards,<br/>InnoTigers - GAE Developers");
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(Constants.ADMIN_EMAIL,"InnoTigers Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(reg.getEmailId(), reg.getName()));
            msg.addRecipient(Message.RecipientType.CC,
                    new InternetAddress(Constants.ACC_CC_MAIL, Constants.ACC_CC_NAME));
            msg.setSubject("VCEW LMS:: Account Delete Mail");
            Multipart multiPart = new MimeMultipart();
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(msgBody.toString(),"text/html");
            multiPart.addBodyPart(bodyPart);
            msg.setContent(multiPart);
            Transport.send(msg);
    
        } catch (AddressException e) {
        	log.warning("AddressException occured in sendInquiryMail() "+e.getMessage());
        } catch (MessagingException e) {
        	log.warning("MessagingException occured in sendInquiryMail() "+e.getMessage());
        } catch (UnsupportedEncodingException e) {
        	log.warning("MessagingException occured in sendInquiryMail() "+e.getMessage());
		}catch (Exception e) {
			log.warning("MessagingException occured in sendInquiryMail() "+e.getMessage());
		}
	}
}
