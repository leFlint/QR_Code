<%@ taglib prefix="qrcode" uri="http://local/qrgen"%>
<h1>
	<a href="${redirection.url}">${redirection.url}</a> <img alt="QRCode"
		src="${qrcode:generate(redirection.url)}" />
</h1>