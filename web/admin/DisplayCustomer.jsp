<%-- 
    Document   : DisplayCustomer
    Created on : Mar 4, 2023, 5:58:08 PM
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
        <title>JSP Page</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
        <style>
            body {
                background: #edf1f5;
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
                border-radius: 0;
            }

            .btn-circle.btn-lg,
            .btn-group-lg>.btn-circle.btn {
                width: 50px;
                height: 50px;
                padding: 14px 15px;
                font-size: 18px;
                line-height: 23px;
            }

            .text-muted {
                color: #8898aa !important;
            }

            [type=button]:not(:disabled),
            [type=reset]:not(:disabled),
            [type=submit]:not(:disabled),
            button:not(:disabled) {
                cursor: pointer;
            }

            .btn-circle {
                border-radius: 100%;
                width: 40px;
                height: 40px;
                padding: 10px;
            }

            .user-table tbody tr .category-select {
                max-width: 150px;
                border-radius: 20px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/admin/HeaderList.jsp"></jsp:include>
        <% 
        Vector<Customer> vector = (Vector<Customer>)request.getAttribute("list");
        %>
        <div>

            <div class="col-md-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-uppercase mb-0">Staff Manager</h5>

                    </div>
                    <div class="table-responsive">
                        <form action="AdminCustomer" method="post">
                            <div style="float: right">
                                <input type="hidden" name="service" value="searchCustomerName">
                                Search  <input type="text" name="name" value="" />
                                <input type="submit" value="Search" />
                            </div>
                        </form> 
                        <table class="table no-wrap user-table mb-0">
                            <thead>

                                <tr>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Name </th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Phone</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Email</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Street</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">City</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">State</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Zip Code</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Status</th>
                                    <th scope="col" class="border-0 text-uppercase font-medium">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Customer cust : vector) { %>
                                <tr>
                                    <td>
                                        <span class="text-muted"><%=cust.getFirst_name() + " " %> <%=cust.getLast_name() %></span><br>
                                        <span class="text-muted"></span>
                                    </td>
                                    <td>
                                        <span class="text-muted"><%=cust.getPhone() %></span><br>
                                        <span class="text-muted"></span>
                                    </td>
                                    <td>
                                        <span class="text-muted"><%=cust.getEmail() %></span><br>
                                        <span class="text-muted"></span>
                                    </td>
                                    <td>
                                        <span class="text-muted"><%=cust.getStreet() %></span><br>
                                        <span class="text-muted"></span>
                                    </td>
                                    <td>
                                        <span class="text-muted"><%=cust.getCity() %></span><br>
                                        <span class="text-muted"></span>
                                    </td>
                                    <td>
                                        <span class="text-muted"><%=cust.getState() %></span><br>
                                        <span class="text-muted"></span>
                                    </td>
                                    <td>
                                        <span class="text-muted"><%=cust.getZip_code() %></span><br>
                                        <span class="text-muted"></span>
                                    </td>
                                    <td>
                                        <span class="text-muted"><%=cust.getStatus() %></span><br>
                                        <span class="text-muted"></span>
                                    </td>
                                    <td>

                                        <a href="AdminCustomer?service=deleteCustomer&id=<%=cust.getCustomer_id()%>" class="btn btn-outline-danger"><i class="fa fa-trash"></i> Delete </a>
                                    </td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
            <jsp:include page="/admin/AdminFooter.jsp"></jsp:include>
    </body>
</html>
