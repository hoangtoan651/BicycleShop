/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import DAO.DAOProducts;
import DAO.DAOStaff;
import entity.Products;
import entity.Staffs;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author GG
 */
public class ControllerAdminHome extends HttpServlet {

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
            DAOProducts dao = new DAOProducts();
            DAOStaff dao1 = new DAOStaff();
//             HttpSession session = request.getSession();
            String service = request.getParameter("service");
            if (service == null) {
                service = "displayAll";
            }

            if (service.equals("displayAll")) {
                ResultSet rs = dao.getData("select DISTINCT  category_name from products");
                Vector<Products> product = dao.listAll();
                request.setAttribute("product", product);
                request.setAttribute("data", rs);
                request.getRequestDispatcher("/admin/AdminHome.jsp").forward(request, response);
            }
            if (service.equals("displayProductdetail")) {
                String pid = request.getParameter("cname");
                Vector<Products> product = dao.getAll("select *from products where category_name ='" + pid + "'");
                ResultSet rs = dao.getData("select DISTINCT category_name from products");
                request.setAttribute("product", product);
                request.setAttribute("data", rs);
                request.getRequestDispatcher("/admin/AdminHome.jsp").forward(request, response);
            }
            if (service.equals("searchProductName")) {
                String name = request.getParameter("name");
                Vector<Products> product = dao.searchProductName(name);
                ResultSet rs = dao.getData("select DISTINCT  category_name from products");
                request.setAttribute("product", product);
                request.setAttribute("data", rs);
                request.getRequestDispatcher("/admin/AdminHome.jsp").forward(request, response);
            }
            if (service.equals("insertProduct")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    ResultSet prolist = dao.getData("select distinct category_name from products");
                    request.setAttribute("product", prolist);
                    request.getRequestDispatcher("/admin/AdminInsertProduct.jsp").forward(request, response);
                } else {
                    int product_id = 0;
                    ResultSet rsPro = dao.getData("select max(product_id) from products");

                    if (rsPro.next()) {
                        product_id = rsPro.getInt(1);
                    }
                    String product_name = request.getParameter("product_name");
                    int model_year = Integer.parseInt(request.getParameter("model_year"));
                    double list_price = Integer.parseInt(request.getParameter("list_price"));
                    String brand_name = request.getParameter("brand_name");
                    String category_name = request.getParameter("category_name");
                    String image = "./image/" + request.getParameter("image");
                    Products product = new Products(product_id + 1, product_name, model_year, list_price, brand_name, category_name, image);
                    int n = dao.addProduct(product);
                    response.sendRedirect("AdminHome");
                }
            }

            if (service.equals("updateStaff")) {
                String submit = request.getParameter("update");
                if (submit == null) {
                    int staff_id = Integer.parseInt(request.getParameter("id"));
                    Vector<Staffs> list = dao1.getStaffbyID1(staff_id);
                    ResultSet rs1 = dao.getData("select * from stores");
                    ResultSet rs2 = dao.getData("select staff_id, (first_name +' '+ last_name) from staffs s where s.staff_id in \n"
                            + "(select manager_id from staffs )");
                    request.setAttribute("rsStore", rs1);
                    request.setAttribute("rsManager", rs2);
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/admin/AdminProfile.jsp").forward(request, response);
                } else {
                    int staff_id = Integer.parseInt(request.getParameter("staff_id"));
                    String first_name = request.getParameter("first_name");
                    String last_name = request.getParameter("last_name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    int active = Integer.parseInt(request.getParameter("active"));
                    int store_id = Integer.parseInt(request.getParameter("store_id"));
                    int manager_id = Integer.parseInt(request.getParameter("manager_id"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    Staffs staff = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id, status);
                    int n = dao1.updateStaff(staff);
                    request.getSession().setAttribute("username", staff.getFirst_name() + " " + staff.getLast_name());
                    response.sendRedirect("AdminHome");
                }
            }
            if(service.equals("deleteProduct")){
                int product_id = Integer.parseInt(request.getParameter("productID"));
                int n = dao.removeProduct(product_id);
                response.sendRedirect("AdminHome");
            }
            if(service.equals("updateProduct")){
                String submit = request.getParameter("submit");
                if(submit == null){
                    int product_id = Integer.parseInt(request.getParameter("productID"));
                    Vector<Products> pro1 = dao.getProductbyID1(product_id);
                    ResultSet pro2 = dao.getData("select distinct category_name from products");
                    request.setAttribute("product", pro1);
                    request.setAttribute("list", pro2);
                    request.getRequestDispatcher("/admin/AdminUpdateProduct.jsp").forward(request, response); 
                }else{
                    int product_id = Integer.parseInt(request.getParameter("product_id"));
                    String product_name = request.getParameter("product_name");
                    int model_year = Integer.parseInt(request.getParameter("model_year"));
                    double list_price = Double.parseDouble(request.getParameter("list_price"));
                    String brand_name = request.getParameter("brand_name");
                    String category_name = request.getParameter("category_name");
                    String image = "./image/" + request.getParameter("image");
                    Products pro = new Products(product_id, product_name, model_year, list_price, brand_name, category_name, image);
                    int n = dao.updateProduct(pro);
                    response.sendRedirect("AdminHome");  
                }
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
