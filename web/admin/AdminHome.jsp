<%-- 
    Document   : AdminHome
    Created on : Mar 1, 2023, 9:43:03 AM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Home</title>
    </head>
    <body>
        <jsp:include page="/admin/AdminHeader.jsp"></jsp:include>
            <div class="container-fluid pt-5">
                <div class="text-center mb-4">
                    <h2 class="section-title px-5"><span class="px-2">All Products</span></h2>
                </div>
                <div class="row px-xl-5 pb-3">
                <jsp:include page="/admin/DisplayProduct.jsp"></jsp:include>
                </div>
            </div>
                
                
                
        <jsp:include page="/admin/AdminFooter.jsp"></jsp:include>
    </body>
</html>
