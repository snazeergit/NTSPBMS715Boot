<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="color: blue; text-align: center; font-size:60px;font-weight:bolder;background:yellow">Welcome to Employee
	Management System</div>
<br>
<br>
<c:choose>
	<c:when test="${!empty empList}">
		<h1 style="color: red; text-align: center">Employees Report</h1>
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<th>EMP NO</th>
				<th>EMP NAME</th>
				<th>EMP JOB</th>
				<th>EMP SALARY</th>
				<th>EMP DEPT NO</th>
				<th>OPERATIONS</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr style="color: blue">
					<td>${emp.eno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td>${emp.deptno}</td>
					<td><a href="emp_edit?eno=${emp.eno }">EDIT<img
							width="30px" height="30px" src="images/edit.png" /></a> <a
						href="emp_delete?eno=${emp.eno }" onclick="return confirm('Are you sure want to delete the employee ?')">DELETE<img width="30px"
							height="30px" src="images/delete.png" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h2 style="color: red; text-align: center">Employees not found</h2>
	</c:otherwise>
</c:choose>
<br>
<h2 style="color: green; text-align: center">${resultMsg }</h2>
<h2 style="text-align: center">
	<a href="./">Home<img width="50px" height="50px"
		src="images/home.png" /></a>&nbsp;&nbsp;&nbsp; <a href="emp_add">Add
		Employee<img width="50px" height="50px" src="images/add.png" />
	</a>
</h2>
