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
	<link href="/favicon.ico" rel="shortcut icon"/>
	<link rel="stylesheet" type="text/css" href="/images/style.css" />
	<link rel="stylesheet" type="text/css" media="all" href="/js/fancybox/jquery.fancybox.css">
	<script type="text/javascript" src="/js/fancybox/jquery.min.js"></script> 
	<script type="text/javascript" src="/js/fancybox/jquery.fancybox.js?v=2.0.6"></script>
	<script type="text/javascript" src="/js/fancybox/loopedslider.js"></script>
	<title>VCEW Learning Management</title>
</head>
<body>
	<div id="bg">
		<div id="sadrzaj">
			<div id="toplinks"></div>

			<div id="zaglavlje">
				<div id="title">
					<p style="color:#fff; padding-left: 20px;">VCEW Learning Management System</p>
				</div>
			</div>
			<div id="clanci_login"></div>
			<%--Latest news starts --%>
			<div id="desna_rubrika">
				<h3>Latest News</h3>
				<p>"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?"</p>
			</div>
			<%--Latest news ends --%>
			<%--Login box starts --%>
			<div id="lijeva_rubrika_login">
				<h3>Sign in to your account</h3><br/>
				<form id="loginform" name="loginform" action="/lms/loginform.htm" method="post">
					<table>
						<tr>
							<td><label class="label" for="login_userid">User ID</label></td>
							<td><input type="text" id="login_userid" name="login_userid" class="txt" required></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><span class="error_class" id="error_login_userid"></span></td>
						</tr>
						<tr>
							<td><label for="login_pwd">Password</label></td>
							<td><input type="password" id="login_pwd" name="login_pwd" class="txt" maxlength="20" required></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><span class="error_class" id="error_login_pwd">${err_msg}</span></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input class="popupbtn" id="loginbtn" value="Sign In" type="submit" /></td>
						</tr>
					</table>
				</form>
			</div>
			<%--Login box ends --%>
			<%-- Registration links starts --%>
			<div id="lijeva_rubrika_login">
				<h3>Registration Links</h3><br/>
				<table class="center">
					<tbody>
						<tr>
							<td colspan="2" align="left"><a class="popupbtn" style="text-decoration: none;" href="/lms/registration.htm?type=Student">Student Registration</a></td>
						</tr>
						<tr>
							<td colspan="2" align="left">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><a class="popupbtn" style="text-decoration: none;" href="/lms/registration.htm?type=Staff">Staff Registration</a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<%-- Registration links ends --%>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#login_userid").on("blur", function(){
			var nameval = $("#login_userid").val();
			var namelen = nameval.length;
			if(namelen <= 0){
				$("#login_userid").addClass("error");
				$("#error_login_userid").text("Enter the User ID");
			}else if(namelen < 2){
				$("#login_userid").addClass("error");
				$("#error_login_userid").text("User ID must have 2 - 30 characters");
			}else if(namelen >= 2){
				$("#login_userid").removeClass("error");
				$("#error_login_userid").text("");
			}
		});
		$("#login_pwd").on("blur", function(){
			var pwdval  = $("#login_pwd").val();
			var pwdlen = pwdval.length;
			if(pwdlen <= 0){
				$("#login_pwd").addClass("error");
				$("#error_login_pwd").text("Enter the Password");
			}else if(pwdlen < 4){
				$("#login_pwd").addClass("error");
				$("#error_login_pwd").text("Password must have 4 - 20 characters");
			}else if(pwdlen >= 4){
				$("#login_pwd").removeClass("error");
				$("#error_login_pwd").text("");
			}
		});
	});
</script>
</html>