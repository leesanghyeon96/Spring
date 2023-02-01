<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.spring.board.BoardDTO" %>

<!-- 이 파일은 -->

<!-- jsp파일을 바로 열면 값을 못가져온다. 객체정보를 가져오지 못한다.
	(session이나 값을 가져오려면 controller를 통해서 열어야한다.) -->

<!-- 세션에 저장된 boardList 를 끄집어 낸다. -->
<%
	//(List) : list타입 , session : 내장객체이므로 별도의 import없이 사용이 가능하다.
	List<BoardDTO> boardList = (List) session.getAttribute("boardList");
		//getAttribute를 통해 boardList의 내용을 빼내어 boardList에 넣는다.
		// 왼쪽의 boardList 에는 db에서 가져온 DTO들이 담겨있다.
			// 이걸 순환시켜 출력시키면 된다.

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1> 게시판 목록 출력 페이지 </h1>
	<hr> 
	
	<h3> 환영합니다. <a href="Logout.do">로그아웃</a></h3>
	
	<!-- 검색 기능 추가 -->
	<form action="getBoardList.jsp" meghod="post">
		<table border="1" cellspacing="0" cellpadding="0" width="700">
			<tr>
				<td> <select name="searhCondition">
					<option value="TITLE">제목</option>
					<option value="TITLE">내용</option>
					</select>
					<input type="text" name="searchkeyword"/>
					<input type="submit" value="검색"/>
				</td>
			</tr>
		</table>
		
		<!-- 서버에서 담은 List에 저장된 DTO를 끄집어내서 출력하는 테이블 -->
		<table border="1" cellspacing="0" cellpadding="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			
			<!-- tr을 for문으로 루프돌려 List의 DTO 값을 끄집어내서 출력 -->
			<%
				for(BoardDTO dto : boardList){
					// 향상된 for문	
					// boardList의 index를 dto변수에 저장
					// dto의 값을 아래에 저장 (getter를 사용해서) (index0 ~ 끝까지)
			%>
			<tr>
				<td align="center"><%= dto.getSeq() %></td>
				<td>
					<!-- jsp로 요청하면 안되고 do요청(controller요청)으로 해야한다. -->
					<a href="getBoard.do?seq=<%= dto.getSeq()%>">
						<%= dto.getTitle() %>
					</a>
				</td>
				<td align="center"><%= dto.getWriter() %></td>
				<td align="center"><%= dto.getRegDate() %></td>
				<td align="center"><%= dto.getCnt() %></td>
			</tr>
			
			<%
				}
			%>
		</table>

		<p/>
		<a href="insertBoard.jsp">새글 등록</a>

	</form>
	
	
	
	
</center>

</body>
</html>
