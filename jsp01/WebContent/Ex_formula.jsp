
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
	<%!String j ="�������� ����~"; %>
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
	<!-- include�����ڸ� ���� ������ ��°�� �ҷ��� -->
	<%//��ũ��Ʈ�� ���ο� �ּ�ó�� �ڹ��������� �ۼ��ص� JSP�ּ�ó���� ���� %>
	<%@include file = "helloworld.jsp" %>
</body>
</html>