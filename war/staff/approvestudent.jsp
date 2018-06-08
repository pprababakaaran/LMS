<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<title>VCEW Learning Management::Approve Student</title>
</head>
<body>
	<div id="bg">
		<div id="sadrzaj">
				<jsp:include page="../includes/leftnav.jsp"></jsp:include><div id="clanci">
				<h2>Activate Student Accounts</h2></div><br>
				<c:choose>
					<c:when test="${!empty unApprovedMap}">
						<form method="post" action="/lms/approvestudent.htm" name="approvestudentform">
						<table style="width:580px"  border="0" cellpadding="0" cellspacing="0">
							<tr>
								<th width="40px" align="center">Select</th>
								<th width="200px" align="left">Name</th>
								<th width="60px" align="left">Course</th>
								<th width="200px" align="left">Dept</th>
								<th width="40px" align="left">Section</th>
								<th width="40px" align="left">Year</th>
							</tr>
							<c:forEach var="userBean" items="${unApprovedMap}">
							<tr>
								<td align="center"><input id="userId" name="userId" value='${userBean.key}' type="checkbox"></td>
								<td><c:out value='${userBean.value.name}'/></td>
								<td><c:out value='${userBean.value.course}'/></td>
								<td><c:out value='${userBean.value.dept}'/></td>
								<td><c:out value='${userBean.value.section}'/></td>
								<td><c:out value='${userBean.value.year}'/></td>
								
							</tr>
							</c:forEach>
							<tr><td colspan="6"  height="13"></td></tr>
							<tr>
								<td colspan="6" align="center"><input id="approvebtn" value="Approve" class="popupbtn" type="submit"></td>
							</tr>
						</table>
						</form>
					</c:when>
					<c:otherwise>
						<center><h4>No account available to activate.</h4></center>
					</c:otherwise>
				</c:choose>					
		</div>
	</div>
</body>
<script>
$(document).ready(function() {
		$("#approvebtn").on("click", function(){
			if($("#userId:checked").length <= 0){
				alert("Please select account to approve.");
				return false;
			}
		});
	});
</script>
</html>