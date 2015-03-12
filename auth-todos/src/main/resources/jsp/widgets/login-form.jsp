<%@taglib uri="/struts-tags" prefix="s"%>
<s:form action="login">
	<s:textfield name="username" label="username" autofocus="true" />
	<s:password name="password" label="password" />
	<s:submit value="login" />
</s:form>
