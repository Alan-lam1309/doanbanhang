/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.GUI;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Doanbanhang.DTO.dulieukhachhang;

/**
 *
 * @author huyhu
 */
public class quanlykhachhang extends JFrame implements ActionListener{
        JTable jt = new JTable();
        Vector<dulieukhachhang> infor= new Vector<>();
        DefaultTableModel model = new DefaultTableModel();
        JLabel l1 = new JLabel("QUẢN LÍ KHÁCH HÀNG");
       
        
        JPanel p1 = new JPanel();
        JLabel l2 = new JLabel("ID");
        JLabel l3 = new JLabel("HỌ VÀ TÊN");
        JLabel l4 = new JLabel("EMAIL");
        JLabel l5 = new JLabel("SỐ ĐIỆN THOẠI");
        JLabel l6 = new JLabel("ĐỊA CHỈ");
        JLabel l7 = new JLabel("LOẠI KHÁCH HÀNG");
        JLabel l8 = new JLabel("ĐIỂM TÍCH LŨY");
        
        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        JTextField tf6 = new JTextField();
        String cn[]= {"Quận 10","Quận 1","Quận Gò Vấp","Quận 9"};
        JComboBox cb2 = new JComboBox(cn);
        JTextField tf3 = new JTextField();
        JTextField tf4 = new JTextField();
        JTextField tf5 = new JTextField();
        
        JButton b1 = new JButton("THÊM");      
        JButton b2 = new JButton("SỬA");    
        JButton b3 = new JButton("XÓA");       
        JButton b4 = new JButton("TÌM KIẾM");    
        JButton b5 = new JButton("THOÁT");
        
    quanlykhachhang(){
        
        l1.setBounds(720, 30, 170, 70);
        add(l1);
        b1.setBounds(150,550,100,40);
        b2.setBounds(400, 550,100,40);
        b3.setBounds(150,600,100,40);
        b4.setBounds(400, 600,100,40);
        b5.setBounds(1400,800,100,40);
        
        p1.add(l2);
        p1.add(tf1);
        p1.add(l3);
        p1.add(tf2);
        p1.add(l4);
        p1.add(tf6);
        p1.add(l5);
        p1.add(tf4);
        p1.add(l6);
        p1.add(tf3);
        p1.add(l7);
        p1.add(cb2);
        p1.add(l8); 
        p1.add(tf5); 
        
        p1.setBounds(100,100,500,400);
        p1.setLayout(new GridLayout(7,2,10,10));
        
        hienthilist();
        JScrollPane sp= new JScrollPane(jt);
        sp.setBounds(650,100,850,650);    
     
        add(sp);
        add(p1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);      
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public void hienthilist(){
        jt.setModel(model);
        model.addColumn("ID");
        model.addColumn("HỌ VÀ TÊN");
        model.addColumn("EMAIL");
        model.addColumn("SỐ ĐIỆN THOẠI");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("LOẠI KHÁCH HÀNG");
        model.addColumn("ĐIỂM TÍCH LŨY");
        int i=0;
      while(i <= infor.size()-1){
           dulieukhachhang s = infor.get(i);
           model.addRow(new Object[]{
            });
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b5){
            dispose();
        }
        if(e.getSource()==b2){
            int i = jt.getSelectedRow();
            if(i >= 0){
                model.setValueAt(tf1.getText(),i,0);
                model.setValueAt(tf2.getText(),i,1);
                model.setValueAt(tf6.getText(), i,2);
                model.setValueAt(cb2.getSelectedItem(), i,3);
                model.setValueAt(tf3.getText(), i, 4);
                model.setValueAt(tf4.getText(), i, 5);
                model.setValueAt(tf5.getText(), i, 6);
            }
        }
        
        if(e.getSource()==b3){
            int i = jt.getSelectedRow();
            if(i>=0){
                model.removeRow(i);
            }
        }
    }

}
   