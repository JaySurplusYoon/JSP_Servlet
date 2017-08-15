<%@page import="com.javalec.ex.memberDTO"%>
<%@page import="com.javalec.ex.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");//post로 받은 id, pw를 String 변수에 넣음
	
	memberDAO dao = memberDAO.getInstance();
	if(dao.userCheck(id,pw)==memberDAO.MEMBER_LOGIN_IS_NOT){
//history.back()과 history.go(-1)은 동일%>
	<script language="javascript">
		alert("아이디가 존재하지 않습니다");
		history.go(-1);
	</script>    
<%
	}else if(dao.userCheck(id,pw)==memberDAO.MEMBER_LOGIN_PW_NO_GOOD){
%>
	<script language="javascript">
		alert("비밀번호가 틀렸습니다");
		history.go(-1);
	</script>
<%
	}else if(dao.userCheck(id,pw)==memberDAO.MEMBER_JOIN_SUCCESS){
		memberDTO dto = dao.getMember(id);
			if(dto==null){
%>
			<script language="javascript">
			alert("회원정보를 불러올 수 없습니다. 다시 로그인해주세요");
			history.go(-1);
			</script>
<%
			}else{
				String name=dto.getName();
				session.setAttribute("id",id);
				session.setAttribute("name",name);
				session.setAttribute("ValidMem","yes");//해당 브라우져의 정보로서 세션에(서버에) 해당 id,name,ValidMem이라는 속성과 각각의 value를 저장한다
				response.sendRedirect("main.jsp");//입력받은 정보(id,pw)를 지닌채 main.jsp로 포워딩
			}
	}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>