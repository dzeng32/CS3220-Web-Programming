<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>Story List</title>
	</head>
	<body>
		<h1>List Story hw2</h1>
		<a class="btn btn-primary" href="SubmitStory" role="button">Submit Story</a>
		<table class="table table-sm table-striped">
			<thead>
				<tr>
					<th scope="col">Story</th>
					<th scope="col">Submitted</th>
					<th scope="col">Published</th>
					<th scope="col">Operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items= "${entries}" var= "entry">
				<tr>
					<td><a href="DisplayStory?id=${entry.id}">${entry.storyTitle}</a></td>
					<td>${entry.submitDate}</td>
					
					<c:choose>
					  <c:when test="${empty entry.publishDate}">
					    <td><a href="PublishStory?id=${entry.id}">Publish</a></td>
					  </c:when>
					  <c:otherwise>
					    <td>${entry.publishDate}</td>
					  </c:otherwise>
					</c:choose>
					
					<td><a href="${pageContext.request.contextPath}/EditStory?id=${entry.id}">Edit </a></td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
	</body>
</html>