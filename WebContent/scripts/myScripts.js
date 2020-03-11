function allFilmsXMLTable() {
	// Clears table for new entry.
	$('#table>tbody').empty();
	$.ajax({
		url : "getAllFilms?format=xml",
		dataType : "xml",

		success : function(data) {
			$(data).find("film").each(
					function() {
						var genre = [], cast = [];

						$("table").append(
								"<tr>" + "<td>" + $(this).find("title").text()
										+ "</td>" +

										"<td>" + $(this).find("id").text()
										+ "</td>" +

										"<td>" + $(this).find("review")

										.text() + "</td>" + "<td>"
										+ $(this).find("stars")

										.text() + "</td>" + "<td>"
										+ $(this).find("director")

										.text() + "</td>" + "<td>"
										+ $(this).find("year")

										.text() + "</td>" + "</tr>");
					});
		}
	});
}

function allFilmsJsonTable() {
	// Clears table for new entry.
	$('#table>tbody').empty();
	$.getJSON("getAllFilms", function(data) {
		var filmInfo = '';
		$.each(data, function(key, value) {
			filmInfo += '<tr>';
			filmInfo += '<td>' + value.title + '</td>';
			filmInfo += '<td>' + value.id + '</td>';
			filmInfo += '<td>' + value.review + '</td>';
			filmInfo += '<td>' + value.stars + '</td>';
			filmInfo += '<td>' + value.director + '</td>';
			filmInfo += '<td>' + value.year + '</td>';
			filmInfo += '<tr>';
		});
		$('#table').append(filmInfo);
	});

}

function allFilmsTextTable() {
	// Clears table for new entry.
	$('#table>tbody').empty();
	
	
	$.getJSON("getAllFilms?format=text", function(data) {
		var filmInfo = '';
		$.each(data, function(key, value) {
			filmInfo += '<tr>';
			filmInfo += '<td>' + value.title + '</td>';
			filmInfo += '<td>' + value.id + '</td>';
			filmInfo += '<td>' + value.review + '</td>';
			filmInfo += '<td>' + value.stars + '</td>';
			filmInfo += '<td>' + value.director + '</td>';
			filmInfo += '<td>' + value.year + '</td>';
			filmInfo += '<tr>';
		});
		$('#table').append(filmInfo);
	});

}



function searchFilmsXMLTable() {
	// Clears table for new entry
	$('#table>tbody').empty();

	var searchString = document.getElementById("searchString2").value;
	
	//Stops the function printing all films if nothing is entered into the text box.
	if (searchString === ""){
		return;
	}
	$.ajax({
		url : "getFilmByTitle?format=xml&filmname=" + searchString,
		dataType : "xml",

		success : function(data) {
			$(data).find("film").each(
					function() {
						var genre = [], cast = [];

						$("table").append(
								"<tr>" + "<td>" + $(this).find("title").text()
										+ "</td>" +

										"<td>" + $(this).find("id").text()
										+ "</td>" +

										"<td>" + $(this).find("review")

										.text() + "</td>" + "<td>"
										+ $(this).find("stars")

										.text() + "</td>" + "<td>"
										+ $(this).find("director")

										.text() + "</td>" + "<td>"
										+ $(this).find("year")

										.text() + "</td>" + "</tr>");
					});
		}
	});
}

function searchFilmsJsonTable() {
	// Clears table for new entry.
	$('#table>tbody').empty();

	var searchString = document.getElementById("searchString").value;
	
	//Stops the function printing all films if nothing is entered into the text box.
	if (searchString === ""){
		return;
	}
	$.getJSON("getFilmByTitle?filmname=" + searchString, function(
			data) {
		var filmInfo = '';

		$.each(data, function(key, value) {
			filmInfo += '<tr>';
			filmInfo += '<td>' + value.title + '</td>';
			filmInfo += '<td>' + value.id + '</td>';
			filmInfo += '<td>' + value.review + '</td>';
			filmInfo += '<td>' + value.stars + '</td>';
			filmInfo += '<td>' + value.director + '</td>';
			filmInfo += '<td>' + value.year + '</td>';
			filmInfo += '<tr>';
		});
		$('#table').append(filmInfo);
	});

}

function outputController(){
	
	var e = document.getElementById("format-type");
	var format = e.options[e.selectedIndex].value;
	
	if (format == "json"){
		allFilmsJsonTable();
	}
	if (format == "xml"){
		allFilmsXMLTable();
	} 
	else {
		return;
	}
	
	
}

function ajaxPost(address, data, responseHandler) {
	  var request = getRequestObject();
	  request.onreadystatechange = 
	    function() { responseHandler(request); };
	  request.open("POST", address, true);
	  request.setRequestHeader("Content-Type", 
	                           "application/x-www-form-urlencoded");
	  request.send(data);
	}





function homepage(){
	document.location.href="index.html"; 
}



function addFilm(){
	

	
	var title = document.getElementById("title").value;
	var id = document.getElementById("id").value;
	var review = document.getElementById("review").value;
	var stars = document.getElementById("stars").value;
	var director = document.getElementById("director").value;
	var year = document.getElementById("year").value;
	
	 var request = new XMLHttpRequest();
	    request.open("GET","insertFilm?Title=" + title + "&ID=" + id + "&Review=" + review + "&Stars=" + stars + "&Director=" + director + "&Year=" + year);
	    request.send();
	    
	    
	    
	    alert("Your Film has been added to the database. Click ok to go back to the Homepage");
	    document.location.href="index.html"; 
}






