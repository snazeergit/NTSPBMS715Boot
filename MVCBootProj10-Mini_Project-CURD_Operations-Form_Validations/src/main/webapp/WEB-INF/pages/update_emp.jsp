<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script language="JavaScript" src="js/validation.js"></script>

<div
	style="color: blue; text-align: center; font-size: 60px; font-weight: bolder; background: yellow">Welcome
	to Employee Management System</div>
<br>
<br>
<h2 style="color: red; text-align: center">Update Employee</h2>
<frm:form modelAttribute="emp" action="emp_edit" method="post"
	onsubmit="return doValidations(this)">
	<%--
		<!-- For FORM VALIDATIONS -->
		<p style="color: red; text-align: center">
			<frm:errors path="*" />
		</p>
    --%>
	<table align="center" bgcolor="cyan">

		<tr>
			<td>EMP NO ::</td>
			<td><frm:input path="eno" readonly="true" /></td>
		</tr>
		<tr>
			<td>EMP NAME ::</td>
			<td><frm:input path="ename" /> <frm:errors path="ename" /><span
				id="enameErr"></span></td>
		</tr>
		<tr>
			<td>EMP JOB ::</td>
			<td><frm:input path="job" /> <frm:errors path="job" /><span
				id="jobErr"></span></td>
		</tr>
		<tr>
			<td>EMP SALARY ::</td>
			<td><frm:input path="sal" /> <frm:errors path="sal" /><span
				id="salErr"></span></td>
		</tr>
		<tr>
			<td>EMP DEPT NO ::</td>
			<td><frm:select path="deptno">
					<frm:options items="${deptNoInfo}" />
				</frm:select><span id="deptnoErr"></span></td>
		</tr>
		<tr>
			<td><input type="submit" value="Update" /> <input type="reset"
				value="cancel" /> <a href="./">Home</a></td>
		</tr>
	</table>
</frm:form>

