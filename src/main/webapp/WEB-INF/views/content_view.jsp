<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>content_view.jsp</title>
</head>
<body>
	<h3>자유게시판 글 보기</h3>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify">
         <tr>
            <td>번 호</td>
            <td>${content_view.bId }</td>
         </tr>
         <tr>
            <td>조회수</td>
            <td>${content_view.bHit }</td>
         </tr>
         <tr>
            <td>이 름</td>
            <td><input type="text" name=bName size="60" value="${content_view.bName }"></td>
         </tr>
         <tr>
            <td>제 목</td>
            <td><input type="text" name=bTitle size="60" value="${content_view.bTitle }"></td>
         </tr>            
         <tr>
            <td align="center" colspan="2">내 용</td>
         </tr>
            <td align="center" colspan="2"><textarea name="bContent" rows="10" cols="56">${content_view.bContent }</textarea></td>
         <tr>         
            <td colspan="2"><a href="list">글 목록 보기</a>&nbsp;&nbsp;
            <a href="reply_view?bId=${content_view.bId }">답 변</a> &nbsp;&nbsp; <a href="delete?bId=${content_view.bId }">삭 제</a>
            </td>
         </tr>
         <tr>
            <td align="center" colspan="2"><input type="submit" value="수정"></td>
         </tr>         
      </form>	
	</table>
	
</body>
</html>