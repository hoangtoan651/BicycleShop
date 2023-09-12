/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import DAO.DAOOrders;
import entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author GG
 */
public class ControllerAdminOrder extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOOrders dao = new DAOOrders();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         String service = request.getParameter("service");
            if(service == null){
                service = "displayAll";
            }
            if(service.equals("displayAll")){
              
                
                Vector<Orders> list = dao.listAll();
                ResultSet rs = dao.getData("select a.order_id, a.customer_id, a.order_status, a.order_date, a.required_date, a.shipped_date,\n"
                        + "	   b.first_name , b.last_name,c.store_name, d.first_name , d.last_name , a.status \n"
                        + "					from orders as a join customers as b on a.customer_id = b.customer_id \n"
                        + "					join stores as c on a.store_id = c.store_id\n"
                        + "					join staffs as d on d.staff_id = a.staff_id");
                request.setAttribute("listall", rs);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/admin/DisplayOrder.jsp").forward(request, response);
            }
            if(service.equals("insertOrder")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    ResultSet rs = dao.getData("select customer_id, (first_name + ' '+ last_name) from customers");
                    ResultSet rs1 = dao.getData("select store_id, store_name from stores");
                    ResultSet rs2 = dao.getData("select staff_id, (first_name + ' '+ last_name) from staffs");
                    request.setAttribute("rsCustomer", rs);
                    request.setAttribute("rsStore", rs1);
                    request.setAttribute("rsStaff", rs2);
                    request.getRequestDispatcher("/admin/AdminInsertOrder.jsp").forward(request, response);
                }else{
                    int order_id = 0;
                    ResultSet rs3 = dao.getData("select max(order_id) from orders");
                    if(rs3.next()){
                        order_id = rs3.getInt(1);
                    }
                    
                    int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                    int order_status = Integer.parseInt(request.getParameter("order_status"));
                    String order_date = request.getParameter("order_date");
                    String requied_date = request.getParameter("requied_date");
                    String shipped_date = request.getParameter("shipped_date");
                    int store_id = Integer.parseInt(request.getParameter("store_id"));
                    int staff_id = Integer.parseInt(request.getParameter("staff_id"));
                    int status = Integer.parseInt(request.getParameter("status"));

                    Orders orde = new Orders(order_id + 1, customer_id, order_status, order_date, requied_date, shipped_date, store_id, staff_id, status);
                    dao.addOrder(orde);
                    response.sendRedirect("AdminOrder");
                }
            }
            
            if(service.equals("updateOrder")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    int order_id = Integer.parseInt(request.getParameter("order_id"));
                    Vector<Orders> list = dao.getOrderbyID(order_id);
                    request.setAttribute("list", list);
                    ResultSet rs = dao.getData("select customer_id, (first_name + ' '+ last_name) from customers");
                    ResultSet rs1 = dao.getData("select store_id, store_name from stores");
                    ResultSet rs2 = dao.getData("select staff_id, (first_name + ' '+ last_name) from staffs");
                    
                    request.setAttribute("rsCustomer", rs);
                    request.setAttribute("rsStore", rs1);
                    request.setAttribute("rsStaff", rs2);
                    request.getRequestDispatcher("/admin/AdminUpdateOrder.jsp").forward(request, response);
                }else{
                    int order_id = Integer.parseInt(request.getParameter("order_id"));
                    int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                    int order_status = Integer.parseInt(request.getParameter("order_status"));
                    String order_date = request.getParameter("order_date");
                    String requied_date = request.getParameter("requied_date");
                    String shipped_date = request.getParameter("shipped_date");
                    int store_id = Integer.parseInt(request.getParameter("store_id"));
                    int staff_id = Integer.parseInt(request.getParameter("staff_id"));
                    int status = Integer.parseInt(request.getParameter("status"));

                    Orders order = new Orders(order_id, customer_id, order_status, order_date, requied_date, shipped_date, store_id, staff_id, status);
                    dao.updateOrder(order);
                    response.sendRedirect("AdminOrder");
                }
                
            }
            if(service.equals("searchStatus")){
                int status = Integer.parseInt(request.getParameter("status"));
                ResultSet rsSearch = dao.getData("select a.order_id, a.customer_id, a.order_status, a.order_date, a.required_date, a.shipped_date,\n"
                        + "	   b.first_name , b.last_name,c.store_name, d.first_name , d.last_name , a.status \n"
                        + "					from orders as a join customers as b on a.customer_id = b.customer_id \n"
                        + "					join stores as c on a.store_id = c.store_id\n"
                        + "					join staffs as d on d.staff_id = a.staff_id where a.status ="+status);
                request.setAttribute("listall", rsSearch);
                request.getRequestDispatcher("/admin/DisplayOrder.jsp").forward(request, response);
            }
            if(service.equals("deleteOrder")){
               int order_id = Integer.parseInt(request.getParameter("id"));
               dao.removeOrder(order_id);
               response.sendRedirect("AdminOrder");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }   
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
