/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Quoc Phu
 */
public class loginDAL {

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
    public void closeConnect(){
        try{
            if(con!=null)
                con.close();
        }catch(Exception ec){
            System.out.println(ec);
        }
    }

    public boolean dangnhap(String user, String pass) {

        if (Connection()) {
            try {
                PreparedStatement pre = con.prepareStatement("select * from DangNhap where NAMEUSER=? and PASSWD=?");
                pre.setString(1, user);
                pre.setString(2, pass);
                pre.execute();
                ResultSet rs = pre.getResultSet();
                while (rs.next()) {
                    return true;
                }
                
            } catch (Exception e) {
                System.out.println(e);   
            }finally{
                closeConnect();
            } 
        }
        return false;
    }

   
}

    
