<%@ page import="java.util.ArrayList" %>
<%@ page import="com.vn.model.Product" %>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Johntoan</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <!-- phần thanh menu trên đầu -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
        <div class="container-fluid">
            <img class="rounded-circle" src="img/logo.jpg" height="70" width="70"/>

            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarResponsive">
            </button>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sản Phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Giới Thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Liên Hệ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Tìm Kiếm</a>
                </li>
            </ul>
            <input type="text" placeholder="Tìm kiếm" name="search" id="search">
        </div>
        </div>
    </nav>

    <!-- phần ảnh trên -->

<div id="panner">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/anh2.jpg" height="590" width="100%"/>
            <div class="carousel-caption text-primary ">
                <h1 class="display-1">Thọ Uyên</h1>
                <h2>Trung tâm nội thất</h2>

                <button type="button" class="btn btn-outline-light btn-lg">
                    LIÊN HỆ NGAY
                </button>
                <button type="button" class="btn btn-primary btn-lg">MUA NGAY</button>
            </div>
        </div>
    </div>
</div>

<!--dưới ảnh trang wed-->
<div class="jumbotron">
    <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
        <h4>Quản trị hệ thống</h4>
    </div>
    <br>
    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
        <a href="homeND?">
            <button type="button" class="btn btn-outline-info">Quản trị User</button>
        </a>
        <br>
        <br>
        <a href="home?action=view">
            <button type="button" class="btn btn-outline-info">Quản trị Sản Phẩm</button>
        </a>
    </div>
</div>

<!--Sản phẩm mới-->
<div class="container-fluid padding">
    <div class="row welcome text-center">
        <div class="col-12">
            <h2 class="display-4">SẢN PHẨM MỚI</h2>
            <a href="#">
                <button type="button" class="btn btn-outline-info">xem tất cả</button>
            </a>
        </div>
    </div>
</div>
<hr class="col-10" color="zed">

<!--Phần hiển thị sản phẩm-->

<div class="container-fluid padding" id="hienthi">
    <div class="row text-center padding">
        <c:forEach items='${requestScope["listSP"]}' var="sanPham">

            <div class="col-xs-12 col-sm-6 col-md-4 ">
                <img src=" ${sanPham.getImgSP()} " height="300" width="470"/>
                <h3> ${sanPham.getNameSP()} </h3>
                <p> ${sanPham.getGiaSP()}</p>
            </div>

        </c:forEach>
    </div>
</div>
<br>
<div class="container-fluid padding">
    <div class="row welcome text-center">
        <div class="col-12">
            <a href="home?action=view">
                <button type="button" class="btn btn-outline-info">New or Edit SP</button>
            </a>
        </div>
    </div>
</div>
<br>

<hr class="col-10" color="zed">
<br>
<!-- phần ảnh dưới -->
<div id="slide_show" class="container-fluid col-8">
    <div id="demo" class="carousel slide" data-ride="carousel">
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
        </ul>

        <div class="carousel-inner">
            <div class="carousel-item ">
                <img src="img/anh1.jpg" width="100%" height="400">
            </div>

            <div class="carousel-item">
                <img src="img/anh2.jpg" width="100%" height="400">
            </div>

            <div class="carousel-item active">
                <img src="img/anh3.jpg" width="100%" height="400">
            </div>

        </div>

        <!-- 2 nút ấn 2 bên ảnh-->
        <!-- <a class="carousel-control-prev" href="#panner" data-slide="prev">-->
        <!-- <span class="carousel-control-prev-icon"></span>-->
        <!-- </a>-->
        <!-- <a class="carousel-control-next" href="#panner" data-slide="next">-->
        <!-- <span class="carousel-control-next-icon"></span>-->
        <!-- </a>-->
    </div>
</div>

<!--Phần tiếp theo-->
<br>
<hr class="col-10" color="zed">

<footer>
    <div class="container-fluid padding">
        <div class="row text-center">
            <div class="col-md-4">
                <hr class="bg-light">
                <h5>Thông tin</h5>
                <hr class="bg-light">
                <p>111-222-3333</p>
                <p>johntoan98@gmail.com</p>
                <p>Đông triều - Quảng Ninh - Việt Nam</p>
            </div>
            <div class="col-md-4">
                <hr class="bg-light">
                <h5>Giờ mở cửa</h5>
                <hr class="bg-light">
                <p>Monday-Friday: 7am - 22pm</p>
                <p>Weekend: 7am - 24am</p>
            </div>
            <div class="col-md-4">
                <hr class="bg-light">
                <h5>Dịch vụ</h5>
                <hr class="bg-light">
                <p>Miễn phí Ship</p>
                <p>Thiết kế miễn phí</p>
                <p>Bảo hành ít nhất 2 năm</p>
            </div>

            <div class="col-12">
                <br>
                <br>
                <h3>&copy;John Toàn</h3>
                <br>
                <br>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
