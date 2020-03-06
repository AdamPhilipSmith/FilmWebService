function ajaxLoading() {
  $.ajax({
    url: "getAllFilms",
    dataType: "xml",
    success: function(data) {
      $(data)
        .find("title")
        .each(function() {
          var genre = [],
            cast = [];
          $(this)
            .find("year")
            .each(function() {
              year.push($(this).text());
            });
          $(this)
            .find("director")
            
            .each(function() {
              director.push($(this).attr("name"));
            });

          $("table").append(
            "<tr>" +
              "<td>" +
              $(this)
                .find("title")
                .text() +
              "</td>" +
              "<td>" +
              genre.join(", ") +
              "</td>" +
              "<td>" +
              $(this)
                .find("dyear")
                .text() +
              "</td>" +
              "<td>" +
              cast.join(", ") +
              "</td>" +
              "<td>" +
              $(this)
                .find("imdb-info")
                .find("synopsis")
                .text() +
              "</td>" +
              "<td>" +
              $(this)
                .find("imdb-info")
                .find("score")
                .text() +
              "</td>" +
              "</tr>"
          );
        });
    }
  });
}