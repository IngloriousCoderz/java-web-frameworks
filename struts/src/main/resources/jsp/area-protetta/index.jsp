<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Login con successo</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>Sei dentro, <s:property value="USER" />!</h1>
	<p>Hello <s:property value="user.username" />, benvenuto nell'area protetta!</p>
	<p>Te lo dico un'altra volta? Hello ${user.username}!</p>
</body>
</html>
