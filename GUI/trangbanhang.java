/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.GUI;

import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Quoc Phu
 */
public class trangbanhang {
    JFrame j= new JFrame("GUU STORE0");

    public trangbanhang() {
        j.setSize(500,450);
        j.setResizable(false);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        
        JLabel idsp=new JLabel("Mã số sản phẩm: ");
        idsp.setBounds(20,60,300,30);
        idsp.setFont(new Font("aaaa",Font.PLAIN,21));
        JLabel tenkhachhang=new JLabel("Tên khách hàng: ");
        tenkhachhang.setBounds(20,100,300,30);
        tenkhachhang.setFont(new Font("tenkhachhang",Font.PLAIN,21));
        JLabel sdt =new JLabel("Số điện thoại: ");
        sdt.setBounds(20,140,300,30);
        sdt.setFont(new Font("tenkhachhang",Font.PLAIN,21));
        JLabel diachi =new JLabel("Địa chỉ: ");
        diachi.setBounds(20,180,300,30);
        diachi.setFont(new Font("tenkhachhang",Font.PLAIN,21));
        JLabel email =new JLabel("Email: ");
        email.setBounds(20,220,300,30);
        email.setFont(new Font("tenkhachhang",Font.PLAIN,21));
        JTextField bt1=new JTextField();
        bt1.setBounds(180,60,300,30);
        JTextField bt2=new JTextField();
        bt2.setBounds(180,100,300,30);
        JTextField bt3=new JTextField();
        bt3.setBounds(180,140,300,30);
        JTextField bt4=new JTextField();
        bt4.setBounds(180,180,300,30);
        JTextField bt5=new JTextField();
        bt5.setBounds(180,220,300,30);
        j.add(idsp);j.add(bt1);
        j.add(tenkhachhang);j.add(bt2);
        j.add(sdt);j.add(bt3);
        j.add(diachi);j.add(bt4);
        j.add(email);j.add(bt5);
        j.setVisible(true);
        
    }
    
    
}
