/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DTO;

/**
 *
 * @author Phuc loz
 */
public class dulieudoanhthu {

    String ID1;
    String MaHD1;
    String KhachHang;
    String CuaHang;
    String DoanhThu;
        public  dulieudoanhthu (String ID, String MaHD, String KhachHang, String CuaHang,String DoanhThu )
        {
           this.ID1=ID;
           this.MaHD1=MaHD;
           this.KhachHang=KhachHang;
           this.CuaHang=CuaHang;
           this.DoanhThu=DoanhThu;
        }
        public dulieudoanhthu ()
        { 
        }

    public String getID1() {
        return ID1;
    }

    public void setID1(String ID1) {
        this.ID1 = ID1;
    }

    public String getMaHD1() {
        return MaHD1;
    }

    public void setMaHD1(String MaHD1) {
        this.MaHD1 = MaHD1;
    }

    public String getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(String KhachHang) {
        this.KhachHang = KhachHang;
    }

    public String getCuaHang() {
        return CuaHang;
    }

    public void setCuaHang(String CuaHang) {
        this.CuaHang = CuaHang;
    }

    public String getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(String DoanhThu) {
        this.DoanhThu = DoanhThu;
    }

        
        
}