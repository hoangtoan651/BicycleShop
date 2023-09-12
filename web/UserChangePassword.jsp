<%-- 
    Document   : UserChangePassword
    Created on : Jan 17, 2023, 8:36:00 PM
    Author     : GG
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TechShop ChangePassword Site</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="./provides/vendor/bootstrap-4.5.3/css/bootstrap.min.css" type="text/css">
        <!-- Material design icons -->
        <link rel="stylesheet" href="./provides/icons/material-design-icons/css/mdi.min.css" type="text/css">
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300&display=swap" rel="stylesheet">
        <!-- Latform styles -->
        <link rel="stylesheet" href="./provides/css/latform-style-1.min.css" type="text/css">
    </head>
    <body>
        <div class="form-wrapper">
            <div class="container">
                <div class="card">
                    <div class="card-body">
                        <div class="logo">
                            <img src="./provides/images/logo-colorful.png" alt="logo">
                        </div>
                        
                        <div class="my-5 text-center">
                            <h3 class="font-weight-bold mb-3">Change Password</h3>
                        </div>
                        <form action="ControllerChangePassword" method="post">
                            <input type="hidden" value="changePassword" name="service">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <div class="form-icon-wrapper">
                                    <input type="text" class="form-control" name="email" id="email" placeholder="Enter email" autofocus
                                           required>
                                    <i class="form-icon-left mdi mdi-email"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password">New password</label>
                                <div class="form-icon-wrapper">
                                    <input type="password" class="form-control" name="phone" id="password" placeholder="Enter password" autofocus
                                           required>
                                    <i class="form-icon-left mdi mdi-lock"></i>
<!--                                    <a href="#" class="form-icon-right password-show-hide" title="Hide or show password">
                                        <i class="mdi mdi-eye"></i>
                                    </a>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password2">Retype password</label>
                                <div class="form-icon-wrapper">
                                    <input type="password" class="form-control" name="phone2" id="password2" placeholder="Enter password" autofocus
                                           required>
                                    <i class="form-icon-left mdi mdi-lock"></i>
<!--                                    <a href="#" class="form-icon-right password-show-hide" title="Hide or show password">
                                        <i class="mdi mdi-eye"></i>
                                    </a>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-block" name="submit">Change Password</button>
                            </div>
                        </form>
                        <p class="text-center">You can now <a href="login">sign in</a> or <a href="SignUp">create an
                                account</a>.</p>
                                                    <div class="text-divider">Login with Google or back Home</div>
                            <div class="social-links justify-content-center">
                                <a href="#" class="bg-google">
                                    <i class="mdi mdi-google"></i>
                                </a>
                                <!--                                <a href="#" class="bg-facebook">
                                                                    <i class="mdi mdi-facebook"></i>
                                                                </a>-->
                                <!--                                <a href="#" class="bg-twitter">
                                                                    <i class="mdi mdi-twitter"></i>
                                                                </a>-->
                                <a href="homepage" class="bg-twitter">
                                    <i class="mdi mdi-home"></i>

                                </a>
                            </div>        
                    </div>
                </div>
            </div>
        </div>
        <!-- Jquery -->
        <script src="./provides/vendor/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="./provides/vendor/bootstrap-4.5.3/js/bootstrap.min.js"></script>
        <!-- Latform scripts -->
        <script src="./provides/js/latform.min.js"></script>
    </body>
</html>
