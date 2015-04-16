<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Feisbuc</title>
</head>
<body>
	<jsp:include page="widgets/menu.jsp" />

	<s:form action="publish">
		<s:textfield name="newPostText" placeholder="Your thoughts" autofocus="true" />
		<s:submit value="publish" />
	</s:form>

	<ul>
		<s:iterator value="posts">
			<li>
				<s:property value="text" />
				<br><s:property value="likes" /> likes, <s:property value="comments" /> comments
				<s:form theme="simple">
					<s:hidden name="id" />
					<s:submit value="like" action="like" />
					<s:submit value="comment" action="comment" />
				</s:form>
			</li>
		</s:iterator>
	</ul>

	<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
	<script src="scripts/wall.js"></script>
</body>
</html>
