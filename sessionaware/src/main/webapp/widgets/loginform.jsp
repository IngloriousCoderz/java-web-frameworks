<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form action="login">
    <s:textfield name="name" label="Name" />
    <s:password name="password" label="Password" />
    <s:submit value="login" />
</s:form>
