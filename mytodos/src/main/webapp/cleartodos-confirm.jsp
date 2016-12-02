<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Clear Todos</title>
	</head>
	<body>
		<h1>WARNING!</h1>
		<p>
			Performing this action will delete all your todos! Do you wish
			to continue?
		</p>
		<s:form theme="simple">
			<s:submit value="Hell yeah!" action="clear-yes" />
			<s:submit value="No way!" action="" />
		</s:form>
	</body>
</html>
