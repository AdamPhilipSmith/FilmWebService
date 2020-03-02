package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/** Sends random double between 0 and 1. */
@WebServlet("/show-number")
public class ShowNumber extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    response.setHeader("Cache-Control", "no-cache");
    out.print("Your number is " + Math.random());
  }
}