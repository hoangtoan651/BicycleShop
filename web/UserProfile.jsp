<%-- 
    Document   : UserProfile
    Created on : Mar 2, 2023, 2:59:15 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import=" DAO.DAOCustomer"%>
<%@page import="entity.Customer" %>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
        <style>
            body {
                background: #f7f7ff;
                margin-top: 20px;
            }

            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid transparent;
                border-radius: .25rem;
                margin-bottom: 1.5rem;
                box-shadow: 0 2px 6px 0 rgb(218 218 253 / 65%), 0 2px 6px 0 rgb(206 206 238 / 54%);
            }

            .me-2 {
                margin-right: .5rem !important;
            }
            active{
                color:red;
            }
        </style>
        <title>User Profile</title>
    </head>
    <body>
        <%
            Vector<Customer> vec = (Vector<Customer>)request.getAttribute("list");
            Customer cus = vec.get(0);
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="main-body">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex flex-column align-items-center text-center">
                                        <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Admin"
                                             class="rounded-circle p-1 bg-primary" width="110">
                                        <div class="mt-3">
                                            <h4><%=cus.getFirst_name()%> <%=cus.getLast_name()%></h4>
                                            <p class="text-secondary mb-1"></p>
                                            <p class="text-muted font-size-sm"><%=cus.getStreet()%>, <%=cus.getCity()%>, <%=cus.getState()%> </p>
                                        </div>
                                    </div>
                                    <hr class="my-4">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="card">
                                <form action="ControllerUpdateProfile" method="post">
                                    <input type="hidden" name="service" value="proFile">
                                    <div class="card-body">
                                        <div class="row mb-3">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Customer ID</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="number" name="customer_id" class="form-control" value="<%=cus.getCustomer_id()%>" readonly>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">First Name</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="first_name" class="form-control" value="<%=cus.getFirst_name()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Last Name</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="last_name" class="form-control" value="<%=cus.getLast_name()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Email</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="email" class="form-control" value="<%=cus.getEmail()%>" readonly>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Phone</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="phone" class="form-control" value="<%=cus.getPhone()%>" readonly>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Street</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="street" class="form-control" value="<%=cus.getStreet()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">City</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="city" class="form-control" value="<%=cus.getCity()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">State</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="state" class="form-control" value="<%=cus.getState()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Zip Code</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="zip_code" class="form-control" value="<%=cus.getZip_code()%>">
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Status</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <p class="active"><input  type="radio" name="status" id="status" value="1"<%=cus.getStatus() == 1 ? "Checked" : ""%>>Active
                                           <input  type="radio" name="status" id="status" value="0" <%=cus.getStatus() == 0 ? "Checked" : ""%>>DeActive</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3"></div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="submit" class="btn btn-primary px-4" name="submit" value="Save Changes">
                                        </div>
                                    </div>
                                </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
