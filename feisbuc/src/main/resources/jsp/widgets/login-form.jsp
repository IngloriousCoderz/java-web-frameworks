<%@taglib uri="/struts-tags" prefix="s"%>
<s:form>
	<s:textfield name="username" label="username" autofocus="true" />
	<s:password name="password" label="password" />
	<s:iterator value="#parameters">
		<s:hidden name="%{key}" value="%{value}" />
	</s:iterator>
	<s:submit value="login" />
</s:form>
Don't have an account? <s:a action="register">Sign up</s:a>
