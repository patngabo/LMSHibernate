<%@ taglib prefix="gcit" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="includes.jsp"%>

<div class="container">
	
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		
		<gcit:forEach items="${authors}" var="author">
			<tr>
				<td>${author.authorId}</td>
				<td>${author.authorName}</td>
				<td><input type="button" value="edit" /></td>
				<td><input type="button" value="delete" /></td>
			</tr>
		</gcit:forEach>
	</table>

</div>