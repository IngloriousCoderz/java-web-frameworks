<jsp:include page="widgets/menu.jsp" />
<%@ taglib uri="/struts-tags" prefix="s"%>
Welcome to Profile,
<s:property value="#session.name" />!
<s:text name="hi.msg" />
