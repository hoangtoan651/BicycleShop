<%-- 
    Document   : login
    Created on : Jan 17, 2023, 8:04:01 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TechShop Login Site</title>
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
                            <h3 class="font-weight-bold mb-3">Sign In</h3>
                            <p class="text-muted">Sign in to TechShop to continue</p>
                        </div>
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <div class="form-icon-wrapper">
                                    <input type="text" class="form-control" name="email" id="email" placeholder="Enter email" autofocus
                                           required>
                                    <i class="form-icon-left mdi mdi-email"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password">Phone</label>
                                <div class="form-icon-wrapper">

                                    <input type="password" class="form-control" name="phone" id="password" placeholder="Enter password"
                                           required>
                                    <i class="form-icon-left mdi mdi-lock"></i>
                                    <a href="#" class="form-icon-right password-show-hide" title="Hide or show password">
                                        <i class="mdi mdi-eye"></i>
                                    </a>


                                </div>
                            </div>
                            <div class="form-group">
<!--                                <div class="d-md-flex justify-content-between">
                                    <div class="custom-control custom-checkbox mb-2 mb-md-0">
                                        <input type="checkbox" class="custom-control-input" id="customCheck1" checked>
                                        <label class="custom-control-label" for="customCheck1">You know password is phone</label>
                                    </div>
                                    <a href="UserForgotPassword.jsp">I forgot my password!</a>
                                </div>-->
                                <div class="d-md-flex justify-content-between">
                                    <!--<div class="custom-control custom-checkbox mb-2 mb-md-0">
                                        <input type="checkbox" class="custom-control-input" id="customCheck1" checked>
                                        <label class="custom-control-label" for="customCheck1">You know password is phone</label>
                                    </div>-->
                                    <a href="ControllerChangePassword">Change Password</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-block">Sign In</button>
                            </div>
                            <p class="text-center">
                                Don't have an account?
                                <a href="SignUp">Create a free account</a>.
                            </p>
                            <div class="text-divider">Login with Google or back Home</div>
                            <div class="social-links justify-content-center">
                                <a href="#" class="bg-google">
                                    <i class="mdi mdi-google"></i>
                                </a>
                                <a href="homepage" class="bg-twitter">
                                    <i class="mdi mdi-home"></i>

                                </a>
                            </div>
                        </form>
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
