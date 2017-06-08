<form action="" method="post" id="createForm">
	<div class="form-group">
		<label for="redirectionLink">Redirection</label> <input type="url"
			name="url" id="url" class="form-control" id="redirectionLink"
			placeholder="Link">
	</div>
	<button type="submit" class="btn btn-default">Créer</button>
</form>

<script type="text/javascript">
	$('#createForm').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url : "management/redirection",
			contentType : "application/json",
			type : 'post',
			data : JSON.stringify({
				"url" : $('#url').val(),
			}),
			dataType : 'json',
			success : function() {
				$('#listeTab').click();
			}
		});
	});
</script>