  package com.cpe.tuto.jee.servlet;

  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;

  @WebServlet("/redirect2")
  public class Redirect2Servlet extends HttpServlet {
      private static final long serialVersionUID = 1L;
      
      public Redirect2Servlet() {
          super();
      }

      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println(" I AM REDIRECT2 SERVLET");
          response.sendRedirect("redirect3");
      }
  }
