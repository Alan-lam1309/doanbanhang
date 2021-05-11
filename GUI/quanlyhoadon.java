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
import Doanbanhang.DAL.connect;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane; 
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.TableModel;
import Doanbanhang.DAL.quanlithongkeDAL;
import Doanbanhang.DTO.dulieuthongke;
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

public class quanlyhoadon {
        dulieuthongke dltk;
        public Scanner sc = new Scanner(System.in);
        Vector <Doanbanhang.DTO.dulieuthongke> nhanvienList = new Vector <> ();
        DefaultTableModel model = new DefaultTableModel ();
        connect openconnect=new connect();
        Connection con =openconnect.connectsql();
        JTable tb1 = new JTable ();
        JButton b1= new JButton ("Thêm");
        JButton b2= new JButton ("Xóa");
        JButton b3= new JButton ("Sửa");
        JButton b4= new JButton ("Tìm");
        JButton b5= new JButton ("Thoát");
        
        JTextField tf1= new JTextField ();
        JTextField tf2= new JTextField ();
        JTextField tf3= new JTextField ();
        JTextField tf4= new JTextField ();
        JTextField tf5= new JTextField ();
        JTextField tf6= new JTextField ();
        JTextField tf7= new JTextField ();
        
        
    quanlyhoadon ()
    {
        
        JFrame f = new JFrame ("Quan Ly Hoa Don");
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //JPanel p1= new JPanel ();
        //JPanel p2= new JPanel ();
        
        JLabel lbt = new JLabel ("BẢN THỐNG KÊ QUẢN LÝ HÓA ĐƠN");
        lbt.setHorizontalAlignment(JLabel.CENTER);
        lbt.setBounds(650,-170,400,400);
        f.add(lbt);
        Connection con ;
      
        
        JLabel l1=new JLabel ("Số Hóa Đơn Trong Ngày :");l1.setBounds(10,0,200,200);
        tf1.setBounds(160,92,150,20);
        JLabel l2=new JLabel ("Mã Đơn Hàng :");l2.setBounds(10,50,200,200);
        tf2.setBounds(160,142,150,20);
        JLabel l3=new JLabel ("Ngày Xuất Hóa Đơn :");l3.setBounds(10,100,200,200);
        tf3.setBounds(160,192,150,20);
        JLabel l4=new JLabel ("Loại Khách Hàng :");l4.setBounds(10,150,200,200);
        tf4.setBounds(160,242,150,20);
        JLabel l5= new JLabel ("Tổng Tiền Hàng :");l5.setBounds(10,200,200,200);
        tf5.setBounds(160,292,150,20);
        JLabel l6= new JLabel ("Giảm Giá :");l6.setBounds(10,250,200,200);
        tf6.setBounds(160,342,150,20);
        JLabel l7= new JLabel ("Tổng Tiền Sau Giảm Giá :");l7.setBounds(10,300,200,200);
        tf7.setBounds(160,392,150,20);
        f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);f.add(tf6);f.add(tf7);
        
        hienthiList();
        JScrollPane sp = new JScrollPane(tb1);
        f.add(sp);
        sp.setBounds(400, 60, 1100, 600);
        filltable();
       tb1.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {    
            int i=tb1.getSelectedRow();
            if(i>=0)
             {
                tf1.setText((String) tb1.getModel().getValueAt(i, 0));
                tf2.setText((String) tb1.getModel().getValueAt(i, 1));
                tf3.setText((String) tb1.getModel().getValueAt(i, 2));
                tf4.setText((String) tb1.getModel().getValueAt(i, 3));
                tf5.setText((String) tb1.getModel().getValueAt(i, 4));
                tf6.setText((String) tb1.getModel().getValueAt(i, 5));
                tf7.setText((String) tb1.getModel().getValueAt(i, 6));
             }
           }
       });
        
        
        

        
        b1.setBounds(10,550,100,50);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                            btnThemActionPerformed (e);
            }
        });
        b2.setBounds(10,630,100,50);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                            btnXoaActionPerformed (e);
            }
        });
        b3.setBounds(150,550,100,50);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                           btnSuaActionPerformed (e);
            }
        });
        b4.setBounds(150,630,100,50);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                         //  btnTimKiemActionPerformed (e);
            }
        });
        b5.setBounds(70,700,100,50);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                           btnThoatActionPerformed (e);
            }
        });
        
        

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        ImageIcon icon1 = new ImageIcon ("C:\\hinh anh\\file_add.png");
        ImageIcon icon2 = new ImageIcon ("C:\\hinh anh\\file_delete.png");
        ImageIcon icon3 = new ImageIcon ("C:\\hinh anh\\document_edit.png");
        ImageIcon icon4 = new ImageIcon ("C:\\hinh anh\\file_search.png");
        b1.setIcon(icon1);
        b2.setIcon(icon2);
        b3.setIcon(icon3);
        b4.setIcon(icon4);
           
        f.setVisible(true);
        
    }
    


        public void hienthiList(){
        
        tb1.setModel(model);
        model.addColumn("SĐH");
        model.addColumn("MSHĐ");
        model.addColumn("Ngày Xuất");
        model.addColumn("Khách Hàng");
        model.addColumn("Tổng Tiền");
        model.addColumn("Giảm Giá");
        model.addColumn("Thành Tiền");    
        }

        
        
        public void btnThemActionPerformed (ActionEvent evt ){
            try
            {
            dulieuthongke nv;
            nv=new dulieuthongke(tf1.getText(),
                    tf2.getText(),
                    tf3.getText(),
                    tf4.getText(),
                    (tf5.getText()),
                    (tf6.getText()),
                    (tf7.getText()));
            nhanvienList.add(nv);
            model.addRow(new Object []
            {
                nv.getID(),
                nv.getMaHD(),nv.getNgayXuat(),nv.getKhachHang(),nv.getTongTien(),nv.getGiamGia(),nv.getThanhTien()
            });
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e.getMessage()); 
            }
        } 
        
           public void btnXoaActionPerformed (ActionEvent evt ){
            int i=tb1.getSelectedRow();
            if (i>=0)
                model.removeRow(i);
         }
           
           public void btnSuaActionPerformed (ActionEvent evt)
           {
               int i= tb1.getSelectedRow();
            
               if(i>=0)
               {
                
                   model.setValueAt(tf1.getText(), i, 0);
                   model.setValueAt(tf2.getText(), i, 1);
                   model.setValueAt(tf3.getText(), i, 2);
                   model.setValueAt(tf4.getText(), i, 3);
                   model.setValueAt(tf5.getText(), i, 4);
                   model.setValueAt(tf6.getText(), i, 5);
                   model.setValueAt(tf7.getText(), i, 6);
               }
               
           }
           
           
            public void btnThoatActionPerformed (ActionEvent evt){  
                System.exit(0);}
          
         public void filltable()
         {
             quanlithongkeDAL getdata=new quanlithongkeDAL();
             Vector<dulieuthongke> uptable= getdata.DisPlay();
                for(dulieuthongke i: uptable)
                {
                    model.addRow(new Object[]{i.MaHD,i.NgayXuat,i.KhachHang,i.ThanhTien ,i.GiamGia,i.TongTien});
                }
         }
           
         
}