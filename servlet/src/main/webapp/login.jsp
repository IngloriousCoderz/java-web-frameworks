<!doctype html>
<html>
<head>
<title>Login richiesto</title>
<style type="text/css">
div {
	color: red;
}
.right {
	text-align: right;
}
</style>
</head>
<body>
	<h1>Devi autenticarti</h1>
	<div>${message}</div>
	<form action="${destination}" method="POST">
		<table>
			<tr>
				<td><label for="username">Username:</label></td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td colspan="2" class="right"><input type="submit" value="login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
