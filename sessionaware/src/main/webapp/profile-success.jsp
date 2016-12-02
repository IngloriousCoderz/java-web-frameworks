<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Profile page</title>
	</head>
	<body>
		<jsp:include page="widgets/menu.jsp" />
		Welcome to Profile,
		<s:property value="#session.name" />!
		<s:text name="hi.msg" />
	</body>
</html>
