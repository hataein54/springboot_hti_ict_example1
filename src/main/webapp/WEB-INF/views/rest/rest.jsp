<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/js/board.js"></script>

<script type="text/javascript">
$(document).ready(function(){
		
	let board = boardService();
	//board.list();
	//board.get(1021)
	
	let boardObj = {
		bid : 87,
		bname : "아햏햏",
		bcontent : "아햏햏하오",
		btitle : "음매에 ~~~"
	}
	
	//board.add(boardObj);
	
	//board.del(1080);
	//board.del(1086);
	board.modify(boardObj);
	
	
		
});

</script>



</head>
<body>
	<h1>Restful 게시판 연습</h1>
	

	
	
</body>
</html>