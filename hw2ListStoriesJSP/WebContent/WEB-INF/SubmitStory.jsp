<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>Submit Story</title>
	</head>
	<body>
		<form action="SubmitStory" method="post">
			
			<div class="form-group row">
			    <label for="titleInput" class="ml-1 col-sm-1 col-form-label">Title</label>
			    <div class="col-sm-5">
			      <input type="text" class="form-control" id="titleInput" name="title" >
			    </div>
			</div>
			
			<div class="form-group row">
			    <label for="subtitleInput" class="ml-1 col-sm-1 col-form-label">Subtitle</label>
			    <div class="col-sm-5">
			      <input type="text" class="form-control" id="subtitleInput" name="subtitle">
			    </div>
			</div>
		
			<div class="form-group row">
			    <label for="contentInput" class="ml-1 col-sm-1 col-form-label">Content</label>
			    <div class="col-sm-5">
			      <textarea class="form-control" id="contentInput" rows="3" name="content"></textarea>
			    </div>
			</div>
			
			<div class="form-group row">
			    <div class="col-sm-5">
			      <button type="submit" class="ml-1 btn btn-primary">Submit</button>
			    </div>
			</div>
		
		</form>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
	</body>
</html>