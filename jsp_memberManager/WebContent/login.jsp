<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//이미 로긴상태라면 main페이지로 보내라,,2개의 스크립트릿 사이에 jsp코드 위치시킬 수 있다 %>
<%if(session.getAttribute("ValidMem")!=null){%>
	<jsp:forward page="main.jsp"></jsp:forward>
<%}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginOk.jsp" method="post">
		아이디 : <input type="text" name="id" value="<%if(session.getAttribute("id")!=null)out.println(session.getAttribute("id")); %>"><br/>
		비밀번호 : <input type = "text" name="pw"><br/>
		<input type="submit" value="로그인"> &nbsp;&nbsp; <input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'">
	<%// onclick="javascript:window.location='join.jsp' : 클릭시 수행한다(onclick), join.jsp로 페이지 이동한다(javascript:window.location~)%>
	<%//&nbsp  줄바꿈없는 공백%>
	</form>
	
</body>
</html>