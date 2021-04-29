/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DAL;
import java.sql.*;

/**
 *
 * @author huyhu
 */
public class qlnvDAL {
    private Connection con;
    public boolean openConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(Exception ex){
            
        }
        return false;
        
    }
    

            
}
