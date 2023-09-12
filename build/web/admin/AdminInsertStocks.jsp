<%-- 
    Document   : AdminInsertStocks
    Created on : Mar 4, 2023, 11:06:29 PM
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
        <title>Stock</title>
    </head>
    <body>
        <%
            ResultSet rsStore = (ResultSet)request.getAttribute("rsStore");
            ResultSet rsProduct = (ResultSet)request.getAttribute("rsProduct");
        
        %>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">

                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Store Add Information</h4>
                        </div>
                        <form action="AdminStocks" method="post"> 
                            <input  type="hidden" value="insertStock" name="service">
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">Store ID </label>
                                    <select name="store_id" id="store_id">
                                        <%while(rsStore.next()) {%>
                                        <option value="<%=rsStore.getInt(1)%>"> <%=rsStore.getString(2)%> </option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Product </label>
                                    <select name="product_id" id="product_id">
                                        <%while (rsProduct.next()){%>
                                        <option value="<%=rsProduct.getInt(1)%>"><%=rsProduct.getString(2)%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-md-6">
                                    <label class="labels">Quantity</label>
                                    <input class="form-control" type="number" name="quantity" id="quantity" value="">
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
