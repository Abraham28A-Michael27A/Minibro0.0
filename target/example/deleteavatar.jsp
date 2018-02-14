<%-- 
    Document   : deleteavatar
    Created on : Feb 13, 2018, 1:07:48 PM
    Author     : abraham
--%>

<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="functions.JsonReader"%>
<%@page import="DAO.AvatarDAO"%>
<%
    if(session.getAttribute("userref")==null){
    response.sendRedirect("index.jsp");
     }
    String n= request.getParameter("n");
    AvatarDAO dao = new AvatarDAO();
    dao.deleteAvatar(n);
     response.sendRedirect("MenuAvatar.jsp");
    %>
