<%@page import="com.javalec.ex.memberDTO"%>
<%@page import="com.javalec.ex.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%	String id = (String)session.getAttribute("id");
 	memberDAO dao = memberDAO.getInstance();
 	memberDTO dto = dao.getMember(id);
 %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%//요건심사는 members.js에서 한 후 modifyOk.jsp로 입력한 정보를 보낸다 %>
	<form action="modifyOk.jsp" method="post" name="reg_frm">
		아이디 : <%=dto.getId()%><br/>
		비밀번호 : <input type = "password" name="pw" size="20"><br/>
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br/>
		이름 : <%=dto.getName()%><br/>
		메일 : <input type = "text" name="email" size="20" value="<%=dto.geteMail()%>"><br/>
		주소 : <input type = "text" name="address" size="50" value="<%=dto.getAddress()%>"><br/>	
		<input type ="button" value="수정" onclick="updateinfoConfirm()">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소" onclick="javascript.window.location='main.jsp'">	
	</form>
</body>
</html>