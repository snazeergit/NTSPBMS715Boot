<%@ page isELIgnored="false" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Model Atrributes ::</h1>

<b> Fav colors :::</b>
<c:forEach var="color" items="${favColors}">
${color},
</c:forEach>

<b> nickNames:::</b>
<c:forEach var="nickName" items="${nickNames}">
${nickName},
</c:forEach>

<b> phones :::</b>
<c:forEach var="phone" items="${phones}">
${phone},
</c:forEach>

<b> identities :::</b>
<c:forEach var="id" items="${identities}">
${id.key},${id.value}<br>
</c:forEach>