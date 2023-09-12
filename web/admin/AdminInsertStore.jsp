<%-- 
    Document   : AdminInsertStore
    Created on : Mar 4, 2023, 10:54:14 PM
    Author     : GG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.DAOStores"%>
<%@page import="entity.Stores"%>
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
        <title>Add Store</title>
    </head>
    <body>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-3 border-right">
                   
                </div>
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Store Add Information</h4>
                        </div>
                        <form action="AdminStore" method="post"> 
                            <input  type="hidden" value="insertStore" name="service">
                            <div class="row mt-2">
                                <div class="col-md-4">
                                    <label class="labels">Store ID </label>
                                    <input type="number" name="store_id" id="store_id" class="form-control" value="">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Store Name</label>
                                    <input type="text" name="store_name" id="store_name" class="form-control" value="" >
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">Phone</label>
                                    <input type="text" class="form-control" name="phone" id="phone" value="">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Email</label>
                                    <input type="text" class="form-control" name="email" id="email" value="">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Street</label>
                                    <input type="text" class="form-control" name="street" id="street" value="">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">City</label>
                                    <input type="text" class="form-control"  name="city" id="city" value="">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">State</label>
                                    <input type="text" class="form-control" name="state" id="state" value="">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Zip Code</label>
                                    <input type="text" class="form-control" name="zip_code" id="zip_code" value="">
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
