<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Car Rental</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="css/animate.css" rel="stylesheet">

    <!-- Google Font Lato -->
    <link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Plugin Styles -->
    <link href="css/datepicker.css" rel="stylesheet">

    <!-- Main Styles -->
    <link href="css/styles.css" rel="stylesheet">
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="img/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="img/ico/favicon2.png">

</head>
<body id="top" data-spy="scroll" data-target=".navbar" data-offset="260">

<!-- Header start -->
<header data-spy="affix" data-offset-top="39" data-offset-bottom="0" class="large">

    <div class="row container box">
        <div class="col-md-5">
            <!-- Logo start -->
            <div class="brand">
                <h1><a class="scroll-to" href="/"><img class="img-responsive"  src="img/logo.gif" alt="Car|Rental"></a></h1>
            </div>
            <!-- Logo end -->
        </div>

        <div class="col-md-7">
            <div class="pull-right">
                <div class="header-info pull-right">
                    <div class="contact pull-left">CONTACT: +7(960)-032-60-98</div>
                    <div class="language-switch pull-right">
                        <a href="/login"><input type="submit" class="submit pull-left" value="Sign in" name="submit"></a>

                        <a href="/registration"><input type="submit" class="submit pull-right" value="Sign up" name="submit"></a>
                    </div>
                </div>
            </div>

            <div class="clearfix"></div>

            <!-- start navigation -->
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <!-- Toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand scroll-to" href="#top"><img class="img-responsive"  src="img/logo.gif" alt="Car|Rental"></a>
                    </div>
                    <!-- Collect the nav links, for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <!-- Nav-Links start -->
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="/client" class="scroll-to">Home</a></li>
                            <li><a href="#services" class="scroll-to">Services</a></li>
                            <li><a href="/cars" class="scroll-to">Vehicle Models</a></li>
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
<!-- Header end -->



<!-- Teaser start -->
<section id="teaser">
    <div class="container" style="margin-left: 60px">
        <div class="row">
            <div class="col-md-7 col-xs-12 pull-right">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Wrapper for slides start -->
                    <div class="carousel-inner">

                        <div class="item active">
                            <h1 class="title">Get 15% off your rental
                                <span class="subtitle">Plan your trip now</span></h1>
                            <div class="car-img">
                                <img src="img/car2.png" class="img-responsive" alt="car1">
                            </div>
                        </div>
                    </div>
                    <!-- Wrapper for slides end -->

                    <!-- Slider Controls start -->
                    <!-- Slider Controls end -->
                </div>
            </div>
            <div class="col-md-5 col-xs-12 pull-left">
                <div class="reservation-form-shadow">
                    <@sf.form action="/order" method="POST" name="car-select" id="car-select" modelAttribute="orderform">
                        <div class="alert alert-danger hidden" id="car-select-form-msg">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <strong>Note:</strong> All fields required!
                        </div>

                        <!-- Car select start -->
                        <div class="styled-select-car">
                            <@sf.select path="car_id" name="car-select" id="car-select">
                                <option>Select your car type</option>
                                <#list cars as car>
                                <@sf.option value="${car.id}">${car.model}</@sf.option>
                                </#list>
                            </@sf.select>
                        </div>
                        <!-- Car select end -->

                        <!-- Pick-up location start -->
                        <div class="location">
                            <div class="input-group pick-up">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-map-marker"></span> Pick-up</span>
                                <@sf.input path="pickUpLoc" type="text" name="pick-up-location" id="pick-up-location" class="form-control autocomplete-location" placeholder="Enter a City or Airport"/>
                            </div>
                            <!-- Pick-up location end -->

                            <a class="different-drop-off" href="#">Need a different drop-off location?</a>

                            <!-- Drop-off location start -->
                            <div class="input-group drop-off">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-map-marker"></span> Drop-off</span>
                                <@sf.input path="dropOffLoc" type="text" name="drop-off-location" id="drop-off-location" class="form-control autocomplete-location" placeholder="Enter a City or Airport"/>
                            </div>
                        </div>
                        <!-- Drop-off location end -->

                        <!-- Pick-up date/time start -->
                        <div class="datetime pick-up">
                            <div class="date pull-left">
                                <div class="input-group">
                                    <span class="input-group-addon pixelfix"><span class="glyphicon glyphicon-calendar"></span> Pick-up</span>
                                    <@sf.input path="pickUpDate" type="text" name="pick-up-date" id="pick-up-date" class="form-control datepicker" placeholder="mm-dd-yyyy"/>
                                </div>
                            </div>
                            <div class="time pull-right">
                                <div class="styled-select-time">
                                    <@sf.select path="pickUpTime" name="pick-up-time" id="pick-up-time">
                                        <@sf.option value="00:00">00:00</@sf.option>
                                        <@sf.option value="00:30">00:30</@sf.option>
                                        <@sf.option value="01:00">01:00</@sf.option>
                                        <@sf.option value="01:30">01:30</@sf.option>
                                        <@sf.option value="02:00">02:00</@sf.option>
                                        <@sf.option value="02:30">02:30</@sf.option>
                                        <@sf.option value="03:00">03:00 </@sf.option>
                                        <@sf.option value="03:30">03:30 </@sf.option>
                                        <@sf.option value="04:00">04:00 </@sf.option>
                                        <@sf.option value="04:30">04:30 </@sf.option>
                                        <@sf.option value="05:00">05:00 </@sf.option>
                                        <@sf.option value="05:30">05:30 </@sf.option>
                                        <@sf.option value="06:00">06:00 </@sf.option>
                                        <@sf.option value="06:30">06:30 </@sf.option>
                                        <@sf.option value="07:00">07:00 </@sf.option>
                                        <@sf.option value="07:30">07:30 </@sf.option>
                                        <@sf.option value="08:00">08:00 </@sf.option>
                                        <@sf.option value="08:30">08:30 </@sf.option>
                                        <@sf.option value="09:00">09:00 </@sf.option>
                                        <@sf.option value="09:30">09:30 </@sf.option>
                                        <@sf.option value="10:00">10:00 </@sf.option>
                                        <@sf.option value="10:30">10:30 </@sf.option>
                                        <@sf.option value="11:00">11:00 </@sf.option>
                                        <@sf.option value="11:30">11:30 </@sf.option>
                                        <@sf.option value="12:00">12:00 </@sf.option>
                                        <@sf.option value="12:30">12:30 </@sf.option>
                                        <@sf.option value="13:00">13:00 </@sf.option>
                                        <@sf.option value="13:30">13:30 </@sf.option>
                                        <@sf.option value="14:00">14:00 </@sf.option>
                                        <@sf.option value="14:30">14:30 </@sf.option>
                                        <@sf.option value="15:00">15:00 </@sf.option>
                                        <@sf.option value="15:30">15:30 </@sf.option>
                                        <@sf.option value="16:00">16:00 </@sf.option>
                                        <@sf.option value="16:30">16:30 </@sf.option>
                                        <@sf.option value="17:00">17:00 </@sf.option>
                                        <@sf.option value="17:30">17:30 </@sf.option>
                                        <@sf.option value="18:00">18:00 </@sf.option>
                                        <@sf.option value="18:30">18:30 </@sf.option>
                                        <@sf.option value="19:00">19:00 </@sf.option>
                                        <@sf.option value="19:30">19:30 </@sf.option>
                                        <@sf.option value="20:00">20:00 </@sf.option>
                                        <@sf.option value="20:30">20:30 </@sf.option>
                                        <@sf.option value="21:00">21:00 </@sf.option>
                                        <@sf.option value="21:30">21:30 </@sf.option>
                                        <@sf.option value="22:00">22:00 </@sf.option>
                                        <@sf.option value="22:30">22:30 </@sf.option>
                                        <@sf.option value="23:00">23:00 </@sf.option>
                                        <@sf.option value="23:30">23:30 </@sf.option>
                                    </@sf.select>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <!-- Pick-up date/time end -->

                        <!-- Drop-off date/time start -->
                        <div class="datetime drop-off">
                            <div class="date pull-left">
                                <div class="input-group">
                                    <span class="input-group-addon pixelfix"><span class="glyphicon glyphicon-calendar"></span> Drop-off</span>
                                    <@sf.input path="dropOffDate" type="text" name="drop-off-date" id="drop-off-date" class="form-control datepicker" placeholder="mm-dd-yyyy"/>
                                </div>
                            </div>
                            <div class="time pull-right">
                                <div class="styled-select-time">
                                    <@sf.select path="dropOffTime" name="drop-off-time" id="drop-off-time">
                                        <@sf.option value="00:00">00:00</@sf.option>
                                        <@sf.option value="00:30">00:30</@sf.option>
                                        <@sf.option value="01:00">01:00</@sf.option>
                                        <@sf.option value="01:30">01:30</@sf.option>
                                        <@sf.option value="02:00">02:00</@sf.option>
                                        <@sf.option value="02:30">02:30</@sf.option>
                                        <@sf.option value="03:00">03:00 </@sf.option>
                                        <@sf.option value="03:30">03:30 </@sf.option>
                                        <@sf.option value="04:00">04:00 </@sf.option>
                                        <@sf.option value="04:30">04:30 </@sf.option>
                                        <@sf.option value="05:00">05:00 </@sf.option>
                                        <@sf.option value="05:30">05:30 </@sf.option>
                                        <@sf.option value="06:00">06:00 </@sf.option>
                                        <@sf.option value="06:30">06:30 </@sf.option>
                                        <@sf.option value="07:00">07:00 </@sf.option>
                                        <@sf.option value="07:30">07:30 </@sf.option>
                                        <@sf.option value="08:00">08:00 </@sf.option>
                                        <@sf.option value="08:30">08:30 </@sf.option>
                                        <@sf.option value="09:00">09:00 </@sf.option>
                                        <@sf.option value="09:30">09:30 </@sf.option>
                                        <@sf.option value="10:00">10:00 </@sf.option>
                                        <@sf.option value="10:30">10:30 </@sf.option>
                                        <@sf.option value="11:00">11:00 </@sf.option>
                                        <@sf.option value="11:30">11:30 </@sf.option>
                                        <@sf.option value="12:00">12:00 </@sf.option>
                                        <@sf.option value="12:30">12:30 </@sf.option>
                                        <@sf.option value="13:00">13:00 </@sf.option>
                                        <@sf.option value="13:30">13:30 </@sf.option>
                                        <@sf.option value="14:00">14:00 </@sf.option>
                                        <@sf.option value="14:30">14:30 </@sf.option>
                                        <@sf.option value="15:00">15:00 </@sf.option>
                                        <@sf.option value="15:30">15:30 </@sf.option>
                                        <@sf.option value="16:00">16:00 </@sf.option>
                                        <@sf.option value="16:30">16:30 </@sf.option>
                                        <@sf.option value="17:00">17:00 </@sf.option>
                                        <@sf.option value="17:30">17:30 </@sf.option>
                                        <@sf.option value="18:00">18:00 </@sf.option>
                                        <@sf.option value="18:30">18:30 </@sf.option>
                                        <@sf.option value="19:00">19:00 </@sf.option>
                                        <@sf.option value="19:30">19:30 </@sf.option>
                                        <@sf.option value="20:00">20:00 </@sf.option>
                                        <@sf.option value="20:30">20:30 </@sf.option>
                                        <@sf.option value="21:00">21:00 </@sf.option>
                                        <@sf.option value="21:30">21:30 </@sf.option>
                                        <@sf.option value="22:00">22:00 </@sf.option>
                                        <@sf.option value="22:30">22:30 </@sf.option>
                                        <@sf.option value="23:00">23:00 </@sf.option>
                                        <@sf.option value="23:30">23:30 </@sf.option>
                                    </@sf.select>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <!-- Drop-off date/time end -->

                        <input type="submit" class="submit" name="submit" value="continue car reservation"/>
                    </@sf.form>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="arrow-down"></div>
<!-- Teaser end -->


<!-- Contact start -->
<section id="contact" class="container wow bounceInUp" data-wow-offset="50" style="margin-left: 60px">
    <div class="row">
        <div class="col-md-12">
            <h2>Contact Us</h2>
        </div>
        <div class="col-md-4 col-xs-12 pull-right">
            <h4 class="contact-box-title">Customer Center</h4>
            <div class="contact-box">
                <img src="img/contact-box-img1.jpg" alt="contact-img">
                <div class="contact-box-name">Sarah Connor</div>
                <div class="contact-box-phon"><span class="highlight">Phone:</span> 666-999-888</div>
                <div class="contact-box-email"><span class="highlight">Email:</span> connor@example.com</div>
                <div class="clearfix"></div>
            </div>
            <div class="contact-box-border">&nbsp;</div>

            <div class="contact-box-divider">&nbsp;</div>

            <h4 class="contact-box-title">Change or Cancel Reservation</h4>
            <div class="contact-box">
                <img src="img/contact-box-img2.jpg" alt="contact-img">
                <div class="contact-box-name">Mike Smith</div>
                <div class="contact-box-phon"><span class="highlight">Phone:</span> 666-999-888</div>
                <div class="contact-box-email"><span class="highlight">Email:</span> connor@example.com</div>
                <div class="clearfix"></div>
            </div>
            <div class="contact-box-border">&nbsp;</div>

            <div class="contact-box">
                <img src="img/contact-box-img3.jpg" alt="contact-img">
                <div class="contact-box-name">Jane Doe</div>
                <div class="contact-box-phon"><span class="highlight">Phone:</span> 666-999-888</div>
                <div class="contact-box-email"><span class="highlight">Email:</span> connor@example.com</div>
                <div class="clearfix"></div>
            </div>
            <div class="contact-box-border">&nbsp;</div>
        </div>
        <div class="col-md-8 col-xs-12 pull-left">
            <p class="contact-info">You have any questions or need additional information? <br>
                <span class="address"><span class="highlight">Address:</span>  Car|Rental / 3861 Sepulveda Blvd. / Culver City, CA 90230</span></p>
            <form action="#" method="post" id="contact-form" name="contact-form">

                <div class="alert hidden" id="contact-form-msg"></div>

                <div class="form-group">
                    <input type="text" class="form-control first-name text-field" name="first-name" placeholder="First Name:">
                    <input type="text" class="form-control last-name text-field" name="last-name" placeholder="Last Name:">
                    <div class="clearfix"></div>
                </div>

                <div class="form-group">
                    <input type="tel" class="form-control telephone text-field" name="telephone" placeholder="Telephone:">
                </div>

                <div class="form-group">
                    <input type="email" class="form-control email text-field" name="email" placeholder="Email:">
                </div>

                <div class="form-group">
                    <textarea class="form-control message" name="message" placeholder="Message:"></textarea>
                </div>

                <input type="submit" class="btn submit-message" name="submit-message" value="Submit Message">


            </form>
        </div>

    </div>
</section>
<!-- Contact end -->


<a href="#" class="scrollup">ScrollUp</a>


<!-- Footer start -->
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
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->

<!--Start Style Switcher (remove befor uploaded to Themeforest)-->
<script src="js/style-switcher.js"></script>
<!--End Style Switcher (remove befor uploaded to Themeforest)-->

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.autocomplete.min.js"></script>
<script src="js/jquery.placeholder.js"></script>
<script src="js/locations-autocomplete.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script src="js/gmap3.min.js"></script>


<!--[if !(gte IE 8)]><!-->
<script src="js/wow.min.js"></script>
<script>
    // Initialize WOW
    //-------------------------------------------------------------
    new WOW({mobile: false}).init();
</script>
<!--<![endif]-->

<script src="js/custom.js"></script>



</body>
</html>