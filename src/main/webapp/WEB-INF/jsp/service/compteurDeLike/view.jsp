<%@ taglib prefix="qrcode" uri="http://local/qrgen"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<h1>${compteurDeLike.sentence }</h1>
<h3>
	<span id="nbLike">${compteurDeLike.nbLike}</span> like !
</h3>
<button onclick="doLike()">Like</button>

<script>
	function doLike() {
		$.ajax({
			url : '/compteurDeLike/like/${compteurDeLike.id}',
			contentType : "application/json",
			type : 'post',
			success : function(r) {
				$('#nbLike').html(r);
			}
		});
	}
</script>