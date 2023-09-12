<%-- 
    Document   : DisplayProduct
    Created on : Mar 2, 2023, 3:18:27 PM
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
        <%int n = 0;%>
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
        <% n++; %>
    </c:forEach>   
    <br>
    <header>Have <%=n%> Products </header>
</body>
</html>
