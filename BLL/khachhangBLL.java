/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.BLL;
import Doanbanhang.DAL.qlkhDAL;
import Doanbanhang.DTO.dulieukhachhang;
import java.util.Vector;

/**
 *
 * @author huyhu
 */
public class khachhangBLL {
    qlkhDAL qlkhAL;
    public khachhangBLL(){
        qlkhAL = new qlkhDAL();
    }
    public Vector<dulieukhachhang> showlistkh(){
        return qlkhAL.customerList(); 
    }
    public void addkhBLL(String ID,String name,String email,String sdt,String diachi,String loaikh,String diemtichluy) {
        qlkhAL.addkhachhang(ID,name,email,sdt,diachi,loaikh,diemtichluy);
    }
    public void dltkh(String ID){
        qlkhAL.deletekh(ID);
    }
    public void updhvtkh(String ID1,String ID2,String ten,String place,String sdt,String loai,String diem ){
        qlkhAL.updatehovatenkhachhang(ID1,ID2,ten,place,sdt,loai,diem);
    }
}
