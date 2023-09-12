/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAOStocks;
import entity.Stocks;
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
public class ControllerAdminStocks extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DAOStocks dao = new DAOStocks();
            String service = request.getParameter("service");
            if (service == null) {
                service = "displayAll";
            }
            if (service.equals("displayAll")) {

//                Vector<Stocks> list = dao.listAll();
                ResultSet rsList = dao.getData("select b.store_id,b.product_id, c.store_name,a.product_name,b.quantity\n"
                        + "from products as a join stocks as b on a.product_id=b.product_id\n"
                        + "				join stores as c on b.store_id=c.store_id");
                ResultSet rs = dao.getData("select *from stores");
                ResultSet rs1 = dao.getData("select *from products");
                request.setAttribute("rsStore", rs);
                request.setAttribute("rsProduct", rs1);
                request.setAttribute("list", rsList);
                request.getRequestDispatcher("/admin/DisplayStock.jsp").forward(request, response);
            }
            if(service.equals("searchProduct")){
                int store = Integer.parseInt(request.getParameter("store"));
                ResultSet rsList = dao.getData("select b.store_id,b.product_id, c.store_name,a.product_name,b.quantity\n"
                        + "from products as a join stocks as b on a.product_id=b.product_id\n"
                        + "				join stores as c on b.store_id=c.store_id where c.store_id = "+store);
                ResultSet rs = dao.getData("select *from stores");
                ResultSet rs1 = dao.getData("select *from products");
                request.setAttribute("rsStore", rs);
                request.setAttribute("rsProduct", rs1);
                request.setAttribute("list", rsList);
                request.setAttribute("store", store);
                request.getRequestDispatcher("/admin/DisplayStock.jsp").forward(request, response);
            }
            if (service.equals("insertStock")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    ResultSet rs = dao.getData("select *from stores");
                    ResultSet rs1 = dao.getData("select *from products");
                    request.setAttribute("rsStore", rs);
                    request.setAttribute("rsProduct", rs1);
                    request.getRequestDispatcher("/admin/AdminInsertStocks.jsp").forward(request, response);
                } else {
                    int store_id = Integer.parseInt(request.getParameter("store_id"));
                    int product_id = Integer.parseInt(request.getParameter("product_id"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    Stocks stos = new Stocks(store_id, product_id, quantity);
                    int n = dao.addStock(stos);
                    response.sendRedirect("AdminStocks");
                }
            }
            
            
            
            if (service.equals("updateStock")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    int storeID = Integer.parseInt(request.getParameter("id"));
                    int productID = Integer.parseInt(request.getParameter("productID"));
                    ResultSet rsStock = dao.getData("select * from stocks "
                            + " where store_id=" + storeID + " and product_id=" + productID + "");
                    ResultSet rs = dao.getData("select *from stores");
                    ResultSet rs1 = dao.getData("select *from products");
                    request.setAttribute("list", rsStock);
                    request.setAttribute("rsStore", rs);
                    request.setAttribute("rsProduct", rs1);
                    request.getRequestDispatcher("/admin/AdminUpdateStocks.jsp").forward(request, response);
                } else {
                    int store_id = Integer.parseInt(request.getParameter("store_id"));
                    int product_id = Integer.parseInt(request.getParameter("product_id"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    Stocks sto = new Stocks(store_id, product_id, quantity);
                    dao.updateStock(sto);
                    response.sendRedirect("AdminStocks");

                }
            }
            if (service.equals("deleteStock")) {
                int stock_id = Integer.parseInt(request.getParameter("id"));
                int product_id = Integer.parseInt(request.getParameter("productID"));
                dao.removeStock(stock_id, product_id);
                response.sendRedirect("AdminStocks");
            }

        } catch (Exception e) {
            e.printStackTrace();
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
