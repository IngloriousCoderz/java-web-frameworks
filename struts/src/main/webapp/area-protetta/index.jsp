<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Login con successo</title>
</head>
<body>
	<h1>Sei dentro <s:property value="USER" />!</h1>
	<p>Hello <s:property value="username" />, benvenuto nell'area protetta!</p>
	<p>Te lo dico un'altra volta? Hello %{username}!</p>
	<p><s:a href="gallery">vai alla photogallery</s:a></p>
</body>
</html>
