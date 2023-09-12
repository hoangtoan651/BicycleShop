<%-- 
    Document   : DisplayOrder
    Created on : Mar 4, 2023, 4:56:44 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOOrders"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.Orders"%>
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
            
            
            ResultSet rs = (ResultSet)request.getAttribute("listall");
            int n = 0;
            int m = 0;
        %>
         <jsp:include page="/admin/HeaderList.jsp"></jsp:include>
                   
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title text-uppercase mb-0">Staff Manager</h5>
                                
                            </div>
                            <div class="table-responsive">
                                <table class="table no-wrap user-table mb-0">
                                    <thead>
                                         <a href="AdminOrder?service=insertOrder" class="btn btn-info"> Add Orders</a>
                                        
                                         <form action="AdminOrder" method="post"  >
                                             <input type="hidden" name="service" value="searchStatus">
                                             <select style="width: 10%" name="status" onchange="this.form.submit()" class="form-select">
                                                 <option value="0">In progress</option>
                                                 <option value="1">Done  </option>
                                             </select>
                                         </form> 
                                            
                                        <tr>
                                            <th scope="col" class="border-0 text-uppercase font-medium pl-4">#</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Customer</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Order Status</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Order Date</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Required Date</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Shipped Date</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Store ID</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Staff ID</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Status</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%while(rs.next()){%>
                                        <tr>
                                           
                                            <td>
                                                <span class="pl-4"><%=rs.getInt(1)%></span>
                                                
                                            </td>
                                            <td>
                                                <h5 class="text-muted"><%=rs.getString(7) +" "%><%=rs.getString(8)%></h5><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=rs.getInt(3)%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=rs.getString(4)%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=rs.getString(5)%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=rs.getString(6)%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=rs.getString(9)%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=rs.getString(10) +" "%><%=rs.getString(11) +" "%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                             <td>
                                                 <% if(rs.getInt(12) == 1){ %>
                                                <span class="text-muted">Done</span><br>
                                                <% n++;}else{%>
                                                 <span class="text-muted">Inprogress</span><br>
                                                <% m++; }%>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <a href="AdminOrder?service=updateOrder&order_id=<%=rs.getInt(1)%>" class="btn btn-secondary"><i class="fa fa-pencil-square-o"></i> Update </a>
                                                <a href="AdminOrder?service=deleteOrder&order_id=<%=rs.getInt(1)%>" class="btn btn-outline-danger"><i class="fa fa-trash"></i> Delete </a>
                                            </td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
<!--                                    <div> Have <%=n%> Done and Have <%=m%> In Progress</div>     -->
                        </div>
                               
                    </div>
                                
                </div>
                                    
            </div>
                                                         
         <jsp:include page="/admin/AdminFooter.jsp"></jsp:include>
    </body>
</html>
