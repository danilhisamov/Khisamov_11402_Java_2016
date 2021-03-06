// Custom JS for the Theme

// Config 
//-------------------------------------------------------------

var companyName = "Car Rental Station"; // Enter your event title


// Initialize Tooltip  
//-------------------------------------------------------------

$('.my-tooltip').tooltip();


// Initialize jQuery Placeholder
//-------------------------------------------------------------

$('input, textarea').placeholder();


// Toggle Header / Nav
//-------------------------------------------------------------

$(document).on("scroll", function () {
    if ($(document).scrollTop() > 39) {
        $("header").removeClass("large").addClass("small");
    }
    else {
        $("header").removeClass("small").addClass("large");
    }
});


// Vehicles Tabs / Slider
//-------------------------------------------------------------


var activeVehicleData = $(".vehicle-nav .active a").attr("href");
$(activeVehicleData).show();

$(".vehicle-nav li").on("click", function () {

    $(".vehicle-nav .active").removeClass("active");
    $(this).addClass('active');

    $(activeVehicleData).fadeOut("slow", function () {
        activeVehicleData = $(".vehicle-nav .active a").attr("href");
        $(activeVehicleData).fadeIn("slow", function () {
        });
    });

    return false;
});


// Vehicles Responsive Nav
//-------------------------------------------------------------

$("<div />").appendTo("#vehicle-nav-container").addClass("styled-select-vehicle-data");
$("<select />").appendTo(".styled-select-vehicle-data").addClass("vehicle-data-select");
$("#vehicle-nav-container a").each(function () {
    var el = $(this);
    $("<option />", {
        "value": el.attr("href"),
        "text": el.text()
    }).appendTo("#vehicle-nav-container select");
});

$(".vehicle-data-select").change(function () {
    $(activeVehicleData).fadeOut("slow", function () {
        activeVehicleData = $(".vehicle-data-select").val();
        $(activeVehicleData).fadeIn("slow", function () {
        });
    });

    return false;
});


// Initialize Datepicker
//-------------------------------------------------------------------------------
$('.datepicker').datepicker().on('changeDate', function () {
    $(this).datepicker('hide');
});


// Toggle Drop-Off Location
//-------------------------------------------------------------------------------
$(".input-group.drop-off").hide();
$(".different-drop-off").on("click", function () {
    $(".input-group.drop-off").toggle();
    $(".autocomplete-suggestions").css("width", $('.pick-up .autocomplete-location').outerWidth());
    return false;
});


// Scroll to Top Button
//-------------------------------------------------------------------------------

$(window).scroll(function () {
    if ($(this).scrollTop() > 100) {
        $('.scrollup').removeClass("animated fadeOutRight");
        $('.scrollup').fadeIn().addClass("animated fadeInRight");
    } else {
        $('.scrollup').removeClass("animated fadeInRight");
        $('.scrollup').fadeOut().addClass("animated fadeOutRight");
    }
});

$('.scrollup, .navbar-brand').click(function () {
    $("html, body").animate({scrollTop: 0}, 'slow', function () {
        $("nav li a").removeClass('active');
    });
    return false;
});


// Location Map Function
//-------------------------------------------------------------------------------

function loadMap(addressData) {

    var path = document.URL;
    path = path.substring(0, path.lastIndexOf("/") + 1)

    var locationContent = "<h2>" + companyName + "</h2>"
        + "<p>" + addressData + "</p>";

    $('#locations .map').gmap3({
            map: {
                options: {
                    maxZoom: 15,
                    scrollwheel: false,
                }
            },
            infowindow: {
                address: addressData,
                options: {
                    content: locationContent
                }
            },
            marker: {
                address: addressData,
                options: {
                    icon: new google.maps.MarkerImage(
                        path + "img/mapmarker.png",
                        new google.maps.Size(59, 58, "px", "px"),
                        new google.maps.Point(0, 0),    //sets the origin point of the icon
                        new google.maps.Point(29, 34)   //sets the anchor point for the icon
                    )
                }
            }
        },
        "autofit");
}

loadMap(locations[0].value);

$("#location-map-select").append('<option value="' + locations[0].value + '">Please select a location</option>');
$.each(locations, function (index, value) {
    var option = '<option value="' + value.value + '">' + value.value + '</option>';
    $("#location-map-select").append(option);
});

$('#location-map-select').on('change', function () {
    $('#locations .map').gmap3('destroy');
    loadMap(this.value);
});


// Scroll To Animation
//-------------------------------------------------------------------------------

var scrollTo = $(".scroll-to");

scrollTo.click(function (event) {
    $('.modal').modal('hide');
    var position = $(document).scrollTop();
    var scrollOffset = 110;

    if (position < 39) {
        scrollOffset = 260;
    }

    var marker = $(this).attr('href');
    $('html, body').animate({scrollTop: $(marker).offset().top - scrollOffset}, 'slow');

    return false;
});


// setup autocomplete - pulling from locations-autocomplete.js
//-------------------------------------------------------------------------------

$('.autocomplete-location').autocomplete({
    lookup: locations
});


// Newsletter Form
//-------------------------------------------------------------------------------

$("#newsletter-form").submit(function () {

    $('#newsletter-form-msg').addClass('hidden');
    $('#newsletter-form-msg').removeClass('alert-success');
    $('#newsletter-form-msg').removeClass('alert-danger');

    $('#newsletter-form input[type=submit]').attr('disabled', 'disabled');

    $.ajax({
        type: "POST",
        url: "php/newsletter.php",
        data: $("#newsletter-form").serialize(),
        dataType: "json",
        success: function (data) {

            if ('success' == data.result) {
                $('#newsletter-form-msg').css('visibility', 'visible').hide().fadeIn().removeClass('hidden').addClass('alert-success');
                $('#newsletter-form-msg').html(data.msg[0]);
                $('#newsletter-form input[type=submit]').removeAttr('disabled');
                $('#newsletter-form')[0].reset();
            }

            if ('error' == data.result) {
                $('#newsletter-form-msg').css('visibility', 'visible').hide().fadeIn().removeClass('hidden').addClass('alert-danger');
                $('#newsletter-form-msg').html(data.msg[0]);
                $('#newsletter-form input[type=submit]').removeAttr('disabled');
            }

        }
    });

    return false;
});


// Contact Form
//-------------------------------------------------------------------------------

$("#contact-form").submit(function () {

    $('#contact-form-msg').addClass('hidden');
    $('#contact-form-msg').removeClass('alert-success');
    $('#contact-form-msg').removeClass('alert-danger');

    $('#contact-form input[type=submit]').attr('disabled', 'disabled');

    $.ajax({
        type: "POST",
        url: "php/contact.php",
        data: $("#contact-form").serialize(),
        dataType: "json",
        success: function (data) {

            if ('success' == data.result) {
                $('#contact-form-msg').css('visibility', 'visible').hide().fadeIn().removeClass('hidden').addClass('alert-success');
                $('#contact-form-msg').html(data.msg[0]);
                $('#contact-form input[type=submit]').removeAttr('disabled');
                $('#contact-form')[0].reset();
            }

            if ('error' == data.result) {
                $('#contact-form-msg').css('visibility', 'visible').hide().fadeIn().removeClass('hidden').addClass('alert-danger');
                $('#contact-form-msg').html(data.msg[0]);
                $('#contact-form input[type=submit]').removeAttr('disabled');
            }

        }
    });

    return false;
});


// Car Select Form
//-------------------------------------------------------------------------------

//$("#car-select-form").submit(function () {
//
//    var selectedCar = $("#car-select").find(":selected").text();
//    var selectedCarVal = $("#car-select").find(":selected").val();
//    var selectedCarImage = $("#car-select").val();
//    var pickupLocation = $("#pick-up-location").val();
//    var dropoffLocation = $("#drop-off-location").val();
//    var pickUpDate = $("#pick-up-date").val();
//    var pickUpTime = $("#pick-up-time").val();
//    var dropOffDate = $("#drop-off-date").val();
//    var dropOffTime = $("#drop-off-time").val();
//
//    var error = 0;
//
//    if (validateNotEmpty(selectedCarVal)) {
//        error = 1;
//    }
//    if (validateNotEmpty(pickupLocation)) {
//        error = 1;
//    }
//    if (validateNotEmpty(pickUpDate)) {
//        error = 1;
//    }
//    if (validateNotEmpty(dropOffDate)) {
//        error = 1;
//    }
//
//    if (0 == error) {
//
//        $("#selected-car-ph").html(selectedCar);
//        $("#selected-car").val(selectedCar);
//        $("#selected-vehicle-image").attr('src', selectedCarImage);
//
//        $("#pickup-location-ph").html(pickupLocation);
//        $("#pickup-location").val(pickupLocation);
//
//        if ("" == dropoffLocation) {
//            $("#dropoff-location-ph").html(pickupLocation);
//            $("#dropoff-location").val(pickupLocation);
//        }
//        else {
//            $("#dropoff-location-ph").html(dropoffLocation);
//            $("#dropoff-location").val(dropoffLocation);
//        }
//
//        $("#pick-up-date-ph").html(pickUpDate);
//        $("#pick-up-time-ph").html(pickUpTime);
//        $("#pick-up").val(pickUpDate + ' at ' + pickUpTime);
//
//        $("#drop-off-date-ph").html(dropOffDate);
//        $("#drop-off-time-ph").html(dropOffTime);
//        $("#drop-off").val(dropOffDate + ' at ' + dropOffTime);
//
//        $('#checkoutModal').modal();
//    }
//    else {
//        $('#car-select-form-msg').css('visibility', 'visible').hide().fadeIn().removeClass('hidden').delay(2000).fadeOut();
//    }
//
//    return false;
//});
//
//
//// Check Out Form
////-------------------------------------------------------------------------------
//
//$("#checkout-form").submit(function () {
//
//    $('#checkout-form-msg').addClass('hidden');
//    $('#checkout-form-msg').removeClass('alert-success');
//    $('#checkout-form-msg').removeClass('alert-danger');
//
//    $('#checkout-form input[type=submit]').attr('disabled', 'disabled');
//
//    $.ajax({
//        type: "POST",
//        url: "php/inquiry.php",
//        data: $("#checkout-form").serialize(),
//        dataType: "json",
//        success: function (data) {
//
//            if ('success' == data.result) {
//                $('#checkout-form-msg').css('visibility', 'visible').hide().fadeIn().removeClass('hidden').addClass('alert-success');
//                $('#checkout-form-msg').html(data.msg[0]);
//                $('#checkout-form input[type=submit]').removeAttr('disabled');
//
//                setTimeout(function () {
//                    $('.modal').modal('hide');
//                    $('#checkout-form-msg').addClass('hidden');
//                    $('#checkout-form-msg').removeClass('alert-success');
//
//                    $('#checkout-form')[0].reset();
//                    $('#car-select-form')[0].reset();
//                }, 5000);
//
//            }
//
//            if ('error' == data.result) {
//                $('#checkout-form-msg').css('visibility', 'visible').hide().fadeIn().removeClass('hidden').addClass('alert-danger');
//                $('#checkout-form-msg').html(data.msg[0]);
//                $('#checkout-form input[type=submit]').removeAttr('disabled');
//            }
//
//        }
//    });
//
//    return false;
//});


// Not Empty Validator Function
//-------------------------------------------------------------------------------

function validateNotEmpty(data) {
    if (data == '') {
        return true;
    } else {
        return false;
    }
}


function getCar(id) {
    $.ajax({
        url: "/cars/process",
        method: "GET",
        data: {"id": id},
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (resp) {
            var img = document.getElementById("carPhoto");
            img.src = resp.photoPath;
            $("#price").text(resp.price);
            $("#model").text(resp.model);
            $("#doors").text(resp.doors);
            $("#seats").text(resp.seats);
            $("#luggage").text(resp.luggage);
            $("#transmission").text(resp.transmission);
            $("#air_cond").text(resp.air_cond);
        }
    })
}

function getCarsByStatus() {
    $.ajax({
        url: "/admin/cars/show",
        method: "GET",
        data: {"choose": $("#ch").val()},
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (resp) {
            $("#car_res").text("")
            for (var i = 0;i < resp.length;i++){
                $("#car_res").append("<section id='vehicles' class='container' style='margin-left: 100px'>" +
                    "<div class='row'>" +
                    "<div class='vehicle-data' id='vehicle' style='display: '>" +
                    "<div class='col-md-6 wow fadeIn' data-wow-offset='100'>"+
                    "<div class='vehicle-img'>"+
                    "<img class='img-responsive' id='carPhoto' src=" + resp[i].photoPath + ">"+
                    "</div> </div>"+
                    "<div class='col-md-3 wow fadeInUp' data-wow-offset='200'> <div class='vehicle-price' id='car-price'>"+
                    "<div id='price' style='float: left'>" + resp[i].price + "</div> <span class='info'>&nbsp;rent per day</span></div>"+
                "<table class='table vehicle-features'>"+
                    "<tr>"+
                    "<td>Model</td> <td id='model'>" + resp[i].model + "</td>" +
                    "</tr> <tr>"+
                    "<td>Doors</td> <td id='doors'>" + resp[i].doors + "</td>"+
                    "</tr> <tr>"+
                    "<td>Seats</td> <td id='seats'>" + resp[i].seats + "</td>"+
                    "</tr> <tr>"+
                    "<td>Luggage</td> <td id='luggage'>" + resp[i].luggage + "</td>"+
                    "</tr> <tr>" +
                    "<td>Transmission</td> <td id='transmission'>" + resp[i].transmission + "</td>"+
                    "</tr> <tr>" +
                    "<td>Air conditioning</td> <td id='air_cond'>" + resp[i].air_cond + "</td>" +
                    "</tr><tr>"+
                    "<td>Status</td><td id='status'>" + resp[i].status + "</td> </tr>"+
                    "</table>"+
                    "<a href= '/admin/car_change/" + resp[i].id + "'> <input type='button' name='admin_add_car_button' value='Add Car'></a>"+
                    "</div> </div> </div>" +
                    "</section>")
            }
        }
    })
}

function getOrdersByTime(time){
    $.ajax({
        url: "/admin/orders/show",
        method: "GET",
        data: {"time": time},
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (resp) {
            $("#order_rows").text("")
            for (var i = 0;i < resp.length;i++){
                $("#order_rows").append("<tr>" +
                    "<td>" + resp[i].id + "</td>" +
                    "<td>" + resp[i].client + "</td>" +
                    "<td>" + resp[i].car + "</td>" +
                    "<td>" + resp[i].pickUpLoc + "</td>" +
                    "<td>" + resp[i].pickUpDate + "</td>" +
                    "<td>" + resp[i].pickUpTime + "</td>" +
                    "<td>" + resp[i].dropOffLoc+ "</td>" +
                    "<td>" + resp[i].dropOffDate+ "</td>" +
                    "<td>" + resp[i].dropOffTime+ "</td>" +
                    "<td>" + resp[i].price+ "</td>" +
                    "</tr>")
            }
        }
    })
}

