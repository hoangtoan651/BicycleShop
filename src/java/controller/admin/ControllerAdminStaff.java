/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAOStaff;
import entity.Staffs;
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
public class ControllerAdminStaff extends HttpServlet {

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
        DAOStaff dao = new DAOStaff();
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if (service == null) {
                service = "displayAll";
            }
            if (service.equals("displayAll")) {
                Vector<Staffs> list = dao.displayStaff();
                ResultSet rs1 = dao.getData("select * from stores");
                ResultSet rs2 = dao.getData("select staff_id, (first_name +' '+ last_name) from staffs s where s.staff_id in \n"
                        + "(select manager_id from staffs )");
                request.setAttribute("rsStore", rs1);
                request.setAttribute("rsManager", rs2);
                request.setAttribute("list", list);
                request.getRequestDispatcher("/admin/AdminShowList.jsp").forward(request, response);
            }
            //Chú ý form đổi pass word và list staff ở bên project ProjectSE1713 
            //Form add sẽ sử dụng cùng update cho lẹ 
            if (service.equals("deleteStaff")) {
                int staff_id = Integer.parseInt(request.getParameter("id"));
                dao.removeStaff(staff_id);
                response.sendRedirect("AdminStaff");
            }
            if(service.equals("searchStaff")){
                String name = request.getParameter("name");
                Vector<Staffs> list = dao.searchStaffLName(name);
                 request.setAttribute("list", list);
                request.getRequestDispatcher("/admin/AdminShowList.jsp").forward(request, response);
            }
            if (service.equals("InsertStaff")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    ResultSet rsStore = dao.getData("select *from stores");
                    ResultSet rsManager = dao.getData("select *from staffs");
                    request.setAttribute("rsStore", rsStore);
                    request.setAttribute("rsManager", rsManager);
                    request.getRequestDispatcher("/admin/AdminInsertStaff.jsp").forward(request, response);
                } else {
                    int staff_id = 0;
                   
                    ResultSet rs = dao.getData("select max(staff_id) from staffs");
                    if(rs.next()){
                        staff_id = rs.getInt(1);
                    }
                    String first_name = request.getParameter("first_name");
                    String last_name = request.getParameter("last_name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    int active = Integer.parseInt(request.getParameter("active"));
                    int store_id = Integer.parseInt(request.getParameter("store_id"));
                    int manager_id = Integer.parseInt(request.getParameter("manager_id"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    Staffs stas = new Staffs(staff_id + 1, first_name, last_name, email, phone, active, store_id, manager_id, status);
                    int n = dao.addStaff(stas);
                    response.sendRedirect("AdminStaff");
                }
            }
        }catch(Exception e){
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
