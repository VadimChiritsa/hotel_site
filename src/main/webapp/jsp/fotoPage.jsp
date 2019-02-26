<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="text"/>
<head>
    <title>Metropol</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="../image/emblem.png">
    <link href="../css/index.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script type="javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
    <link rel="shortcut icon" href="../image/emblem.png">
</head>
<body style="height:auto">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid menu">
        <div class="navbar-header">
            <a class="navbar-brand name" href="#" style="color: black">Metropol</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/controller?command=openpage&page=main"><fmt:message key="main.main" /></a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/controller?command=openpage&page=foto"><fmt:message key="main.foto" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=openpage&page=info"><fmt:message key="main.info" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=openpage&page=login"><fmt:message key="main.autorization" /></a></li>
        </ul>
    </div>
</nav>

<div class="container ballet-body" style="margin-top:50px">
    <div class="modal fade" id="image-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <div class="modal-title" ></div>
                </div>
                <div class="modal-body">
                    <img class="img-responsive center-block" src="" alt="">
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- 1 Изображение -->
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="data:image/jpeg;base64,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" alt="..." style="width:242px; height:200px">
            </a>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTF_YPcecDdqPA9JkVY4ZEQF4bjWHBTml8y0ut5aVEW1ra8OXah" alt="..." style="width:242px; height:200px">
            </a>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="http://metropol-moscow.ru/upload/iblock/866/866e253d4382a235fd02d7174ab641d3.jpg" alt="..." style="width:242px; height:200px">
            </a>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGUnX5oPBFKq1Su5mquZG6urW3awsKx5WHg9uI_s0KHfB_K3PU" alt="..." style="width:242px; height:200px">
            </a>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="http://00bc63e63043ca4ba700-db33b2c7518117562db3fdad47434a05.r53.cf1.rackcdn.com/responsive/580/00bc63e63043ca4ba700-db33b2c7518117562db3fdad47434a05.r53.cf1.rackcdn.com/XLGallery/Lobby-bar-with-fireplace-at-Sheraton-Moscow-Sheremetyevo.jpg" alt="..." style="width:242px; height:200px">
            </a>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThWca_MUQ978h6pU0izfybSV3lmSCZ_xUdN30Mc8aU7ByByPUr" alt="..." style="width:242px; height:200px">
            </a>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOgWdYKpoapctcFGSOHBXf7WGSMHyYdGmAztY2pU1cy519xEAd" alt="..." style="width:242px; height:200px">
            </a>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThWca_MUQ978h6pU0izfybSV3lmSCZ_xUdN30Mc8aU7ByByPUr" alt="..." style="width:242px; height:200px">
            </a>
        </div>
        <div class="col-sm-6 col-md-3 col-lg-4">
            <a href="#" class="thumbnail">
                <img src="http://metropol-moscow.ru/upload/iblock/866/866e253d4382a235fd02d7174ab641d3.jpg" alt="..." style="width:242px; height:200px">
            </a>
        </div>
    </div>
</div>
<script>
    //при нажатии на ссылку, содержащую Thumbnail
    $('a.thumbnail').click(function(e) {
        //отменить стандартное действие браузера
        e.preventDefault();
        //присвоить атрибуту scr элемента img модального окна
        //значение атрибута scr изображения, которое обёрнуто
        //вокруг элемента a, на который нажал пользователь
        $('#image-modal .modal-body img').attr('src', $(this).find('img').attr('src'));
        //открыть модальное окно
        $("#image-modal").modal('show');
    });
    //при нажатию на изображение внутри модального окна
    //закрыть его (модальное окно)
    $('#image-modal .modal-body img').on('click', function() {
        $("#image-modal").modal('hide')
    });


    $("#adagio").click(function() {
        document.getElementById("adagioText").innerHTML= "Количество мест в номере: 2" +"<br/>"
            +  "Вид: исторический"+"<br/>"+
            "В спальне: кровать «king size» 2х2 метра"+"</br>"+
            "Просторная ванная комната оснащена тропическим душем, встроенным в зеркалом"+"</br>";
        ;});

    $("#arabesk").click(function(){
        document.getElementById("arabeskText").innerHTML =  "Количество мест в номере: 2" +"<br/>"
            +  "Возрастное ограничение: Детям до 14 лет с сопровождающим лицом"+"<br/>"+
            "Вид: новый"+"</br>"+
            "Площадь номера – 48 кв. метров (157 кв. футов)."+"</br>"+
            "Номера оборудованы ЖК телевизором (с диагональю экрана в 49 дюймов), IPad Air 2, системой «Умный дом»."+"</br>"+
            "К услугам гостей: косметические средства Asprey London в ванных комнатах, мини-бар, кофе-машина Nespresso с набором капсул, элитные сорта чая и чайник KitchenAid."+ "</br>"
    });

    $("#asamble").click(function() {
        $("#asambleText").html("Наши номера класса «Стандарт» аналогичны по благородному декору, комбинированному освещению и удобному зонированию, но в то же время отличаются друг от друга планировкой, дизайном и цветовым решением. Для удобства гостей с детьми отель располагает номерами, сообщающимися между собой.\n" +
            "\n" +
            "Площадь номера «Стандартный» – от 25 м2. \n" +
            "Каждый номер оснащен телевизором с жидкокристаллическим экраном со светодиодной подсветкой, мини-баром и рабочим столом.");
        ;});



    $("#showDanceDirection").bind('click',function(){
        $.getJSON("room.json", function( data ) {
            html = '<div class="panel panel-default">' + '<table class="table table-striped table-hover">' + '<tr>' + '<th>' + 'Фильм' + '</th>' + '<th>' + 'Доступные сеансы сегодня' + '</th>' + '</tr>';
            $.each(data, function(key, val) {
                html += "<tr>" + '<td>' + key + '</td>' +"<td>";
                $.each(val, function(key1, val1) {
                    html += key1 + " ";
                });
                html += "</td>" + "</tr>";
            });
            html += '</table>' + '</div>';

            $("#aboutSchool").append(html);
        });

    });
    $(".adagio").bind('mouseover',function(){
        $(this).tooltip("show");
    })

</script>
</body>

