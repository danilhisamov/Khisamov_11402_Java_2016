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
        <link rel="shortcut icon" href="img/ico/favicon.png">

    </head>
<body>
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
                        <a href="/login"><input type="submit" class="submit pull-left" value="Sign in" name="submit"/></a>

                        <a href="/registration"><input type="submit" class="submit pull-right" value="Sign up" name="submit"/></a>
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
            <@sf.form action="/registration" method="post" id="checkout-form" name="checkout-form" modelAttribute="regform">
                <!-- Modal body start -->
                <div class="modal-body">
                    <!-- Checkout Personal Info start -->
                    <div class="checkout-personal-info">
                        <div class="alert hidden" id="checkout-form-msg">
                            test
                        </div>
                        <h3>PERSONAL INFORMATION</h3>
                        <div class="form-group left">
                            <label for="login">Login:</label>
                            <@sf.input path="login" type="text" class="form-control" name="login" id="login" placeholder="Enter your Login"/>
                            <@sf.errors path="login" class = "form-control alert alert-warning text-center"/>
                        </div>
                        <div class="form-group right">
                            <label for="passwd">Password:</label>
                            <@sf.input path="password" type="password" class="form-control" name="password" id="password" placeholder="Enter your Password"/>
                            <@sf.errors path="password" class = "form-control alert alert-warning text-center"/>
                            <br>
                            <label for="passwd">Confirm Password:</label>
                            <@sf.input path="repassword" type="password" class="form-control" name="confirm_passwd" id="confirm_passwd" placeholder="Confirm your Password"/>
                            <@sf.errors path="repassword" class = "form-control alert alert-warning text-center"/>
                        </div>
                        <div class="form-group left">
                            <label for="first-name">First Name:</label>
                            <@sf.input path="firstname" type="text" class="form-control" name="first-name" id="first-name" placeholder="Enter your first name"/>
                            <@sf.errors path="firstname" class = "form-control alert alert-warning text-center"/>
                        </div>
                        <div class="form-group right">
                            <label for="last-name">Last Name:</label>
                            <@sf.input path="lastname" type="text" class="form-control" name="last-name" id="last-name" placeholder="Enter your last name"/>
                            <@sf.errors path="lastname" class = "form-control alert alert-warning text-center"/>
                        </div>
                        <div class="form-group left">
                            <label for="phone-number">Phone Number:</label>
                            <@sf.input path="phone" type="text" class="form-control" name="phone-number" value="+7" id="phone-number"/>
                            <@sf.errors path="phone" class = "form-control alert alert-warning text-center"/>
                        </div>
                        <div class="form-group right age">
                            <label for="age">Age:</label>
                            <div class="styled-select-age">
                                <@sf.select path="age" name="age" id="age">
                                    <@sf.option value="18">18</@sf.option>
                                    <@sf.option value="19">19</@sf.option>
                                    <@sf.option value="20">20</@sf.option>
                                    <@sf.option value="21">21</@sf.option>
                                    <@sf.option value="22">22</@sf.option>
                                    <@sf.option value="23">23</@sf.option>
                                    <@sf.option value="24">24</@sf.option>
                                    <@sf.option value="25">25</@sf.option>
                                    <@sf.option value="26">26</@sf.option>
                                    <@sf.option value="27">27</@sf.option>
                                    <@sf.option value="28">28</@sf.option>
                                    <@sf.option value="29">29</@sf.option>
                                    <@sf.option value="30">30</@sf.option>
                                    <@sf.option value="31">31</@sf.option>
                                    <@sf.option value="32">32</@sf.option>
                                    <@sf.option value="33">33</@sf.option>
                                    <@sf.option value="34">34</@sf.option>
                                    <@sf.option value="35">35</@sf.option>
                                    <@sf.option value="36">36</@sf.option>
                                    <@sf.option value="37">37</@sf.option>
                                    <@sf.option value="38">38</@sf.option>
                                    <@sf.option value="39">39</@sf.option>
                                    <@sf.option value="40">40</@sf.option>
                                    <@sf.option value="41">41</@sf.option>
                                    <@sf.option value="42">42</@sf.option>
                                    <@sf.option value="43">43</@sf.option>
                                    <@sf.option value="44">44</@sf.option>
                                    <@sf.option value="45">45</@sf.option>
                                    <@sf.option value="46">46</@sf.option>
                                    <@sf.option value="47">47</@sf.option>
                                    <@sf.option value="48">48</@sf.option>
                                    <@sf.option value="49">49</@sf.option>
                                    <@sf.option value="50">50</@sf.option>
                                    <@sf.option value="51">51</@sf.option>
                                    <@sf.option value="52">52</@sf.option>
                                    <@sf.option value="53">53</@sf.option>
                                    <@sf.option value="54">54</@sf.option>
                                    <@sf.option value="55">55</@sf.option>
                                    <@sf.option value="56">56</@sf.option>
                                    <@sf.option value="57">57</@sf.option>
                                    <@sf.option value="58">58</@sf.option>
                                    <@sf.option value="59">59</@sf.option>
                                    <@sf.option value="50">50</@sf.option>
                                    <@sf.option value="61">61</@sf.option>
                                    <@sf.option value="62">62</@sf.option>
                                    <@sf.option value="63">63</@sf.option>
                                    <@sf.option value="64">64</@sf.option>
                                    <@sf.option value="65">65</@sf.option>
                                    <@sf.option value="66">66</@sf.option>
                                    <@sf.option value="67">67</@sf.option>
                                    <@sf.option value="68">68</@sf.option>
                                    <@sf.option value="69">69</@sf.option>
                                    <@sf.option value="70">70</@sf.option>
                                    <@sf.option value="71">71</@sf.option>
                                    <@sf.option value="72">72</@sf.option>
                                    <@sf.option value="73">73</@sf.option>
                                    <@sf.option value="74">74</@sf.option>
                                    <@sf.option value="75">75</@sf.option>
                                    <@sf.option value="76">76</@sf.option>
                                    <@sf.option value="77">77</@sf.option>
                                    <@sf.option value="78">78</@sf.option>
                                    <@sf.option value="79">79</@sf.option>
                                    <@sf.option value="80">80</@sf.option>
                                    <@sf.option value="81">81</@sf.option>
                                    <@sf.option value="82">82</@sf.option>
                                    <@sf.option value="83">83</@sf.option>
                                    <@sf.option value="84">84</@sf.option>
                                    <@sf.option value="85">85</@sf.option>
                                    <@sf.option value="86">86</@sf.option>
                                    <@sf.option value="87">87</@sf.option>
                                    <@sf.option value="88">88</@sf.option>
                                    <@sf.option value="89">89</@sf.option>
                                    <@sf.option value="90">90</@sf.option>
                                    <@sf.option value="91">91</@sf.option>
                                    <@sf.option value="92">92</@sf.option>
                                    <@sf.option value="93">93</@sf.option>
                                    <@sf.option value="94">94</@sf.option>
                                    <@sf.option value="95">95</@sf.option>
                                    <@sf.option value="96">96</@sf.option>
                                    <@sf.option value="97">97</@sf.option>
                                    <@sf.option value="98">98</@sf.option>
                                    <@sf.option value="99">99</@sf.option>
                                    <@sf.option value="100">100</@sf.option>
                                </@sf.select>
                                <@sf.errors path="age" class = "form-control alert alert-warning text-center"/>
                            </div>
                        </div>
                        <div class="form-group left">
                            <label for="email-address">Email Address:</label>
                            <@sf.input path="email" type="email" class="form-control" name="email-address" id="email-address" placeholder="Enter your email address"/>
                            <@sf.errors path="email" class = "form-control alert alert-warning text-center"/>
                        </div>
                        <div class="form-group right sex">
                            <label for="sex">Sex:</label>
                            <div class="styled-select-sex">
                                <@sf.select path="sex" name="sex" id="sex">
                                    <@sf.option value="MALE">Male</@sf.option>
                                    <@sf.option value="FEMALE">Female</@sf.option>
                                </@sf.select>
                                <@sf.errors path="sex" class = "form-control alert alert-warning text-center"/>
                            </div>
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