<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.inno.bean.Registration,
				 com.inno.utils.Utility,
				 com.inno.constants.Constants" %>
<% 
	Registration userBean = (Registration)session.getAttribute("userBean");
	if(null==userBean){
		%><jsp:forward page="accessdenied.htm"/><%
	}
%>
<!doctype html>
			<div id="toplinks">
			<%if(!Utility.isEmpty(userBean.getName())){ %>
				<p>Welcome, <%= userBean.getName()%></p>
			<% } %>
				<a href="/lms/logout.htm">Logout</a>
			</div>

			<div id="zaglavlje">
				<div id="title">
					<p style="color:#fff; padding-left: 20px;">VCEW Learning Management System</p>
				</div>
			</div>

			<div id="navigacija">
				<%if(Constants.STUDENT_TYPE.equalsIgnoreCase(userBean.getType())){ %>
				<ul>
					<li><a href="/lms/changeprofile.htm">Change Profile</a></li>
					<li><a href="/lms/displaybooks.htm">Display Books</a></li>
				</ul>
				<%} else if(Constants.STAFF_TYPE.equalsIgnoreCase(userBean.getType())){ %>
				<ul>
					<li><a href="/lms/changeprofile.htm">Change Profile</a></li>
					<li><a href="/lms/approvalstudent.htm">Approve Account</a></li>
					<li><a href="/lms/deletestudentform.htm">Delete Account</a></li>
					<li><a href="/lms/uploadbooks.htm">Upload Books</a></li>
					<li><a href="/lms/deletebooks.htm">Delete Books</a></li>
				</ul>
				<%} else if(Constants.ADMIN_TYPE.equalsIgnoreCase(userBean.getType())){ %>
				<ul>
					<li><a href="/lms/changeprofile.htm">Change Profile</a></li>
					<li><a href="/lms/approvalstaff.htm">Approve Account</a></li>
					<li><a href="/lms/deletestaffform.htm">Delete Account</a></li>
					<li><a href="/lms/uploadbooks.htm">Upload Books</a></li>
					<li><a href="/lms/admindeletebooks.htm">Delete Books</a></li>
				</ul>
				<%} %>

				<%--
				<div class="lijevo">
				<%if(Constants.STUDENT_TYPE.equalsIgnoreCase(userBean.getType())){ %>
					<p><b>Topics</b></p>
					<p>
					<a href="#">Books</a><br />
					<a href="#">Exercises</a><br />
					<a href="#">Lab</a><br />
					</p>
					<%} %>
				</div>
				--%>
			</div>