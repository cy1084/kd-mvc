<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/user-info/delete" method="POST">
	<input type="hidden" name="uiNum" value="${userInfo.uiNum }">
		<table border="1">
			<tr>
				<th>번호</th>
				<td>${userInfo.uiNum}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${userInfo.uiName}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${userInfo.uiId}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${userInfo.uiPwd}</td>
			</tr>
			<tr>
				<th colspan="2">
					<button onclick="location.href='/user-info/update?uiNum=${userInfo.uiNum}'" type="button">수정</button>
					<!-- type이 button이기 때문에 눌러도 form 태그의 url로 가지 않음! -->
					<button>삭제</button>
					<!-- default 가 submit이기 때문에 버튼을 클릭하면 form 태그의 url으로 감!  -->
				</th>
			</tr>
		</table>
	</form>
</body>
</html>