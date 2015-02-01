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
	<form action="<s:property value="destination"/>" method="POST">
		<input type="text" name="username" /><br>
		<input type="password" name="password" /><br>
		<input type="submit" value="login" />
	</form>
</body>
</html>
