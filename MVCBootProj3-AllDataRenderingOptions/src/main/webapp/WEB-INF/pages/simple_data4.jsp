<%@ page isELIgnored="false" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 style="color: green; text-align: center">simple_data4.jsp</h1>

<b style="color: blue; text-align: center"> Student Details :::</b>

<c:choose>
	<c:when test="${!empty stdInfo }">
		<table border="1" bgcolor="pink" align="center">
			<tbody>
				<tr>
					<th>sno</th>
					<th>sname</th>
					<th>salary</th>
					<th>vaccinated</th>
				</tr>
				<c:forEach var="std" items="${stdInfo}">
					<tr>
						<td>${std.sno}</td>
						<td>${std.sname}</td>
						<td>${std.salary}</td>
						<td>${std.vaccinated}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">Student not found</h1>
	</c:otherwise>
</c:choose>

