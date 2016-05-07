<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Car Rental</title>

    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="/css/animate.css" rel="stylesheet">

    <!-- Google Font Lato -->
    <link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,400italic,700italic,900italic' rel='stylesheet'
          type='text/css'>
    <link rel="stylesheet" href="/css/font-awesome.min.css">

    <!-- Plugin Styles -->
    <link href="/css/datepicker.css" rel="stylesheet">

    <!-- Main Styles -->
    <link href="/css/styles.css" rel="stylesheet">
    <!-- Available main styles: styles-red.css, styles-green.css -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <link href="/css/ie8fix.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Lato:400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:900' rel='stylesheet' type='text/css'>
    <![endif]-->


    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/img/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/img/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/img/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/img/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="/img/ico/favicon.png">

</head>
<body>
<header data-spy="affix" data-offset-top="39" data-offset-bottom="0" class="large">

    <div class="row container box">
        <div class="col-md-5">
            <!-- Logo start -->
            <div class="brand">
                <h1><a class="scroll-to" href="/"><img class="img-responsive" src="/img/logo.gif" alt="Car|Rental"></a>
                </h1>
            </div>
            <!-- Logo end -->
        </div>

        <div class="col-md-7">
            <div class="pull-right">
                <div class="header-info pull-right">
                    <div class="contact pull-left">CONTACT: +7(960)-032-60-98</div>
                    <div class="language-switch pull-right">
                        <a href="/login"><input type="submit" class="submit pull-left" value="Sign in"
                                                name="submit"></a>

                        <a href="/registration"><input type="submit" class="submit pull-right" value="Sign up"
                                                       name="submit"></a>
                    </div>
                </div>
            </div>

            <div class="clearfix"></div>

            <!-- start navigation -->
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <!-- Toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand scroll-to" href="#top"><img class="img-responsive" src="/img/logo.gif"
                                                                           alt="Car|Rental"></a>
                    </div>
                    <!-- Collect the nav links, for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <!-- Nav-Links start -->
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#" class="scroll-to">Home</a></li>
                            <li><a href="#services" class="scroll-to">Services</a></li>
                            <li><a href="#vehicles" class="scroll-to">Vehicle Models</a></li>
                            <li><a href="#reviews" class="scroll-to">Reviews</a></li>
                            <li><a href="#locations" class="scroll-to">Locations</a></li>
                            <li><a href="#contact" class="scroll-to">Contact</a></li>
                        </ul>
                        <!-- Nav-Links end -->
                    </div>
                </div>
            </nav>
            <!-- end navigation -->
        </div>
    </div>

</header>
<div id="checkoutModal">
    <div class="client-body" style="margin-left: 210px;
    background-color: white;
    width: 900px">
        <div class="client-body-inner">
            <div class="container" style="width: 900px">
                <div class="row profile">
                    <div class="col-md-3">
                        <div class="profile-sidebar">
                            <!-- SIDEBAR USERPIC -->
                            <div class="profile-userpic">
                                <img src="/img/users/profile_img.png" class="img-responsive" alt="">
                            </div>
                            <!-- END SIDEBAR USERPIC -->
                            <!-- SIDEBAR USER TITLE -->
                            <!-- END SIDEBAR USER TITLE -->
                            <!-- SIDEBAR BUTTONS -->
                            <!-- END SIDEBAR BUTTONS -->
                            <!-- SIDEBAR MENU -->
                            <div class="profile-usermenu" style="font-size: 15px">
                                <ul class="nav">
                                    <li class="active">
                                        <a href="/client">
                                            <i class="glyphicon glyphicon-home"></i>
                                            Overview </a>
                                    </li>
                                    <li>
                                        <a href="/client/rides">
                                            <i class="glyphicon glyphicon-user"></i>
                                            Rides </a>
                                    </li>
                                    <li>
                                        <a href="#" target="_blank">
                                            <i class="glyphicon glyphicon-ok"></i>
                                            Tasks </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="glyphicon glyphicon-flag"></i>
                                            Help </a>
                                    </li>
                                </ul>
                            </div>
                            <!-- END MENU -->
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="profile-content" style="font-size: 13px">
                            <table class="table table-bordered" cellspacing="10px" border="1" width="">
                            <#list list as order>
                                <tbody>
                                <tr>
                                    <td>${order.car.model}</td>
                                    <td>${order.pickUpLoc}</td>
                                    <td>${order.pickUpDate}</td>
                                    <td>${order.pickUpTime}</td>
                                <td>${order.dropOffLoc}</td>
                                <td>${order.dropOffDate}</td>
                                <td>${order.dropOffTime}</td>
                                <tr>
                                </tbody>
                            </#list>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <ul class="footer-nav">
                    <li><a class="scroll-to" href="#top">Home</a></li>
                    <li><a class="scroll-to" href="#services">Service</a></li>
                    <li><a class="scroll-to" href="#vehicles">Vehicle Models</a></li>
                    <li><a class="scroll-to" href="#reviews">Reviews</a></li>
                    <li><a class="scroll-to" href="#locations">Locations</a></li>
                    <li><a class="scroll-to" href="#contact">Contact</a></li>
                </ul>
                <div class="clearfix"></div>
                <p class="copyright">©2014 Themeinjection, All Rights Reserved</p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>