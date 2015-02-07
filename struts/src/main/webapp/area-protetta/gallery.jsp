<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Photogallery</title>
<meta charset="UTF-8">
</head>
<body>
	<h1>Photogallery di <s:property value="user.username" /></h1>
	<p><img src="http://tinyurl.com/k3jwlnw" alt="${user.username}" /></p>
	<p><s:a href="home">torna alla home dell'area protetta</s:a></p>
</body>
</html>
