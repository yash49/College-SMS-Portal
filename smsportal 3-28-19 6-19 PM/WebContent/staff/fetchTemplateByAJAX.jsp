<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
[
<c:forEach items="${list}" var="i">
	{

		${i.smsTemplateText}
	}
</c:forEach>
]
