<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Errore di login</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>Login fallito</h1>
	<p>Nome utente e password non corrispondono. Riprova per favore</p>
	<jsp:include page="login-form.jsp" />
</body>
</html>
