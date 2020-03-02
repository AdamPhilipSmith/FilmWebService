package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/** Sends random double between 0 and 1. */
@WebServlet("/show-number-list")
public class ShowNumberList extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    double[] randomNums =
      { Math.random(), Math.random(), 
        Math.random(), Math.random()
      };
    request.setAttribute("nums", randomNums);
    response.setHeader("Cache-Control", "no-cache");
    RequestDispatcher dispatcher =
      request.getRequestDispatcher("/show-number-list.jsp");
    dispatcher.include(request, response);
  }
}