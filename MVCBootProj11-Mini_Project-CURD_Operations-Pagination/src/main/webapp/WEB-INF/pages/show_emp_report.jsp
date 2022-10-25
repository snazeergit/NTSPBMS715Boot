<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<div
	style="color: blue; text-align: center; font-size: 60px; font-weight: bolder; background: yellow">Welcome
	to Employee Management System</div>
<br>
<br>
<div class=container>
	<c:choose>
		<c:when test="${!empty empsData.getContent()}">
			<h1 style="color: red; text-align: center">Employees Report</h1>
			<table border="1" class="table">
				<tr class="table-danger">
					<th>EMP NO</th>
					<th>EMP NAME</th>
					<th>EMP JOB</th>
					<th>EMP SALARY</th>
					<th>EMP DEPT NO</th>
					<th>EMP STATUS</th>
					<th>OPERATIONS</th>
				</tr>
				<c:forEach var="emp" items="${empsData.getContent()}">
					<tr class="table-success">
						<td>${emp.eno}</td>
						<td>${emp.ename}</td>
						<td>${emp.job}</td>
						<td>${emp.sal}</td>
						<td>${emp.deptno}</td>
						<td>${emp.status}</td>
						<td><a href="emp_edit?eno=${emp.eno }">EDIT<img
								width="30px" height="30px" src="images/edit.png" /></a> <a
							href="emp_delete?eno=${emp.eno }"
							onclick="return confirm('Are you sure want to delete the employee ?')">DELETE<img
								width="30px" height="30px" src="images/delete.png" /></a></td>
					</tr>
				</c:forEach>
			</table>

			<p style="text-align: center">
				<c:if test="${empsData.hasPrevious()}">
					<a href="emp_report?page=${empsData.getPageable().getPageNumber()-1}">Previous</a>&nbsp;&nbsp;
			</c:if>

				<c:if test="${empsData.isFirst()}">
					<a href="emp_report?page=0">First</a>&nbsp;&nbsp;
			</c:if>

				<c:forEach var="i" begin="1" end="${empsData.getTotalPages()}"
					step="1">
					[<a href="emp_report?page=${i-1}">${i}</a>]&nbsp;&nbsp;
			</c:forEach>

				<c:if test="${empsData.isLast()}">
					<a href="emp_report?page=${empsData.getTotalPages()-1}">Last</a>&nbsp;&nbsp;
		</c:if>

				<c:if test="${empsData.hasNext()}">
					<a href="emp_report?page=${empsData.getPageable().getPageNumber()+1}">Next</a>&nbsp;&nbsp;
		</c:if>
			</p>
		</c:when>
		<c:otherwise>
			<h2 style="color: red; text-align: center">Employees not found</h2>
		</c:otherwise>
	</c:choose>
	<br>
	<c:if test="${!empty resultMsg}">
		<h2 style="color: green; text-align: center">${resultMsg }</h2>
	</c:if>
	<br> <br>
	<h2 style="text-align: center">
		<a href="./"><img width="50px" height="50px" src="images/home.png" />Home</a>&nbsp;&nbsp;&nbsp;
		<a href="emp_add"><img width="50px" height="50px"
			src="images/add.png" />Add Employee</a>
	</h2>
</div>