<%-- 
    Document   : doinscription
    Created on : Feb 11, 2018, 6:37:45 PM
    Author     : abraham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="functions.JsonReader"%>
<%
    String nom=request.getParameter("nom");
    String prenom=request.getParameter("prenom");
    String mail=request.getParameter("mail");
    String pseudo=request.getParameter("pseudo");
    String mdp=request.getParameter("mdp");
    String q1=request.getParameter("q1");
    String r1=request.getParameter("r1");
    JSONArray jsn= JsonReader.readJsonArrayFromUrl("http://localhost:8084/minibrotest1/getuserbymail.jsp?mail="+mail);
    JSONArray jsn1= JsonReader.readJsonArrayFromUrl("http://localhost:8084/minibrotest1/getuserbypseudo.jsp?pseudo="+pseudo);
    if(jsn.length()>0 && jsn1.length()==0){
        response.sendRedirect("inscription.jsp?mail=mail");
    }
    else if(jsn.length()==0 && jsn1.length()>0){
        response.sendRedirect("inscription.jsp?pseudo=pseudo");    
    }
    else if(jsn.length()>0 && jsn1.length()>0){
        response.sendRedirect("inscription.jsp?all=all"); 
    }
    else{
        String url ="http://localhost:8084/minibrotest1/insertuser.jsp?nom=%s&prenom=%s&mail=%s&pseudo=%s&mdp=%s&q1=%s&r1=%s";
        url = String.format(url,nom,prenom,mail,pseudo,mdp,q1,r1);
        response.sendRedirect(url);
    }
%>
