/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.DTO;

/**
 *
 * @author Quoc Phu
 */
public class dulieuaccount {
    String name;
    String pass;
    public dulieuaccount(String name,String pass){
        this.name=name;
        this.pass=pass;
    }
    public String getName(){
        return name;
    }
    public String getPass(){
        return pass;
    }
}
