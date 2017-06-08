<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des services</title>

</head>

<body>
	<div class="container">
		<h1>Services</h1>
	</div>
	<div id="navContainer" class="container">
		<ul class="nav nav-pills">
			<li><a href="#redirection" data-toggle="tab"
				onclick="$('#mainContent').load('redirections');">Redirection</a></li>
			<li><a href="#compteurLike" data-toggle="tab"
				onclick="$('#mainContent').load('compteurDeLike');">Compteur
					De Like</a></li>
		</ul>

		<div class="tab-pane" id="mainContent"></div>
	</div>
</body>

</html>