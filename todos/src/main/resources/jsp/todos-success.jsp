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
	<p>Add a new todo:</p>
	<s:form action="add">
		<s:textfield name="title" label="title" autofocus="true" />
		<s:submit value="add" />
	</s:form>
	<ul>
		<s:iterator value="todos">
			<li data-id="<s:property value="id" />"><s:property value="title" /></li>
		</s:iterator>
	</ul>
	<s:form action="clear">
		<s:submit value="clear" />
	</s:form>
</body>
</html>
