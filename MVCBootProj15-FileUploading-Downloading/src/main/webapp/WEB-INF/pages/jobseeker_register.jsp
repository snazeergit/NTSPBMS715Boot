<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color: red; text-align: center">File Uploading & Downloading Application</h1>
<br>
<br>
<br>
<br>
<h2 style="color: blue; text-align: center">JobSeeker Registration page</h2>
<br>
<br>
<frm:form modelAttribute="js" enctype="multipart/form-data">
	<table border="0" bgcolor="cyan" align="center">
		<tr>
			<td>Name ::</td>
			<td><frm:input path="jsName" /></td>
		</tr>
		<tr>
			<td>Address ::</td>
			<td><frm:input path="jsAddrs" /></td>
		</tr>
		<tr>
			<td>Select Resume ::</td>
			<td><frm:input type="file" path="resume" /></td>
		</tr>
		<tr>
			<td>Select Photo ::</td>
			<td><frm:input type="file" path="photo" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register" /></td>
		</tr>
	</table>
</frm:form>