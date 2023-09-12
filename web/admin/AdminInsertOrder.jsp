<%-- 
    Document   : AdminInsertOrder
    Created on : Mar 5, 2023, 10:42:31 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOOrders"%>
<%@page import="entity.Orders"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>Add Stock</title>
    </head>
    <body>
        <%
            ResultSet rsStore = (ResultSet)request.getAttribute("rsStore");
            ResultSet rsCustomer = (ResultSet)request.getAttribute("rsCustomer");
            ResultSet rsStaff = (ResultSet)request.getAttribute("rsStaff");
        
        %>
       <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">
                   
                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Order Add Information</h4>
                        </div>
                        <form action="AdminOrder" method="post"> 
                            <input type="hidden" value="insertOrder" name="service">
                            <div class="row mt-2">
                                <div class="col-md-4">
                                    <label class="labels">Customer</label>
                                    <select name="customer_id" id="customer_id">
                                        <%while(rsCustomer.next()){%>
                                        <option value="<%=rsCustomer.getInt(1)%>"><%=rsCustomer.getString(2)%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Order Status </label>
                                    <input type="radio" name="order_status" value="1">Not Yet
                                    <input type="radio" name="order_status" value="2">Not Purchase
                                    <input type="radio" name="order_status" value="3">Purchased
                                    <input type="radio" name="order_status" value="4">Shipping
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">Order Date</label>
                                    <input type="text" name="order_date" id="order_date" >
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Required Date</label>
                                    <input type="text" name="requied_date" id="requied_date">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Shipped Date</label>
                                    <input type="text" name="shipped_date" id="shipped_date">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Store</label>
                                    <select name="store_id" id="store_id">
                                        <%while(rsStore.next()){%>
                                        <option value="<%=rsStore.getInt(1)%>"><%=rsStore.getString(2)%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Staff</label>
                                    <select name="staff_id" id="staff_id">
                                        <%while(rsStaff.next()){%>
                                        <option value="<%=rsStaff.getInt(1)%>"><%=rsStaff.getString(2)%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Status</label>
                                    <input type="radio" name="status" value="1">Active
                                    <input type="radio" name="status" value="0">DeActive
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
