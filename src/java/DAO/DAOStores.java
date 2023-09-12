/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Stores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author GG
 */
public class DAOStores extends DBConnect {

    public int addStore(Stores store) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[stores]\n"
                + "           ([store_id]\n"
                + "           ,[store_name]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[street]\n"
                + "           ,[city]\n"
                + "           ,[state]\n"
                + "           ,[zip_code])\n"
                + "     VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, store.getStore_id());
            pre.setString(2, store.getStore_name());
            pre.setString(3, store.getPhone());
            pre.setString(4, store.getEmail());
            pre.setString(5, store.getStreet());
            pre.setString(6, store.getCity());
            pre.setString(7, store.getState());
            pre.setString(8, store.getZip_code());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n;

    }

    public Vector<Stores> getStorebyID(int id) {
        Vector<Stores> vec = new Vector<>();
        String sql = " select *from stores where store_id = " + id;

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Stores sto = new Stores();
                sto.setStore_id(rs.getInt(1));
                sto.setStore_name(rs.getString(2));
                sto.setPhone(rs.getString(3));
                sto.setEmail(rs.getString(4));
                sto.setStreet(rs.getString(5));
                sto.setCity(rs.getString(6));
                sto.setState(rs.getString(7));
                sto.setZip_code(rs.getString(8));
                vec.add(sto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public int updateStore(Stores store) {
        int n = 0;
        String sql = "UPDATE [dbo].[stores]\n"
                + "   SET \n"
                + "      [store_name] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[street] = ?\n"
                + "      ,[city] = ?\n"
                + "      ,[state] = ?\n"
                + "      ,[zip_code] = ?\n"
                + " WHERE [store_id] = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1, store.getStore_name());
            pre.setString(2, store.getPhone());
            pre.setString(3, store.getEmail());
            pre.setString(4, store.getStreet());
            pre.setString(5, store.getCity());
            pre.setString(6, store.getState());
            pre.setString(7, store.getZip_code());
            pre.setInt(8, store.getStore_id());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n;
    }

    public Vector<Stores> listAll() {
        Vector<Stores> vec = new Vector<>();
        String sql = "Select *from stores";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Stores sto = new Stores();
                sto.setStore_id(rs.getInt(1));
                sto.setStore_name(rs.getString(2));
                sto.setPhone(rs.getString(3));
                sto.setEmail(rs.getString(4));
                sto.setStreet(rs.getString(5));
                sto.setCity(rs.getString(6));
                sto.setState(rs.getString(7));
                sto.setZip_code(rs.getString(8));
                vec.add(sto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    

    public int removeStore(int id) {
        int n = 0;
        String sql = "delete from stores where store_id = " + id;
        try {
            Statement pre = connection.createStatement();
            n = pre.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public Vector<Stores> searchStorename(String name) {
        Vector<Stores> vec = new Vector<>();
        String sql = "Select *from stores where store_name like '%" + name + "%'";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Stores sto = new Stores();
                sto.setStore_id(rs.getInt(1));
                sto.setStore_name(rs.getString(2));
                sto.setPhone(rs.getString(3));
                sto.setEmail(rs.getString(4));
                sto.setStreet(rs.getString(5));
                sto.setCity(rs.getString(6));
                sto.setState(rs.getString(7));
                sto.setZip_code(rs.getString(8));
                vec.add(sto);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vec;
    }

    public static void main(String[] args) {
        DAOStores dao = new DAOStores();
//        int n = dao.addStore(new Stores(4, "Fat_Store", "012312312", "fatfat@gmail.com", "Ha Noi", "Ha Noi","MB ", "10000"));
//        int n = dao.updateStore(new Stores(4, "Fat_Storev1", "012312312", "fatfat231321@gmail.com", "Phu Cu", "Hung Yen","MB ", "12000"));
//        if(n>0){
//            System.out.println("updated");
//        }
//          System.out.println(dao.listAll());
//        dao.removeStore(4);
        System.out.println(dao.searchStorename("a"));
    }
}
