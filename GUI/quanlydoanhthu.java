/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Doanbanhang.BLL.doanhthubll;
import Doanbanhang.DAL.quanlidoanhthuDAL;
import Doanbanhang.DTO.dulieudoanhthu;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Scanner;
import javax.swing.table.TableModel;

public class quanlydoanhthu {

    dulieudoanhthu dldt;
    doanhthubll dtbll = new doanhthubll();
    public Scanner sc = new Scanner(System.in);
    Vector<dulieudoanhthu> doanhthulist = new Vector<>();
    DefaultTableModel model = new DefaultTableModel();
    JTable tb1 = new JTable();
    JButton b1 = new JButton("Thêm", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\add (2).jpg"));
    JButton b2 = new JButton("Xóa", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (6) (2).jpg"));
    JButton b3 = new JButton("Sửa", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (7) (2).jpg"));
    JButton b4 = new JButton("Tìm", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download.jpg"));
    JButton b5 = new JButton("Thoát");
    
            
            

    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();
    JTextField tf5 = new JTextField();
    JTextField tf6 = new JTextField();
    JTextField tf7 = new JTextField();

    quanlydoanhthu() {

        JFrame f = new JFrame("Quan Ly Doanh Thu");
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JLabel lbt = new JLabel("BẢN THỐNG KÊ QUẢN LÝ DOANH THU");
        lbt.setHorizontalAlignment(JLabel.CENTER);
        lbt.setBounds(650, -170, 400, 400);
        f.add(lbt);
        Connection con;

        JLabel l1 = new JLabel("STT :");
        l1.setBounds(10, 0, 200, 200);
        tf1.setBounds(160, 92, 150, 20);
        
        JLabel l2 = new JLabel("Mã Đơn Hàng :");
        l2.setBounds(10, 50, 200, 200);
        tf2.setBounds(160, 142, 150, 20);
        
        JLabel l3 = new JLabel("Tên Khách Hàng :");
        l3.setBounds(10, 100, 200, 200);
        tf3.setBounds(160, 192, 150, 20);
        
        JLabel l4 = new JLabel("Địa Chỉ Cửa Hàng :");
        l4.setBounds(10, 150, 200, 200);
        tf4.setBounds(160, 242, 150, 20);

        JLabel l5 = new JLabel("Tổng Doanh Thu :");
        l5.setBounds(10, 200, 200, 200);
        tf5.setBounds(160, 292, 150, 20);
        
//        JLabel l6 = new JLabel("Giảm Giá :");
//        l6.setBounds(10, 250, 200, 200);
//        tf6.setBounds(160, 342, 150, 20);

//        JLabel l7 = new JLabel("Tổng Doanh Thu ");
//        l7.setBounds(10, 300, 200, 200);
//        tf7.setBounds(160, 392, 150, 20);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
      //  f.add(l6);
      //  f.add(l7);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(tf4);
        f.add(tf5);
     //   f.add(tf6);
      //  f.add(tf7);

        initmodel();
        //hienthiList();
       filltable();
        JScrollPane sp = new JScrollPane(tb1);
        f.add(sp);
        sp.setBounds(400, 60, 1100, 600);

        tb1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = tb1.getSelectedRow();
                if (i >= 0) {
                    tf1.setText((String) tb1.getModel().getValueAt(i, 0));
                    tf2.setText((String) tb1.getModel().getValueAt(i, 1));
                    tf3.setText((String) tb1.getModel().getValueAt(i, 2));
                    tf4.setText((String) tb1.getModel().getValueAt(i, 3));
                    tf5.setText((String) tb1.getModel().getValueAt(i, 4));
                 //   tf6.setText((String) tb1.getModel().getValueAt(i, 5));
                  //  tf7.setText((String) tb1.getModel().getValueAt(i, 6));
                }
            }
        });

        b1.setBounds(10, 550, 100, 50);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnThemActionPerformed(e);
            }
        });
        b2.setBounds(10, 630, 100, 50);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnXoaActionPerformed(e);
            }
        });
        b3.setBounds(150, 550, 100, 50);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSuaActionPerformed(e);
            }
        });
        b4.setBounds(150, 630, 100, 50);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  btnTimKiemActionPerformed (e);
            }
        });
        b5.setBounds(70, 700, 150, 50);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        
        f.setVisible(true);

    }

    private void initmodel() {
        tb1.setModel(model);
        model.addColumn("STT");
        model.addColumn("MSHĐ");
        model.addColumn("Tên Khách Hàng");
        model.addColumn("Cửa Hàng");
        model.addColumn("Doanh Thu");
    }

 


    private void btnThemActionPerformed(ActionEvent evt) {
        if (tf1.getText().equals("") ||  tf2.getText().equals("") || tf3.getText().equals("") ||  tf4.getText().equals("") ||  tf5.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!!!!!!!!!");
        } else {
            dulieudoanhthu dt;
            dt = new dulieudoanhthu(tf1.getText(),
                    tf2.getText(),
                    tf3.getText(),
                    tf4.getText(),
                    tf5.getText());
            doanhthulist.add(dt);
            model.addRow(new Object[]{
                dt.getID1(),
                dt.getMaHD1(),
                dt.getKhachHang(),
                dt.getCuaHang(),
                dt.getDoanhThu()
            });
            dtbll.adddt(tf1.getText(),
                    tf2.getText(),
                    tf3.getText(),
                    tf4.getText(),
                    tf5.getText()
                  );
        }
    }

    private void btnXoaActionPerformed(ActionEvent evt) {
        int ques = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Hủy", JOptionPane.YES_NO_OPTION);
        if (ques == JOptionPane.YES_OPTION) {
            int i = tb1.getSelectedRow();
            if (i >= 0) {
                dtbll.deletedt((String) tb1.getModel().getValueAt(i, 0));
                model.removeRow(i);
            }
        }
    }

    private void btnSuaActionPerformed(ActionEvent evt) {
        int ques = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa dữ liệu này không?", "Hủy", JOptionPane.YES_NO_OPTION);
        int i = tb1.getSelectedRow();

        if (ques == JOptionPane.YES_OPTION ) {
            String m = (String) tb1.getModel().getValueAt(i, 0);
            model.setValueAt(tf1.getText(), i, 0);
            model.setValueAt(tf2.getText(), i, 1);
            model.setValueAt(tf3.getText(), i, 2);
            model.setValueAt(tf4.getText(), i, 3);
            model.setValueAt(tf5.getText(), i, 4); 
            dtbll.updatedt(tf1.getText(), tf2.getText(), tf3.getText(),  tf4.getText(),  tf5.getText());
              JOptionPane.showMessageDialog(null,  dtbll.updatedt(tf1.getText(),tf2.getText(), tf3.getText(), tf4.getText(),  tf5.getText())); 
        }
    }



    public void filltable() {
        quanlidoanhthuDAL getdata = new quanlidoanhthuDAL();
        Vector<dulieudoanhthu> uptable = getdata.doanhthulist();
        for (dulieudoanhthu i : uptable) {
            model.addRow(new Object[]{i.getID1(), i.getMaHD1(), i.getKhachHang(), i.getCuaHang(), i.getDoanhThu()});
        }
    }
}