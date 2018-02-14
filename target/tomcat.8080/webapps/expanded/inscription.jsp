<!DOCTYPE html>
<!--
author:Aldramech Micmic
-->
<html>
    <head>
        <title>MiniBro - Inscription</title>
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
        <link href="css/bootstrap.css" rel="stylesheet">
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
            <div class="row-fluid inscription">
                <% if(request.getParameter("mail")!=null){%>
                    <div class="alert alert-danger">
                        <strong>Email already assigned!</strong>
                    </div>
                <% }
                if(request.getParameter("pseudo")!=null){%>
                     <div class="alert alert-danger">
                        <strong>Username already in use!</strong>
                    </div>   
                    <%}if(request.getParameter("all")!=null){%>
                     <div class="alert alert-danger">
                        <strong>Username and Email already in use!</strong>
                    </div>   
                    <%}if(request.getParameter("err")!=null){%>
                     <div class="alert alert-success">
                        <strong>New User added!</strong>
                    </div>   
                    <%}%>
                <div class="login text-center">
                    <h1>INSCRIPTION</h1>
                    <hr>
                    <form action="doinscription.jsp" method="post">
                        <input type="text" name="nom" placeholder="Name"/>
                        <input type="text" name="prenom" placeholder="Firstname"/>
                        <input type="email" name="mail" placeholder="Email"/>
                        <input type="text" name="pseudo" placeholder="Username"/>
                        <input type="password" name="mdp" placeholder="Password"/>
                        <input type="password"  placeholder="Confirm Password"/><br>
                        Choose your secret question:
                        <select name="q1">
                            <option value="1">How do you call your hand?</option>
                            <option value="2">Who is your first friend?</option>
                            <option value="3">How do you call your dog?</option>
                            <option value="4">How do you call your cat?</option>
                            <option value="5">How are you today?</option>
                        </select>
                        <input type="text" name="r1" placeholder="The Answer"/> <br>               
                        <input class="btn btn-primary" type="submit" value="Sign In" />
            </form>
                </div>
            </div>
        <div class="row col-lg-offset-3"><a href="index.jsp"><button class="btn btn-primary btn-lg">Go Back</button></a></div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    </body>
</html>