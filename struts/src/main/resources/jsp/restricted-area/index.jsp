<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>You're in!</title>
</head>
<body>
	<jsp:include page="widgets/menu.jsp" />
	<h1>You're in, <s:property value="login" />!</h1>
	<p>Hello <s:property value="user.username" />, welcome inside!</p>
	<p>Do I have to tell you again? Hello ${user.username}!</p>
</body>
</html>
