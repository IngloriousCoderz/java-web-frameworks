<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Login richiesto</title>
<style type="text/css">
div {
	color: red;
}
</style>
</head>
<body>
	<h1>Devi autenticarti</h1>
	<div><s:property value="message"/></div>
	<div><s:property value="destination"/></div>
	<s:form action="%{destination}">
		<s:textfield name="username" label="Username" />
		<s:textfield type="password" name="password" label="Password" />
		<s:submit value="Login" />
	</s:form>
</body>
</html>
