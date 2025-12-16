package myPackage;

import java.io. * ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet. * ;
import jakarta.servlet.annotation. * ;
import jakarta.servlet.http. * ;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	@Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException,
  IOException {
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html");
    
    Boolean success = true;
    String sqlError = "";
    String redirectUrl = "";
    Connection connection = null;
    
    String itemDesc = request.getParameter("description");
    String itemFounder = request.getParameter("founder");
    String itemLoc = request.getParameter("location");
    String removeItem = request.getParameter("removeItem");
    
    if (itemDesc == null) {
      itemDesc = "";
    }
    if (itemFounder == null) {
      itemFounder = "";
    }
    if (itemLoc == null) {
      itemLoc = "";
    }
    try {
      Class.forName("org.postgresql.Driver");
      String dbURL = "jdbc:postgresql://localhost:5432/laf2874";
      String dbName = "postgres";
      String dbPass = "Terhs2004.";
      connection = DriverManager.getConnection(dbURL, dbName, dbPass);
    }
    catch(SQLException | ClassNotFoundException err) {
    }
    if (removeItem != null) {
      String idToRemove = request.getParameter("itemIdToRemove");
      int idToRemoveInInt = 0;
      try {
        idToRemoveInInt = Integer.parseInt(idToRemove);
      }
      catch(Exception err) {
        success = false;
      }
      String prepared = "DELETE FROM LOSTANDFOUND WHERE IID IN (?);";
      try {
        PreparedStatement prep = connection.prepareStatement(prepared);
        prep.setInt(1, idToRemoveInInt);
        prep.executeUpdate();
      }
      catch(SQLException err) {
        success = false;
      }
      if (!success) {
    	redirectUrl = "view_all.jsp?message=problem";
        response.sendRedirect(redirectUrl);
      }
      else {
    	redirectUrl = "view_all.jsp";
        response.sendRedirect(redirectUrl);
      }
    }
    else {
      String prepared = "INSERT INTO LOSTANDFOUND (DESCRIPTION, FINDER, LOCATIONFOUND) VALUES (?, ?, ?);";
      try {
        PreparedStatement prep = connection.prepareStatement(prepared);
        itemDesc = itemDesc.trim();
        itemFounder = itemFounder.trim();
        itemLoc = itemLoc.trim();
        prep.setString(1, itemDesc);
        prep.setString(2, itemFounder);
        prep.setString(3, itemLoc);
        prep.executeUpdate();
        success=true;
      }
      catch(SQLException err) {
        sqlError = err.getMessage();
        success = false;
      }
      if (!success) {
    	  try {
        redirectUrl = "insert.jsp?message=problem&got=" + java.net.URLEncoder.encode(sqlError, "UTF-8") + "&description=" + java.net.URLEncoder.encode(itemDesc, "UTF-8") + "&founder=" + java.net.URLEncoder.encode(itemFounder, "UTF-8") + "&location=" + java.net.URLEncoder.encode(itemLoc, "UTF-8");
        response.sendRedirect(redirectUrl);
    	  }
        catch (Exception err) {
        }
      }
      else {
        redirectUrl = "insert.jsp?message=complete";
        response.sendRedirect(redirectUrl);
      }
    }
    try {
        connection.close();
      }
      catch(SQLException err) {}
  }
}
