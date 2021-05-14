
package Doanbanhang.BLL;


import Doanbanhang.DAL.quanlidoanhthuDAL;
import Doanbanhang.DTO.dulieudoanhthu;
import java.util.Vector;
/**
 *
 * @author Phuc loz
 */
public class doanhthubll {

    quanlidoanhthuDAL qldtDAL;
    public doanhthubll(){
        qldtDAL = new quanlidoanhthuDAL();
    }
    public Vector<dulieudoanhthu> showlistdt(){
        return qldtDAL.doanhthulist(); 
    }
    public void adddt(String ID1,String MaHD1,String KhachHang,String CuaHang,String DoanhThu) {
        qldtDAL.adddoanhthu(ID1,MaHD1,KhachHang,CuaHang,DoanhThu);
    }
    public void deletedt(String ID1){
        qldtDAL.deletedoanhthu(ID1);
    }
    public String updatedt(String ID1,String MaHD1,String KhachHang,String CuaHang,String DoanhThu ){
        if(qldtDAL.updatedoanhthu(ID1,MaHD1,KhachHang,CuaHang,DoanhThu)){
            return "Update success";
        }
        return "Fail 🙁";
        
    }
}

