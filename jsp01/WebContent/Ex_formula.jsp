
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Scripe</title>
</head>
<body>
	<%!String j ="구구단을 외자~"; %>
	<%=j %>
	<%=j %>
	<br/>
	<%int i =0;
	while(i<10){
	i++;
	out.println("2*"+i+"="+2*i+"<br/>");%>

	<% out.println("============" +"<br/>");}%>
	
	<%int [] iArr={10,20,30};
	out.println(Arrays.toString(iArr));%>
	<!-- include지시자를 통해 페이지 통째로 불러옴 -->
	<%//스크립트릿 내부에 주석처리 자바형식으로 작성해도 JSP주석처리와 동일 %>
	<%@include file = "helloworld.jsp" %>
</body>
</html>