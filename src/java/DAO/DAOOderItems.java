/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.OrderItems;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author GG
 */
public class DAOOderItems extends DBConnect{
    public int addOrderItems(OrderItems ord){
        int n = 0;
        String sql = "INSERT INTO [dbo].[order_items]([order_id],[item_id],"
                + "[product_id],[quantity],[list_price],[discount])\n" +
                " VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, ord.getOrder_id());
            pre.setInt(2, ord.getItem_id());
            pre.setInt(3, ord.getProduct_id());
            pre.setInt(4, ord.getQuantity());
            pre.setDouble(5, ord.getList_price());
            pre.setDouble(6, ord.getDiscount());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
   
    
    public void updateOrderItems (OrderItems ord){
        String sql = "update order_items set product_id = ?,quantity = ?,list_price = ?,discount = ? where order_id = ? and item_id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, ord.getProduct_id());
            pre.setInt(2, ord.getQuantity());
            pre.setDouble(3, ord.getList_price());
            pre.setDouble(4, ord.getDiscount());
            pre.setInt(5, ord.getOrder_id());
            pre.setInt(6, ord.getItem_id());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public Vector<OrderItems> listAll(){
        Vector<OrderItems> vec = new Vector<>();
        String sql = "select *from order_items";
        try {
            PreparedStatement pre =connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                OrderItems ord = new OrderItems();
                ord.setItem_id(rs.getInt(1));
                ord.setProduct_id(rs.getInt(2));
                ord.setQuantity(rs.getInt(3));
                ord.setList_price(rs.getDouble(4));
                ord.setDiscount(rs.getDouble(5));
                ord.setOrder_id(rs.getInt(6));
                vec.add(ord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return vec;
    }
    public void removeOrderItem(int order_id, int item_id){
        
        String sql = "DELETE FROM [dbo].[order_items]\n"
                + "      WHERE order_id = '"+order_id+"'"+" and item_id =  '"+item_id+"'";
        
        try {
            Statement pre = connection.createStatement();
             pre.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
       
    }
    
    public Vector<OrderItems> searchQuantity(String quantity){
        Vector<OrderItems> vec = new Vector<>(); 
         String sql = "select *from order_items where [quantity] like %"+quantity+"%";
//        String sql = "select *from order_items where [quantity] = ?";
         try {
            PreparedStatement pre =connection.prepareStatement(sql);
//            pre.setString(1, quantity);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                OrderItems ord = new OrderItems();
                ord.setItem_id(rs.getInt(1));
                ord.setProduct_id(rs.getInt(2));
                ord.setQuantity(rs.getInt(3));
                ord.setList_price(rs.getDouble(4));
                ord.setDiscount(rs.getDouble(5));
                ord.setOrder_id(rs.getInt(6));
                vec.add(ord);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }  
        return vec;
    }
    
    public Vector<OrderItems> searchPrice(String price){
        Vector<OrderItems> vec = new Vector<>(); 
        String sql = "select *from order_items where list_price like '%"+price+"%'";
         try {
            PreparedStatement pre =connection.prepareStatement(sql);
//            pre.setString(1, price);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                OrderItems ord = new OrderItems();
                ord.setItem_id(rs.getInt(1));
                ord.setProduct_id(rs.getInt(2));
                ord.setQuantity(rs.getInt(3));
                ord.setList_price(rs.getDouble(4));
                ord.setDiscount(rs.getDouble(5));
                ord.setOrder_id(rs.getInt(6));
                vec.add(ord);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }  
        return vec;
    }
    
       public Vector<OrderItems> searchDiscount(String discount){
        Vector<OrderItems> vec = new Vector<>(); 
        String sql = "select *from order_items where discount like '%"+discount+"%'";
         try {
            PreparedStatement pre =connection.prepareStatement(sql);
//            pre.setString(1, price);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                OrderItems ord = new OrderItems();
                ord.setItem_id(rs.getInt(1));
                ord.setProduct_id(rs.getInt(2));
                ord.setQuantity(rs.getInt(3));
                ord.setList_price(rs.getDouble(4));
                ord.setDiscount(rs.getDouble(5));
                ord.setOrder_id(rs.getInt(6));
                vec.add(ord);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }  
        return vec;
    }
       
       
        public int count(int id){
        int s = 0;
        String sql = "select * from order_items o where o.order_id = "+id+" order by item_id DESC";
        try {
            PreparedStatement pre =connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
            s = rs.getInt(2);
            break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return s+1;
        }
        
        
        public OrderItems getItem(int oid, int pid){
        OrderItems ord = new OrderItems();
        String sql = "select * from order_items o where o.order_id ="+oid+" and o.product_id = "+pid;
        try {
            PreparedStatement pre =connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                 ord = new OrderItems();
                 ord.setOrder_id(rs.getInt(1));
                ord.setItem_id(rs.getInt(2));
                ord.setProduct_id(rs.getInt(3));
                ord.setQuantity(rs.getInt(4));
                ord.setList_price(rs.getDouble(5));
                ord.setDiscount(rs.getDouble(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ord;
    }
    public OrderItems getItemByOidIid(int oid, int iid) {
        OrderItems ord = new OrderItems();
        String sql = "select * from order_items where order_id = " + oid + "and item_id = " + iid;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ord = new OrderItems();
                ord.setOrder_id(rs.getInt(1));
                ord.setItem_id(rs.getInt(2));
                ord.setProduct_id(rs.getInt(3));
                ord.setQuantity(rs.getInt(4));
                ord.setList_price(rs.getDouble(5));
                ord.setDiscount(rs.getDouble(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ord;
    }
        
       
        
    public static void main(String[] args) {
        DAOOderItems dao = new DAOOderItems();
//        int n = dao.addOrderItems(new OrderItems(1701, 10, 2023, 100, 200.1, 5.2));
//        int n = dao.updateOrderItems(new OrderItems(1701, 10, 2023, 100, 450.5, 9.2));
//        if(n > 0 ){
//            System.out.println("inserted");
//        }
//        System.out.println(dao.listAll());
//        int n = dao.removeOrderItem(1701, 10);
//        if(n > 0){
//            System.out.println("removed !");
//        }
         OrderItems i = dao.getItem(1, 20);
        System.out.println(i.toString());
    }
}
