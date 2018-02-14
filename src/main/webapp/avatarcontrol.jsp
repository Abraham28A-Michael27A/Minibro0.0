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
    String user=request.getParameter("user");
    String gout=request.getParameter("gout");
    String caractere=request.getParameter("caractere");
    String message=request.getParameter("message");
    String requete=request.getParameter("requete");
    Double humeur = Double.parseDouble(request.getParameter("humeur"));
    Double attention = Double.parseDouble(request.getParameter("attention"));
    Double pa = Double.parseDouble(request.getParameter("pa"));
    Double img = Double.parseDouble(request.getParameter("img"));
    JSONArray jsn= JsonReader.readJsonArrayFromUrl("https://quiet-fjord-74456.herokuapp.com/getavatarnom.jsp?nom="+nom);
    if(jsn.length()>0){
        response.sendRedirect("creerminibro.jsp?err=1");
    }
    else{
        String url ="https://quiet-fjord-74456.herokuapp.com/insertavatarfo.jsp?nom=%s&user=%s&gout=%s&caractere=%s&message=%s&requete=%s&humeur=%s&attention=%s&pa=%s&img=%s&web=1";
         url = String.format(url,nom,user,gout,caractere,message,requete,humeur,attention,pa,img);
        response.sendRedirect(url);
    }
%>

