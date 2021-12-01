<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Display Zoom Links</title>
	</head>
	<body>
	  <form action="DisplayZoomLinks" method="post">
	  	<select name = "courseId" >
	  		<c:forEach items="${courseEntries}" var="courseEntry">	  		  		
		  		<option value="${courseEntry.id}" ${courseEntry.courseTitle == selectedCourse.courseTitle ? 'selected':''}>${courseEntry.courseTitle}</option>
	  		</c:forEach>
	  	</select>
	  	<input type="submit" value="Select"> <a href = "AddClass">Add Class</a> <br><br>
	  </form>
	  
	  <form action="AddLink" method="post">
	  	<table border="1">

	  			<c:forEach items="${selectedCourse.links}" var="link">
			  		<tr>
			  			<td>${link.name}</td>
			  			<td><a href="${link.zoomLink}">${link.zoomLink}</a></td>
			  			<td><a href="DeleteLink?linkId=${link.id}">Delete</a></td>
			  		</tr>
		  		</c:forEach>

		  	
		  		<tr>
		  			<td> <input type="text" name = "sectionTitle"> </td>
		  			<td> <input type="text" name = "zoom"> </td>
		  			<td> <input type="submit" value="Add"> </td>
		  		</tr>

	  	</table>  	
	  </form>
	</body>
</html>