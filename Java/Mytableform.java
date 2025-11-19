package mypackage;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/** Simple servlet for testing. Generates HTML instead of plain
 *  text as with the HelloWorld servlet.
 */


@WebServlet("/mytableform")
public class Mytableform extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();
    String rowParam="";
    String columnParam="";
    int rowParamToInt=-1;
    int columnParamToInt=-1;
    out.println
      ("<!DOCTYPE html>\n" +
       "<html> \n" +
       "<head><title>A Table Generating Example 2</title></head>\n" +
       "<body bgcolor=\"#fdf5e6\"> \n" +
       "<h1> A Table generating example! </h1>" + 
       "<form> \n" +
       "<p>Row Count: <input type=\"text\" name=\"rowCount\" value=\"" + rowParam + "\"> </p>\n" +
       "<p>Column Count: <input type=\"text\" name=\"columnCount\" value=\"\"> </p>\n" +
       "<input type=\"submit\" name=\"makeTable\" value=\"Make Table\"> <br>" +
       "</form> \n");
    boolean flag=true;
    rowParam = request.getParameter("rowCount");
    columnParam = request.getParameter("columnCount");
    if (!rowParam.trim().equals("") && !columnParam.trim().equals("") && !columnParam.trim().equals("0")) {
    	try {
    rowParamToInt = Integer.parseInt(rowParam);
    columnParamToInt = Integer.parseInt(columnParam);
    	}
    	catch(NumberFormatException e) {
         out.print("<p> ERROR!!! DO NOT PUT TEXT! ONLY NUMBERS!!! </p> \n");
         flag=false;
    	}
    	if (flag!=false) {
    out.println("<table border = \"2\">");
    for (int row=0 ; row <= rowParamToInt ; row++) {
    	for (int col=0 ; col < columnParamToInt ; col++) {
    		if (row==0) {
    			out.print("<th>" + " " + "Header" + " " +  Integer.toString(col+1) + "</th>");
    		}
    		else {
    		out.print("<td>"+ "row " + Integer.toString(row) + ", col" + Integer.toString(col+1) + "</td>");
    			     
    	}
    }
    	out.print("</tr>");
    }
    out.println("</table> </body> </html> \n");
  }
    }
    else {
    	out.println("<p> ERROR!!! DO NOT LEAVE TEHM NULL!!! </p> \n");
    }
  }
}
