<%@ page language="java" replyType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply_view</title>
</head>
<body>
	<h3>자유게시판 글 보기</h3>
	  <table width="500" cellpadding="0" cellspacing="0" border="1">
      <form action="reply">
      	<input type="hidden" name="bId" value="${reply_view.bId }">
      	<input type="hidden" name="bGroup" value="${reply_view.bGroup }">
      	<input type="hidden" name="bStep" value="${reply_view.bStep }">
      	<input type="hidden" name="bIndent" value="${reply_view.bIndent }">      
       <tr>
            <td>번 호</td>
            <td>${reply_view.bId }</td>
         </tr>
         <tr>
            <td>조회수</td>
            <td>${reply_view.bHit }</td>
         </tr>
         <tr>
            <td>이 름</td>
            <td><input type="text" name=bName size="60" value="${reply_view.bName }"></td>
         </tr>
         <tr>
            <td>제 목</td>
            <td><input type="text" name=bTitle size="60" value="${reply_view.bTitle }"></td>
         </tr>            
         <tr>
            <td align="center" colspan="2">내 용</td>
         </tr>
            <td align="center" colspan="2"><textarea name="bContent" rows="10" cols="60">${reply_view.bContent }=========================================</textarea></td>
         <tr>         
            <td colspan="2"><a href="list">글 목록 보기</a>
            </td>
         </tr>
         <tr>
            <td align="center" colspan="2"><input type="submit" value="덧글입력">
            </td>
         </tr>         
      </form>  
   </table>
</body>
</html>