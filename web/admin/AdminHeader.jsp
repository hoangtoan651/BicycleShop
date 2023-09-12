<%-- 
    Document   : AdminHeader
    Created on : Mar 2, 2023, 12:12:56 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Tech Shop</title>
        <link rel="icon" href="./nav/img/favicon.png">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="./nav/css/bootstrap.min.css">
        <!-- animate CSS -->
        <link rel="stylesheet" href="./nav/css/animate.css">
        <!-- owl carousel CSS -->
        <link rel="stylesheet" href="./nav/css/owl.carousel.min.css">
        <!-- font awesome CSS -->
        <link rel="stylesheet" href="./nav/css/all.css">
        <!-- flaticon CSS -->
        <link rel="stylesheet" href="./nav/css/flaticon.css">
        <link rel="stylesheet" href="./nav/css/themify-icons.css">
        <!-- font awesome CSS -->
        <link rel="stylesheet" href="./nav/css/magnific-popup.css">
        <!-- swiper CSS -->
        <link rel="stylesheet" href="./nav/css/slick.css">
        <!-- style CSS -->
        <link rel="stylesheet" href="./nav/css/style.css">
        <title>Header</title>
    </head>
    <body>
        
        <% ResultSet rs=(ResultSet)request.getAttribute("data");%>
        <header class="main_menu home_menu">
        <div class="container-fluid">
            <div class="row align-items-center py-3 px-xl-5">
                <div class="col-lg-12">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <!--Should Show name shop  -->
                        <a style="font-size: 36px; font-weight: bold; " class="navbar-brand" href="AdminHome"> Tech Shop</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="menu_icon"><i class="fas fa-bars"></i></span>
                        </button>

                        <div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="AdminHome">Home</a>
                                </li>
                                <c:if test="${staff != null }">
                                <li class="nav-item">
                                    <a class="nav-link" href="AdminHome?service=insertProduct" > Add Products</a>
                                </li>
                                </c:if>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="ViewProduct" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown">
                                        Category
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        
                                        <%while(rs.next()){%>
                                        
                                        <a class="dropdown-item" href="AdminHome?service=displayProductdetail&cname=<%=rs.getString(1)%>"><%=rs.getString(1)%></a>
                                         
                                        <%}%>
                                    </div>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_3"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Product Manager
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
                                        <c:choose>
                                            <c:when test="${staff != null }">
                                                <a class="dropdown-item" href="AdminOrder">Order</a>
                                                <a class="dropdown-item" href="AdminStore">Store</a>
                                                <a class="dropdown-item" href="AdminStocks">Stocks</a>
                                                <a class="dropdown-item" href="AdminCustomer">Customers</a>
                                                <a class="dropdown-item" href="AdminStaff">Staffs</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a class="dropdown-item" href="loginAdmin">Order</a>
                                                <a class="dropdown-item" href="loginAdmin">Store</a>
                                                <a class="dropdown-item" href="loginAdmin">Stocks</a>
                                                <a class="dropdown-item" href="loginAdmin">Customers</a>
                                                <a class="dropdown-item" href="loginAdmin">Staffs</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        
                        <form action="AdminHome" method="post">
                            <input type="hidden" name="service" value="searchProductName">
                            <div class="input-group">
                                <input type="text" class="form-control" name="name" placeholder="Search for products">
                                <div class="input-group-append">
                                    <span class="input-group-text bg-transparent text-primary">
                                        <i class="fa fa-search"></i>
                                    </span>
                                </div>
                            </div>
                        </form>
                       

                        <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a href="loginAdmin"><i class="fas fa-user text-primary"></i>
                                <c:if test="${staff != null }">
                                <span class="badge">${username}</span>
                                  </c:if>
                            </a>
                            <div class="dropdown-menu">
                                <c:if test="${staff == null }">
                                <a class="dropdown-item" href="loginAdmin">Login</a>
                                
                                </c:if>
                                <c:if test="${staff != null }">
                                    <a class="dropdown-item" href="AdminHome?service=updateStaff&id=${staff.getStaff_id()}">User Profile</a>
                                <a class="dropdown-item" href="AdminChangePassword?service=changePassword">Change Password </a>
                                <a class="dropdown-item" href="logoutAdmin">Log out</a>
                                </c:if>
                                 
                             </div>
                         </li>
                        </ul>
                        <div class="hearer_icon d-flex">  
                            <a href="" >
                                <i class="text-primary"></i>
                                <span class="badge"></span>
                            </a>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        
    </header>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
             

        
    <script src="js/jquery-1.12.1.min.js"></script>
    <!-- popper js -->
    <script src="js/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- easing js -->
    <script src="js/jquery.magnific-popup.js"></script>
    <!-- swiper js -->
    <script src="js/swiper.min.js"></script>
    <!-- swiper js -->
    <script src="js/masonry.pkgd.js"></script>
    <!-- particles js -->
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <!-- slick js -->
    <script src="js/slick.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>
    <!-- custom js -->
    <script src="js/custom.js"></script>
        
    </body>
</html>
