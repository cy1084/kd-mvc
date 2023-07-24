<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>영화 수정</h3>
	<form action="/movie-info/update" method="POST">
		<input type="hidden" name="miNum" value="${movieInfo.miNum }">
		<input type="text" name="miTitle" placeholder="제목"
			value="${movieInfo.miTitle }"> <input type="text"
			name="miDesc" placeholder="내용" value="${movieInfo.miDesc }">
		<input type="text" name="miGenre" placeholder="장르"
			value="${movieInfo.miGenre }"> <input type="text"
			name="miCredat" placeholder="개봉일" value="${movieInfo.miCredat }">
		<input type="text" name="miCnt" placeholder="관객수"
			value="${movieInfo.miCnt }">
		<button>수정</button>
	</form>

</body>
</html>