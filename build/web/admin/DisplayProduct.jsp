<%-- 
    Document   : DisplayProduct
    Created on : Mar 2, 2023, 10:42:00 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:forEach items="${product}" var="l">
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="card product-item border-0 mb-4">
                    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                        <img class="img-fluid w-100" src="${l.image}" alt="">

                    </div>
                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                        <h6 class="text-truncate mb-3">${l.product_name}</h6>
                        <div class="d-flex justify-content-center">
                            <h6>${l.list_price}</h6>
                            <h6 class="text-muted ml-2"></h6>
                        </div>
                    </div>
                    <div class="card-footer d-flex justify-content-between bg-light border">
                        <c:choose>
                            <c:when test="${staff != null }">
                                <a href="AdminHome?service=updateProduct&productID=${l.product_id}" class="btn btn-sm text-dark p-0"><i class="fa fa-wrench text-primary mr-1"></i>Update</a>
                                <a href="AdminHome?service=deleteProduct&productID=${l.product_id}" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Delete</a>
                            </c:when>
                            <c:otherwise>
                                 <a href="loginAdmin" class="btn btn-sm text-dark p-0"><i class="fa fa-wrench text-primary mr-1"></i>Update</a>
                                 <a href="loginAdmin" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Delete</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:forEach>

    </body>
</html>
