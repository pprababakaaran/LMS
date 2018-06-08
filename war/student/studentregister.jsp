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
	<title>VCEW Learning Management::Student Registration</title>
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
			<div style="text-align: center;"><h3>Student Registration</h3></div>
			<div id="lijeva_rubrika_register">
			
			<form:form method="Post" action="/lms/registration.htm" commandName="registration">
					<table style="width:738px">
						<tr>
							<td colspan="2" height="13" align="center"><h3>Login Information</h3></td>
						</tr>
						<tr>
							<td width="150" valign="top">Student/User ID *</td>
							<td width="185"><form:input style="height:17px;width: 175px;" path="userId" maxlength="15"/></td>
							<td><FONT color="red"><form:errors path="userId" /></FONT></td>
						</tr>
						<form:hidden path="type" value="Student"/>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="150" valign="top">Password *</td>
							<td width="185"><form:password style="height:17px;width: 175px;" path="pwd" maxlength="30"/></td>
							<td><FONT color="red"><form:errors path="pwd" /></FONT></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="150" valign="top">Confirm Password *</td>
							<td width="185"><form:password style="height:17px;width: 175px;" path="confirmPwd" maxlength="30"/></td>
							<td><FONT color="red"><form:errors path="confirmPwd" /></FONT></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="150" valign="top">Email *</td>
							<td width="185"><form:input style="height:17px;width: 175px;" path="emailId" maxlength="60"/></td>
							<td><FONT color="red"><form:errors path="emailId" /></FONT></td>
						</tr>
						<tr>
							<td colspan="2" height="13" align="center"><h3>Course Information</h3></td>
						</tr>
						<tr>
							<td width="150" valign="top">Your Name *</td>
							<td width="185"><form:input style="height:20px;width: 175px;" path="name" maxlength="30" /></td>
							<td><FONT color="red"><form:errors path="name" /></FONT></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="150" valign="top">Course *</td>
							<td width="185">
								<form:select path="course" style="height:23px;width:180px;">
									<c:forEach var="courseVar" items="${courseMap}">
										<form:option id="${courseVar.key}" value="${courseVar.key}" label="${courseVar.key}" />
									</c:forEach>
								 </form:select>
				             </td>
							<td><FONT color="red"><form:errors path="course" /></FONT></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="150" valign="top">Department *</td>
							<td width="185">
								<form:select path="dept" style="height:23px;width:180px;">
									<form:option value="N/A" label="---Select Department---" />
								 </form:select>
				             </td>
							<td><FONT color="red"><form:errors path="dept"/></FONT></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="150" valign="top">Section *</td>
							<td width="185">
								<form:select path="section" style="height:23px;width:180px;">
									<form:option value="N/A" label="N/A" />
									<form:option value="A" label="A" />
									<form:option value="B" label="B" />
									<form:option value="C" label="C" />
								 </form:select>
				             </td>
							<td><FONT color="red"><form:errors path="section" /></FONT></td>
						</tr>
						<form:hidden path="position" value="N/A"/>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="150" valign="top">Year *</td>
							<td width="185">
								<form:select path="year" style="height:23px;width:180px;">
									<form:option value="1" label="1" />
									<form:option value="2" label="2" />
									<form:option value="3" label="3" />
									<form:option value="4" label="4" />
									<form:option value="5" label="5" />
								 </form:select>
				             </td>
							<td><FONT color="red"><form:errors path="year" /></FONT></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="150" valign="top">Mobile No *</td>
							<td width="185"><form:input style="height:20px;width: 175px;" path="mobileNo" maxlength="10" /></td>
							<td><FONT color="red"><form:errors path="mobileNo" /></FONT></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td colspan="2" align="center"><input class="popupbtn" type="submit" value="Register" /></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
<script type="text/javascript">
	function getDepartment(courseId){
		var courseVal = "course="+courseId;
		$.ajax({
			type: 'POST',
			url: '/lms/registration/dept.htm?',
			data: courseVal,
			dataType:'json',
			success: function(data) {
				$('#dept').empty().append(new Option('---Select Department---','N/A'));
				if(data.Messages.length > 0){
					$.each(data.Messages, function(i,data){
						$("#dept").append(new Option(data.deptName,data.deptName));
					});
				}else{
					$("#dept").append(new Option('Others','Others'));
				}
			}
		});
	}
	$(document).ready(function() {
		getDepartment($("#course").val());
		$("#course").on("change", function(){
			getDepartment($("#course").val());
		});
	});
</script>
</body>
</html>