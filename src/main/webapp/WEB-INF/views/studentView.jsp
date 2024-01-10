
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import = "com.student.bean.*" %>
 <%@ page import = "java.util.*"%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
    
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
    <body>	
    	<div>
    		<p>
    			<h1><c:out value="${headerName}" /></h1>
    		</p>
    	</div>
    	<div>
        	<table>
        		<tr>
        			<th>Name</th>
        			<th>Fees</th>
					<th>Location</th>
        		</tr>
        		<c:forEach items="${student}" var="student" >
        			<c:choose>  
	        			<c:when test = "${student.faculty == 'RAJU'}">
			        		<tr style="background-color:green;">
			        			<td>${student.name}</td>
			        			<td>${student.fees}</td>
								<td>${student.location}</td>
			        		</tr>
		        		</c:when>
		        		<c:otherwise>  
		        			<tr style="background-color:red;">
			        			<td>${student.name}</td>
			        			<td>${student.fees}</td>
								<td>${student.location}</td>
			        			
			        		</tr>
		        		</c:otherwise>  
		        	</c:choose>  
        		</c:forEach>
        		
        		<% 
        			List<Standard> standards = (List<Standard>)request.getAttribute("standards");
        			for(Standard stand : standards){
        			out.println("<tr>");
        			
        				out.println("<td>");
        					out.println(stand.getName());
        				out.println("</td>");
        				
        				out.println("<td>");
        					out.println(stand.getFees());
        				out.println("</td>");
						out.println("<td>");
        					out.println(stand.getLocation());
        				out.println("</td>");
        			out.println("</tr>");
        			}
        		
        		%>
        		
        	</table>
        </div>
    </body>
</html>
