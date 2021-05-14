package Doanbanhang.DAL;

import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import jdk.nashorn.api.tree.WhileLoopTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quoc Phu
 */
public class thanhtoanDAL {

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
    

    public int thanhtien(String tt) {
        try {
            if (Connection()) {
                PreparedStatement pre = con.prepareStatement("Select * FROM SanPham where MASP=? ");
                pre.setString(1, tt);
                pre.execute();
                ResultSet rs = pre.getResultSet();
                while (rs.next()) {
                    return rs.getInt(3);
                    
                }
            }
        } catch (Exception e) {

        }
        return 0;

    }
    public int dem(){
        String stt="Select * from hoadon";
        try{
            if(Connection()){
                Statement stmt=con.createStatement();
                stmt.executeQuery(stt);
                ResultSet rs=stmt.getResultSet();
                rs.last();
                int st=rs.getRow();
                JOptionPane.showMessageDialog(null, st);
                return st;
            }
        }catch(Exception e){
            
        }
        return 0;
    }
    public void tthd( String kh, String msmh,String tong,String thanh) {

        String thanhtoan = "INSERT INTO hoadon VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            if (Connection()) {
                
                
                PreparedStatement pre = con.prepareStatement(thanhtoan);
                pre.setInt(1, toString().indexOf(dem()+1));
                pre.setInt(2, toString().indexOf(dem()+1));
                pre.setString(3, java.time.LocalDate.now().toString());
                pre.setString(4, kh);
                pre.setString(5, msmh);
                pre.setString(6, tong);
                pre.setString(7,"0" );
                pre.setString(8,thanh);
                pre.execute();
            }
        } catch (Exception e) {
            e.getMessage();
        }finally{
            closeConnect();
        }
    }
    public boolean testkh(String tenkh,String sdt) {

        if (Connection()) {
            try {
                PreparedStatement pre = con.prepareStatement("select * from DangNhap where hovaten=?,sodienthoai=?");
                pre.setString(1, tenkh);
                pre.setString(2, sdt);
                pre.execute();
                ResultSet rs = pre.getResultSet();
                while (rs.next()) {
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
    public void ttaddkh(String hovaten,String email,String sodienthoai,String diachi) {
        String add = "INSERT INTO khachhang (hovaten,email,sodienthoai,diachi) VALUES(?,?,?,?)";
        if (Connection() ) {
            try {
                PreparedStatement pre = con.prepareStatement(add);
                pre.setString(1, hovaten);
                pre.setString(2,email);
                pre.setString(3,sodienthoai);
                pre.setString(4,diachi);
                pre.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                closeConnect();
            }
        }
    }
}
