/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.GUI;

import Doanbanhang.BLL.khachhangBLL;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Doanbanhang.DTO.dulieukhachhang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Doanbanhang.DAL.qlkhDAL;
import Doanbanhang.BLL.khachhangBLL;
import java.awt.event.*;


/**
 *
 * @author huyhu
 */
public class quanlykhachhang extends JFrame {

    JTable jt = new JTable();
    Vector<dulieukhachhang> customerList = new Vector<dulieukhachhang>();
    DefaultTableModel model = new DefaultTableModel();
    khachhangBLL khBLL = new khachhangBLL();
    
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
    String cn[] = {" ","Thường niên", "Bạc", "Vàng", "VIP"};
    JComboBox cb2 = new JComboBox(cn);
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();
    JTextField tf5 = new JTextField();

    JButton b1 = new JButton("THÊM", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\add (2).jpg"));
    JButton b2 = new JButton("SỬA", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (7) (2).jpg"));
    JButton b3 = new JButton("XÓA", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (6) (2).jpg"));
    JButton b4 = new JButton("THOÁT");
    

            
            
 
    quanlykhachhang() {

        l1.setBounds(720, 30, 170, 70);
        add(l1);
        b1.setBounds(150, 550, 100, 40);
        b2.setBounds(400, 550, 100, 40);
        b3.setBounds(150, 600, 100, 40);
        b4.setBounds(400, 600, 100, 40);

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

        p1.setBounds(100, 100, 500, 400);
        p1.setLayout(new GridLayout(7, 2, 10, 10));

        hienthilist();
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(650, 100, 850, 650);

        add(sp);
        add(p1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                themActionListener(e);
                
        }});
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            suaActionListener(e);
        }});
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            xoaActionListener(e);
                
        }});
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                thoatActionListener(e);
        }});       

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void hienthilist() {
        jt.setModel(model);
        model.addColumn("ID");
        model.addColumn("HỌ VÀ TÊN");
        model.addColumn("EMAIL");
        model.addColumn("SỐ ĐIỆN THOẠI");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("LOẠI KHÁCH HÀNG");
        model.addColumn("ĐIỂM TÍCH LŨY");
        Vector<dulieukhachhang> customerList = new Vector<dulieukhachhang>();
        customerList = khBLL.showlistkh();
        for (int i = 0; i < customerList.size(); i++) {
            dulieukhachhang s = customerList.get(i);
            String ID = s.getID();
            String name = s.getHovaten();
            String email = s.getEmail();
            String sdt = s.getSodienthoai();
            String diachi = s.getDiachi();
            String loaikh = s.getLoaikhachhang();
            String diemtichluy = s.getDiemtichluy();
            Object[] row = {ID,name, email, sdt, diachi, loaikh, diemtichluy};
            model.addRow(row);

        }

    }
    private void thoatActionListener(ActionEvent e){
        dispose();
    }
    private void themActionListener(ActionEvent e)
    {        
        if(tf1.getText().equals(" ")||tf2.getText().equals(" ")||tf6.getText().equals(" ")||tf4.getText().equals(" ")||tf3.getText().equals(" ")||cb2.getSelectedItem().toString().equals(" ")||tf5.getText().equals(" ")){
            JOptionPane.showMessageDialog(null,"Bạn chưa nhập đủ thông tin!!!!!!!!!");
        }
        else{dulieukhachhang s = new dulieukhachhang(tf1.getText(),
                tf2.getText(),
                tf6.getText(),
                tf4.getText(),
                tf3.getText(),
                cb2.getSelectedItem().toString(),
                tf5.getText());
            customerList.add(s);
            model.addRow(new Object[]{s.getID(), s.getHovaten(), s.getEmail(), s.getSodienthoai(), s.getDiachi(), s.getLoaikhachhang(), s.getDiemtichluy()});
            khBLL.addkhBLL(tf1.getText(),
                tf2.getText(),
                tf6.getText(),
                tf4.getText(),
                tf3.getText(),
                cb2.getSelectedItem().toString(),
                tf5.getText());
        }
    }
    private void suaActionListener(ActionEvent e){
         int ques = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn update này không?", "Hủy", JOptionPane.YES_NO_OPTION);
         int i = jt.getSelectedRow();
         if (ques == JOptionPane.YES_OPTION && i >=0) {
                model.setValueAt(tf1.getText(), i, 0);
                model.setValueAt(tf2.getText(), i, 1);
                model.setValueAt(tf6.getText(), i, 2);
                model.setValueAt(tf3.getText(), i, 3);
                model.setValueAt(tf4.getText(), i, 4);
                model.setValueAt(cb2.getSelectedItem(), i, 5);
                model.setValueAt(tf5.getText(), i, 6);
                khBLL.updhvtkh(tf1.getText(),tf1.getText(), tf2.getText(),tf6.getText(),tf4.getText(),tf3.getText(),tf5.getText());

            
            }
    }
    private void xoaActionListener(ActionEvent e)
    {
        int ques = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Hủy", JOptionPane.YES_NO_OPTION);
        if(ques==JOptionPane.YES_OPTION){
        int i = jt.getSelectedRow();
            if (i >= 0) {
                khBLL.dltkh((String) jt.getModel().getValueAt(i,0));
                model.removeRow(i);

            }
        }
    }
    
}