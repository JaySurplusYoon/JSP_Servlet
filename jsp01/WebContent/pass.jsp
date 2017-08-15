<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>pass</title>
</head>

	<%int age = Integer.parseInt(request.getParameter("age"));%>
	당신은 <%=age %>세로 성인이군요<br/>
	<a href="Human_info2.html"><input type="submit" value="돌아가기"></a>
</body>
</html>