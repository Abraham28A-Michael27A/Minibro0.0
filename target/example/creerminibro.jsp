<%
    if(session.getAttribute("userref")==null){
    response.sendRedirect("index.jsp");
    }%>
<%-- 
    Document   : creeminibro
    Created on : Feb 11, 2018, 10:19:54 PM
    Author     : abraham
--%>
<html>
    <head>
        <title>MiniBro - MiniBro Creation</title>
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
        <div class="titre"><img src="img/minibro.png" /></div>
        <div class="row col-lg-10 col-lg-offset-1" style="background-color:#b1b1e9;" >
            <% if(request.getParameter("err")!=null){%>
            <div class="alert alert-danger">
                <strong>Minibro name already in use!</strong>
            </div>
            <% }%>
            <div class="row">
                <div class="row">
                    <form action="avatarcontrol.jsp" method="post">
                        <div class="col-lg-6 col-lg-offset-1" style="float:left;">
                            <div class="row">
                            The name of your MINIBRO<input type="text" name="nom" placeholder="Name"/>
                            <input class="form-control" type="hidden" name="user" value="<%=session.getAttribute("userref")%>"/>
                            </div>
                            <div class="row">
                            The taste of your MINIBRO:
                            <select class="form-control" name="gout">
                                <option value="1">Simple</option>
                                <option value="2">Good</option>
                                <option value="3">Bad</option>
                            </select>  
                            </div>
                            <div class="row">
                            The character of your MINIBRO:
                            <select class="form-control" name="caractere">
                                <option value="1">Sociable</option>
                                <option value="2">Lone wolf</option>
                                <option value="3">Passionate</option>
                                <option value="4">TryHard</option>
                                <option value="5">Lazy</option>
                                <option value="6">Playa</option>
                            </select>
                            </div>
                            <input type="hidden" name="message" value="0"/>
                            <input type="hidden" name="requete" value="0"/>
                            <input type="hidden" name="humeur" value="100"/>
                            <input type="hidden" name="attention" value="100"/>
                            <input type="hidden" name="pa" value="10"/>
                        </div>
                        <div class="col-lg-4 col-lg-offset-2" style="float:left;">
                                        Homme<input  type="radio" value="1" checked="true" name="img"/>
                                        <img style="width:100px;" src="img/superhappy1.png"/>
                                        <img style="width:100px;" src="img/happy1.png"/>
                                        <img style="width:100px;" src="img/angry1.png"/>
                        </div>
                        <div class="col-lg-4" style="float:left;">
                                        Femme<input type="radio" value="2" name="img"/>
                                        <img style="width:100px;" src="img/superhappy2.png"/>
                                        <img style="width:100px;" src="img/happy2.png"/>
                                        <img style="width:100px;" src="img/angry2.png"/>
                        </div>
                        <input class="btn btn-primary" type="submit" value="Create MINIBRO" />
                        
                    </form>
                        <a href="MenuAvatar.jsp"><button class="btn btn-primary btn-lg">Go Back</button></a>
                </div>
        </div>
            
        </div>
        
    </div>
    </body>
</html>
