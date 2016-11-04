<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Photogallery</title>
<meta charset="UTF-8">
<style type="text/css">
img {
	max-width: 100%;
}
</style>
</head>
<body>
	<jsp:include page="widgets/menu.jsp" />
	<h1>
		Photogallery of
		<s:property value="user.username" />
	</h1>
	<p>
		<img src="http://tinyurl.com/k3jwlnw"
			alt="<s:property value="user.username" />" />
	</p>
</body>
</html>
