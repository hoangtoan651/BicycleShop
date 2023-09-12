/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GG
 */
public class DAOProducts extends DBConnect {

    public int addProduct(Products pro) {
        int n = 0;
        String sql = "INSERT INTO products\n"
                + "           ([product_id]\n"
                + "           ,[product_name]\n"
                + "           ,[model_year]\n"
                + "           ,[list_price]\n"
                + "           ,[brand_name]\n"
                + "           ,[category_name]\n"
                + "           ,[image])\n"
                + "     VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, pro.getProduct_id());
            pre.setString(2, pro.getProduct_name());
            pre.setInt(3, pro.getModel_year());
            pre.setDouble(4, pro.getList_price());
            pre.setString(5, pro.getBrand_name());
            pre.setString(6, pro.getCategory_name());
            pre.setString(7, pro.getImage());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public Vector<Products> getAll(String sql) {
        Vector<Products> vector = new Vector<Products>();
        //String sql = "select * from Products";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String pName = rs.getString(2);
                int model = rs.getInt(3);
                double price = rs.getDouble(4);
                String brand = rs.getString(5);
                String cate = rs.getString(6);
                String image = rs.getString(7);
                // create object
                Products pro = new Products(id, pName, model, price, brand, cate, image);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public int updateProduct(Products pro) {
        int n = 0;
        String sql = "UPDATE [dbo].[products]\n"
                + "   SET \n"
                + "      [product_name] = ?\n"
                + "      ,[model_year] = ?\n"
                + "      ,[list_price] = ?\n"
                + "      ,[brand_name] = ?\n"
                + "      ,[category_name] = ?\n"
                + "      ,[image] = ?\n"
                + " WHERE [product_id] = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, pro.getProduct_name());
            pre.setInt(2, pro.getModel_year());
            pre.setDouble(3, pro.getList_price());
            pre.setString(4, pro.getBrand_name());
            pre.setString(5, pro.getCategory_name());
            pre.setString(6, pro.getImage());
            pre.setInt(7, pro.getProduct_id());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public Vector<Products> listAll() {
        String sql = "select *from products";
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    //function pagging
    public Vector<Products> listToPage(Vector<Products> Products, int start, int end) {
        Vector<Products> pageList = new Vector<>();
        for (int i = start; i < end; i++) {
            pageList.add(Products.get(i));
        }
        return pageList;
    }
    //end function pagging
    public Vector<Products> listAllJoin(int id, String category, String search) {
        String sql = "select b.product_id, b.product_name, b.model_year, b.list_price, b.brand_name, b.category_name, b.image from (stocks a join products b on a.product_id = b.product_id) \n"
                + "			 join stores s on a.store_id = s.store_id\n"
                + "			 where s.store_id = " + id + " and b.category_name like '%" + category + "%' and product_name like '%" + search + "%'";
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Products> listTopProduct() {
        String sql = "select top 8 *from products";
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Products> listTopProduct1() {
        String sql = "select top 8 *from products where product_name like '%p%'";
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Products> listAllProduct() {
        Vector<Products> vec = new Vector<>();
        String sql = "select *from products";

        try {
//            Statement state = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);         
            //default: con trỏ bản ghi chỉ đi từ bản ghi đầu đến bản ghi cuối 
            //Dữ liệu chỉ đọc
            Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Srcoll: Con trỏ bảng ghi dịch theo chiều; senstive:threadSafe nghe sự thay đổi/ tranh chấp trong quá trình đọc dữ liệu
            //updatetable: cho phép thay đổi dữ liệu 
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return vec;
    }

    //Warning: After remove product int table products you should check key constrain in table Stocks
    //Have data table constrain
    //Create Query Trigger delete
//      public int removeProduct(int id){
//        int n=0;
//        String sql = "delete from products where product_id = "+id;
//        // check foreign key costain
//        try {
//            Statement state = connection.createStatement();
//            ResultSet rs1 = this.getData("select *from stocks where product_id = "+id);
//            ResultSet rs2 = this.getData("select *from order_items where product_id = "+id);
//            if(rs1.next()|| rs2.next()){
//                //error constrain key
//              n = -1;  
//            }else{ 
//                n = state.executeUpdate(sql);
//            }      
//            n = state.executeUpdate(sql);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return n;
//    }
    public Vector<Products> getProductbyID1(int id) {
        Vector<Products> vec = new Vector<>();
        Products pro = new Products();
        String sql = "select *from products where product_id = " + id;

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Products> searchProductName(String name) {
        String sql = "select *from products where product_name like '%" + name + "%'";
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Products> searchModel(String name) {
        String sql = "select *from products where model_year like '%" + name + "%'";
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Products> searchBrandName(String name) {
        String sql = "select *from products where brand_name like '%" + name + "%'";
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Products> searchCategoryName(String name) {
        String sql = "select *from products where category_name like '%" + name + "%'";
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    //Start Paging

    public int getTotalProduct() {
        String sql = " select count(*) from products";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Vector<Products> pagingAccount(int index) {
        Vector<Products> list = new Vector<>();
        String sql = "select *from products\n"
                + "order by product_id\n"
                + "offset ? rows fetch next 9 row only ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, (index - 1) * 9);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Vector<String> getCategory(int id) {
        Vector<String> vector = new Vector<String>();
        String sql = "select  DISTINCT  category_name from (products p join stocks s on p.product_id = s.product_id) join stores st on st.store_id = s.store_id\n"
                + "where s.store_id = " + id;
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) {

                String cate = rs.getString(1);

                vector.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Products getProductById(int id) {
        String sql = "select * from products p where p.product_id = " + id;
        Products pro = null;

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;
    }

//    public int CountCart(int customer_id) {
//        int n =0;
//        String sql = "select count(*) from (order_items item join orders o on item.order_id = o.order_id) join products p on p.product_id = item.product_id \n"
//                + "                where o.status = 0\n"
//                + "                and o.customer_id = " + customer_id;
//      try {
//            PreparedStatement pre = connection.prepareStatement(sql);
//            ResultSet rs = pre.executeQuery();
//            if(rs.next()) {
//                Products pro = new Products();
//                pro.setProduct_id(rs.getInt(1));
//                pro.setProduct_name(rs.getString(2));
//                pro.setModel_year(rs.getInt(3));
//                pro.setList_price(rs.getDouble(4));
//                pro.setBrand_name(rs.getString(5));
//                pro.setCategory_name(rs.getString(6));
//                pro.setImage(rs.getString(7));
//                pro.setQuantity(rs.getInt(8));
//                pro.setItemid(rs.getInt(9));
//                pro.setOrderid(rs.getInt(10));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }  
//       return n;
//    }
    public Vector<Products> listCart(int cusid, String sid) {
        String sql = "select p.product_id, p.product_name,P.model_year,p.list_price,p.brand_name,p.category_name,p.image,item.quantity,item.item_id,o.order_id \n"
                + "from (order_items item join orders o on item.order_id = o.order_id) join products p on p.product_id = item.product_id \n"
                + "where o.status = 0\n"
                + "and o.staff_id like '%" + sid + "%'\n"
                + "and o.customer_id = " + cusid;
        Vector<Products> vec = new Vector<>();

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Products pro = new Products();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                pro.setImage(rs.getString(7));
                pro.setQuantity(rs.getInt(8));
                pro.setItemid(rs.getInt(9));
                pro.setOrderid(rs.getInt(10));
                vec.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public int CountCart(int customer_id) {
        int count = 0;
        String sql = "select count(*) from (order_items item join orders o on item.order_id = o.order_id) join products p on p.product_id = item.product_id \n"
                + "                where o.status = 0\n"
                + "                and o.customer_id = " + customer_id;
        try {
            PreparedStatement pre = connection.prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public double getAllPrice(int customer_id) {
        double total = 0;
        String sql = "select sum(p.list_price * item.quantity * (1 - item.discount))\n"
                + "from (order_items item join orders o on item.order_id = o.order_id) join products p on p.product_id = item.product_id \n"
                + "where o.status = 0 and o.customer_id = " + customer_id;

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public int removeProduct(int id) {
        int n = 0;
        String sql = "delete from products where product_id = " + id;
        // check foreign key costain
        try {
            Statement state = connection.createStatement();
            ResultSet rs1 = this.getData("select *from stocks where product_id = " + id);
            ResultSet rs2 = this.getData("select *from order_items where product_id = " + id);
            if (rs1.next() || rs2.next()) {
                //error constrain key
                n = -1;
            } else {
                n = state.executeUpdate(sql);
            }
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        DAOProducts dao = new DAOProducts();
//        int n = dao.addProduct(new Products(2023, "Honda Civi", 2023, 4.5, "Car", "Car run by fuel", "/src/image.."));
//        int n  = dao.updateProduct(new Products(200, "HTrek Powerfly 5 - 2018", 2018, 3500.1, "Car Automation", "Electric Car", "/src/imageCar"));
//        if(n>0){
//            System.out.println("Updated");
//        }
//        System.out.println(dao.listAll());
//        System.out.println(dao.listAllProduct());
//        int n = dao.removeProduct(1);
//        if (n > 0) {
//            System.out.println("Updated");
//        }
//        System.out.println(dao.searchCategoryName("e"));
//        Vector<Products> list = dao.listCart(5, "");
//        for (Products products : list) {
//            System.out.println(products.toString());
//
//        }

        System.out.println(dao.CountCart(501));
    }
}
