/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DAL;

import Doanbanhang.DTO.dulieudoanhthu;
import Doanbanhang.DTO.dulieuthongke;
import java.util.Vector;
import java.sql.*;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Phuc loz
 */

public class quanlidoanhthuDAL {

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

    public Vector<dulieudoanhthu> doanhthulist() {
        Vector<dulieudoanhthu> c = new Vector<dulieudoanhthu>();
        if (Connection()) {
            try {

                Statement pre = con.createStatement();
                ResultSet rs = pre.executeQuery("Select * from doanhthu");
                while (rs.next()) {
                    dulieudoanhthu dt = new dulieudoanhthu();
                    dt.setID1(rs.getString(1));
                    dt.setMaHD1(rs.getString(2));
                    dt.setKhachHang(rs.getString(3));
                    dt.setCuaHang(rs.getString(4));
                    dt.setDoanhThu(rs.getString(5));
                    c.add(dt);
                }
                return c;
            } catch (Exception e) {
                System.out.println(e.getMessage());

            } finally {
                closeConnect();

            }
        }
        return c;
    }

    public void adddoanhthu(String ID1, String MaHD1, String KhachHang,String CuaHang, String DoanhThu) {
        String add = "INSERT INTO doanhthu VALUES(?,?,?,?,?)";
        if (Connection()) {
            try {
                PreparedStatement stmt = con.prepareStatement(add);
                stmt.setString(1, ID1);
                stmt.setString(2, MaHD1);
                stmt.setString(3, KhachHang);
                stmt.setString(4, CuaHang);
                stmt.setString(5, DoanhThu);
                stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnect();
            }
        }
    }

    public void deletedoanhthu(String ID1) {
        String delete = "DELETE FROM doanhthu WHERE SoDonHang=? ";
        if (Connection()) {
            try {
                PreparedStatement stmt = con.prepareStatement(delete);
                stmt.setString(1, ID1);
                stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnect();
            }
        }
    }

    public boolean updatedoanhthu(String ID1,String MaHD1,String KhachHang,String CuaHang,String DoanhThu) {
        boolean result = false;
        if (Connection()) {
            try {
                String update = "UPDATE doanhthu SET SoDonHang=?,MaSoHoaDon=?,TenKhachHang=?,CuaHang=?,DoanhThu=? WHERE SoDonHang=?";
                PreparedStatement prep = con.prepareStatement(update);
                prep.setString(1, ID1);
                prep.setString(2, MaHD1);
                prep.setString(3, KhachHang);
                prep.setString(4, CuaHang);
                prep.setString(5, DoanhThu);

                
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
    
    
    
    
    
//    
//    
//    public Vector<Employee> SearchNhanVien(String ten){
//        Vector<Employee> arrEmp = null;
//        String sql;
//            sql = "SELECT * FROM NhanVien WHERE TENNV LIKE '"+ten+"%'";
//        try{
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrEmp = new Vector<Employee>();
//            while(rs.next()){
//                Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
//                arrEmp.add(e);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "lỗi !");
//        }
//        return arrEmp;
//    }
//    
//    
    
    
    
    public void searchdoanhthu(String ID1) {
        String delete = "DELETE FROM doanhthu WHERE SoDonHang=? ";
        if (Connection()) {
            try {
                PreparedStatement stmt = con.prepareStatement(delete);
                stmt.setString(1, ID1);
                stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                closeConnect();
            }
        }
    }

}