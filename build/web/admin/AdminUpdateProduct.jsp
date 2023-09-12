<%-- 
    Document   : AdminUpdateProduct
    Created on : Mar 12, 2023, 4:54:44 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOProducts"%>
<%@page import="entity.Products"%>
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
        <title>Update Product</title>
    </head>
    <body>
        <%
            DAOProducts dao = new DAOProducts();
            Vector<Products> vec = (Vector<Products>)request.getAttribute("product");
//            Vector<Products> list = dao.listAll();
            ResultSet rsCate = (ResultSet)request.getAttribute("list");
            Products pro = vec.get(0);
        %>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">

                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Product Update Information</h4>
                        </div>
                        <form action="AdminHome" method="post"> 
                            <input  type="hidden" value="updateProduct" name="service">
                            <div class="row mt-2">
                                <div class="col-md-12">
                                    <label class="labels">Product ID</label>
                                    <input type="text" name="product_id" id="product_id" class="form-control" value="<%=pro.getProduct_id()%>" readonly>
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Product Name</label>
                                    <input type="text" name="product_name" id="product_name" class="form-control" value="<%=pro.getProduct_name()%>">
                                </div>
                                <div class="col-md-4">
                                    <label class="labels">Model Year</label>
                                    <input type="number" name="model_year" id="model_year" class="form-control" value="<%=pro.getModel_year()%>" >
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-4">
                                    <label class="labels">List Price</label>
                                    <input type="number" class="form-control" name="list_price" id="list_price" value="<%=pro.getList_price()%>">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Brand Name</label>
                                    <input type="text" class="form-control" name="brand_name" id="brand_name" value="<%=pro.getBrand_name()%>">
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-12">
                                        <label class="labels">Category Name</label>
                                        <select name="category_name" id="category_name">
                                            <%while(rsCate.next()){%>
                                            <option value="<%=rsCate.getString(1)%>" <%=(rsCate.getString(1).equals(pro.getCategory_name())? "selected" : "")%>><%=rsCate.getString(1)%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-12">
                                        <label class="labels">Image</label>
                                        <input accept=".jpg, .jpeg, .png, .svg" class="form-control" type="file" name="image" value="<%=pro.getImage()%>">
                                    </div>

                                    <div class="mt-5 text-center">
                                        <button class="btn btn-primary profile-button" name="submit" type="submit">Save</button>
                                    </div>
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
