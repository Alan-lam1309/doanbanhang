/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DAL;


import java.sql.DriverManager;

import java.sql.Connection;
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
    public void closeConnect(){
        try{
            if(con!=null)
                con.close();
        }catch(Exception ec){
            System.out.println(ec);
        }
    }
    

}
