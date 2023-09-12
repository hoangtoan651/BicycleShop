/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.DAOOderItems;
import DAO.DAOOrders;
import entity.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import DAO.DAOProducts;
import DAO.DAOStaff;
import DAO.DAOStocks;
import entity.Customer;
import entity.OrderItems;
import entity.Orders;
import entity.Staffs;
import entity.Stocks;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author GG
 */
public class ControllerProducts extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DAOProducts dao = new DAOProducts();
            DAOStaff daostaff = new DAOStaff();
            DAOOrders daooder = new DAOOrders();
            DAOOderItems daoitem = new DAOOderItems();
            DAOStocks daostock = new DAOStocks();
            String service = request.getParameter("service");
            int allpro = 0;
            if (session.getAttribute("user") != null) {
                Customer cus = (Customer) session.getAttribute("user");
                allpro = dao.CountCart(cus.getCustomer_id());
                session.setAttribute("countproduct", allpro);
            }
            if (service == null) {
                service = "displayAll";
            }
            if (service.equals("displayAll")) {

                session.setAttribute("ids", Integer.parseInt(request.getParameter("idStore")));
                String cname = "";
                String search = "";
                //session.removeAttribute("cname");
                int ids = (int) session.getAttribute("ids");

                if (request.getParameter("search") != null) {
                    session.setAttribute("search", request.getParameter("search"));
                    search = (String) session.getAttribute("search");
                }

                if (request.getParameter("cname") != null) {
                    session.setAttribute("cname", request.getParameter("cname"));
                    cname = (String) session.getAttribute("cname");
                }

                if (request.getParameter("staffid") != null) {
                    int staffid = Integer.parseInt(request.getParameter("staffid"));
                    //  Staffs st = daostaff.getStaffbyID(staffid);
                    session.setAttribute("staffid", staffid);
                }
                Vector<Staffs> liststaff = daostaff.getStaffByStore(ids);
                session.setAttribute("liststaff", liststaff);
                Vector<String> listcate = dao.getCategory(ids);
                session.setAttribute("liscate", listcate);
                Vector<Products> product = dao.listAllJoin(ids, cname, search);
                //Paging 
                int numPerPage = 20;
                int page;//current page
                if (request.getParameter("page") == null) {
                    page = 1;
                } else {
                    page = Integer.parseInt(request.getParameter("page"));
                }
                int size = product.size();
                int num = (size % numPerPage == 0 ? (size / numPerPage) : ((size / numPerPage) + 1)); //number of pages
                int start, end;
                start = (page - 1) * numPerPage;
                end = Math.min(page * numPerPage, size);
                Vector<Products> contains = dao.listToPage(product, start, end);
                request.setAttribute("size", size);
                request.setAttribute("page", page);
                request.setAttribute("num", num);
                request.setAttribute("product", contains);
                //end paging
                request.setAttribute("searched", search);
                request.getRequestDispatcher("Shop.jsp").forward(request, response);
            }
            if (service.equals("displayProductdetail")) {
                String pid = request.getParameter("cname");
                Vector<Products> product = dao.getAll("select *from products where category_name ='" + pid + "'");
                ResultSet rs = dao.getData("select DISTINCT category_name from products");
                request.setAttribute("product", product);
                request.setAttribute("data", rs);
                request.getRequestDispatcher("Shop.jsp").forward(request, response);
            }

            if (service.equals("addToCart")) {

                if (session.getAttribute("user") != null) {
                    Customer cus = (Customer) session.getAttribute("user");
                    int idpro = Integer.parseInt(request.getParameter("proID"));
                    int storeid = Integer.parseInt(request.getParameter("idStore"));
                    String cname = request.getParameter("cname");
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    String datenow = df.format(date);

                    if (session.getAttribute("staffid") == null) {
                        response.sendRedirect("ViewProduct?service=displayAll&idStore=" + storeid + "&cname=" + cname);
                    } else {
                        int staffid = (int) session.getAttribute("staffid");
                        //check order exist or not
                        Orders o = daooder.getOrder(storeid, cus.getCustomer_id(), staffid);
                        Products pro = dao.getProductById(idpro);
                        if (o.getOrder_id() == 0) {
                            Orders od = new Orders(daooder.count(), cus.getCustomer_id(), 1, datenow, datenow, "", storeid, staffid, 0);
                            daooder.addOrder(od);
                            o = daooder.getOrder(storeid, cus.getCustomer_id(), staffid);
                            OrderItems i = daoitem.getItem(o.getOrder_id(), idpro);
                            if (i.getOrder_id() == 0) {
                                int iditem = daoitem.count(o.getOrder_id());
                                OrderItems oitem = new OrderItems(o.getOrder_id(), iditem, pro.getProduct_id(), 1, pro.getList_price(), 0);
                                daoitem.addOrderItems(oitem);
                            } else {
                                OrderItems oitem = new OrderItems(o.getOrder_id(), i.getItem_id(), pro.getProduct_id(), i.getQuantity() + 1, pro.getList_price(), 0);
                                daoitem.updateOrderItems(oitem);
                            }
                        } else {
                            OrderItems i = daoitem.getItem(o.getOrder_id(), idpro);
                            if (i.getOrder_id() == 0) {
                                int iditem = daoitem.count(o.getOrder_id());
                                //discount need to add after
                                OrderItems oitem = new OrderItems(o.getOrder_id(), iditem, pro.getProduct_id(), 1, pro.getList_price(), 0);
                                daoitem.addOrderItems(oitem);
                            } else {
                                OrderItems oitem = new OrderItems(o.getOrder_id(), i.getItem_id(), pro.getProduct_id(), i.getQuantity() + 1, pro.getList_price(), 0);
                                daoitem.updateOrderItems(oitem);
                            }

                            o = new Orders(o.getOrder_id(), o.getCustomer_id(), 1, o.getOrder_date(), datenow, datenow, o.getStore_id(), o.getStaff_id(), o.getStatus());
                            daooder.updateOrder(o);
                        }

                        if (session.getAttribute("detailPro") == null) {
                            response.sendRedirect("ViewProduct?service=displayAll&idStore=" + storeid + "&cname=" + cname + "&staffid=" + staffid);
                        } else {
                            Products productReturn = (Products) session.getAttribute("detailPro");
                            response.sendRedirect("ViewProduct?service=detailProductID&id=" + productReturn.getProduct_id());
                        }
                        session.removeAttribute("detailPro");
                    }

                } else {
                    response.sendRedirect("login");
                }
            }
            if (service.equals("cart")) {
                if (session.getAttribute("user") != null) {
                    Customer cus = (Customer) session.getAttribute("user");
                    //Update staff by filter
                    //String staffid = "";
                    //Get All price of product in cart
                    double all = dao.getAllPrice(cus.getCustomer_id());
                    session.setAttribute("all", all);
                    Vector<Products> listcart = dao.listCart(cus.getCustomer_id(), "");

                    session.setAttribute("listcart", listcart);
                    request.getRequestDispatcher("Cart.jsp").forward(request, response);
                } else {
                    response.sendRedirect("login");
                }

            }

            if (service.equals("deitem")) {
                int oid = Integer.parseInt(request.getParameter("deoid"));
                int iid = Integer.parseInt(request.getParameter("deiid"));
                daoitem.removeOrderItem(oid, iid);
                response.sendRedirect("ViewProduct?service=cart");
            }

            if (service.equals("Dequantity")) {
                int oid = Integer.parseInt(request.getParameter("minusOrder"));
                int iid = Integer.parseInt(request.getParameter("minusItem"));
                OrderItems item = daoitem.getItemByOidIid(oid, iid);
                if (item.getQuantity() == 1) {
                    daoitem.removeOrderItem(oid, iid);
                } else {
                    OrderItems o = new OrderItems(item.getOrder_id(), item.getItem_id(), item.getProduct_id(), item.getQuantity() - 1, item.getList_price(), item.getDiscount());
                    daoitem.updateOrderItems(o);
                }
                response.sendRedirect("ViewProduct?service=cart");
            }
            if (service.equals("detailProductID")) {
                int pid = Integer.parseInt(request.getParameter("id"));
                Products detailPro = dao.getProductById(pid);
                session.setAttribute("detailPro", detailPro);
                request.getRequestDispatcher("DetailProduct.jsp").forward(request, response);
            }
            if (service.equals("Asquantity")) {
                int oid = Integer.parseInt(request.getParameter("asoid"));
                int iid = Integer.parseInt(request.getParameter("asiid"));
                OrderItems item = daoitem.getItemByOidIid(oid, iid);
                //item.setQuantity(item.getQuantity() + 1);
                OrderItems o = new OrderItems(item.getOrder_id(), item.getItem_id(), item.getProduct_id(), item.getQuantity() + 1, item.getList_price(), item.getDiscount());
                daoitem.updateOrderItems(o);
                response.sendRedirect("ViewProduct?service=cart");
            }

            if (service.equals("checkout")) {
                if (session.getAttribute("user") != null) {
                    request.getRequestDispatcher("CheckOut.jsp").forward(request, response);
                } else {
                    response.sendRedirect("login");
                }

            }
            if (service.equals("Payment")) {
                if (session.getAttribute("user") != null) {
                    Customer cus = (Customer) session.getAttribute("user");
                    Vector<Products> listcart = dao.listCart(cus.getCustomer_id(), "");
                    Vector<Orders> listOrder = daooder.getOrderbyCusID(cus.getCustomer_id());
                    for (Products products : listcart) {
                        Orders ord = daooder.getOrderById(products.getOrderid());
                        ord.setStatus(1);
                        daooder.updateOrder(ord);
                        Stocks sto = daostock.getStockByOrder(ord.getStore_id(), products.getProduct_id());
                        sto.setQuantity(sto.getQuantity() - products.getQuantity());
                        daostock.updateStock(sto);
                    }
                    response.sendRedirect("homepage");
                } else {
                    response.sendRedirect("login");
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
