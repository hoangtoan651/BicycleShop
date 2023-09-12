<%-- 
    Document   : UserSignUp
    Created on : Jan 17, 2023, 8:28:05 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TechShop SignUp Site</title>
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
                        <div class="text-center my-5">
                            <h3 class="font-weight-bold mb-3">Create Account</h3>
                            <p class="text-muted">You can create a free account now</p>
                        </div>
                        <form action="SignUp" method="post">
                            <div class="form-group">
                                <label for="firstname">First name</label>
                                <div class="form-icon-wrapper">
                                    <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Enter firstname" autofocus required>
                                    <i class="form-icon-left mdi mdi-account"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname">Last name</label>
                                <div class="form-icon-wrapper">
                                    <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Enter lastname" autofocus required>
                                    <i class="form-icon-left mdi mdi-account"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <div class="form-icon-wrapper">
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Enter email" required>
                                    <i class="form-icon-left mdi mdi-email"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password">Phone</label>
                                <div class="form-icon-wrapper">
                                    <input type="password" class="form-control" name="phone" id="password" placeholder="Enter password">
                                    <i class="form-icon-left mdi mdi-lock"></i>
<!--                                    <a href="#" class="form-icon-right password-show-hide" title="Hide or show password">
                                        <i class="mdi mdi-eye"></i>
                                    </a>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password-repeat">Retype Phone</label>
                                <div class="form-icon-wrapper">
                                    <input type="password" class="form-control" name="phone" id="password-repeat" placeholder="Enter password">
                                    <i class="form-icon-left mdi mdi-lock"></i>
<!--                                    <a href="#" class="form-icon-right password-show-hide" title="Hide or show password">
                                        <i class="mdi mdi-eye"></i>
                                    </a>-->
                                </div>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-block">Sign Up</button>
                            </div> 
                            <p class="text-center" style="font-style: bold; color: red;">Remember that password is your phone sign up.</p>
                            <p class="text-center">Do you already have an account? <a href="login">Sign in</a>.</p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Jquery -->
        <script src="../../provides/vendor/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../provides/vendor/bootstrap-4.5.3/js/bootstrap.min.js"></script>
        <!-- Latform scripts -->
        <script src="../../provides/js/latform.min.js"></script>
    </body>
</html>
