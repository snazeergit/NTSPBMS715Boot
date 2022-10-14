<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<h1 style="color: green; text-align: center">Student Registration
	Page</h1>
<form action="register" method="post">
	<table bgcolor="pink" align="center">
		<tbody>
			<tr>
				<td>Studnet no:</td>
				<td><input type="text" name="sno" /></td>
			</tr>
			<tr>
				<td>Studnet name:</td>
				<td><input type="text" name="sname" /></td>
			</tr>
			<tr>
				<td>Studnet address:</td>
				<td><input type="text" name="sadd" /></td>
			</tr>
			<tr>
				<td>Studnet average:</td>
				<td><input type="text" name="avg" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="register" /></td>
			</tr>
		</tbody>
	</table>
</form>
