<%-- 
    Document   : login
    Created on : Jan 20, 2023, 9:47:25 PM
    Author     : GG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/loginform.css">
    </head>
    <body>
        <h2> Login and Register </h2>
        <div class="container" id="container" style="width: 790px; min-height: 530px;">
            <div class="form-container sign-up-container">
                <form class="sign-up" onsubmit="return formSubmit()" action="register" method="post" style="margin-top: 0%;">
                    <br>
                    <h1>Create Account</h1>
                    <input class="box" type="text"  name="fullname" placeholder="Full Name" required/> 	
                    <input class="box" type="text" id="username" name="username" placeholder="User Name" />	
                    <div id="validUsername"></div>
                    <input class="box" type="password" id="password" name="password" placeholder="Password" />
                    <div id="validPassword"></div>
                    <input class="box" type="password" id="rePassword" name="Repassword" placeholder="Repassword" />
                    <div id="validRePassword"></div>
                    <input class="box" type="text" id="email" name="email" placeholder="Email" />
                    <div id="validEmail"></div>
                    <button type="submit">Sign Up</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
<!--                <c:if test="${message != null }">
                    <div class="p-3 text-center bg-info">${message }</div>
                </c:if>-->

                <form class="sign-in" action="login" method="post">
                    <h1>Sign in</h1>
                    <span>or use your account</span>
                    <input class="box" type="text" name="email" placeholder="Username" />
                    <input class="box" type="password" name="phone" placeholder="Password" />
                    <a href="forgotpassword">Forgot your password?</a>
                    <button type="submit">Sign In</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <h6>To keep connected with us please login with your personal info</h6>
                        <button class="ghost" id="signIn">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <h6>Enter your personal details and start journey with us</h6>
                        <button class="ghost" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
