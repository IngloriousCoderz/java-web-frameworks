<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Todos</title>
	</head>
	<body>
		<jsp:include page="widgets/menu.jsp" />

		<s:form action="submit">
			<s:textfield name="title" label="title" autofocus="true" />
			<s:hidden name="id" />
			<s:submit value="submit" />
		</s:form>

		<ul>
			<s:iterator value="todos">
				<li>
					<s:property value="title" />
					<s:form theme="simple">
						<s:hidden name="id" />
						<s:submit value="edit" action="edit" />
						<s:submit value="delete" action="delete" />
					</s:form>
				</li>
			</s:iterator>
		</ul>

		<s:form action="clear">
			<s:submit value="clear" />
		</s:form>
	</body>
</html>
