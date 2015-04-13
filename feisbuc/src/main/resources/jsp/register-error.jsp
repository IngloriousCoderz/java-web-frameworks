<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Failed</title>
</head>
<body>
	<jsp:include page="widgets/menu.jsp" />
	<h1>Oh Snap!</h1>
	<p>Username must have already been taken, please choose another one.</p>
	<jsp:include page="widgets/register-form.jsp" />
</body>
</html>
