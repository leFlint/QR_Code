<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="qrcode" uri="http://local/qrgen"%>
<table class="table">
	<thead>
		<tr>
			<th>Sentence</th>
			<th>QrCode</th>
			<th>Nombre de Like</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${compteurDeLikes}" var="compteurDeLike">
			<tr>
				<c:set var="baseURL"
					value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
				<c:set var="urlToShare">
					<c:url value="${baseURL}/compteurDeLike/view/${compteurDeLike.id}"></c:url>
				</c:set>
				<td><a href="${urlToShare}" target="_blank">${compteurDeLike.sentence}</a></td>
				<td><img alt="QRCode" src="${qrcode:generate(urlToShare)}" /></td>
				<td><span>${compteurDeLike.nbLike}</span></td>
			</tr>
		</c:forEach>
	</tbody>
</table>