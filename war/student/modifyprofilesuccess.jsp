<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.inno.bean.Registration,
				 com.inno.utils.Utility" %>
<% 
	Registration userBean = (Registration)session.getAttribute("userBean");
	if(null==userBean){
		%><jsp:forward page="accessdenied.htm"/><%
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="description" content="vcwe lms" />
	<meta name="keywords" content="vivekanadha,college,lms,learning" />
	<meta name="author" content="innotigers" />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<link href="../favicon.ico" rel="shortcut icon"/>
	<link rel="stylesheet" type="text/css" href="../images/style.css" />
	<link rel="stylesheet" type="text/css" media="all" href="../js/fancybox/jquery.fancybox.css">
	<script type="text/javascript" src="../js/fancybox/jquery.min.js"></script> 
	<script type="text/javascript" src="../js/fancybox/jquery.fancybox.js?v=2.0.6"></script>
	<script type="text/javascript" src="../js/fancybox/loopedslider.js"></script>
	<title>VCEW Learning Management::Modify Account</title>
</head>
<body>
	<div id="bg">
		<div id="sadrzaj">
			<jsp:include page="../includes/leftnav.jsp" flush="true"></jsp:include>
			<div id="clanci">Account is modified successfully.</div>
		</div>
	</div>
</body>
</html>