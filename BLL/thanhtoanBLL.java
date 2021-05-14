/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.BLL;

import Doanbanhang.DAL.thanhtoanDAL;

/**
 *
 * @author Quoc Phu
 */
public class thanhtoanBLL {
    thanhtoanDAL ttDAL =new thanhtoanDAL();
    public int hientongtien(String mshh){
        return ttDAL.thanhtien(mshh);
    }
    public void thanhtoan(String kh,String msmh,String tong,String thanh){
        ttDAL.tthd(kh, msmh, tong, thanh);
    }
    public boolean test(String tenkh,String sdt){
        return ttDAL.testkh(tenkh, sdt);
    }
    public void ttaddkh(String hovaten,String email, String sodienthoai,String diachi){
        ttDAL.ttaddkh(hovaten, email, sodienthoai, diachi);
    }
}
