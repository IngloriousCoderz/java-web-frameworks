<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<title>Todos</title>
</head>
<body>
	<s:a action="">
		<h1>Todos</h1>
	</s:a>
	<s:form action="submit">
		<s:textfield name="title" label="title" autofocus="true" />
		<s:hidden name="id" value="%{id}" />
		<s:submit value="submit" />
	</s:form>
	<ul>
		<s:iterator value="todos">
			<li>
				<s:property value="title" />
				<s:form action="edit">
					<s:hidden name="id" value="%{id}" />
					<s:submit value="edit" />
				</s:form>
				<s:form action="delete">
					<s:hidden name="id" value="%{id}" />
					<s:submit value="delete" />
				</s:form>
			</li>
		</s:iterator>
	</ul>
	<s:form action="clear">
		<s:submit value="clear" />
	</s:form>
</body>
</html>
