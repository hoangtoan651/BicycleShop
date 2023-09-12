<%-- 
    Document   : DisplayStaff
    Created on : Mar 3, 2023, 4:25:37 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOStaff"%>
<%@page import="entity.Staffs"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Staff</title>
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
            
            Vector<Staffs> vector = (Vector<Staffs>)request.getAttribute("list");
            ResultSet rsManager = (ResultSet)request.getAttribute("rsManager");
            ResultSet rsStore = (ResultSet)request.getAttribute("rsStore");
            
        %>
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
                                         <a href="AdminStaff?service=InsertStaff" class="btn btn-info"> Add Staff</a>
                                        
                                         <form action="AdminStaff" method="post" >
                                             <div style="float: right">
                                                 <input type="hidden" name="service" value="searchStaff">
                                                 Search  <input type="text" name="name" value="" />
                                                 <input type="submit" value="Search" />
                                             </div>
                                         </form>
                                          
                                        <tr>
                                            <th scope="col" class="border-0 text-uppercase font-medium pl-4">#</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Name</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Email</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Phone</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Active</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Store</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Manageer</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Status</th>
                                            <th scope="col" class="border-0 text-uppercase font-medium">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Staffs staffs : vector) {%>
                                        <tr>
                                           
                                            <td>
                                                <span class="pl-4"><%=staffs.getStaff_id()%></span>
                                                
                                            </td>
                                            <td>
                                                <h5 class="text-muted"><%=staffs.getFirst_name() +" "%><%=staffs.getLast_name()%></h5><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=staffs.getEmail()%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=staffs.getPhone()%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=staffs.getActive()%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=staffs.getStore_id()%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=staffs.getManager_id()%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <span class="text-muted"><%=staffs.getStatus()%></span><br>
                                                <span class="text-muted"></span>
                                            </td>
                                            <td>
                                                <a href="AdminStaff?service=deleteStaff&id=<%=staffs.getStaff_id()%>" class="btn btn-outline-danger"><i class="fa fa-trash"></i> Delete </a>
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
        
    </body>
</html>
