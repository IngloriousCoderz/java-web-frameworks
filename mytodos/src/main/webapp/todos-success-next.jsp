<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Todos</title>
		<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
		<script>
			$(function () {
				$('ul').on(
								'click',
								'li',
								function (event) {
									window.location.href = 'update.action?id='
													+ $(event.currentTarget).data('id');
								});
			});
		</script>
	</head>
	<body>
		<s:a action="">
			<h1>Todos</h1>
		</s:a>
		<s:form action="add">
			<input type="hidden" name="id" />
			<s:textfield name="title" label="title" />
			<s:submit value="add" />
		</s:form>
		<ul>
			<s:iterator value="todos">
				<li data-id="${id}"><s:property value="title" /></li>
				</s:iterator>
		</ul>
		<s:form action="clear">
			<s:submit value="clear" />
		</s:form>
	</body>
</html>
