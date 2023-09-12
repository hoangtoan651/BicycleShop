/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Staffs;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author GG
 */
public class DAOStaff extends DBConnect{
    public int addStaff(Staffs sta ){
        int n = 0;
        String sql = "INSERT INTO staffs\n" +
"           ([staff_id]\n" +
"           ,[first_name]\n" +
"           ,[last_name]\n" +
"           ,[email]\n" +
"           ,[phone]\n" +
"           ,[active]\n" +
"           ,[store_id]\n" +
"           ,[manager_id]\n" +
"           ,[status])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, sta.getStaff_id());
            pre.setString(2, sta.getFirst_name());
            pre.setString(3, sta.getLast_name());
            pre.setString(4, sta.getEmail());
            pre.setString(5, sta.getPhone());
            pre.setInt(6, sta.getActive());
            pre.setInt(7, sta.getStore_id());
            pre.setInt(8, sta.getManager_id());
            pre.setInt(9, sta.getStatus());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public Staffs getStaffbyID(int id){
        String sql = "select *from staffs where staff_id =" +id;
        Staffs st = null;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                int statuts = rs.getInt(9);
                st = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id, statuts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
        
    }
    
    public Vector<Staffs> getStaffbyID1(int id){
        String sql = "select *from staffs where staff_id =" +id;
        Vector<Staffs> list = new Vector<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                int statuts = rs.getInt(9);
                Staffs st = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id, statuts);
                list.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        
    }
    
    public int changePasswordStaff(String email, String phone){
        int n = 0;
        String sql = "update staffs\n"
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
    
    public Staffs getStaff(String email, String phone){
        Staffs st = null;
        String sql = "select *from staffs where email = ? and phone = ?";
        try {
           PreparedStatement pre = connection.prepareStatement(sql);
           pre.setString(1, email);
           pre.setString(2, phone);
           ResultSet rs = pre.executeQuery();
           if(rs.next()){
               st = new Staffs();
               st.setStaff_id(rs.getInt(1));
               st.setFirst_name(rs.getString(2));
               st.setLast_name(rs.getString(3));
               st.setEmail(rs.getString(4));
               st.setPhone(rs.getString(5));
               st.setActive(rs.getInt(6));
               st.setStore_id(rs.getInt(7));
               st.setManager_id(rs.getInt(8));
               st.setStatus(rs.getInt(9));
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    public int updateStaff(Staffs sta){
        int n = 0;
        String sql = "UPDATE [dbo].[staffs]\n"
                + "   SET \n"
                + "      [first_name] = ?\n"
                + "      ,[last_name] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[active] = ?\n"
                + "      ,[store_id] = ?\n"
                + "      ,[manager_id] = ?\n"
                + "      ,[status] = ?\n"
                + " WHERE [staff_id] = ?";
        
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            
            pre.setString(1, sta.getFirst_name());
            pre.setString(2, sta.getLast_name());
            pre.setString(3, sta.getEmail());
            pre.setString(4, sta.getPhone());
            pre.setInt(5, sta.getActive());
            pre.setInt(6, sta.getStore_id());
            pre.setInt(7, sta.getManager_id());
            pre.setInt(8, sta.getStatus());
            pre.setInt(9, sta.getStaff_id());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    public Vector<Staffs> displayStaff(){
        Vector<Staffs> vec = new Vector<>();
        String sql = "select *from staffs";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                int statuts = rs.getInt(9);
                Staffs st = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id, statuts);
                vec.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public int removeStaff(int id){
        int n  =0;
        String sql = "DELETE FROM [dbo].[staffs]\n"
                + "      WHERE staff_id =   "+id;
        try {
            Statement pre = connection.createStatement();
            n = pre.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    
    public Vector<Staffs> searchStaffFName(String name){
        Vector<Staffs> vec = new Vector<>();
        String sql = "select *from staffs where first_name like '%"+name+"%'";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                int statuts = rs.getInt(9);
                Staffs st = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id, statuts);
                vec.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    public Vector<Staffs> searchStaffLName(String name){
        Vector<Staffs> vec = new Vector<>();
        String sql = "select *from staffs where last_name like '%"+name+"%'";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                int statuts = rs.getInt(9);
                Staffs st = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id, statuts);
                vec.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    
    
    public Vector<Staffs> getStaffByStore(int id) {
        Vector<Staffs> vec = new Vector<>();
        String sql = "select st.staff_id, st.first_name, st.last_name, st.email, st.phone, st.active, st.store_id, st.manager_id, st.status\n"
                + "from staffs st join stores s \n"
                + "on st.store_id = s.store_id \n"
                + "where s.store_id = " + id;
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int staff_id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int active = rs.getInt(6);
                int store_id = rs.getInt(7);
                int manager_id = rs.getInt(8);
                int statuts = rs.getInt(9);
                Staffs st = new Staffs(staff_id, first_name, last_name, email, phone, active, store_id, manager_id, statuts);
                vec.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }
    
    public static void main(String[] args) {
        DAOStaff dao = new DAOStaff();
//        int n = dao.addStaff(new Staffs(2023,"fat_san" , "Hoang", "Fat_bears", "0123456789", 1, 1, 1, 1));

//        int n = dao.updateStaff(new Staffs(2023,"fat_san" , "Hoang", "Fat_nail", "0931231231", 1, 3, 1, 1));
//        if(n>0){
//            System.out.println("updated");
//        }
//        System.out.println(dao.displayStaff());
//        dao.removeStaff(2023);
//        System.out.println(dao.searchStaffLName("a"));
        dao.changePasswordStaff("trungnamyeuvo123@gmail.com", "09876543210");
    }
}
