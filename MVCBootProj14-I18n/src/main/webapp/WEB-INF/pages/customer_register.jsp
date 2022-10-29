<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>

<h1 style="color: green; text-align: center">
	<sp:message code="cust.registration.title" />
</h1>

<fr:form modelAttribute="cust">
	<table bordder="1" align="center" bgcolor="cyan">
		<tr>
			<td><sp:message code="cust.registration.name" /></td>
			<td><fr:input path="cname" /></td>
		</tr>
		<tr>
			<td><sp:message code="cust.registration.address" /></td>
			<td><fr:input path="caddress" /></td>
		</tr>
		<tr>
			<td><sp:message code="cust.registration.billAmount" /></td>
			<td><fr:input path="billAmount" /></td>
		</tr>
		<tr>
			<td><input type="submit"
				value="<sp:message code="cust.registration.submit.caption"/>" /></td>
		</tr>
	</table>
</fr:form>
<br>
<br>
<p align="center">
	<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;&nbsp; <a
		href="?lang=de_DE">German</a>&nbsp;&nbsp;&nbsp; <a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;&nbsp;
	<a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp; <a href="?lang=zh_CN">Chinese</a>
</p>