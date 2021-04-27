/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

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
    
    public String getID(){
        return ID;
    }
    public String gethovaten() {
        return hovaten;
    }
    public String getchucvu(){
        return chucvu;
    }
    public String getchinhanh(){
        return chinhanh;
    }
    public String getsdt() {
       return sdt;
    }

    public String getdiachi() {
        return diachi;
    }

    public String getluong() {
        return luong;
    }
    

    

}
