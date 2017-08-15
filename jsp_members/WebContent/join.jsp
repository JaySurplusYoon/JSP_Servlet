<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%//하단에 자바스크립트 메서드가 좀 나올건데, members.js라는 소스안에 메서드들 있어~%>
<script language="JavaScript" src="members.js"></script>

</head>
<body>
<%//요건심사는 members.js에서 한 후 joinOK.jsp로 입력한 정보를 보낸다 %>
	<form action="joinOk.jsp" method="post" name="reg_frm">
		아이디 : <input type="text" name="id" size="20"><br/>
		비밀번호 : <input type="password" name="pw" size="20"><br/>
		비밀번호확인 : <input type="password" name="pw_check" size= "20"><br/>
		이름:<input type="text" name="name" size="20"><br/>
		메일:<input type="text" name="email" size="20"><br/>
		주소:<input type="text" name="address" size="50"><br/>
		<%//button클릭시 다음 메서드 수행 : members.js내에 있는 infoConfirm()라는 자바스크립트 메서드 수행  %>
		<input type="button" value="회원가입" onclick="updateInfoConfirm()"> &nbsp; &nbsp;
		<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>