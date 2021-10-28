<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>list.jsp</title>
</head>
<body>
	<h3>자유게시판 글 리스트</h3>
	<table width="1000" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td align="center">번호</td>
			<td align="center">글쓴이</td>
			<td align="center">글제목</td>
			<td align="center">게시일</td>
			<td align="center">조회수</td>
		</tr>
		<c:forEach items="${list }" var="dto">		
		<tr>
			<td>${dto.bId }</td>
			<td>${dto.bName }</td>
			<td>
				<c:forEach begin="1" end="$dto.bIndent">&nbsp;&nbsp;</c:forEach>
				<a href="content_view?bId=${dto.bId }">${dto.Title }</a>
			</td>
			<td>${dto.bDate }</td>
			<td>${dto.bHit }</td>
		</tr>
		</c:forEach>
		<tr>
			<td><a href="write_view">글쓰기</a></td>
		</tr>
	</table>
</body>
</html>