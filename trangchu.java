/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanbanhang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.CubicCurve2D;
import java.security.PKCS12Attribute;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author Quoc Phu
 */
public class trangchu {
    Calendar cal = Calendar.getInstance();

    trangchu(){
        JFrame j=new JFrame("aaa");
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setResizable(false);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel p=new JPanel(null);
        p.setBorder(BorderFactory.createLoweredBevelBorder());
        JPanel p1=new JPanel(null);
        JPanel p2=new JPanel(null);
        JLabel background =new JLabel(new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\background1.jpg"));
        background.setBounds(0, 0, 1680, 900);
        
        
        JButton b1 = new JButton("Quản lí Cửa Hàng",new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (8) (2).jpg"));
        b1.setFont(new Font("Vẻdana", Font.PLAIN,21));
        JButton b2 = new JButton("Quản lí Doanh Thu");
        b2.setFont(new Font("Vẻdana", Font.PLAIN,21));
        JButton b3 = new JButton("Quản lí Hàng Hóa");
        b3.setFont(new Font("Vẻdana", Font.PLAIN,21));
        JButton b4= new JButton("Quản lí Account");
        b1.setBounds(0,100,301,100);
        b2.setBounds(0,250,301,100);
        b3.setBounds(0,400,301,100);
        b4.setBounds(0,550,301,100);
        
        JButton nvq1 = new JButton("Nhân viên",new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\aaa.jpg"));
        JButton hhq1 = new JButton("Hàng hóa");
        JButton dtq1 = new JButton("Doanh thu");
        JButton hdq1 = new JButton("Hóa đơn");
        JButton nvq2 = new JButton("Nhân viên");
        JButton hhq2 = new JButton("Hàng hóa");
        JButton dtq2 = new JButton("Doanh thu");
        JButton hdq2 = new JButton("Hóa đơn");
        JButton nvq3 = new JButton("Nhân viên");
        JButton hhq3 = new JButton("Hàng hóa");
        JButton dtq3= new JButton("Doanh thu");
        JButton hdq3 = new JButton("Hóa đơn");
        JButton nvq4 = new JButton("Nhân viên");
        JButton hhq4 = new JButton("Hàng hóa");
        JButton dtq4 = new JButton("Doanh thu");
        JButton hdq4 = new JButton("Hóa đơn");
        
        //phần doanh thu của tổng quán----------------------------------------------------------
        JLabel l1= new JLabel("DOANH THU CỦA CHUỖI");
        l1.setFont(new Font("Vẻdana", Font.PLAIN,50));
        l1.setBounds(330,0,1225,100);
        
        JLabel l2=new JLabel("Tháng: ");
        l2.setFont(new Font("Vẻdana", Font.PLAIN,17));
        l2.setBounds(50,150,100,30);
        JLabel l3=new JLabel("Năm:   ");
        l3.setFont(new Font("Vẻdana", Font.PLAIN,17));
        l3.setBounds(50,200,100,30);
        JComboBox cb =new JComboBox();
        cb.addItem("1");
        cb.addItem("2");
        cb.addItem("3");
        cb.addItem("4");
        cb.addItem("5");
        cb.addItem("6");
        cb.addItem("7");
        cb.addItem("8");
        cb.addItem("9");
        cb.addItem("10");
        cb.addItem("11");
        cb.addItem("12");
        cb.setBounds(120,150,80,30);
        JComboBox cb2=new JComboBox();
        cb2.setBounds(120,200,80,30);
       int i=cal.get(Calendar.YEAR),a=0;
       while(a<50){
           cb2.addItem(i);
           i--;
           a++;
       }
        
        p1.add(cb);
        p1.add(l2);
        p1.add(l3);
        p1.add(cb2);
        
        JPanel panel =new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK) );
        panel.setBounds(300,150,800,600);
        p1.add(panel);
        
        JLabel jLabel=new JLabel();
        
        JLabel l= new JLabel("Welcome admin to our store :))");
        l.setBounds(10,15,1000,200) ;
        l.setFont(new Font("Vẻdana", Font.PLAIN,50));
        
        JLabel lchinhanh1 = new JLabel("Chi nhánh quận 1");
        lchinhanh1.setFont(new Font("Vẻdana", Font.PLAIN,30));
        lchinhanh1.setBounds( 200, 50, 500, 50);
        p.add(lchinhanh1);
        p.add(nvq1);
        p.add(hhq1);
        p.add(hdq1);
        p.add(dtq1);
        nvq1.setBounds(110,150, 180, 70);
        hhq1.setBounds(110,240, 180, 70);
        hdq1.setBounds(350,150, 180, 70);
        dtq1.setBounds(350,240, 180, 70);
        
        JLabel lchinhanh2 = new JLabel("Chi nhánh quận 10");
        lchinhanh2.setFont(new Font("Vẻdana", Font.PLAIN,30));
        lchinhanh2.setBounds( 730, 50, 500, 50);
        p.add(lchinhanh2);
        p.add(nvq2);
        p.add(hhq2);
        p.add(hdq2);
        p.add(dtq2);
        nvq2.setBounds(110,560,180,70);
        hhq2.setBounds(110,650,180,70);
        hdq2.setBounds(350,560,180,70);
        dtq2.setBounds(350,650,180,70);
    
        JLabel lchinhanh3 = new JLabel("Chi nhánh quận Gò vấp");
        lchinhanh3.setFont(new Font("Vẻdana", Font.PLAIN,30));
        lchinhanh3.setBounds( 160, 450, 500, 50);
        p.add(lchinhanh3);
        p.add(nvq3);
        p.add(hhq3);
        p.add(hdq3);
        p.add(dtq3);
        nvq3.setBounds(650,150,180,70);
        hhq3.setBounds(650,240,180,70);
        hdq3.setBounds(890,150,180,70);
        dtq3.setBounds(890,240,180,70);
        
        JLabel lchinhanh4 = new JLabel("Chi nhánh quận 9");
        lchinhanh4.setFont(new Font("Vẻdana", Font.PLAIN,30));
        lchinhanh4.setBounds( 730, 450, 500, 50);
        p.add(lchinhanh4);
        p.add(nvq4);
        p.add(hhq4);
        p.add(hdq4);
        p.add(dtq4);
        nvq4.setBounds(650,560,180,70);
        hhq4.setBounds(650, 650, 180, 70);
        hdq4.setBounds(890, 560, 180, 70);
        dtq4.setBounds(890,650,180,70);
        
        p.setVisible(false);
        p1.setBackground(Color.blue);
        p1.setVisible(false);
        p2.setBackground(Color.yellow);
        p2.setVisible(false);
        p.setBounds (300,15,1225,815);
        p1.setBounds(300,15,1225,815);
        p2.setBounds(300,15,1225,815);
        
        p1.add(l1);
        
        j.add(p);
        j.add(p1);
        j.add(p2);
        j.add(b1);
        j.add(b2);
        j.add(b3);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                p1.setVisible(false);
                p.setVisible(true);
                p2.setVisible(false);
        }});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                p1.setVisible(true);
                p.setVisible(false);
                p2.setVisible(false);
        }});
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                p1.setVisible(false);
                p.setVisible(false);
                p2.setVisible(true);
        }});
        
        
        
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(background);
        j.setVisible(true);
        
    }
}
