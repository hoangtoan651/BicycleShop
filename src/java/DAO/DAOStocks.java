/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.sun.javafx.geom.Vec2d;
import entity.Stocks;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author GG
 */
public class DAOStocks extends DBConnect {

    public int addStock(Stocks sto) {
        int n = 0;
        String sql = "INSERT INTO [stocks]\n"
                + "           ([store_id]\n"
                + "           ,[product_id]\n"
                + "           ,[quantity])\n"
                + "     VALUES (?,?,?)";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, sto.getStore_id());
            pre.setInt(2, sto.getProduct_id());
            pre.setInt(3, sto.getQuantity());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n;
    }

    
    
    public int updateStock(Stocks sto) {
        int n = 0;
        String sql = "update stocks set [quantity]=? where [store_id]=? and [product_id]=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setInt(1, sto.getQuantity());
            pre.setInt(2, sto.getStore_id());
            pre.setInt(3, sto.getProduct_id());

            n = pre.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Stocks> listAll() {
        String sql = "select *from stocks";
        Vector<Stocks> vec = new Vector<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Stocks st = new Stocks();
                st.setStore_id(rs.getInt(1));
                st.setProduct_id(rs.getInt(2));
                st.setQuantity(rs.getInt(3));
                vec.add(st);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;

    }

    public Stocks getStockByOrder(int sid, int pid) {
        Stocks st = null;
        String sql = "select distinct d.store_id, d.product_id, d.quantity from orders as a join order_items as b on a.order_id = b.order_id \n"
                + "						 join stores as c on a.store_id = c.store_id \n"
                + "						 join stocks as d on c.store_id = d.store_id\n"
                + "						 join products as e on d.product_id = e.product_id\n"
                + "where c.store_id = "+sid+ "and e.product_id = "+pid;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                st = new Stocks();
                st.setStore_id(rs.getInt(1));
                st.setProduct_id(rs.getInt(2));
                st.setQuantity(rs.getInt(3));
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    public int removeStock(int Sid, int Pid) {
        int n = 0;
        String sql = "delete from stocks where [store_id]='" + Sid + "' and [product_id]='" + Pid + "'";
        // check foreign key costain
        try {
            Statement state = connection.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        DAOStocks dao = new DAOStocks();
//        int n = dao.addStock(new Stocks(1,2023 , 1000));
//        int n = dao.updateStock(new Stocks(1, 2023, 1500));
//        if(n>0){
//            System.out.println("updated");
//        }
//        System.out.println(dao.listAll());
        System.out.println(dao.getStockByOrder(1,5));
    }
}
