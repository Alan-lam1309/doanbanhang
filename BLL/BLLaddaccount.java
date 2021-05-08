package Doanbanhang.BLL;

import Doanbanhang.DAL.addaccountDAL;
import Doanbanhang.DTO.dulieuaccount;
import java.util.Vector;

public class BLLaddaccount {

    addaccountDAL acDAL = new addaccountDAL();

    public Vector<dulieuaccount> showlist() {
        return acDAL.showlist();
    }

    public void addacBLL(String user, String pass) {
        acDAL.addAccount(user, pass);
    }
    public void dltacDLL(String user,String pass){
        acDAL.deleteAccount(user, pass);
    }
}
