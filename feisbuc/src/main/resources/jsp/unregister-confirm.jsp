<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Off</title>
</head>
<body>
	<h1>WARNING!</h1>
	<p>Performing this action will delete your account along with all
		your posts! Do you wish to continue?</p>
	<s:form theme="simple">
		<s:submit value="Hell yeah!" action="unregister-yes" />
		<s:submit value="No way!" action="" />
	</s:form>
</body>
</html>
