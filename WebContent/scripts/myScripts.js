   
function allFilmsXML() {
$.ajax({
                type: 'GET',
                url: 'getAllFilms?format=xml',           // The file path.
                dataType: 'xml',    
                success: function(xml) {
                    $(xml).find('film').each(function() {
                    	
                        // Append new data to the DIV element.
                        $('#films').append(
                            '<div>' +
                                '<div><b>Title </b>' +
                                    $(this).find('title').text() + '</div> ' +
                                '<div><b>ID </b>' +
                                    $(this).find('id').text() + '</div> ' +
                                    '<div><b>Review </b>' +
                                    $(this).find('review').text() + '</div> ' +
                                    '<div><b>Stars </b>' +
                                    $(this).find('stars').text() + '</div> ' +
                                    '<div><b>Director </b>' +
                                    $(this).find('director').text() + '</div> ' +
                                '<div><b>Year</b>' +
                                    $(this).find('year').text() + '</div> ' +
                            '</div>');
                    });
                }
            });
}


function allFilmsXMLTable() {
	  $.ajax({
	    url: "getAllFilms?format=xml",
	    dataType: "xml",
	    
	    success: function(data) {
	      $(data)
	        .find("film")
	        .each(function() {
	          var genre = [],
	            cast = [];
	          
	          
	        
	          $("table").append(
	            "<tr>" +
	              "<td>" +
	              $(this)
	                .find("title")
	                .text() +
	              "</td>" +
	              
	              "<td>" +
	              $(this)
	                .find("id")
	                .text() +
	              "</td>" +
	              
	              "<td>" +
	              $(this)
	                .find("review")
	                
	                .text() +
	              "</td>" +
	              "<td>" +
	              $(this)
	                .find("stars")
	                
	                .text() +
	              "</td>" +
	              "<td>" +
	              $(this)
	                .find("director")
	                
	                .text() +
	              "</td>" +
	              "<td>" +
	              $(this)
	                .find("year")
	                
	                .text() +
	              "</td>" +
	              "</tr>"
	          );
	        });
	    }
	  });
	}