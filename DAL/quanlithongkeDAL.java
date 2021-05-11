/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DAL;


import Doanbanhang.DTO.dulieunhanvien;
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
   Connection con;
    Vector<dulieunhanvien> nhanvienList = new Vector<dulieunhanvien>();
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
                pre.executeQuery("Select * from hoadon");
                ResultSet rs=pre.getResultSet();
                while (rs.next()) {
                    dulieuthongke tk  = new dulieuthongke();
                    tk.setID(rs.getString("ID"));
                    tk.setMaHD(rs.getString("MaHD"));
                    tk.setNgayXuat(rs.getString("NgayXuat"));
                    tk.setKhachHang(rs.getString("KhachHang"));
                    tk.setTongTien(rs.getString("TongTien"));
                    tk.setGiamGia(rs.getString("GiamGia"));
                    tk.setThanhTien(rs.getString("ThanhTien"));
                    b.add(tk);
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                   

            } finally {
                closeConnect();
                
            }
        }
       return b; 
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



    
    
    public void addnhanvien(String ID,String hovaten,String chucvu,String chinhanh,String sdt,String diachi, String luong) {
        String add = "INSERT INTO nhanvien VALUES(?,?,?,?,?,?,?)";
        if (Connection() ) {
            try {
                PreparedStatement pre = con.prepareStatement(add);
                pre.setString(1, ID);
                pre.setString(2, hovaten);
                pre.setString(3,chucvu);
                pre.setString(4,chinhanh);
                pre.setString(5,sdt);
                pre.setString(6,diachi);
                pre.setString(7,luong);
                pre.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnect();
            }
        }
    }
    public void deletenv(String ID) {
        String delete = "DELETE FROM nhanvien WHERE ID=? ";
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
