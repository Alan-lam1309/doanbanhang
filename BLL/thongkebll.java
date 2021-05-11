/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.BLL;


import java.util.Vector;

import Doanbanhang.DAL.quanlithongkeDAL;
import Doanbanhang.DTO.dulieuthongke;
import java.util.Vector;

public class thongkebll {

    quanlithongkeDAL qltkDAL;
    public thongkebll(){
        qltkDAL = new quanlithongkeDAL();
    }
    public Vector<dulieuthongke> showlistkh(){
        return qltkDAL.DisPlay(); 
    }
    public void addkhBLL(String ID,String name,String email,String sdt,String diachi,String loaikh,String diemtichluy) {
        qltkDAL.addhoadon(ID,name,email,sdt,diachi,loaikh,diemtichluy);
    }
    public void dltkh(String ID){
        qltkDAL.deletehoadon(ID);
    }
}