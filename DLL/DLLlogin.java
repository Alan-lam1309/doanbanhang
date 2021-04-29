/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DLL;
import Doanbanhang.DAL.loginDAL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Doanbanhang.DAL.loginDAL;
/**
 *
 * @author Quoc Phu
 */
public class DLLlogin {
    loginDAL logindal=new loginDAL();
    public boolean dlllogin(String user,String pass){
        return logindal.dangnhap(user, pass);
    }
}
