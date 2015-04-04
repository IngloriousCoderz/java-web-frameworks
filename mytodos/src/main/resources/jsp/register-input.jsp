<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
</head>
<body>
	<jsp:include page="widgets/menu.jsp" />
	<h1>Sign Up</h1>
	<s:form action="register-success">
		<s:textfield name="username" label="username" autofocus="true" />
		<s:password name="password" label="password" />
		<s:submit value="register" />
	</s:form>
</body>
</html>
