<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: red; text-align: center">Register Customer</h1>
<br>
<br>
<frm:form modelAttribute="cust">
	<frm:errors path="*"></frm:errors>
	<table border="1" bgcolor="cyan" align="center">
		<tr>
			<td>Customer Name:</td>
			<td><frm:input path="cname" /></td>
		</tr>
		<tr>
			<td>Customer data of birth(DOB):</td>
			<td><frm:input path="dob" type="date" /></td>
		</tr>
		<tr>
			<td>Customer data of purchase(DOP):</td>
			<td><frm:input path="dop" type="date" /></td>
		</tr>
		<tr>
			<td>Is customer Member:</td>
			<td><frm:checkbox path="isHavingMembership" value="true" />Member</td>
		</tr>
		<tr>
			<td><input type="submit" value="Register" /></td>
			<td><input type="reset" value="Cancel" /></td>
		</tr>
	</table>
</frm:form>