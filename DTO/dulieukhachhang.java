/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DTO;

import java.util.Vector;

/**
 *
 * @author huyhu
 */
public class dulieukhachhang {

    String ID, hovaten, email, diachi, loaikhachhang;
    String sodienthoai, diemtichluy;

    public dulieukhachhang(String ID, String hovaten, String email,String sodienthoai, String diachi, String loaikhachhang, String diemtichluy) {
        this.ID = ID;
        this.hovaten = hovaten;
        this.email = email;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.loaikhachhang = loaikhachhang;
        this.diemtichluy = diemtichluy;
    }

    
    public dulieukhachhang() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getLoaikhachhang() {
        return loaikhachhang;
    }

    public void setLoaikhachhang(String loaikhachhang) {
        this.loaikhachhang = loaikhachhang;
    }

    public String getDiemtichluy() {
        return diemtichluy;
    }

    public void setDiemtichluy(String diemtichluy) {
        this.diemtichluy = diemtichluy;
    }

}
