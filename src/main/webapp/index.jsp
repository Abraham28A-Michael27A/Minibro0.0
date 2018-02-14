<!DOCTYPE html>
<!--
author:Aldramech Micmic
-->
<html>
    <head>
        <title>MiniBro - Home</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Remplacer la ligne du dessus par celle-ci pour désativer le zoom -->
        <!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> -->
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Permet d\'afficher un icône dans la base d\'adresse -->
        <!-- <link rel="shortcut icon" href="image/favicon.png"> -->
        <!-- css Bootstrap -->
        <link href="css/style.css" rel="stylesheet">
        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
        <!-- HTML5 Shim et Respond.js permet à IE8 de supporter les éléments du HTML5 -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    
    
    <body class="background">
    <div class="maincontent container">       
        <div class="row"><div class="titre"><img src="img/minibro.png" /></div></div>        
        <div class="row-fluid" style="border-radius:25px;">
            <% if(request.getParameter("err")!=null){%>
            <div class="alert alert-danger">
                <strong>Username and Password don't match!</strong>
            </div>
            <% }%>
           <div class="desc">Welcome to MINIBRO, the game where you take care of up to 3 Mini Persons.
                                                        Your Goal is to keep your MiniBro's Stats as high as possible by selecting the actions he will do.</div>
            <div class="login text-center">
                <h1>LOGIN</h1>
                <hr>
                <form class="form-group" action="verificationlogin.jsp" method="post">                    
                        <input type="text" class="form-control" name="pseudo" placeholder="Your pseudonyme"/><br>
                        <input type="password" class="form-control" name="mdp" placeholder="Password"/><br>
                        <input type="submit" class="btn btn-primary" value="Se Connecter" /><br>
                        <a href="inscription.jsp">No Account? Sign in here!</a><br>
                        <a href="recuperation.html">Password forgotten?</a>                    
                </form>
            </div> 
        </div>
        
      <div class="row footer">Made by Los Hermanos</div>  
     </div>   
        
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    </body>
</html>