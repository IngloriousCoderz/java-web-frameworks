<!doctype html>
<html>
<head>
<title>Login richiesto</title>
<style type="text/css">
div {
	color: red;
}
</style>
</head>
<body>
	<h1>Devi autenticarti</h1>
	<div>${message}</div>
	<form action="${destination}" method="POST">
		<input type="text" name="username" /><br>
		<input type="password" name="password" /><br>
		<input type="submit" value="login" />
	</form>
</body>
</html>
