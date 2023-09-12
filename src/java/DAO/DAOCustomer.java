/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author GG
 */
public class DAOCustomer extends DBConnect{
    
    //Login user by email and phone 
    public boolean Login(String email, String phone){
        boolean flag = false;
        String sql = "select *from customers where email = ? and phone = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, phone);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public Customer getCustomerbyId(int id){
        Customer user = null;
        String sql= "select *from customers where customer_id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                user = new Customer();
                user.setCustomer_id(rs.getInt(1));
                user.setFirst_name(rs.getString(2));
                user.setLast_name(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setStreet(rs.getString(6));
                user.setCity(rs.getString(7));
                user.setState(rs.getString(8));
                user.setZip_code(rs.getString(9));
                user.setStatus(rs.getInt(10));
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return user;
    } 
    public Vector<Customer> getCustomerbyID(int id){
        
        Vector<Customer> vec = new Vector<>();
        String sql = "select *from customers where customer_id = " +id;
        try {
            ResultSet rs = this.getData(sql);
            while(rs.next()){
                int cus_id = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String street = rs.getString(6);
                String city = rs.getString(7);
                String state = rs.getString(8);
                String zip_code = rs.getString(9);
                int status = rs.getInt(10);
                Customer cus = new Customer(cus_id, fname, lname, phone, email, street, city, state, zip_code, status);
                vec.add(cus);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return vec;
    }
    
    public Customer getCustomer(String emails, String phones){
        Customer user = null;
        String sql="Select *from customers where email = ? and phone = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, emails);
            pre.setString(2, phones);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                int cus_id = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String street = rs.getString(6);
                String city = rs.getString(7);
                String state = rs.getString(8);
                String zip_code = rs.getString(9);
                int status = rs.getInt(10);
                user = new Customer(cus_id, fname, lname, phone, email, street, city, state, zip_code, status);
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public int addCustomer(Customer cus) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[customers]\n" +
"           ([customer_id]\n" +
"           ,[first_name]\n" +
"           ,[last_name]\n" +
"           ,[phone]\n" +
"           ,[email]\n" +
"           ,[street]\n" +
"           ,[city]\n" +
"           ,[state]\n" +
"           ,[zip_code]\n" +
"           ,[status])\n" +
"     VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, cus.getCustomer_id());
            pre.setString(2, cus.getFirst_name());
            pre.setString(3, cus.getLast_name());
            pre.setString(4, cus.getPhone());
            pre.setString(5, cus.getEmail());
            pre.setString(6, cus.getStreet());
            pre.setString(7, cus.getCity());
            pre.setString(8, cus.getState());
            pre.setString(9, cus.getZip_code());
            pre.setInt(10, cus.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int changePassword(String email, String phone){
        int n = 0;
        String sql = "update customers\n"
                + "set phone = ?\n"
                + "where email = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(2, email);
            pre.setString(1, phone);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public int updateCustomer(Customer cus){
        int n = 0;
        String sql = "UPDATE [dbo].[customers]\n"
                + "   SET \n"
                + "	   [first_name] = ?\n"
                + "      ,[last_name] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[street] = ?\n"
                + "      ,[city] = ?\n"
                + "      ,[state] = ?\n"
                + "      ,[zip_code] = ?\n"
                + "      ,[status] = ?\n"
                + " WHERE [customer_id] = ?";
         try {
            PreparedStatement pre = connection.prepareStatement(sql);    
            pre.setString(1, cus.getFirst_name());
            pre.setString(2, cus.getLast_name());
            pre.setString(3, cus.getPhone());
            pre.setString(4, cus.getEmail());
            pre.setString(5, cus.getStreet());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getState());
            pre.setString(8, cus.getZip_code());
            pre.setInt(9, cus.getStatus());
             pre.setInt(10, cus.getCustomer_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    
    
    
    public Vector<Customer> listAll(){
        Vector<Customer> vec = new Vector<>();
        String sql="Select *from customers";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
//                Customer cus = new Customer();
//                cus.setCustmer_id(rs.getInt(1));
//                cus.setFirst_name(rs.getString(2));
//                cus.setLast_name(rs.getString(3));
//                cus.setPhone(rs.getString(4));
//                cus.setEmail(rs.getString(5));
//                cus.setStreet(rs.getString(6));
//                cus.setCity(rs.getString(7));
//                cus.setState(rs.getString(8));
//                cus.setZip_code(rs.getString(9));
//                cus.setStatus(rs.getInt(10));
                int cus_id = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String street = rs.getString(6);
                String city = rs.getString(7);
                String state = rs.getString(8);
                String zip_code = rs.getString(9);
                int status = rs.getInt(10);
                Customer cus = new Customer(cus_id, fname, lname, phone, email, street, city, state, zip_code, status);
                vec.add(cus);
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return vec;
    }
    
    public int removeCustomer(int id){
        int n = 0;
        String sql = "delete from customers where customer_id = '"+ id +"'";
        try {
            Statement pre = connection.createStatement();
            n = pre.executeUpdate(sql);
        } catch (Exception e) {
         e.printStackTrace();
        }
        return n;
        
    }
    public Vector<Customer> searchCity(String city){
        Vector<Customer> vec = new Vector<>();
         String sql = "select *from customers where city like '%"+city+"%'";
         try {
            PreparedStatement pre =connection.prepareStatement(sql);
//            pre.setString(1, city);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Customer cus = new Customer();
                cus.setCustomer_id(rs.getInt(1));
                cus.setFirst_name(rs.getString(2));
                cus.setLast_name(rs.getString(3));
                cus.setPhone(rs.getString(4));
                cus.setEmail(rs.getString(5));
                cus.setStreet(rs.getString(6));
                cus.setCity(rs.getString(7));
                cus.setState(rs.getString(8));
                cus.setZip_code(rs.getString(9));
                cus.setStatus(rs.getInt(10));
                vec.add(cus);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }  
        return vec;
    }
    public Vector<Customer> searchFname(String name){
        Vector<Customer> vec = new Vector<>();
         String sql = "select *from customers where first_name like '%"+name+"%'";
         try {
            PreparedStatement pre =connection.prepareStatement(sql);
//            pre.setString(1, name);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Customer cus = new Customer();
                cus.setCustomer_id(rs.getInt(1));
                cus.setFirst_name(rs.getString(2));
                cus.setLast_name(rs.getString(3));
                cus.setPhone(rs.getString(4));
                cus.setEmail(rs.getString(5));
                cus.setStreet(rs.getString(6));
                cus.setCity(rs.getString(7));
                cus.setState(rs.getString(8));
                cus.setZip_code(rs.getString(9));
                cus.setStatus(rs.getInt(10));
                vec.add(cus);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }  
        return vec;
    }
    
     public Vector<Customer> searchLname(String name){
        Vector<Customer> vec = new Vector<>();
         String sql = "select *from customers where last_name like '%"+name+"%'";
         try {
            PreparedStatement pre =connection.prepareStatement(sql);
//            pre.setString(1, name);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Customer cus = new Customer();
                cus.setCustomer_id(rs.getInt(1));
                cus.setFirst_name(rs.getString(2));
                cus.setLast_name(rs.getString(3));
                cus.setPhone(rs.getString(4));
                cus.setEmail(rs.getString(5));
                cus.setStreet(rs.getString(6));
                cus.setCity(rs.getString(7));
                cus.setState(rs.getString(8));
                cus.setZip_code(rs.getString(9));
                cus.setStatus(rs.getInt(10));
                vec.add(cus);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }  
        return vec;
    }
     
     public Vector<Customer> searchState(String state){
        Vector<Customer> vec = new Vector<>();
         String sql = "select *from customers where [state] like '%"+state+"%'";
         try {
            PreparedStatement pre =connection.prepareStatement(sql);
//            pre.setString(1, name);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Customer cus = new Customer();
                cus.setCustomer_id(rs.getInt(1));
                cus.setFirst_name(rs.getString(2));
                cus.setLast_name(rs.getString(3));
                cus.setPhone(rs.getString(4));
                cus.setEmail(rs.getString(5));
                cus.setStreet(rs.getString(6));
                cus.setCity(rs.getString(7));
                cus.setState(rs.getString(8));
                cus.setZip_code(rs.getString(9));
                cus.setStatus(rs.getInt(10));
                vec.add(cus);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }  
        return vec;
    }
     
     public Vector<Customer> searchStreet(String street){
        Vector<Customer> vec = new Vector<>();
         String sql = "select *from customers where last_name like '%"+street+"%'";
         try {
            PreparedStatement pre =connection.prepareStatement(sql);
//            pre.setString(1, name);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Customer cus = new Customer();
                cus.setCustomer_id(rs.getInt(1));
                cus.setFirst_name(rs.getString(2));
                cus.setLast_name(rs.getString(3));
                cus.setPhone(rs.getString(4));
                cus.setEmail(rs.getString(5));
                cus.setStreet(rs.getString(6));
                cus.setCity(rs.getString(7));
                cus.setState(rs.getString(8));
                cus.setZip_code(rs.getString(9));
                cus.setStatus(rs.getInt(10));
                vec.add(cus);
                
            }
        } catch (Exception e) {
        e.printStackTrace();
        }  
        return vec;
    }
    //Hoàn thành search các bảng
    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();
       // int n = dao.addCustomer(new Customer(2023, "Hoang", "Toan", "0123654789", "toanhoang@gmail.com", "BigCityBoy", "Ha Noi", "TT", "10000", 1));
//        System.out.println(dao.listAll());
//        int n = dao.updateCustomer(new Customer(2023, "Hoang", "Toan", "0123654789", "toanhoang@gmail.com", "BigCityBoy Dau cat moi", "Ha Noi", "TT", "10000", 1));
//
//        int n = dao.removeCustomer("2023");
//        if (n > 0) {
//            System.out.println("inserted");
//        }
//        System.out.println(dao.searchCity("s"));;
//        System.out.println(dao.searchStreet("a"));
        dao.changePassword("abcsieusieu@gmail.com", "0912345678");
    }
}
