<%-- 
    Document   : doactionhumeur.jsp
    Created on : Feb 12, 2018, 11:12:33 AM
    Author     : abraham
--%>
<%@page import="java.lang.Math"%>
<%@page import="org.json.JSONObject"%>
<%@page import="functions.JsonReader"%>
<%
JSONObject jsn = JsonReader.readJsonFromUrl("https://quiet-fjord-74456.herokuapp.com/getavatarbynom.jsp?nom="+session.getAttribute("minibroref"));
double rng= Math.random();
int humeur=(int)jsn.get("Attention");
if((int)jsn.get("Pa")==0){
    response.sendRedirect("GestionAvatar.jsp?pa=0");
}
else{
int pa = (int)jsn.get("Pa") -1;
if(rng>=0.5){
    humeur=humeur - 5;
    response.sendRedirect("https://quiet-fjord-74456.herokuapp.com/updateAvatarA.jsp?nom="+session.getAttribute("minibroref")+"&attention="+humeur+"&pa="+pa+"&web=1");
}
else{
    humeur=humeur + 5;
    response.sendRedirect("https://quiet-fjord-74456.herokuapp.com/updateAvatarA.jsp?nom="+session.getAttribute("minibroref")+"&attention="+humeur+"&pa="+pa+"&web=1");
}}
%>
