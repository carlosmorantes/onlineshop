<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${param.locale}" />
<fmt:setBundle basename="messages" />

<!DOCTYPE html>
<html>
<body>
	Language set to:
	<c:out value="${param.locale}" />
	<br>

	<a href="hellowelt.jsp?locale=de_DE">German</a>
	<a href="hellowelt.jsp?locale=en_US">English</a>
	<br> Messages:
	<br>
	<fmt:message key="hello.world"></fmt:message>
	<br>
	<fmt:message key="your.email.password">
		<fmt:param value="${customer.email}"></fmt:param>
		<fmt:param value="${customer.password}"></fmt:param>
	</fmt:message>





</body>
</html>