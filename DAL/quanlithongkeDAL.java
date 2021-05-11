/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DAL;


import java.util.Vector;
import java.sql.*;
import java.sql.Statement;
import Doanbanhang.DTO.dulieuthongke;
import Doanbanhang.GUI.quanlyhoadon;
import java.util.HashSet;
import java.util.Scanner;
/**
 *
 * @author Phuc loz
 */

public class quanlithongkeDAL {
    public Scanner sc = new Scanner(System.in);
    connect openconnect = new connect();
    Connection con = openconnect.connectsql();
    
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



    public Vector<dulieuthongke> DisPlay() {
        Vector<dulieuthongke> thongke = new Vector<>();;
        if (Connection()) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hoadon");
            while (rs.next()) {

        dulieuthongke tk=new dulieuthongke
        (rs.getString("ID"),rs.getString("MSHĐ"),rs.getString("NgayXuat"),rs.getString("KhachHang"),rs.getString("TongTien"),rs.getString("GiamGia"),rs.getString("ThanhTien"));
                    thongke.add(tk);
        }
        }catch (SQLException e) {
            System.err.println(e.getMessage());
                   } 
        finally {
                closeConnect();
                
            }
        
        
    } 
        return thongke;
    }
  
    public void addhoadon(String ID,String MaHD, String NgayXuat,String KhachHang,String TongTien,String GiamGia,String ThanhTien ) {
        String add = "INSERT INTO hoadon VALUES(?,?,?,?,?,?,?)";
        if (Connection() ) {
            try {
                PreparedStatement stmt = con.prepareStatement(add);
                stmt.setString(1, ID);
                stmt.setString(2, MaHD);
                stmt.setString(3, NgayXuat);
                stmt.setString(4, KhachHang);
                stmt.setString(5, TongTien);
                stmt.setString(6, GiamGia);
                stmt.setString(7, ThanhTien);
                stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnect();
            }
        }
    }
    public void deletehoadon (String ID) {
        String delete = "DELETE FROM khachhang WHERE ID=? ";
        if (Connection()) {
            try {
                PreparedStatement pred = con.prepareStatement(delete);
                pred.setString(1,ID);
                pred.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnect();
            }
        }
    }
}