<%@ page import="java.util.ArrayList" %>
<%@ page import="com.vn.model.NguoiDungEntity" %>

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
<body>
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
        <input type="text" name="search" id="search">
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
        <h4>Tư vấn thiết kế, hoàn thiện nội thất gia đình hoặc công ty</h4>
    </div>
    <br>
    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
        <a href="#">
            <button type="button" class="btn btn-outline-info">Tư vấn ngay</button>
        </a>
    </div>
</div>

<!--Hiển thị DL SQL-->

<table class="col-10 table table-striped">
    <thead>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Fullname</th>
        <th>SĐT</th>
        <th>ID Loại User</th>        
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${requestScope["listND"]}' var="nguoiDung">
        <tr>
            <td>${nguoiDung.getIdUser()}</td>
            <td>${nguoiDung.getPassword()}</td>
            <td>${nguoiDung.getFullName()}</td>
            <td>${nguoiDung.getSdt()}</td>
            <td>${nguoiDung.getIdLoaiAcout()}</td>
           
            <td><a href="homeND?action=edit&id=${nguoiDung.getIdUser()}">Edit</a></td>
            <td><a href="homeND?action=delete&id=${nguoiDung.getIdUser()}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
