<%@ taglib uri="/struts-tags" prefix="s"%>
<s:form action="user">
	<s:textfield name="name" label="name" />
	<s:submit value="register" />
</s:form>
<s:form action="employee">
	<s:textfield name="name" label="name" />
	<s:textfield name="salary" label="salary" />
	<s:submit value="register" />
</s:form>