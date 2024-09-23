<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Emp 리스트</h1>
	
<table width="50%" border="1"> 
	<tr>  <!-- 테이블의 상단에 들어갈 컬럼명들 -->
		<th>empno</th>
		<th>ename</th>
		<th>job</th>
		<th>mgr</th>
		<th>hiredate</th>
		<th>sal</th>
		<th>sal 등급</th>
		<th>부서위치</th>
		<th>부서이름</th>				
	</tr>
	<c:forEach var="vo" items="${empList}">
		<tr>
			<td>${vo.emp.empno}</td>
			<td>${vo.emp.ename}</td>
			<td>${vo.emp.job}</td>
			<td>${vo.emp.mgr}</td>
			<td>${vo.emp.hiredate}</td>
			<td><fmt:formatNumber value="${vo.emp.sal}" type="number"/></td>
                <!-- 숫자 1000을 1,000으로 표시하는 태그 -->
			<td>${vo.salgrade.grade}</td>
			<td>${vo.dept.loc}</td>
			<td>${vo.dept.dname}</td>
		</tr>
	</c:forEach>
</table>
	
	
</body>
</html>