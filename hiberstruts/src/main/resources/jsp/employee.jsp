<%@ taglib uri="/struts-tags" prefix="s"%>
<p>
Welcome <s:property value="name" />,
your salary is <s:property value="salary" />!
</p>
<p>
Here are all registered employees:
</p>
<ul>
	<s:iterator value="employees">
		<li>
			<s:property value="name" />
			<s:if test="%{salary > 0}">
				- &euro;<s:property value="salary" />
			</s:if>
			<s:elseif test="%{salary == 0}">
				- broke
			</s:elseif>
			<s:else>
				- CATCH HIM/HER!
			</s:else>
		</li>
	</s:iterator>
</ul>
