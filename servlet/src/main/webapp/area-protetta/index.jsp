<%@page import="it.formarete.model.User" %>
<!doctype html>
<html>
<head>
<title>Login con successo</title>
</head>
<body>
	<h1>Sei dentro <%= ((User)request.getAttribute("user")).getUsername() %>!</h1>
	<jsp:useBean id="user" scope="session" class="it.formarete.model.User" />
	<p>Hello <jsp:getProperty name="user" property="username" />, benvenuto nell'area protetta!</p>
	<p>Te lo ripeto? Hello ${user.username}!</p>
</body>
</html>
