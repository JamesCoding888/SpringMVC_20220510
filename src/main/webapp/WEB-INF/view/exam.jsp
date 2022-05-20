<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css"> 
<meta charset="UTF-8">
<title>Exam CRUD</title>
</head>
<body style="padding: 15px;">
	<table border="1">
		<tr>
			<!-- 表單資料處理 CRUD -->
			<td valign="top">
				<form:form modelAttribute="examTest" class="pure-form" method="post">
					<fieldset>
						<legend>Exam Post 考試註冊</legend>
						<form:input path="id" placeholder="請輸入學員編號" /><p />
						<form:select path="name">
							<form:option value="">請選擇</form:option>
							<form:option value="808">OCP 808</form:option>
							<form:option value="809">OCP 809</form:option>
							<form:option value="900">OCAD 900</form:option>							
						
						</form:select>
					
						考試時段 (可複選):
						<form:checkbox path="slot" value="A" />上午 (A)
						<form:checkbox path="slot" value="B" />上午 (B)
						<form:checkbox path="slot" value="C" />上午 (C)
						<p />
						繳費狀況:
						已繳 <form:radiobutton path="pay" value="true"/>
						未繳 <form:radiobutton path="pay" value="false"/>
						<p />
						備註:
						<form:textarea path="note"/>
						<p />
						<button type="submit" class="pure-button pure-button-primary">create</button>
						<button type="reset" class="pure-button pure-button-primary">reset</button>
					</fieldset>					
				</form:form>			
			</td> 
				
		</tr>
	</table>
</body>
</html>