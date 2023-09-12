<%-- 
    Document   : Shop
    Created on : Jan 17, 2023, 10:20:15 PM
    Author     : GG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <title>Tech Shop</title>
    </head>
    <style>
            .modal-content{
                padding: 40px;
            }
            .option{
                padding-left: 5px;
            }

            .isDisabled {
                cursor: not-allowed;
                opacity: 0.5;
            }

            .isDisabled>a {
                color: currentColor;
                display: inline-block; /* For IE11/ MS Edge bug */
                pointer-events: none;
                text-decoration: none;
            }
        </style>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
            <!-- Shop Start -->
            <div class="container-fluid pt-5">
                <div class="row px-xl-5">
                    <!-- Shop Sidebar Start -->
                    <div class="col-lg-3 col-md-12">

                        <div class="col-lg-12 d-none d-lg-block">
                            <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                                <h6 class="m-0">Categories</h6>
                                <i class="fa fa-angle-down text-dark"></i>
                            </a>

                            <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
                                <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">

                                <c:forEach items="${liscate}" var="l">
                                    <a href="ViewProduct?service=displayAll&idStore=${sessionScope.ids}&cname=${l.toString()}" class="nav-item nav-link">${l.toString()}</a>
                                </c:forEach>
                            </div>
                        </nav>

                    </div>
                </div>
                <!-- Shop Sidebar End -->
                <!-- Shop Product Start -->
                <div class="col-lg-9 col-md-12">
                    <div class="row pb-3">
                        <div class="col-12 pb-1">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <!--Search bar  -->
                                <form action="" method="post">

                                    <div class="input-group">
                                        <input type="text" class="form-control" name="search" placeholder="Search by name" value="${sessionScope.GT}">
                                        <div class="input-group-append">
                                            <input type="submit" name = "Search" class="tn btn-primary btn-sm" value="Search">     
                                        </div>
                                    </div>
                                </form>
                                <!--End Search bar  -->
                                <div class="dropdown ml-4">
                                    <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="false">
                                        Choose Staff
                                    </button>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                        <c:forEach items="${sessionScope.liststaff}" var="l">
                                            <a class="dropdown-item" href="ViewProduct?service=displayAll&idStore=${sessionScope.ids}&cname=${sessionScope.cname}&staffid=${l.staff_id}">${l.first_name} ${l.last_name}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${product}" var="p">
                            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                                <div class="card product-item border-0 mb-4">
                                    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                        <img class="img-fluid w-100" src="${p.image}" alt="">
                                    </div>
                                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                        <h6 class="text-truncate mb-3">${p.product_name}</h6>
                                        <div class="d-flex justify-content-center">
                                            <h6>${p.list_price}</h6><h6 class="text-muted ml-2"></h6>
                                        </div>
                                    </div>
                                    <div class="card-footer d-flex justify-content-between bg-light border">
                                        <a href="ViewProduct?service=detailProductID&id=${p.product_id}" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                        <a href="ViewProduct?service=addToCart&idStore=${sessionScope.ids}&cname=${sessionScope.cname}&staffid=${sessionScope.staffid}&proID=${p.product_id}"" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>   
                    </div>
                </div>
                <!-- Shop Product End -->
            </div>
        </div>
        <!-- Pagging Start -->
        <div class="row be-datatable-footer">
            <div class="col-sm-12">
                <div class="dataTables_paginate paging_simple_numbers "
                     id="table5_paginate">
                    <c:if test="${searched == null}">
                        <ul class="pagination justify-content-center fadeInUp ">
                            <li
                                class="paginate_button page-item previous ${page == 1 ? 'isDisabled' : ''}"
                                id="table5_previous"><a
                                    href="ViewProduct?service=displayAll&idStore=1&page=${page-1}"
                                    aria-controls="table5" class="page-link paging-btn">Previous</a></li>
                            <li class="paginate_button page-item inactive"><a
                                    href="ViewProduct?service=displayAll&idStore=1&page=${page}"
                                    aria-controls="table5" data-dt-idx="1" tabindex="0"
                                    class="page-link ">${page}</a></li>
                            <li
                                class="paginate_button page-item next ${page == num ? 'isDisabled' : ''}"
                                id="table5_next"><a
                                    href="ViewProduct?service=displayAll&idStore=1&page=${page+1}"
                                    aria-controls="table5" class="page-link paging-btn">Next</a></li>
                        </ul>
                    </c:if>
                    <c:if test="${searched != null}">
                        <ul class="pagination justify-content-center fadeInUp ">
                            <li
                                class="paginate_button page-item previous ${page == 1 ? 'isDisabled' : ''}"
                                id="table5_previous"><a
                                    href="ViewProduct?service=displayAll&idStore=1&page=${page-1}"
                                    aria-controls="table5" class="page-link paging-btn">Previous</a></li>
                            <li class="paginate_button page-item inactive"><a
                                    href="ViewProduct?service=displayAll&idStore=1&page=${page}"
                                    aria-controls="table5" data-dt-idx="1" tabindex="0"
                                    class="page-link ">${page}</a></li>
                            <li
                                class="paginate_button page-item next ${page == num ? 'isDisabled' : ''}"
                                id="table5_next"><a
                                    href="ViewProduct?service=displayAll&idStore=1&page=${page+1}"
                                    aria-controls="table5" class="page-link paging-btn" >Next</a></li>
                        </ul>
                    </c:if>
                </div>
            </div>
        </div>
         <!-- Pagging End -->
        <jsp:include page="footer.jsp"></jsp:include>

        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>
</html>
