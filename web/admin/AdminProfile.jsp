<%-- 
    Document   : AdminProfile
    Created on : Mar 2, 2023, 4:27:44 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Staffs"%>
<%@page import="DAO.DAOStaff"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <title>Profile</title>
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
            Vector<Staffs> vec = (Vector<Staffs>)request.getAttribute("list");
            ResultSet rsStore = (ResultSet)request.getAttribute("rsStore");
            ResultSet rsManager = (ResultSet)request.getAttribute("rsManager");
            Staffs sta = vec.get(0);
        %>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold"><%=sta.getFirst_name() + " "%> <%=sta.getLast_name()%></span><span class="text-black-50"><%=sta.getEmail()%></span><span> </span></div>
                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <form action="AdminHome" method="post">
                            <input  type="hidden" value="updateStaff" name="service">
                        <div class="row mt-2">
                            <div class="col-md-4">
                                <label for="staff_id" class="labels">Staff ID</label>
                                <input type="number" name="staff_id" id="staff_id" class="form-control" value="<%=sta.getStaff_id()%>" readonly>
                            </div>
                            <div class="col-md-4">
                                <label class="labels">First Name</label>
                                <input type="text" name="first_name" id="first_name" class="form-control" value="<%=sta.getFirst_name()%>">
                            </div>
                            <div class="col-md-4">
                                <label class="labels">Last Name</label>
                                <input type="text" class="form-control" name="last_name" id="last_name" value="<%=sta.getLast_name()%>" >
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12">
                                <label class="labels">Mobile Number</label>
                                <input type="text" class="form-control" name="phone" id="phone" value="<%=sta.getPhone()%>" readonly>
                            </div>
                            <div class="col-md-12">
                                <label class="labels">Email</label>
                                <input type="text" class="form-control" name="email" id="email" value="<%=sta.getEmail()%>"readonly>
                            </div>
                            <div class="col-md-12">
                                <label class="labels">Active</label>
                                <input type="radio"  name="active" value="1" <%=sta.getActive() == 1 ? "Checked" : ""%> >Active
                                <input type="radio"  name="active" value="0" <%=sta.getActive() == 0 ? "Checked" : ""%>>DeActive
                                <!--          Tý check lại cái Active này                       -->
                            </div>
                            <div class="col-md-12">
                                <label class="labels">Store</label>
                                <select class="form-control" name="store_id" id="store_id">
                                    <%while (rsStore.next()) {%>
                                    <option  value="<%=rsStore.getInt(1)%>" <%=sta.getStore_id() ==  rsStore.getInt(1) ? "selected" : ""%>><%=rsStore.getString(2)%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <label  class="labels">Manager</label>
                                <select class="form-control" name="manager_id" id="manager_id">
                                    <%while (rsManager.next()) {%>
                                    <option value="<%=rsManager.getInt(1) %>" <%=rsManager.getInt(1) == sta.getManager_id() ? "selected" : "" %>> <%=rsManager.getString(2)%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="col-md-12">
                                <label class="labels">Status</label>
                                <input type="radio" name="status" value="1" <%=sta.getStatus() == 1 ? "Checked" : ""%>>Present
                                <input type="radio" name="status" value="0" <%=sta.getStatus() == 0 ? "Checked" : "" %>>Absent
                            </div>
                        <div class="mt-5 text-center">
                            <button class="btn btn-primary profile-button" name="update" type="submit">Save Profile</button>
                        </div>
                        </form>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
</div>
</body>
</html>
