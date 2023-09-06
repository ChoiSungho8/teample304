<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>로그인 페이지</title>
</head>
<body>
	<form method="post">
		<h4>ID</h4>
		<input type="text" name="userid" placeholder="아이디 입력">
		<h4>PW</h4>
		<input type="password" name="userpw" placeholder="비밀번호 입력">
		<!-- submit버튼 클릭 시 post방식으로 /login요청 보냄 -->
		<input type="submit" value="submit">
	</form>
</body>
</html>
