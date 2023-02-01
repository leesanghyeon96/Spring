<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.board.BoardDTO" %>
<%
	//session에 저장된 값을 가지고 온다.
		//board : DB의 select한 레코드를 저장하고 있는 dto
	BoardDTO board = (BoardDTO) session.getAttribute("board");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼 페이지</title>
</head>
<body>

<center>
	<h1>글 상세 페이지</h1>
	<a href="Logout.do">Log-out</a>
	<hr>
	<!-- 폼의 value에 출력 -->
	
	<form action="updateBoard.do" method="post">
		<!-- updateBoard.do 페이지로 넘길때 seq를 hidden으로 가져가기 -->
		<!-- 출력구문에는 나타나지 않고 변수값 넘길때 사용 -->
		<input type="hidden" name="seq" value="<%= board.getSeq()%>">
		
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="orange" width="80">제목</td>	<!-- 수정가능 -->
				<td><input type="text" name="title" value="<%= board.getTitle()%>"></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td> <!-- 수정불가 -->
				<td><%= board.getWriter()%></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td> <!-- 수정가능 -->
				<!-- textarea의 value값은 아래처럼 찍어준다. -->
				<td><textarea name="content" cols="40" rows="10"><%= board.getContent()%></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td> <!-- 수정불가 -->
				<td>
				<!-- 수정해도되지만 그냥 찍어준다. -->
				<%= board.getRegDate()%>
				</td>
			</tr>
			<tr>
				<td bgcolor="orange">조회수</td> <!-- 수정불가 -->
				<td><%= board.getCnt()%></td>
			</tr>
			<tr>
				<!-- 글 수정은 넘어오는 seq의 값을 가지고 수정한다. -->
				<td colspan="2" align="right"><input type="submit" value="글 수정"></td>
			</tr>
		</table>
	</form>
	<p>
	<!-- do : controller에서 쿼리의 실행이 필요할 것들 -->
	<a href="insertBoard.jsp">글 등록</a> &nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=<%= board.getSeq()%>">글 삭제</a> &nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글 목록</a>
	
</center>
</body>
</html>