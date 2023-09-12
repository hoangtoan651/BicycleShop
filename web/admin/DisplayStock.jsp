<%-- 
    Document   : DisplayStock
    Created on : Mar 4, 2023, 4:56:58 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOStocks"%>
<%@page import="entity.Stocks"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
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
        <%
        ResultSet rsStore = (ResultSet)request.getAttribute("rsStore");
        ResultSet rsProduct = (ResultSet)request.getAttribute("rsProduct");
        ResultSet rs = (ResultSet)request.getAttribute("list");
        int storecheck = (int)request.getAttribute("store");
        
        %>
        <jsp:include page="/admin/HeaderList.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title text-uppercase mb-0">Staff Manager</h5>

                            </div>
                            <div class="table-responsive">
                                <table class="table no-wrap user-table mb-0">
                                    <thead>
                                    <a href="AdminStocks?service=insertStock" class="btn btn-info"> Add Stocks</a>
                                    <form action="AdminStocks" method="post"  >
                                        <div style="float: right">
                                            <input type="hidden" name="service" value="searchProduct"> 
                                            <select  name="store" onchange="this.form.submit()" class="form-select">
                                               
                                                <%while(rsStore.next()){%>
                                                 <option value="<%=rsStore.getInt(1)%>" <%=(rsStore.getInt(1) == storecheck) ?"selected":""%> ><%=rsStore.getString(2)%></option>
                                                 <%}%>
                                             </select>
                                        </div>
                                    </form> 

                                    <tr>

                                        <th scope="col" class="border-0 text-uppercase font-medium">Store</th>
                                        <th scope="col" class="border-0 text-uppercase font-medium">Product</th>
                                        <th scope="col" class="border-0 text-uppercase font-medium">Quantity</th>
                                        <th scope="col" class="border-0 text-uppercase font-medium">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% while (rs.next()) {%>
                                    <tr>

                                        <td>
                                            <span class="pl-4"><%=rs.getString(3)%></span>

                                        </td>

                                        <td>
                                            <span class="pl-4"><%=rs.getString(4)%></span><br>
                                            <span class="text-muted"></span>
                                        </td>
                                        <td>
                                            <span class="pl-4"><%=rs.getInt(5)%></span><br>
                                            <span class="pl-4"></span>
                                        </td>
                                        <td>
                                            <a href="AdminStocks?service=updateStock&id=<%=rs.getInt(1)%>&productID=<%=rs.getInt(2)%>" class="btn btn-secondary"><i class="fa fa-pencil-square-o"></i> Update </a>
                                            <a href="AdminStocks?service=deleteStock&id=<%=rs.getInt(1)%>&productID=<%=rs.getInt(2)%>" class="btn btn-outline-danger"><i class="fa fa-trash"></i> Delete </a>
                                        </td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/admin/AdminFooter.jsp"></jsp:include>
    </body>
</html>
