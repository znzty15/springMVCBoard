<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>content_view.jsp</title>
</head>
<body>
	<h3>�����Խ��� �� ����</h3>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify">
         <tr>
            <td>�� ȣ</td>
            <td>${content_view.bId }</td>
         </tr>
         <tr>
            <td>��ȸ��</td>
            <td>${content_view.bHit }</td>
         </tr>
         <tr>
            <td>�� ��</td>
            <td><input type="text" name=bName size="65" value="${content_view.bName }"></td>
         </tr>
         <tr>
            <td>�� ��</td>
            <td><input type="text" name=bTitle size="65" value="${content_view.bTitle }"></td>
         </tr>            
         <tr>
            <td align="center" colspan="2">�� ��</td>
         </tr>
            <td align="center" colspan="2"><textarea name="bContent" rows="10" cols="65">${content_view.bContent }</textarea></td>
         <tr>         
            <td colspan="2"><a href="list">�� ��� ����</a>&nbsp;&nbsp;
            <a href="reply_view?bId=${content_view.bId }">�� ��</a> &nbsp;&nbsp; <a href="delete?bId=${content_view.bId }">�� ��</a>
            </td>
         </tr>
         <tr>
            <td align="center" colspan="2"><input type="submit" value="����"></td>
         </tr>         
      </form>
	
	</table>
	
</body>
</html>