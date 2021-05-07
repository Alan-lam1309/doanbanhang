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
import Doanbanhang.DTO.dulieukhachhang;

/**
 *
 * @author huyhu
 */
public class qlkhDAL {
    Connection con ;
    Vector<dulieukhachhang> customerList = new Vector<dulieukhachhang>();
    public qlkhDAL(){
        
    }
    public boolean Connection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLBanHangD_A";
            String username = "lamquocphu1309";
            String password = "0704720250";
            con = (Connection) DriverManager.getConnection(dbUrl, username, password);
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
    public Vector<dulieukhachhang> customerList() {
        Vector<dulieukhachhang> a = new Vector<dulieukhachhang>();
        if (Connection()) {
            try {
                
                Statement pre = con.createStatement();
                pre.executeQuery("Select * from khachhang");
                ResultSet rs=pre.getResultSet();
                while (rs.next()) {
                    dulieukhachhang kh = new dulieukhachhang();
                    kh.setID(rs.getString("ID"));
                    kh.setHovaten(rs.getString("Hovaten"));
                    kh.setEmail("email");
                    kh.setSodienthoai("sodienthoai");
                    kh.setDiachi("diachi");
                    kh.setLoaikhachhang("loaikhachhang");
                    kh.setDiemtichluy("diemtichluy");
                    a.add(kh);
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                   

            } finally {
                closeConnect();
                
            }
        }
       return a; 
    }
    public void addkhachhang(String ID,String hovaten,String email,String sodienthoai,String diachi,String loaikh,String diemtichluy ) {
        String add = "INSERT INTO khachhang VALUES(?,?,?,?,?,?,?)";
        if (Connection() ) {
            try {
                PreparedStatement pre = con.prepareStatement(add);
                pre.setString(1, ID);
                pre.setString(2, hovaten);
                pre.setString(3,email);
                pre.setString(4,sodienthoai);
                pre.setString(5,diachi);
                pre.setString(6,loaikh);
                pre.setString(7,diemtichluy);
                pre.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnect();
            }
        }
    }
}
