<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="qrcode" uri="http://local/qrgen"%>
<table class="table">
	<thead>
		<tr>
			<th>Url</th>
			<th>QrCode</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${redirections}" var="redirection">
			<tr>
				<c:set var="baseURL"
					value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
				<c:set var="urlToShare">
					<c:url value="${baseURL}/redirection/view/${redirection.id}"></c:url>
				</c:set>
				
				<td><a href="${urlToShare}"
					target="_blank">${redirection.url}</a></td>
				<td><img alt="QRCode" src="${qrcode:generate(urlToShare)}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>