<%-- 
    Document   : connecttoavatar
    Created on : Feb 11, 2018, 11:33:29 PM
    Author     : abraham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="functions.JsonReader"%>
<%
 
    
    String n = request.getParameter("n");
    session.setAttribute("minibroref",n);
    response.sendRedirect("GestionAvatar.jsp");
   
%>