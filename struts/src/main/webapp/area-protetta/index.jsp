<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Login con successo</title>
</head>
<body>
	<h1>Sei dentro!</h1>
	<p>Hello <s:property value="username"/>, benvenuto nell'area protetta!</p>
	<p><s:a href="area-protetta/gallery">vai alla photogallery</s:a></p>
</body>
</html>
