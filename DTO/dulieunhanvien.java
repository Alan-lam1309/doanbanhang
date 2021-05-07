/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DTO;

/**
 *
 * @author huyhu
 */
public class dulieunhanvien {
    String ID, hovaten, chucvu, chinhanh,diachi;
    String sdt, luong;
    public dulieunhanvien(String ID,String hovaten,String chucvu,String chinhanh,String sdt,String diachi, String luong){
        this.ID=ID;
        this.hovaten=hovaten;
        this.chucvu=chucvu;
        this.chinhanh=chinhanh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.luong= luong;
    }
    public dulieunhanvien(){
        
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String gethovaten() {
        return hovaten;
    }
    public void sethovaten(String hovaten) {
        this.hovaten = hovaten;
    }
    public String getchucvu(){
        return chucvu;
    }
    public void setchucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    public String getchinhanh(){
        return chinhanh;
    }
    public void setchinhanh(String chinhanh) {
        this.chinhanh = chinhanh;
    }
    public String getsdt() {
       return sdt;
    }
    public void setsdt(String sdt) {
        this.sdt = sdt;
    }
    public String getdiachi() {
        return diachi;
    }
    public void setdiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getluong() {
        return luong;
    }
    public void setluong(String luong) {
        this.luong = luong;
    }
}
