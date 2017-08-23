<head>
<script>
	function validate() {
		var authorName = $('#authorName').val();
		if (authorName == "") {
			$('#result')
					.html(
							"<font color='red'>Please enter a value for Author Name</font><br/>");
			return false;
		} else {
			$.ajax({
				type : "POST",
				url : "addAuthor/" + $('#authorName').val()
			}).done(function(msg) {
				$('#result').html(msg + "<br/>");
			});
		}
	}

	function validate() {
		$.ajax({
			type : "POST",
			url : "addBook/",
			data: {title: $('#title').val(), authors: $('#authors').val()}
		}).done(function(msg) {
			$('#result').html(msg + "<br/>");
		});
}

	function showSection(section) {
		var sectionToShow = $('#' + section);
		if (sectionToShow.css('display') == 'block')
			sectionToShow.css('display', 'none');
		else
			sectionToShow.css('display', 'block');

	}

	function showAuthorList() {
	$.ajax({
		 type: "POST",
		 url: "showAddBook"
		 })
		 .done(function( msg ) {
		 $('#authorList').html(msg);
		 }); 
	}

</script>

</head>

<%@include file="includes.jsp"%>

<div class="container">
	<span id="result"></span> <a
		href="javascript:showSection('addAuthorSection');">Add Author</a>
	<!-- author section -->
	<span id="addAuthorSection" style="display: none;"> <input
		type="text" id="authorName" placeholder="Enter Author's Name" /> <input
		type="button" onclick="javascript:validate();" value="Submit" />
	</span> <br /> 
	<a href="javascript:showSection('addBookSection');showAuthorList();">Add
		Book</a>

	<span id="addBookSection" style="display: none;"> 
		<input type="text" name="title" id="title" placeholder="Enter Book's Title" /><br />

	
	<span id="authorList">
	</span> <br /> <input type="button" onclick="javascript:saveBook();"/>
	</span>

</div>
<script>
	$(function() {
		function log(message) {
			$("<div>").text(message).prependTo("#log");
			$("#log").scrollTop(0);
		}

		$("#city")
				.autocomplete(
						{
							source : function(request, response) {
								$
										.ajax({
											url : "http://localhost:8080/training/getAllAuthors",
											dataType : "jsonp",
											data : {
												q : request.term
											},
											success : function(data) {
												alert(data);
												response(data);
											}
										});
							},
							minLength : 1,
							select : function(event, ui) {
								log(ui.item ? "Selected: " + ui.item.label
										: "Nothing selected, input was "
												+ this.value);
							},
							open : function() {
								$(this).removeClass("ui-corner-all").addClass(
										"ui-corner-top");
							},
							close : function() {
								$(this).removeClass("ui-corner-top").addClass(
										"ui-corner-all");
							}
						});
	});
</script>














