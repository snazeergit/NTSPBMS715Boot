<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<div
	style="color: blue; text-align: center; font-size: 60px; font-weight: bolder; background: yellow">Welcome
	to Employee Management System</div>
<br>
<br>
<h2 style="color: red; text-align: center">Register Employee</h2>
<frm:form modelAttribute="emp" action="emp_add" method="post">
	<%--
		<!-- For FORM VALIDATIONS -->
		<p style="color: red; text-align: center">
			<frm:errors path="*" />
		</p>
	 --%>
	<table align="center" bgcolor="cyan">

		<tr>
			<td>EMP NAME ::</td>
			<td><frm:input path="ename" />
				<frm:errors path="ename" /></td>
		</tr>
		<tr>
			<td>EMP JOB ::</td>
			<td><frm:input path="job" />
				<frm:errors path="job" /></td>
		</tr>
		<tr>
			<td>EMP SALARY ::</td>
			<td><frm:input path="sal" />
				<frm:errors path="sal" /></td>
		</tr>
		<tr>
			<td>EMP DEPT NO ::</td>
			<td><frm:select path="deptno">
					<frm:options items="${deptNoInfo}" />
				</frm:select></td>
		</tr>
		<tr>
			<td><input type="submit" value="register" /> <input
				type="reset" value="cancel" /> <a href="./">Home</a></td>
		</tr>
	</table>
</frm:form>

