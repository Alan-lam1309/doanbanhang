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
import Doanbanhang.DTO.dulieunhanvien;
/**
 *
 * @author huyhu
 */
public class qlnvDAL {
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
    public Vector<dulieunhanvien> nhanvienList() {
        Vector<dulieunhanvien> a = new Vector<dulieunhanvien>();
        if (Connection()) {
            try {
                
                Statement pre = con.createStatement();
                pre.executeQuery("Select * from nhanvien");
                ResultSet rs=pre.getResultSet();
                while (rs.next()) {
                    dulieunhanvien nv = new dulieunhanvien();
                    nv.setID(rs.getString("ID"));
                    nv.sethovaten(rs.getString("hovaten"));
                    nv.setchucvu(rs.getString("chucvu"));
                    nv.setchinhanh(rs.getString("chinhanh"));
                    nv.setsdt(rs.getString("sodienthoai"));
                    nv.setdiachi(rs.getString("diachi"));
                    nv.setluong(rs.getString("luong"));
                    a.add(nv);
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                   

            } finally {
                closeConnect();
                
            }
        }
       return a; 
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
