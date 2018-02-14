<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="functions.JsonReader"%>
<% 
if(session.getAttribute("userref")==null||session.getAttribute("minibroref")==null){
    response.sendRedirect("index.jsp");
    }
JSONObject jsn = JsonReader.readJsonFromUrl("https://quiet-fjord-74456.herokuapp.com/getavatarbynom.jsp?nom="+session.getAttribute("minibroref"));
JSONArray jsn2= JsonReader.readJsonArrayFromUrl("https://quiet-fjord-74456.herokuapp.com/getactiviteccaract.jsp?caractere="+String.valueOf(jsn.get("Caractere")));
JSONArray jsn3= JsonReader.readJsonArrayFromUrl("https://quiet-fjord-74456.herokuapp.com/getactiviteggout.jsp?gout="+String.valueOf(jsn.get("Gout")));
String img="happy";
double score = Double.parseDouble(String.valueOf(jsn.get("Humeur")))+Double.parseDouble(String.valueOf(jsn.get("Attention")));
if(score>=100){
    img="happy";
}
else if(score>300){
    img="superhappy";
}
else if(score<100){
    img="angry";
}
%>
<!DOCTYPE html>
<!--
author:Aldramech Micmic
-->
<html>
    <head>
        <title>MiniBro</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Remplacer la ligne du dessus par celle-ci pour d�sativer le zoom -->
        <!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> -->
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Permet d\'afficher un ic�ne dans la base d\'adresse -->
        <!-- <link rel="shortcut icon" href="image/favicon.png"> -->
        <!-- css Bootstrap -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- HTML5 Shim et Respond.js permet � IE8 de supporter les �l�ments du HTML5 -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="background">
    <div class="maincontent container">       
        <div class="row"><div class="titre"><img src="img/minibro.png" /></div></div>        
        <div class="row-fluid">
        </div>
        <div class="row">
            <% if(request.getParameter("pa")!=null){%>
            <div class="alert alert-danger">
                <strong>Not enough Action Points!</strong>
            </div>
            <% }%>
            <div class="pda"><img style="width:200px" src="img/<%=img+jsn.get("Img")%>.png" alt="image du minibro" /><div class="col-md-offset-2"><h3><%=jsn.get("Nom")%></h3></div></div>
            
            <div class="col-lg-4 col-lg-offset-1">
                <table class="table choix table-hover">                     
                    <tr>
                        <th>Humeur</th>
                    </tr>
                    <% for(int i=0;i<jsn3.length();i++){%>
                    <tr>
                        <td><a href="doactionhumeur.jsp?a=1"><%=jsn3.getJSONObject(i).get("Description")%></a></td>
                    </tr>
                    <% } %>
                    
                </table>
            </div>
            <div class="col-lg-4 col-lg-offset-1">
                <table class="table choix table-hover">                     
                    <tr>
                        <th>Attention</th>
                    </tr>
                    <% for(int i=0;i<jsn2.length();i++){%>
                    <tr>
                        <td><a href="doactionattention.jsp?a=1"><%=jsn2.getJSONObject(i).get("Description")%></a></td>
                    </tr>
                    <% } %>
                   
                </table>
            </div>
            <div class="statsbar">
                <table class="table table-responsive">
                    <tr>
                        <th>Humeur</th>
                        <th>Attention</th>
                        <th>Action Points</th>                        
                    </tr>
                    <tr>
                        <td><%=jsn.get("Humeur")%></td>
                        <td><%=jsn.get("Attention")%></td>
                        <td><%=jsn.get("Pa")%></td>                        
                    </tr>
                </table>
            </div>
                    <div class='messagesdiv'></div>
        </div>
        <div class="row col-lg-offset-3"><a href="MenuAvatar.jsp"><button class="btn btn-primary btn-lg">Go Back</button></a></div>
    </div>
    </body>
</html>