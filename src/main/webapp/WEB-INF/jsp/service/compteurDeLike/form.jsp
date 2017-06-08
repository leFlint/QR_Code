<form action="" method="post" id="createForm">
	<div class="form-group">
		<label for="compteurDeLikeLink">Compteur de Like</label> <input type="text"
			name="sentence" id="sentence" class="form-control" id="compteurDeLikeLink"
			placeholder="Dites ce que vous voulez !!">
	</div>
	<button type="submit" class="btn btn-default">Créer</button>
</form>

<script type="text/javascript">
	$('#createForm').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url : '/compteurDeLike',
			contentType : "application/json",
			type : 'post',
			data : JSON.stringify({
				"sentence" : $('#sentence').val(),
			}),
			dataType : 'json',
			success : function() {
				$('#listeTab').click();
			}
		});
	});
</script>