<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Errore di login</title>
</head>
<body>
	<jsp:include page="widgets/menu.jsp" />
	<h1>Login fallito</h1>
	<p>Nome utente e password non corrispondono. Riprova per favore</p>
	<jsp:include page="widgets/login-form.jsp" />
</body>
</html>
