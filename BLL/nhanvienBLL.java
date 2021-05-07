/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.BLL;
import Doanbanhang.DAL.qlnvDAL;
import Doanbanhang.DTO.dulieunhanvien;
import  java.util.Vector;
/**
 *
 * @author huyhu
 */
public class nhanvienBLL {
    qlnvDAL qlnvAL;
    public nhanvienBLL(){
        qlnvAL = new qlnvDAL();
    }
    public Vector<dulieunhanvien> showlistnv(){
        return qlnvAL.nhanvienList();
    }
    public void addnvBLL(String ID,String hovaten,String chucvu,String chinhanh,String sdt,String diachi, String luong){
        qlnvAL.addnhanvien(ID,hovaten,chucvu,chinhanh,sdt,diachi,luong);
    }
    public void dltnv(String ID){
        qlnvAL.deletenv(ID);
    }
}
