<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.repository.UserInfoRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
</head>
<body>
	<h3>영화 리스트</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>장르</th>
			<th>개봉일</th>
			<th>관객수</th>
		</tr>
		<c:forEach items="${movieInfoList}" var="movieInfo">
			<tr>
				<td>${movieInfo.miNum}</td>
				<td><a href="/movie-info/view?miNum=${movieInfo.miNum}">${movieInfo.miTitle}</a></td>
				<td>${movieInfo.miDesc}</td>
				<td>${movieInfo.miGenre}</td>
				<td>${movieInfo.miCredit}</td>
				<td>${movieInfo.miCnt}</td>
				
			</tr>
		</c:forEach>
		<tr>
		<td align="right" colspan="7"><button onclick="location.href='/movie-info/insert'">등록</button></td>
		</tr>
	</table>

</body>
</html>