<%-- 
    Document   : AdminInsertStaff
    Created on : Mar 3, 2023, 11:04:48 PM
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
        <title>Insert Staff</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <style>
            body {
                background: rgb(99, 39, 120)
            }

            .form-control:focus {
                box-shadow: none;
                border-color: #BA68C8
            }

            .profile-button {
                background: rgb(99, 39, 120);
                box-shadow: none;
                border: none
            }

            .profile-button:hover {
                background: #682773
            }

            .profile-button:focus {
                background: #682773;
                box-shadow: none
            }

            .profile-button:active {
                background: #682773;
                box-shadow: none
            }

            .back:hover {
                color: #682773;
                cursor: pointer
            }

            .labels {
                font-size: 11px
            }

            .add-experience:hover {
                background: #BA68C8;
                color: #fff;
                cursor: pointer;
                border: solid 1px #BA68C8
            }
        </style>
    </head>
    <body>
        <%
            ResultSet rsStore = (ResultSet)request.getAttribute("rsStore");
            ResultSet rsManager = (ResultSet)request.getAttribute("rsManager");
        %>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">
                   
                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <form action="AdminStaff" method="post"> 
                            <input  type="hidden" value="InsertStaff" name="service">
                            <div class="row mt-2">
                                <div class="col-md-4">
                                    <label class="labels">First Name</label>
                                    <input type="text" name="first_name" id="first_name" class="form-control" value="">
                                </div>
                                <div class="col-md-4">
                                    <label class="labels">Last Name</label>
                                    <input type="text" class="form-control" name="last_name" id="last_name" value="" >
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">Mobile Number</label>
                                    <input type="text" class="form-control" name="phone" id="phone" value="">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Email</label>
                                    <input type="text" class="form-control" name="email" id="email" value="">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Active</label>
                                    <input type="radio"  name="active" value="1">Active
                                    <input type="radio"  name="active" value="0">DeActive
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Store</label>
                                    <select class="form-control" name="store_id" id="store_id">
                                        <%while (rsStore.next()) {%>
                                        <option  value="<%=rsStore.getInt(1)%>"><%=rsStore.getString(2)%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label  class="labels">Manager</label>
                                    <select class="form-control" name="manager_id" id="manager_id">
                                        <%while (rsManager.next()) {%>
                                        <option value="<%=rsManager.getInt(1) %>"> <%=rsManager.getString(2) + " "%> <%=rsManager.getString(3) + " "%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Status</label>
                                    <input type="radio" name="status" value="1">Present
                                    <input type="radio" name="status" value="0">Absent
                                </div>
                                <div class="mt-5 text-center">
                                    <button class="btn btn-primary profile-button" name="submit" type="submit">Save</button>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>

</body>
</html>
