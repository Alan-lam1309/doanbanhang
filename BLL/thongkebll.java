/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.BLL;


import Doanbanhang.DAL.quanlithongkeDAL;
import Doanbanhang.DTO.dulieuthongke;
import java.util.Vector;
import java.util.Vector;

public class thongkebll {

    quanlithongkeDAL qltkDAL;
    public thongkebll(){
        qltkDAL = new quanlithongkeDAL();
    }
    public Vector<dulieuthongke> showlisttk(){
        return qltkDAL.hoadonlist(); 
    }
    public void addtk(String ID,String MaHD,String NgayXuat,String KhachHang,String MaSoMatHang ,String TongTien,String GiamGia,String ThanhTien) {
        qltkDAL.addhoadon(ID,MaHD,NgayXuat,KhachHang, MaSoMatHang, TongTien,GiamGia,ThanhTien);
    }
    public void deletetk(String ID){
        qltkDAL.deletehoadon(ID);
    }
    public String updatetk(String SDH,String MaHD,String NgayXuat,String KhachHang,String MaSoMatHang, String TongTien,String GiamGia,String ThanhTien ){
        if(qltkDAL.updatehoadon(SDH,MaHD,NgayXuat,KhachHang,MaSoMatHang,TongTien,GiamGia,ThanhTien)){
            return "Update success";
        }
        return "Fail 🙁";
        
    }
}