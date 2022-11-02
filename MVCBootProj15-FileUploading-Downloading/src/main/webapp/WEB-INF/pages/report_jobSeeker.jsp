<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red; text-align: center">File Uploading &
	Downloading Application</h1>
<br>
<br>
<c:choose>
	<c:when test="${!empty jsInfo}">
		<h1 style="color: red; text-align: center">JobSeekers Report</h1>
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<th>JSID</th>
				<th>NAME</th>
				<th>ADDRESS</th>
				<th>DOWNLOAD-RESUME</th>
				<th>DOWNLOAD-PHOTO</th>
			</tr>
			<c:forEach var="js" items="${jsInfo}">
				<tr style="color: blue">
					<td>${js.jsId}</td>
					<td>${js.jsName}</td>
					<td>${js.jsAddrs}</td>
					<td><a href="js_download?jsId=${js.jsId }&type=resume" >download</a></td>
					<td><a href="js_download?jsId=${js.jsId }&type=photo" >download</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h2 style="color: red; text-align: center">Employees not found</h2>
	</c:otherwise>
</c:choose>
<br>
<h2 style="text-align: center"><a href="./">Home</a></h2> 

