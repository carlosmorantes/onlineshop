<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<body>
	<p>
		<fmt:setLocale value="de_DE" />
		<fmt:bundle basename="messages">
			<fmt:message key="hello.world"></fmt:message>
		</fmt:bundle>
	</p>
	<p>
		<fmt:setLocale value="en_US" />
		<fmt:bundle basename="messages">
			<fmt:message key="hello.world"></fmt:message>
		</fmt:bundle>
	</p>
	
</body>
</html>