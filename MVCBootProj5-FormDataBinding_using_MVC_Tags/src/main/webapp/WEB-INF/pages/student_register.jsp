<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: green; text-align: center">Student Registration
	Page</h1>
<frm:form action="register" method="post" modelAttribute="std">
	<table bgcolor="pink" align="center">
		<tbody>
			<tr>
				<td>Studnet no:</td>
				<td><frm:input path="sno" /></td>
			</tr>
			<tr>
				<td>Studnet name:</td>
				<td><frm:input path="sname" /></td>
			</tr>
			<tr>
				<td>Studnet address:</td>
				<td><frm:input path="sadd" /></td>
			</tr>
			<tr>
				<td>Studnet average:</td>
				<td><frm:input path="avg" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="register" /></td>
				<td><input type="reset" value="clear" /></td>
			</tr>
		</tbody>
	</table>
</frm:form>
