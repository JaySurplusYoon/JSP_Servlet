<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!String name, id, pw, car;
	String[] hobby;
	int age;%>
	<%
	request.setCharacterEncoding("UTF-8");
	
	/*PrintWrite�� �� �ʿ� �����Ƿ� �ϴ� ����
	response.setContentType("text/http; UTF-8");
	*/
	
	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pwd");
	car = request.getParameter("car");
	hobby = request.getParameterValues("hobby");
	age = Integer.parseInt(request.getParameter("age"));
	
	%>
	
	�̸� : <%=name %><br/>
	���� : <%=age %><br/>
	���̵�: <%=id %><br/>
	��й�ȣ : <%=pw %><br/>
	�������� : <%=car %><br/>
	��� : <%=Arrays.toString(hobby)%><br/>
	
	<%if(age>20){
		response.sendRedirect("pass.jsp?age="+age);
      }
	  else{
	  	response.sendRedirect("nonpass.jsp?age="+age);
	  }
	%>
	
</body>
</html>