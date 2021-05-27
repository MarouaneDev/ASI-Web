package com.cpe.tuto.jee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test1Servlet
 */
public class Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name_value = request.getParameter("name");
        String result="";
        
        for( Entry<String, String[]> att_entry : request.getParameterMap().entrySet()) {
            result= result +"<h3>"+ "["+att_entry.getKey()+"]:"+att_entry.getValue()[0]+"</h3>";
        }
        
        PrintWriter writer = response.getWriter();
        writer.println("<h1> The name param value is:"+name_value+"</h1>");
        writer.println("<h2> Below the list of sent params:</h2>");
        writer.println(result);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="";
        for( Entry<String, String[]> att_entry : request.getParameterMap().entrySet()) {
            result= result +"<h3>"+ "["+att_entry.getKey()+"]:"+att_entry.getValue()[0]+"</h3>";
        }
        
        PrintWriter writer = response.getWriter();
        writer.println("<h1> Below the list of sent params:</h2>");
        writer.println(result);
    }


}
