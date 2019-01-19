<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${boardList}
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>타입</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>수정자</th>
			<th>수정일자</th>
		</tr>
	</thead>
	<tbody>
<c:forEach items="${boardList}" var="b">
		<tr>
			<td>${b.boardNum}</td>
			<td>${b.boardType}</td>
			<td>${b.boardTitle}</td>
			<td>${b.boardComment}</td>
			<td>${b.creator}</td>
			<td>${b.createTime}</td>
			<td>${b.modifier}</td>
			<td>${b.modifiedTime}</td>
		</tr>
</c:forEach>
	</tbody>
</table>
</body>
</html>