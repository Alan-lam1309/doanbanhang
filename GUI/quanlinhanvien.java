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
import Doanbanhang.DTO.dulieunhanvien;
/**
 *
 * @author huyhu
 */
public class quanlinhanvien extends JFrame implements ActionListener{
        JTable jt = new JTable();
        Vector<dulieunhanvien> infor= new Vector<>();
        DefaultTableModel model = new DefaultTableModel();
        JLabel l1 = new JLabel("QUẢN LÍ NHÂN VIÊN");
       
        
        JPanel p1 = new JPanel();
        JLabel l2 = new JLabel("ID");
        JLabel l3 = new JLabel("HỌ VÀ TÊN");
        JLabel l4 = new JLabel("CHỨC VỤ");
        JLabel l5 = new JLabel("CHI NHÁNH");
        JLabel l6 = new JLabel("SỐ ĐIỆN THOẠI");
        JLabel l7 = new JLabel("ĐỊA CHỈ");
        JLabel l8 = new JLabel("LƯƠNG NHẬN");
        
        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        String cv[]={"CEO","Quản lí","Nhân Viên Fulltime","Nhân Viên Bán Thời Gian","Mẫu Chụp Hình"};
        JComboBox cb1 = new JComboBox(cv);
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
        
    quanlinhanvien(){
        
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
        p1.add(cb1);
        p1.add(l5);
        p1.add(cb2);
        p1.add(l6);
        p1.add(tf3);
        p1.add(l7);
        p1.add(tf4);
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
        model.addColumn("STT");
        model.addColumn("ID");
        model.addColumn("HỌ VÀ TÊN");
        model.addColumn("CHỨC VỤ");
        model.addColumn("CHI NHÁNH");
        model.addColumn("SỐ ĐIỆN THOẠI");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("LƯƠNG NHẬN");
        int i=0;
      while(i <= infor.size()-1){
           dulieunhanvien s = infor.get(i);
           model.addRow(new Object[]{s.getID(),s.gethovaten(),s.getchucvu(),s.getchinhanh(),s.getsdt(),s.getdiachi(),s.getluong()
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
                model.setValueAt(cb1.getSelectedItem(), i,2);
                model.setValueAt(cb2.getSelectedItem(), i,3);
                model.setValueAt(tf3.getText(), i, 4);
                model.setValueAt(tf4.getText(), i, 5);
                model.setValueAt(tf5.getText(), i, 6);
            }
        }
        if(e.getSource()==b1){
            dulieunhanvien s=new dulieunhanvien(tf1.getText(),
                    tf2.getText(),
                    cb1.getSelectedItem().toString(),
                    cb2.getSelectedItem().toString(),
                    tf3.getText(),
                    tf4.getText(),
                    tf5.getText());
            infor.add(s);
            model.addRow(new Object[]{s.getID(),s.gethovaten(),s.getchucvu(),s.getchinhanh(),s.getsdt(),s.getdiachi(),s.getluong()});
        }
        if(e.getSource()==b3){
            int i = jt.getSelectedRow();
            if(i>=0){
                model.removeRow(i);
            }
        }
    }

}
   