<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.inno.bean.Registration,
				 com.inno.utils.Utility,
				 com.google.appengine.api.blobstore.BlobstoreServiceFactory,
				 com.google.appengine.api.blobstore.BlobstoreService" %>
<% 
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
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
	<title>VCEW Learning Management::Upload Books</title>
</head>
<body>
	<div id="bg">
		<div id="sadrzaj">
				<jsp:include page="../includes/leftnav.jsp" flush="true"></jsp:include>
				<div id="clanci">
				<form id="uploadform" name="uploadform" action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
					<table style="width:600px">
						<tr>
							<td colspan="2" height="13" align="center"><h3>Books Details</h3></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="90" valign="top">Book Category *</td>
							<td width="220"><input style="height:20px;width: 175px;" type="text" id="category" name="category" maxlength="30" /></td>
							<td><span class="error_class" id="error_category"></span></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="90" valign="top">Course *</td>
							<td width="220">
								<select id="course" name="course" style="height:23px;width:180px;">
									<c:forEach var="courseVar" items="${courseMap}">
										<option id="${courseVar.key}" value="${courseVar.key}">${courseVar.key}</option>
									</c:forEach>
								 </select>
				             </td>
							<td><span class="error_class" id="error_course"></span></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="90" valign="top">Department *</td>
							<td width="220">
								<select id="dept" name="dept" style="height:23px;width:180px;">
									<option value="N/A">---Select Department---</option>
								 </select>
				             </td>
							<td><span class="error_class" id="error_dept"></span></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="90" valign="top">Section *</td>
							<td width="220">
								<select id="section" name="section" style="height:23px;width:180px;">
									<option value="N/A">N/A</option>
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
								</select>
				             </td>
							<td><span class="error_class" id="error_section"></span></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="90" valign="top">Year *</td>
							<td width="220">
								<select id="year" name="year" style="height:23px;width:180px;">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								 </select>
				             </td>
							<td><span class="error_class" id="error_year"></span></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td width="90" valign="top">Upload *</td>
							<td width="200"><input type="file" style="height:23px;width: 175px;" id="bookUrl" name="bookUrl"/></td>
							<td><span class="error_class" id="error_bookUrl"></span></td>
						</tr>
						<input type="hidden" name="bookName" id="bookName" value=""/> 
						<tr><td colspan="3"  height="13"></td></tr>
						<tr>
							<td colspan="2" align="center"><input class="popupbtn" id=uploadbtn type="submit" value="Upload"/></td>
						</tr>
						<tr><td colspan="3"  height="13"></td></tr>
					</table>
				 </form>
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
		
		$("#uploadbtn").on("click", function(){

			var categoryVal = $("#category").val();
			var categoryLen  = categoryVal.length;
			var deptVal = $("#dept").val();
			var deptLen  = deptVal.length;
			var bookUrlVal = $("#bookUrl").val();
			var bookUrlLen = bookUrlVal.length;
			$('#bookName').val(bookUrlVal);
			
			if(categoryLen < 2 || categoryLen > 30){
				$("#error_category").text("Category should have 3-30 characters");
				return false; 
			}else{
				$("#error_category").text("");
			}
			
			if(deptLen <= 0 || deptVal == "N/A"){
				$("#error_dept").text("Please select the Department");
				return false; 
			}else{
				$("#error_dept").text("");
			}
			
			if(bookUrlLen <=0){
				$("#error_bookUrl").text("Upload URL must not be blank");
				return false; 
			}else{
				$("#error_bookUrl").text("");
			}
			
		});
	});
</script>
</body>
</html>