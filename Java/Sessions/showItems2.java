package coreservlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.util.*;

@WebServlet("/show-items2")
public class ShowItems2 extends HttpServlet {
  @Override
  public void doPost (HttpServletRequest request,
                      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String buttonParam = request.getParameter("ClearPage");
    if (buttonParam != null) {
  	  session.invalidate(); 
  	  session = request.getSession();
    }
    synchronized(session) {
      @SuppressWarnings("unchecked")
      List<String> previousItems =
        (List<String>)session.getAttribute("previousItems");
      if (previousItems == null) {
        previousItems = new ArrayList<String>();
      }
      String newItem = request.getParameter("newItem");
      if ((newItem != null) &&
          (!newItem.trim().equals(""))) {
        previousItems.add(newItem);
      }
      session.setAttribute("previousItems", previousItems);
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Items Purchased";
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                  "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                  "<H1>" + title + "</H1>");
      if (previousItems.size() == 0) {
        out.println("<I>No items</I>");
      } else {
        out.println("<UL>");
        for(String item: previousItems) {
          out.println("  <LI>" + item);
        }
        out.println("</UL>");
      }
      out.println("<a href=\"order-form2.html\">" + "Back To Orders!" + "</a>");
      out.println("<form action = \"show-items2\" method=\"post\"> <input type=\"submit\" value=\"Clear\" name=\"ClearPage\"> </form>");
      out.println("</BODY></HTML>");
    }
  }
}
