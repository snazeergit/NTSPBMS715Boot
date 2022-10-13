<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 style="color: green; text-align: center">simple_data3.jsp</h1>
<c:if test="${!empty studentInfo}">
<b>Studnet Model Data:: ${studentInfo.sno},${studentInfo.sname}, ${studentInfo.salary},${studentInfo.vaccinated}</b>
</c:if>
