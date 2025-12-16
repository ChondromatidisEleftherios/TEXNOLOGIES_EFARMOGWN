<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%@ page import= "java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ΕΚΑΑ - ΟΛΑ ΤΑ ΑΝΤΙΚΕΙΜΕΝΑ </title>
</head>
<body style ="background-color: #dddfed; text-align: center;">
<h1 style ="color: darkviolet;"> Εμφάνιση Αντικειμένων </h1>
<table border ="1" align="center" style ="float: center;">
<% 
	Connection connection = null;
	try{
	Class.forName("org.postgresql.Driver");
	String dbURL = "jdbc:postgresql://localhost:5432/laf2874";
	String dbName = "postgres";
	String dbPass ="Terhs2004.";
	connection = DriverManager.getConnection(dbURL, dbName, dbPass);
	}
	catch(SQLException err){
		
	}
	String query = "SELECT * FROM LOSTANDFOUND;";
	Statement st = connection.createStatement();
	try{
	ResultSet allItems = st.executeQuery(query);
	%> <tr> <th> Κωδικός </th> <th> Περιγραφή </th> <th> Ευρων </th> <th> Τοποθεσία </th></tr>
	<%
		while(allItems.next()){
			String itemId = allItems.getString(1);
			String itemDesc = allItems.getString(2);
			String itemFinder = allItems.getString(3);
			String itemLoc = allItems.getString(4);
		
		%> <tr> <td> <%= itemId %> </td> <td> <%= itemDesc %> </td> <td> <%= itemFinder %> </td> <td> <%= itemLoc %></td>
			<td><form action="Controller" method="post"><input type="submit" name="removeItem" value="Διαγραφή!" style = "cursor:pointer;">
			    <input type="hidden" name="itemIdToRemove" value= <%= itemId %>> </form></td></tr>
	<%}%>
	</table>
	
	<%}
	catch(Exception err){
} %>

<% try{
		String mes = request.getParameter("message");
		if (mes.equals("problem")){
			%> <h2 style = "color: red;"> Πρόβλημα με την Διαγραφή! </h2>
			<%}
		}
		catch(Exception err){
			
		}
		%>
<br>
<a href="index.jsp"> <strong> Επιστροφή στην αρχική σελίδα </strong></a> <br><br>
<h2 style ="color: cyan;"> <i> Δημιουργήθηκε από τον Ελευθέριο Χονδροματίδη </i></h2>
</body>
</html>
