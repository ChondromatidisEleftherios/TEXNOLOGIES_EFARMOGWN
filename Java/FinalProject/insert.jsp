<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ΕΚΑΑ - ΕΙΣΑΓΩΓΗ ANTIKEIMENOY </title>
</head>
<body style ="background-color: #dddfed; text-align: center;">
<h1 style ="color: darkviolet;"> Εισαγωγή Αντικειμένων </h1>
<br>
<p> <strong> Παρακαλώ, εισάγετε τα ακόλουθα στοιχεία: </strong></p>
<% String prevDesc = request.getParameter("description");
   String prevFounder = request.getParameter("founder");
   String prevLoc = request.getParameter("location");
   if(prevDesc == null){
	   prevDesc = "";
   }
   if (prevFounder == null){
	   prevFounder = "";
   }
   if (prevLoc == null){
	   prevLoc = "";
   }
   %>
<form action = "Controller" method ="post">
<label for ="description"> Περιγραφή: </label>
<input type = "text" name ="description" id ="description" value = "<%= prevDesc %>"><br><br>
<label for ="founder"> Ευρών: </label>
<input type = "text" name ="founder" id ="founder" value ="<%= prevFounder %>"><br><br>
<label for ="location"> Τοποθεσία: </label>
<input type = "text" name ="location" id ="location" value = "<%= prevLoc %>"><br><br>
<input type = "submit" name ="location" id ="location" value ="Εισαγωγή!" style = "cursor:pointer;"><br> <br>
</form>
<% String mes = "";
	try{
	mes = request.getParameter("message");
	if (mes.equals("complete")){
		%> <h2 style = "color: green;"> Η εισαγωγή ολοκληρώθηκε! </h2>
		<%}
	}
	catch(Exception err){
		
	}
	try{
		mes = request.getParameter("message");
		if (mes.equals("problem")){
			%> <h2 style = "color: red;"> Πρόβλημα με την εισαγωγή, μήνυμα σφάλματος: </h2>
			<%}
		}
		catch(Exception err){
			
		}
	
%>

<% String sqlError = "";
	try{
		sqlError = request.getParameter("got");
	if (!sqlError.equals("")){
		%> <p style = "color: red;"> <%= sqlError %> </p><br>
		<%}
	}
	catch(Exception err){
		
	}
	
%>
<a href="index.jsp"> <strong> Επιστροφή στην αρχική σελίδα </strong></a>
<h2 style ="color: cyan;"> <i> Δημιουργήθηκε από τον Ελευθέριο Χονδροματίδη </i></h2>
</body>
</html>
