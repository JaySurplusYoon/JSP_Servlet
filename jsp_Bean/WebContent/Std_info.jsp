<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="Student" class="com.javalec.ex.Student" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty name="Student" property="name" value="홍길동"/>
	<jsp:setProperty name="Student" property="age" value="14"/>
	<jsp:setProperty name="Student" property="grade" value="3"/>
	<jsp:setProperty name="Student" property="stdNo" value="138"/>
	
	이름 :<jsp:getProperty name="Student" property="name"/><br/>
	나이 :<jsp:getProperty name="Student" property="age"/><br/>
	학년 :<jsp:getProperty name="Student" property="grade"/><br/>
	학번 :<jsp:getProperty name="Student" property="stdNo"/><br/>
</body>
</html>