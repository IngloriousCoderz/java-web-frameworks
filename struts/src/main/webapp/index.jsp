<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>Hello world!</h1>
	<p>Inserisci username e password<p>
	<s:form action="login">
		<s:textfield name="username" label="Username" />
		<s:textfield type="password" name="password" label="Password" />
		<s:submit value="Login" />
	</s:form>
	<s:a action="area-protetta">vai all'area protetta</s:a>
</body>
</html>
