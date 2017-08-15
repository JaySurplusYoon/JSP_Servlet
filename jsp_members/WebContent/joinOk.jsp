<%@page import="com.javalec.ex.memberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");  //request로 받을 문자 언어 설정%>

<%//데이터객체 dto를 자바빈으로 불러온 후 , 모든 속성 자동입력(*), (단, DTO와 input태그의 변수명들은 동일해야 자동입력이 연동된다 
  //또한, dto의 rDate속성의 경우 별도 사용자입력값이 아닌 timestamp클래스에서 받아와서 넣는다%>
<jsp:useBean id="dto" class="com.javalec.ex.memberDTO" scope="application"/>
<jsp:setProperty name="dto" property="*"/>
<%	dto.setrDate(new Timestamp(System.currentTimeMillis())); 
	

	memberDAO dao= memberDAO.getInstance();//dao에서 생성한 membersDAO의 단일객체인 instance에 접근한다
	if(dao.confirmId(dto.getId())==memberDAO.MEMBER_EXISTENT){
%>
	<script language="javacript">
		alert("아이디가 이미 존재합니다.");
		history.back();
	</script>
<%
	}else{
		int ri = dao.insertMember(dto);
		if(ri==memberDAO.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id",dto);//session객체는 request등과 더불어 jsp내에 생성되어있다
											//기본 로그인화면의 name=id인 텍스트 입력창의 value에 dto를 넣어두겠다
%>
	<script language="javascript">
		alert("가입이 완료되었습니다");
		document.location.href="login.jsp";
	</script>			
<% 	
		}else{
%>
	<script language="javascript">
		alert("가입 실패!");
		document.location.href="login.jsp";
	</script>					
<%
		}
	}
%>
	
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>