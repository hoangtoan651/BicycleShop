/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 *
 * @author GG
 */
public class DAOOrders extends DBConnect {

    public void addOrder(Orders ord) {
        String sql = "INSERT INTO [dbo].[orders]([order_id],[customer_id],"
                + "[order_status],[order_date],[required_date],"
                + "[shipped_date],[store_id],[staff_id],[status])\n"
                + " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, ord.getOrder_id());
            pre.setInt(2, ord.getCustomer_id());
            pre.setInt(3, ord.getOrder_status());
            pre.setString(4, ord.getOrder_date());
            pre.setString(5, ord.getRequied_date());
            pre.setString(6, ord.getShipped_date());
            pre.setInt(7, ord.getStore_id());
            pre.setInt(8, ord.getStaff_id());
            pre.setInt(9, ord.getStatus());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateOrder(Orders ord) {
        int n = 0;
        String sql = "UPDATE [dbo].[orders]\n"
                + "   SET \n"
                + "      [customer_id] = ?\n"
                + "      ,[order_status] = ?\n"
                + "      ,[order_date] = ?\n"
                + "      ,[required_date] = ?\n"
                + "      ,[shipped_date] = ?\n"
                + "      ,[store_id] = ?\n"
                + "      ,[staff_id] = ?\n"
                + "      ,[status] = ?\n"
                + " WHERE [order_id] = ?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            //set value for ?
            // index start 1

            pre.setInt(1, ord.getCustomer_id());
            pre.setInt(2, ord.getOrder_status());
            pre.setString(3, ord.getOrder_date());
            pre.setString(4, ord.getRequied_date());
            pre.setString(5, ord.getShipped_date());
            pre.setInt(6, ord.getStore_id());
            pre.setInt(7, ord.getStaff_id());
            pre.setInt(8, ord.getStatus());
            pre.setInt(9, ord.getOrder_id());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public Vector<Orders> getOrderbyID(int id) {
        Vector<Orders> vec = new Vector<>();
        String sql = "select *from orders where order_id = " + id;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Orders ord = new Orders();
                ord.setOrder_id(rs.getInt(1));
                ord.setCustomer_id(rs.getInt(2));
                ord.setOrder_status(rs.getInt(3));
                ord.setOrder_date(rs.getString(4));
                ord.setRequied_date(rs.getString(5));
                ord.setShipped_date(rs.getString(6));
                ord.setStore_id(rs.getInt(7));
                ord.setStaff_id(rs.getInt(8));
                ord.setStatus(rs.getInt(9));
                vec.add(ord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Orders> getOrderbyCusID(int customer_id) {
        String sql = "select *from orders \n"
                + "where customer_id = " + customer_id;
        Vector<Orders> vec = new Vector<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Orders ord = new Orders();
                ord.setOrder_id(rs.getInt(1));
                ord.setCustomer_id(rs.getInt(2));
                ord.setOrder_status(rs.getInt(3));
                ord.setOrder_date(rs.getString(4));
                ord.setRequied_date(rs.getString(5));
                ord.setShipped_date(rs.getString(6));
                ord.setStore_id(rs.getInt(7));
                ord.setStaff_id(rs.getInt(8));
                ord.setStatus(rs.getInt(9));
                vec.add(ord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    
    public Orders getOrder(int sid, int cid, int stid) {
        Orders o = new Orders();
        String sql = "select * from orders o where o.store_id = " + sid + "\n"
                + "and o.customer_id = " + cid + "\n"
                + "and o.staff_id = " + stid + "\n"
                + "and o.status = 0";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt(1);
                int cusid = rs.getInt(2);
                int ost = rs.getInt(3);
                String odate = rs.getString(4);
                String rdate = rs.getString(5);
                String sdate = rs.getString(6);
                int ids = rs.getInt(7);
                int idst = rs.getInt(8);
                int st = rs.getInt(9);
                o = new Orders(oid, cusid, ost, odate, rdate, sdate, ids, idst, st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public Vector<Orders> listAll() {
        String sql = "select *from orders";
        Vector<Orders> vec = new Vector<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Orders ord = new Orders();
                ord.setOrder_id(rs.getInt(1));
                ord.setCustomer_id(rs.getInt(2));
                ord.setOrder_status(rs.getInt(3));
                ord.setOrder_date(rs.getString(4));
                ord.setRequied_date(rs.getString(5));
                ord.setShipped_date(rs.getString(6));
                ord.setStore_id(rs.getInt(7));
                ord.setStaff_id(rs.getInt(8));
                ord.setStatus(rs.getInt(9));
                vec.add(ord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public Vector<Orders> listAllField(String sql) {

        Vector<Orders> vec = new Vector<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Orders ord = new Orders();
                ord.setOrder_id(rs.getInt(1));
                ord.setCustomer_id(rs.getInt(2));
                ord.setOrder_status(rs.getInt(3));
                ord.setOrder_date(rs.getString(4));
                ord.setRequied_date(rs.getString(5));
                ord.setShipped_date(rs.getString(6));
                ord.setStore_id(rs.getInt(7));
                ord.setStaff_id(rs.getInt(8));
                ord.setStatus(rs.getInt(9));
                vec.add(ord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    //warning before remove order you should check key constrain in table order_times 
    public int removeOrder(int id) {
        int n = 0;
        String sql = "delete from orders where order_id = " + id;
        try {
            Statement pre = connection.createStatement();
            n = pre.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public Vector<Orders> listOrderStatus(String order) {
        String sql = "select *from orders where order_status = ?";
        Vector<Orders> vec = new Vector<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, order);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Orders ord = new Orders();
                ord.setOrder_id(rs.getInt(1));
                ord.setCustomer_id(rs.getInt(2));
                ord.setOrder_status(rs.getInt(3));
                ord.setOrder_date(rs.getString(4));
                ord.setRequied_date(rs.getString(5));
                ord.setShipped_date(rs.getString(6));
                ord.setStore_id(rs.getInt(7));
                ord.setStaff_id(rs.getInt(8));
                ord.setStatus(rs.getInt(9));
                vec.add(ord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public int count() {
        String sql = "select * from orders";
        int s = 0;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                s = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s + 1;
    }

    public Orders getOrderById(int id) {
        Orders o = new Orders();
        String sql = "select * from orders where order_id = " + id;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt(1);
                int cusid = rs.getInt(2);
                int ost = rs.getInt(3);
                String odate = rs.getString(4);
                String rdate = rs.getString(5);
                String sdate = rs.getString(6);
                int ids = rs.getInt(7);
                int idst = rs.getInt(8);
                int st = rs.getInt(9);
                o = new Orders(oid, cusid, ost, odate, rdate, sdate, ids, idst, st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public static void main(String[] args) {
        DAOOrders dao = new DAOOrders();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String datenow = df.format(date);
        dao.addOrder(new Orders(0, 2, 1, datenow, datenow, datenow, 1, 2, 0));
//        int n = dao.updateOrder(new Orders(1701, 200, 3, "2022-01-20", "2022-12-21", "2022-12-17", 3, 2, 1));
//        if(n > 0){
//            System.out.println("Inserted");
//        }
//        System.out.println(dao.listAll());
        System.out.println(dao.getOrder(1, -2, 1).toString());
    }
}
