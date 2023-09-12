/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import DAO.DAOStores;
import entity.Stores;
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
public class ControllerAdminStore extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            DAOStores dao = new DAOStores();
            /* TODO output your page here. You may use following sample code. */
           String service = request.getParameter("service");
            if (service == null) {
                service = "displayAll";
            }
            if (service.equals("displayAll")) {
                Vector<Stores> list = dao.listAll();
                request.setAttribute("list", list);
                request.getRequestDispatcher("/admin/DisplayStore.jsp").forward(request, response);
            }
            if(service.equals("insertStore")){
                String submit = request.getParameter("submit");
                if(submit ==  null){
                    request.getRequestDispatcher("/admin/AdminInsertStore.jsp").forward(request, response);
                }else{
                    int store_id = 0; 
                    ResultSet rs = dao.getData("select max(store_id) from stores");
                    if(rs.next()){
                      store_id = rs.getInt(1);
                    }
//                    int store_id = Integer.parseInt(request.getParameter("store_id"));
                    String store_name = request.getParameter("store_name");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String street = request.getParameter("street");
                    String city = request.getParameter("city");
                    String state = request.getParameter("state");
                    String zip_code = request.getParameter("zip_code");
                    Stores stos = new Stores(store_id +1, store_name, phone, email, street, city, state, zip_code);
                    int n = dao.addStore(stos);
                    response.sendRedirect("AdminStore");
                }
            }
            if(service.equals("deleteStore")){
                int store_id = Integer.parseInt(request.getParameter("id"));
                dao.removeStore(store_id);
                response.sendRedirect("AdminStore");
            }
            if(service.equals("searchStoreName")){
                String name = request.getParameter("name");
                Vector<Stores> listStore = dao.searchStorename(name);
                request.setAttribute("list", listStore);
                request.getRequestDispatcher("/admin/DisplayStore.jsp").forward(request, response);
            }
            if(service.equals("updateStore")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    int store_id = Integer.parseInt(request.getParameter("id"));
                    Vector<Stores> list = dao.getStorebyID(store_id);
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/admin/AdminUpdateStore.jsp").forward(request, response);
                }else{
                  int store_id = Integer.parseInt(request.getParameter("store_id"));
                  String store_name = request.getParameter("store_name");
                  String phone = request.getParameter("phone");
                  String email = request.getParameter("email");
                  String street = request.getParameter("street");
                  String city = request.getParameter("city");
                  String state = request.getParameter("state");
                  String zip_code = request.getParameter("zip_code");
                  Stores stos = new Stores(store_id, store_name, phone, email, street, city, state, zip_code);
                  int n = dao.updateStore(stos);
                  response.sendRedirect("AdminStore");
                }
            } 
        }catch(Exception e){
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
