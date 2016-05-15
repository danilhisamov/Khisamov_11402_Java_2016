<!DOCTYPE html>
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
    <link href="css/ie8fix.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Lato:400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:900' rel='stylesheet' type='text/css'>
    <![endif]-->


    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/img/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/img/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/img/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/img/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="/img/ico/favicon2.png">

</head>
<body id="top" data-spy="scroll" data-target=".navbar" data-offset="260">

<!-- Header start -->
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
                            <li class="active"><a href="#" class="scroll-to">Home</a></li>
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

<div class="col-md-12" style="background-color: #ffbf00;
margin-top: 30px;
font-size: 36px;
  font-weight: 900;
  background: -webkit-linear-gradient(top, #ffbf00 0%, #fcd45f 50%, #ffbf00 100%);
  background: linear-gradient(to bottom, #ffbf00 0%, #fcd45f 50%, #ffbf00 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='@mainColor', endColorstr='@mainColor', GradientType=0);">
    <h2 class="title wow fadeInDown" data-wow-offset="200">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vehicle Models - <span class="subtitle">Our rental fleet at a glance</span>
    </h2>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="styled-choose" style="margin-left: 140px">
    <select name="ch" id="ch" style="border: none;
    font-size: 16px;
    border-radius: 5px ;
    width: 10%;
    background-image: none;
    background: #dbdbdb;
    -webkit-appearance: none;
    padding: 9px 10px;
    height: 39px;">
        <option value="all">All</option>
        <option value="active">Active</option>
        <option value="not_active">Not Active</option>
    </select>

    <input type="submit" class="btn btn-primary btn-yellow" style=" border: none;
    background-color: yellow;
    color: #716D6D;
    height: 39px;
    margin-bottom: 5px;
" value="Show" onclick="getCarsByStatus()"/>
</div>
<div id="car_res"> <!-- Vehicle nav end -->
<#if cars??>
    <#list cars as car>
        <section id="vehicles" class="container" style="margin-left: 100px">
            <div class="row">
                <!-- Vehicle nav start -->

                <!-- Vehicle 1 data start -->
                <div class="vehicle-data" id="vehicle" style="display: ">
                    <div class="col-md-6 wow fadeIn" data-wow-offset="100">
                        <div class="vehicle-img">
                            <img class="img-responsive" id="carPhoto" src="${car.photoPath}" alt="Vehicle">
                        </div>
                    </div>
                    <div class="col-md-3 wow fadeInUp" data-wow-offset="200">
                        <div class="vehicle-price" id="car-price">
                            <div id="price" style="float: left">${car.price}</div>
                            <span class="info">&nbsp;rent per day</span></div>
                        <table class="table vehicle-features">
                            <tr>
                                <td>Model</td>
                                <td id="model">${car.model}</td>
                            </tr>
                            <tr>
                                <td>Doors</td>
                                <td id="doors">${car.doors}</td>
                            </tr>
                            <tr>
                                <td>Seats</td>
                                <td id="seats">${car.seats}</td>
                            </tr>
                            <tr>
                                <td>Luggage</td>
                                <td id="luggage">${car.luggage}</td>
                            </tr>
                            <tr>
                                <td>Transmission</td>
                                <td id="transmission">${car.transmission}</td>
                            </tr>
                            <tr>
                                <td>Air conditioning</td>
                                <td id="air_cond">${car.air_cond}</td>
                            </tr>
                            <tr>
                                <td>Status</td>
                                <td id="status">${car.status}</td>
                            </tr>
                        </table>
                        <a href="/admin/car_change/${car.id}">
                            <input type="button" name="admin_add_car_button" value="Change Description">
                        </a>
                    </div>
                </div>
            </div>
        </section>
    </#list>
</#if>
</div>
<a href="/admin/car_registration">
    <input type="button" name="admin_add_car_button" style=" border: none;
    background-color: yellow;
    color: #716D6D;
    border-radius: 5px;
    height: 39px;
    margin-left: 900px;
        margin-top: 50px;
    margin-bottom: 5px;" value="Add Car">
</a>

<!-- Vehicles end -->
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
<!-- Footer end -->


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<#--<script src="js/jquery-1.11.0.min.js"></script>-->
<!-- Include all compiled plugins (below), or include individual files as needed -->

<!--Start Style Switcher (remove befor uploaded to Themeforest)-->
<script src="/js/style-switcher.js"></script>
<!--End Style Switcher (remove befor uploaded to Themeforest)-->
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.autocomplete.min.js"></script>
<script src="/js/jquery.placeholder.js"></script>
<script src="/js/locations-autocomplete.js"></script>
<script src="/js/bootstrap-datepicker.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script src="/js/gmap3.min.js"></script>


<!--[if !(gte IE 8)]><!-->
<script src="/js/wow.min.js"></script>
<script>
    // Initialize WOW
    //-------------------------------------------------------------
    new WOW({mobile: false}).init();
</script>
<!--<![endif]-->

<script src="/js/custom.js"></script>

</body>
</html>