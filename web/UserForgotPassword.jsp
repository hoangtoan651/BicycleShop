<%-- 
    Document   : UserForgotPassword
    Created on : Jan 17, 2023, 8:38:08 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TechShop ForgotPassword Site</title>
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
                            <h3 class="font-weight-bold mb-3">Reset Password</h3>
                            <p class="text-muted">Type and send the email address to reset your password.</p>
                        </div>
                        <form>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <div class="form-icon-wrapper">
                                    <input type="email" class="form-control" id="email" placeholder="Enter email" autofocus
                                           required>
                                    <i class="form-icon-left mdi mdi-email"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-block">Send</button>
                            </div>
                        </form>
                        <p class="text-center">You can now <a href="UserLogin.jsp">sign in</a> or <a href="sign-up.html">create an
                                account</a>.</p>
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
