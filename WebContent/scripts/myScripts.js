function allFilmsXML() {
	// Clears table for new entry.
	$('#table>tbody').empty();
	$.ajax({
		type : 'GET',
		url : 'getAllFilms?format=xml', // The file path.
		dataType : 'xml',
		success : function(xml) {
			$(xml).find('film').each(
					function() {

						// Append new data to the DIV element.
						$('#films').append(
								'<div>' + '<div><b>Title </b>'
										+ $(this).find('title').text()
										+ '</div> ' + '<div><b>ID </b>'
										+ $(this).find('id').text() + '</div> '
										+ '<div><b>Review </b>'
										+ $(this).find('review').text()
										+ '</div> ' + '<div><b>Stars </b>'
										+ $(this).find('stars').text()
										+ '</div> ' + '<div><b>Director </b>'
										+ $(this).find('director').text()
										+ '</div> ' + '<div><b>Year</b>'
										+ $(this).find('year').text()
										+ '</div> ' + '</div>');
					});
		}
	});
}

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
	$.getJSON("getAllFilms?format=json", function(data) {
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

function searchFilmsJsonTable() {
	// Clears table for new entry.
	$('#table>tbody').empty();

	var searchString = document.getElementById("searchString").value;
	
	//Stops the function printing all films if nothing is entered into the text box.
	if (searchString === ""){
		return;
	}
	$.getJSON("getFilmByTitle?format=json&filmname=" + searchString, function(
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


