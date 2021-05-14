package Doanbanhang.DAL;



    import java.sql.*;
    import java.util.Scanner;
import javax.swing.*;
       
    public class connect {

    public connect() {
    }

        public Connection con;
        public Scanner sc = new Scanner(System.in);


        
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
    }

  /*
    public class connect {

        public Connection con;
        public Scanner sc = new Scanner(System.in);

      

        connect() {

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLHANGHOA";
                String username = "sa";
                String password = "sa";
                con = DriverManager.getConnection(dbUrl, username, password);              
                con.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());

            }

        }
    }




/*
        private void FindSP() {
            try {
                Statement stmt = con.createStatement();
                String LoaiSP = sc.nextLine();
                ResultSet rs = stmt.executeQuery("select * from SanPham "
                        + " where MaLoaiSP in(select MaLoaiSP from LoaiSanPham where TenLoaiSP ='" + LoaiSP + "')");
                while (rs.next()) {
                    System.out.println("MaSP: " + rs.getString("MaSP") + " TenSP: "
                            + rs.getString("TenSP") + " Gia: " + rs.getString("Gia")
                            + " MaLoaiSP: " + rs.getString("MaLoaiSP"));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
*/
    