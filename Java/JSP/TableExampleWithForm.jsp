<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A Table Generating Example </title>
</head>
<body style ="background-color: #fdf5e6";>
<h1> A Table Generating Example </h1>
<%  
	boolean valid=true;
	String rowParam = request.getParameter("rowCount");
    String columnParam = request.getParameter("columnCount");
    int rowParamToInt=0;
    int columnParamToInt=0;
    if (rowParam == null){
    	rowParam = "";
    }
    if (columnParam == null){
    	columnParam ="";
    } %>
    
    <form>
	Row Count: <input type="text" name="rowCount" value=<%=rowParam %>><br><br>
	Column Count: <input type="text" name="columnCount" value=<%=columnParam %>><br><br>
	<input type="submit" name="makeTable" value="Make Table"> <br><br>
    <%
    if (!rowParam.trim().equals("") && !columnParam.trim().equals("")) {
    try{
    rowParamToInt = Integer.parseInt(rowParam);
    columnParamToInt = Integer.parseInt(columnParam);
    }
    catch(Exception err){
 	valid = false;
    }}
    %>
    <%if (valid && rowParamToInt >= 0 && columnParamToInt >= 1) {%>
    <table border = "2">
    <%for (int row=0 ; row <= rowParamToInt ; row++) { %>
    <tr>
    	<% for (int col=0 ; col < columnParamToInt ; col++) {
    		if (row==0) {
    			%> <th> Header <%=col+1%> </th>
    		<%}
    		else {%>
    		<td> row <%=row%> col <%=col+1%>  </td>
    			     
    	<%}
    }%>
    	</tr>
    <%}
    %></table>
  <%}
    else {
    	valid=false;
   } 
      if (!valid){%>
    	<p style ="color: #6042f5;"> <strong><u>ERROR!!! No valid values inserted!!! </u> </strong></p>
    <%}
    %>

</form>
</body>
</html>
