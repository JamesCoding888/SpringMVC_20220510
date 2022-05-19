<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css" >
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="padding: 15px;">
	<table border="0">
		<tr>
			<!-- 表單資料處理 CRUD -->
			<td valign="top">
			<form:form modelAttribute="exam"
					class="pure-form" method="post"
					action="${ pageContext.request.contextPath }/mvc/exam/${ action }">
					<fieldset>
						<legend>Exam Post 考試註冊</legend>
						學員編號：
						<form:input path="id" placeholder="請輸入學員編號" />
			
						<p />
						考試代號：
						
					</fieldset>
				</form:form> 
				
		</tr>
	</table>
</body>
</html>