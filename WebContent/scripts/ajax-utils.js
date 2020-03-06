// Get the browser-specific request object, either for
// Firefox, Safari, Opera, Mozilla, Netscape, IE 7, or IE 8 
// (top entry) or for IE 5.5 and 6 (second entry). 

function getRequestObject() {
  if (window.XMLHttpRequest) {
    return(new XMLHttpRequest());
  } else if (window.ActiveXObject) { 
    return(new ActiveXObject("Microsoft.XMLHTTP"));
  } else {
    return(null); 
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

// Make an HTTP request to the given address. 
// Display result in an alert box.

function ajaxAlert(address) {
  var request = getRequestObject();
  request.onreadystatechange = 
    function() { showResponseAlert(request); };
  request.open("GET", address, true);
  request.send(null);
}

// Put response text in alert box.

function showResponseAlert(request) {
  if ((request.readyState == 4) &&
      (request.status == 200)) {
    alert(request.responseText);
  }
}

// Make an HTTP request to the given address. 
// Display result in the HTML element that has given ID.

function ajaxResult(address, resultRegion) {
  var request = getRequestObject();
  request.onreadystatechange = 
    function() { showResponseText(request, 
                                  resultRegion); };
  request.open("GET", address, true);
  request.send(null);
}

function ajaxFormatResult(address, formatField, resultRegion) {
	  var request = getRequestObject();
	  var format = getValue(formatField);
	  request.onreadystatechange = 
	    function() { showResponseText(request, 
	                                  resultRegion); };
	  request.open("GET", address, true);
	  request.send(null);
	}

function ajaxFormatResult2(formatField, resultRegion) {
	  var address = "getAllFilms";
	  
	  var format = getValue(formatField);
	  var data = "format=" + format ;
	  var responseHandler = findHandler(format);
	  ajaxPost(address, data, 
	           function(request) { 
	             responseHandler(request, resultRegion); 
	           });
	}

function findHandler(format) {
	  if (format == "xml") {
	    return(showXmlCityInfo);
	  } else if (format == "json") {
	    return(showJsonCityInfo);
	  } else {
	    return(showStringCityInfo);
	  }
	}


function showXmlCityInfo(request, resultRegion) {
	  if ((request.readyState == 4) &&
	      (request.status == 200)) {
	    var xmlDocument = request.responseXML;
	    var headings = getXmlValues(xmlDocument, "filmlist");
	    var cities = xmlDocument.getElementsByTagName("film");
	    var rows = new Array(cities.length);
	    var subElementNames = ["id", "title", "year", "director", "stars", "review"];
	    
	    for(var i=0; i<cities.length; i++) {
	      rows[i] = 
	        getElementValues(cities[i], subElementNames);
	    }
	    var table = getTable(headings, rows);
	    htmlInsert(resultRegion, table);
	  }
	}

function cityTable(cityTypeField, formatField, resultRegion) {
	  var address = "show-cities";
	  var cityType = getValue(cityTypeField);
	  var format = getValue(formatField);
	  var data = "cityType=" + cityType +
	             "&format=" + format;
	  var responseHandler = findHandler(format);
	  ajaxPost(address, data, 
	           function(request) { 
	             responseHandler(request, resultRegion); 
	           });
	}

// Put response text in the HTML element that has given ID.

function showResponseText(request, resultRegion) {
  if ((request.readyState == 4) &&
      (request.status == 200)) {
    htmlInsert(resultRegion, request.responseText);
  }
}

// Insert the HTML data into the element that has the specified id.

function htmlInsert(id, htmlData) {
  document.getElementById(id).innerHTML = htmlData;
}