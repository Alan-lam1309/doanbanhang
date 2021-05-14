package Doanbanhang.BLL;

import Doanbanhang.DAL.addaccountDAL;
import Doanbanhang.DTO.dulieuaccount;
import java.util.Vector;

public class BLLaddaccount {

    addaccountDAL acDAL = new addaccountDAL();

    public Vector<dulieuaccount> showlist() {
        return acDAL.showlist();
    }
    public boolean test(String user){
        return acDAL.testaccount(user);
    }

    public void addacBLL(String user, String pass) {
        acDAL.addAccount(user, pass);
    }
    public void dltacDLL(String user,String pass){
        acDAL.deleteAccount(user, pass);
    }
    public void updacDLL(String user1, String user2,String pass){
        acDAL.updateAccount(user1, user2, pass);
    }
}
