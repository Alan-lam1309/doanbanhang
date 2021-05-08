/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DAL;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Doanbanhang.GUI.trangchu;
import java.util.ArrayList;
import java.util.Vector;
import Doanbanhang.DTO.dulieuaccount;

/**
 *
 * @author Quoc Phu
 */
public class addaccountDAL {

    Connection con;

    public boolean Connection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLBanHangD_A";
            String username = "lamquocphu1309";
            String password = "0704720250";
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;

        } catch (Exception ev) {
            System.err.println(ev.getMessage());
        }
        return false;
    }

    public void closeConnect() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception ec) {
            System.out.println(ec);
        }
    }

    /**
     *
     * @param a
     */
    public Vector<dulieuaccount> showlist() {
        Vector<dulieuaccount> a = new Vector<dulieuaccount>();
        if (Connection()) {
            try {
                Statement pre = con.createStatement();
                pre.executeQuery("Select * from DangNhap");
                ResultSet rs = pre.getResultSet();
                while (rs.next()) {
                    dulieuaccount dl = new dulieuaccount();
                    dl.setName(rs.getString("NAMEUSER"));
                    dl.setPass(rs.getString("PASSWD"));
                    a.add(dl);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            } finally {
                closeConnect();
                
            }
        }
        return a;
    }

    public boolean testaccount(String user) {

        if (Connection()) {
            try {
                PreparedStatement pre = con.prepareStatement("select * from DangNhap where NAMEUSER=?");
                pre.setString(1, user);
                pre.execute();
                ResultSet rs = pre.getResultSet();
                while (rs.next()) {
                    System.out.println("TRÙNG TÊN ĐĂNG NHẬP");
                    return false;
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnect();
            }
        }
        return true;
    }

    public void addAccount(String user, String pass) {
        String add = "INSERT INTO DangNhap VALUES(?,?)";
        if (Connection()) {
            try {
                PreparedStatement pre = con.prepareStatement(add);
                pre.setString(1, user);
                pre.setString(2, pass);
                pre.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnect();
            }
        }
    }

    public void deleteAccount(String user, String pass) {
        String delete = "DELETE FROM DangNhap WHERE NAMEUSER=? ";
        if (Connection()) {
            try {
                PreparedStatement pred = con.prepareStatement(delete);
                pred.setString(1, user);
                pred.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnect();
            }
        }
    }
    public void updateAccount(String user1,String user2,String pass){
        String update="UPDATE DangNhap SET NAMEUSER=?, PASSWD=? WHERE NAMEUSER=?";
        if(Connection()){
            try{
                PreparedStatement prep =con.prepareStatement(update);
                prep.setString(1,user2);
                prep.setString(2,pass);
                prep.setString(3,user1);
                prep.executeUpdate();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }finally{
                closeConnect();
            }
        }
    } 
}
