<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

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
                                                name="submit"/></a>

                        <a href="/registration"><input type="submit" class="submit pull-right" value="Sign up"
                                                       name="submit"/></a>
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
    <div class="modal-content">
    <@sf.form action="/admin/car_change/${car.id}" method="post" id="checkout-form" name="checkout-form" modelAttribute="regform">
        <!-- Modal body start -->
        <div class="modal-body">
            <!-- Checkout Personal Info start -->
            <div class="checkout-personal-info">
                <div class="alert hidden" id="checkout-form-msg">
                    test
                </div>
                <h3>CAR INFORMATION</h3>
                <div class="form-group left">
                    <label for="model">Model:</label>
                    <@sf.input path="model" type="text" class="form-control" name="model" id="model" value="${car.model}"/>
                    <@sf.errors path="model" class = "form-control alert alert-warning text-center"/>
                </div>
                <div class="form-group right">
                    <label for="luggage">Luggage :</label>
                    <@sf.input path="luggage" type="text" class="form-control" name="luggage" id="luggage" value="${car.luggage}"/>
                    <@sf.errors path="luggage" class = "form-control alert alert-warning text-center"/>
                </div>
                <div class="form-group left">
                    <label for="doors">Doors:</label>
                    <@sf.input path="doors" type="text" class="form-control" name="doors" id="doors" value="${car.doors}"/>
                    <@sf.errors path="doors" class = "form-control alert alert-warning text-center"/>
                </div>
                <div class="form-group right">
                    <label for="seats">Seats:</label>
                    <@sf.input path="seats" type="text" class="form-control" name="seats" id="seats" value="${car.seats}"/>
                    <@sf.errors path="seats" class = "form-control alert alert-warning text-center"/>
                </div>
                <div class="form-group left">
                    <label for="air_cond">Air conditioning:</label>
                    <div class="styled-select-age">
                        <@sf.select path="air_cond" name="air_cond" id="air_cond" value="${car.air_cond}">
                            <@sf.option value="Yes">Yes</@sf.option>
                            <@sf.option value="No">No</@sf.option>
                        </@sf.select>
                        <@sf.errors path="air_cond" class = "form-control alert alert-warning text-center"/>
                    </div>
                </div>
                <div class="form-group right age">
                    <label for="transmission">Transmission:</label>
                    <div class="styled-select-age">
                        <@sf.select path="transmission" name="transmission" id="transmission" value="${car.transmission}">
                            <@sf.option value="Automatic">Automatic</@sf.option>
                            <@sf.option value="Mechanic">Mechanic</@sf.option>
                        </@sf.select>
                        <@sf.errors path="transmission" class = "form-control alert alert-warning text-center"/>
                    </div>
                </div>
                <div class="form-group left">
                    <label for="price">Price:</label>
                    <@sf.input path="price" type="text" name="price" id="price"  value="${car.price}"/>
                    <@sf.errors path="price" class = "form-control alert alert-warning text-center"/>
                </div>
                <div class="form-group right">
                    <label for="price">Status:</label>
                    <@sf.select path="status" name="status" id="status" value="${car.status}">
                      <@sf.option value="active">Active</@sf.option>
                    <@sf.option value"not_active">Not Active</@sf.option>
                    </@sf.select>
                    <@sf.errors path="status" class = "form-control alert alert-warning text-center"/>
                </div>
                <div class="clearfix"></div>
            </div>
            <!-- Checkout Personal Info end -->

            <!-- Checkout Address Info start -
            <!-- Checkout Address Info end -->
        </div>
        <!-- Modal body end -->

        <!-- Modal footer start -->
        <div class="modal-footer">
                  <span class="btn-border btn-yellow">
                    <button type="submit" class="btn btn-primary btn-yellow">Done</button>
                  </span>
        </div>
        <!-- Modal footer end -->

    </@sf.form>
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