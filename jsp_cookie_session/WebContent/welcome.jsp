<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공!</title>
</head>
<body>
	<%
		Enumeration enm = session.getAttributeNames();
		while(enm.hasMoreElements()){
			String sName=enm.nextElement().toString();
			String sValue=(String)session.getAttribute(sName);
			
			if(sValue.equals("abcde")){
				out.println(sValue+"님의 입장을 환영합니다");
			}
		}
	%><br/>
	<a href="logout.jsp">
		<input type="submit" value="로그아웃"/>
	</a>
</body>
</html>