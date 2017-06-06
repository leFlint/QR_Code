<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
	<thead>
		<tr>
			<th>Url</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${redirections}" var="redirection">
			<tr>
				<td><a href="/redirections/view/${redirection.id}"
					target="_blank">${redirection.url}</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>