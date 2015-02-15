<%@ taglib uri="/struts-tags" prefix="s"%>
<s:form action="register">
	<s:textfield name="id" label="id" type="number" />
	<s:textfield name="name" label="name" />
	<s:textfield name="salary" label="salary" type="number" />
	<s:submit value="register" />
</s:form>
