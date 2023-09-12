<%-- 
    Document   : AdminUpdateOrder
    Created on : Mar 5, 2023, 10:56:47 PM
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
        <title>Update Order</title>
    </head>
    <body>
        <%
            Vector<Orders> vec = (Vector<Orders>)request.getAttribute("list");
            ResultSet rsStore = (ResultSet)request.getAttribute("rsStore");
            ResultSet rsCustomer = (ResultSet)request.getAttribute("rsCustomer");
            ResultSet rsStaff = (ResultSet)request.getAttribute("rsStaff");
            Orders o = vec.get(0);
        %>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">

                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Stocks Add Information</h4>
                        </div>
                        <form action="AdminOrder" method="post"> 
                            <input type="hidden" value="updateOrder" name="service">
                            <div class="col-md-12">
                            
                            </div> 
                            <div class="row mt-2">
                                <div class="col-md-12">
                                    <label class="labels">Order ID</label> <br>
                                     <input type="number" name="order_id" id="order_id" value="<%=o.getOrder_id()%>" readonly>
                                </div>
                                <div class="col-md-4">
                                    <label class="labels">Customer</label>
                                    <select name="customer_id" id="customer_id">
                                        <%while(rsCustomer.next()){%>
                                        <option value="<%=rsCustomer.getInt(1)%>" <%=(rsCustomer.getInt(1) == o.getCustomer_id() ? "selected" : "")%> ><%=rsCustomer.getString(2)%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Order Status </label>
                                    <input type="radio" name="order_status" value="1" <%=(o.getOrder_status() == 1 ? "Checked" : "")%>>Not Yet
                                    <input type="radio" name="order_status" value="2"<%=(o.getOrder_status()== 2 ? "Checked" : "")%>>Not Purchase
                                    <input type="radio" name="order_status" value="3"<%=(o.getOrder_status() == 3 ? "Checked" : "")%>>Purchased
                                    <input type="radio" name="order_status" value="4"<%=(o.getOrder_status()== 4 ? "Checked" : "")%>>Shipping
                                </div>
                            </div>
                            <div class="row mt-12">
                                <div class="col-md-4">
                                    <label class="labels">Order Date</label>
                                    <input type="text" name="order_date" id="order_date" value="<%=o.getOrder_date()%>">
                                </div>
                                
                                <div class="col-md-12">
                                    <label class="labels">Required Date</label>
                                    <input type="text" name="requied_date" id="requied_date"  value="<%=o.getRequied_date()%>">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Shipped Date</label>
                                    <input type="text" name="shipped_date" id="shipped_date"  value="<%=o.getShipped_date()%>">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Store</label>
                                    <select name="store_id" id="store_id">
                                        <%while(rsStore.next()){%>
                                        <option value="<%=rsStore.getInt(1)%>"<%=(rsStore.getInt(1) == o.getStore_id() ? "selected" :"")%>><%=rsStore.getString(2)%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Staff</label>
                                    <select name="staff_id" id="staff_id"> 
                                        <%while(rsStaff.next()){%>
                                        <option value="<%=rsStaff.getInt(1)%>"<%=(rsStaff.getInt(1) == o.getStaff_id() ? "selected" :"")%>><%=rsStaff.getString(2)%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Status</label>
                                    <input type="radio" name="status" value="1" <%=(o.getStatus() == 1 ? "Checked" : "")%> >Process
                                    <input type="radio" name="status" value="0" <%=(o.getStatus() == 0 ? "Checked" : "")%> >Done
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
