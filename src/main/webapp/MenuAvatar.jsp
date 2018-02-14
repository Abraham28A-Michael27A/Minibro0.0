<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="functions.JsonReader"%>
<% if(session.getAttribute("userref")==null){
    response.sendRedirect("index.jsp");
    }
    JSONArray jsn= JsonReader.readJsonArrayFromUrl("https://quiet-fjord-74456.herokuapp.com/getavatarbyuser.jsp?user="+session.getAttribute("userref"));
    String img="happy";
%>
<!DOCTYPE html>
<!--
author:Aldramech Micmic
-->
<html>
    <head>
        <title>MiniBro - Choose your MINIBRO</title>
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
            <div class="accountsettings"> <h2>Hello, <% out.print(session.getAttribute("userref")); %></h2> </div>
            <div class="choixavatar">
                <h2>Choose the MiniBro to use:</h2>
            <div ><hr>
                <% if(jsn.length()>0){
                for(int i=0;i<jsn.length();i++){
                    
                    double score = Double.parseDouble(String.valueOf(jsn.getJSONObject(i).get("Humeur")))+Double.parseDouble(String.valueOf(jsn.getJSONObject(i).get("Attention")));
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
                <div class="row listea">
                    <a href="connecttoavatar.jsp?n=<%=jsn.getJSONObject(i).get("Nom")%>">
                            <div class="col-lg-4"><img width="100px" src="img/<%=img+jsn.getJSONObject(i).get("Img")%>.png" /></div>
                        <div class="col-lg-4">
                            <div><span class="dur">Nom:</span><%=jsn.getJSONObject(i).get("Nom")%></div>
                        </div>
                        <div class="col-lg-4">
                            <div><span class="dur">Humeur:</span><%=jsn.getJSONObject(i).get("Humeur")%></div>                        
                            <div><span class="dur">Attention:</span><%=jsn.getJSONObject(i).get("Attention")%></div>
                        </div>
                        <div class="col-lg-4">
                            <div><span class="dur">PA:</span><%=jsn.getJSONObject(i).get("Pa")%></div>   
                            <span class="dur">score:</span><%=score%>
                        </div>
                        <div class="col-lg-4">
                            <a style="font-size:14px; color:red;" alt="Delete" href="deleteavatar.jsp?n=<%=jsn.getJSONObject(i).get("Nom")%>">Delete avatar</a>
                        </div>
                    </a>
                </div>
                        <hr>
                <%}}
                if(jsn.length()<3){ 
                %>
                <div class="newavatar">
                    <div class="labelcreate text-center"><a href="creerminibro.jsp" class="createminibro">Create a new MINIBRO</div>
                    <div class="clearfix"></div>
                    <br>
                </div>
                <%}
                %>
                
            </div>
            
        </div>
                
        </div>  
        <div class="row col-lg-offset-3"><a href="Disconnect.jsp"><button class="btn btn-primary btn-lg">Disconnect</button></a></div>
    </div>
        
        
    </body>
</html>