/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DAL;


    import java.sql.*;
    import java.util.Scanner;
import javax.swing.*;
    public class connect {

    public connect() {
    }

        public Connection con;
        public Scanner sc = new Scanner(System.in);

//        public static void main(String[] args) {
//            new connect();
//        } 
        
        public  Connection connectsql()
        {
                 String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLBanHangD_A";
                String username = "lamquocphu1309";
                String password = "0704720250";
                try
                {
                                 return DriverManager.getConnection(dbUrl, username, password);
   
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                return  null;
        }
//        connect() {
//
//            try {
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLHANGHOA";
//                String username = "sa";
//                String password = "sa";
//                con = DriverManager.getConnection(dbUrl, username, password);
                //System.out.println("Them SP");
                //addSP();
                //System.out.println("Hien Thi DS_SP sau Khi them SP");
                //DisPlay();
                //System.out.println("Xoa SP");
                //DeleteSP();
                //System.out.println("Hien Thi DS_SP sau Khi xoa SP");
                //DisPlay();

                //System.out.println("Sua SP");
                //UpdateSP();
                //System.out.println("hien thi DS_Sp sau khi sua SP");
                //DisPlay();
//                System.out.println("tim SP theo LoaiSP");
//                FindSP();
//                con.close();
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//
//            }
//
//        }
    }