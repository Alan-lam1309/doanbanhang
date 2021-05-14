/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DAL;

import Doanbanhang.DTO.dulieuthongke;
import java.util.Vector;
import java.sql.*;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Phuc loz
 */

public class quanlithongkeDAL {

    Connection con;
    Vector<dulieuthongke> thongkelist = new Vector<dulieuthongke>();

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

    public Vector<dulieuthongke> hoadonlist() {
        Vector<dulieuthongke> b = new Vector<dulieuthongke>();
        if (Connection()) {
            try {

                Statement pre = con.createStatement();
                ResultSet rs = pre.executeQuery("Select * from hoadon");
                while (rs.next()) {
                    dulieuthongke tk = new dulieuthongke();
                    tk.setID(rs.getString(1));
                    tk.setMaHD(rs.getString(2));
                    tk.setNgayXuat(rs.getString(3));
                    tk.setKhachHang(rs.getString(4));
                     tk.setMaSoMatHang(rs.getString(5));
                    tk.setTongTien(rs.getString(6));
                    tk.setGiamGia(rs.getString(7));
                    tk.setThanhTien(rs.getString(8));
                    b.add(tk);
                }
                return b;
            } catch (Exception e) {
                System.out.println(e.getMessage());

            } finally {
                closeConnect();

            }
        }
        return b;
    }

    public void addhoadon(String ID, String MaHD, String NgayXuat, String KhachHang,String MaSoMatHang, String TongTien, String GiamGia, String ThanhTien) {
        String add = "INSERT INTO hoadon VALUES(?,?,?,?,?,?,?,?)";
        if (Connection()) {
            try {
                PreparedStatement stmt = con.prepareStatement(add);
                stmt.setString(1, ID);
                stmt.setString(2, MaHD);
                stmt.setString(3, NgayXuat);
                stmt.setString(4, KhachHang);
                stmt.setString(5, MaSoMatHang);
                stmt.setString(6, TongTien);
                stmt.setString(7, GiamGia);
                stmt.setString(8, ThanhTien);
                stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnect();
            }
        }
    }

    public void deletehoadon(String ID) {
        String delete = "DELETE FROM hoadon WHERE SĐH=? ";
        if (Connection()) {
            try {
                PreparedStatement stmt = con.prepareStatement(delete);
                stmt.setString(1, ID);
                stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnect();
            }
        }
    }

    public boolean updatehoadon(String SDH, String MaHD, String NgayXuat, String KhachHang,String MaSoMatHang, String TongTien, String GiamGia, String ThanhTien) {
        boolean result = false;
        if (Connection()) {
            try {
                String update = "UPDATE hoadon SET SĐH=?,NgayXuat=?,KhachHang=?,MaSoMatHang=?,TongTien=?,GiamGia=?,ThanhTien=? WHERE MSHĐ=?";
                PreparedStatement prep = con.prepareStatement(update);
                prep.setString(1, SDH);
                prep.setString(2, MaHD);
                prep.setString(3, NgayXuat);
                prep.setString(4, KhachHang);
                prep.setString(5, MaSoMatHang);
                prep.setString(6, TongTien);        
                prep.setString(7, GiamGia);
                prep.setString(8, ThanhTien);
                
                if (prep.executeUpdate() >= 1) { 
                    result = true; 
                    
                    
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnect();
            }
        }
        return result;
    }

}