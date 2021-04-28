/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import DLL.DLLlogin;

/**
 *
 * @author Quoc Phu
 */
public class Dangnhap {
    DLLlogin dlllogin=new DLLlogin();
    
   JFrame j= new JFrame();
        JLabel l=new JLabel("LOG IN");
        JPanel p= new JPanel();
        JPanel p1= new JPanel();
        JPanel p2=new JPanel();
        JTextField t1= new JTextField();
        JPasswordField t2= new JPasswordField();
        JLabel name= new JLabel("Your Name:");
        JLabel pass= new JLabel("PassWord :");
        JButton submit = new JButton("Submit",new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\dangnhap.png"));
        JButton exit = new JButton("Exit",new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\9739889771543238875-512.png"));
        
    Dangnhap(){
       
        l.setFont(new Font("Vẻdana", Font.PLAIN,50));
        j.add(l);
        l.setBounds(140,50,450,50);
         p.add(name);
         p.add(t1);
         t1.setPreferredSize(new Dimension(200,30));
         t2.setPreferredSize(new Dimension(200,30));
         p.add(pass);
         p.add(t2);
         p.setBounds(60,120,300,70);
         j.add(p);
         
      
        
        
        
       
        
        submit.setBounds(110,230, 112, 30);
        exit.setBounds(240, 230, 112, 30);
        
        j.add(submit);j.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               j.dispose();
            }
        });
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(t1.getText().equals("") || t2.getText().equals("")  ){
                    JOptionPane.showMessageDialog(null,"Bạn chưa nhập thông tin tài khoản vào ô đăng nhập!!!!!!!!!");
                }
                else{
                    if(dlllogin.dlllogin(t1.getText(), t2.getText()))
                    {
                        JOptionPane.showMessageDialog(null,"Đăng nhập thành công :)))))");
                        new trangchu();
                        j.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Your name or your password is wrong");
                    }
                }
                
            }
        });
        
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLayout(null);
        j.setBounds(500,150,450,350);
        j.setVisible(true);
    }
    
}
