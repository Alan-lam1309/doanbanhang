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
import Doanbanhang.BLL.nhanvienBLL;
/**
 *
 * @author huyhu
 */
public class quanlinhanvien extends JFrame {
        JTable jt = new JTable();
        Vector<dulieunhanvien> nhanvienList= new Vector<>();
        DefaultTableModel model = new DefaultTableModel();
        JLabel l1 = new JLabel("QUẢN LÍ NHÂN VIÊN");
        nhanvienBLL nvBLL = new nhanvienBLL();
        
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
        String cv[]={" ","CEO","Quản lí","Nhân Viên Fulltime","Nhân Viên Bán Thời Gian","Mẫu Chụp Hình"};
        JComboBox cb1 = new JComboBox(cv);
        String cn[]= {" ","Quận 10","Quận 1","Quận Gò Vấp","Quận 9"};
        JComboBox cb2 = new JComboBox(cn);
        JTextField tf3 = new JTextField();
        JTextField tf4 = new JTextField();
        JTextField tf5 = new JTextField();
        
        JButton b1 = new JButton("THÊM", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\add (2).jpg"));      
        JButton b2 = new JButton("SỬA", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (7) (2).jpg"));    
        JButton b3 = new JButton("XÓA", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (6) (2).jpg"));       
        JButton b4 = new JButton("TÌM KIẾM", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download.jpg"));    
        JButton b5 = new JButton("THOÁT");
        
            
            
        
    quanlinhanvien(){
        
        l1.setBounds(720, 30, 170, 70);
        add(l1);
        b1.setBounds(150,550,120,40);
        b2.setBounds(400, 550,120,40);
        b3.setBounds(150,600,120,40);
        b4.setBounds(400, 600,120,40);
        b5.setBounds(250,800,100,40);
        
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
        b5.addActionListener(new ActionListener(){
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
    public void hienthilist(){
        jt.setModel(model);
        model.addColumn("ID");
        model.addColumn("HỌ VÀ TÊN");
        model.addColumn("CHỨC VỤ");
        model.addColumn("CHI NHÁNH");
        model.addColumn("SỐ ĐIỆN THOẠI");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("LƯƠNG NHẬN");
        Vector<dulieunhanvien> nhanvienList = new Vector<dulieunhanvien>();
        nhanvienList = nvBLL.showlistnv();
        for (int i = 0; i < nhanvienList.size(); i++) {
            dulieunhanvien nv = nhanvienList.get(i);
            String ID = nv.getID();
            String name = nv.gethovaten();
            String chucvu = nv.getchucvu();
            String chinhanh = nv.getchinhanh();
            String sdt = nv.getsdt();
            String diachi = nv.getdiachi();
            String luong = nv.getluong();
            Object[] row = {ID,name, chucvu,chinhanh, sdt, diachi, luong};
            model.addRow(row);

        }
    }
    private void thoatActionListener(ActionEvent e){
        dispose();
    }
    private void themActionListener(ActionEvent e){
        if(tf1.getText().equals(" ")||tf2.getText().equals(" ")||cb1.getSelectedItem().toString().equals(" ")||cb2.getSelectedItem().toString().equals(" ")||tf3.getText().equals(" ")||tf4.getText().equals(" ")||tf5.getText().equals(" "))
                    JOptionPane.showMessageDialog(null,"Bạn chưa nhập đủ thông tin!!!!!!!!!");
            
        else{
        dulieunhanvien s=new dulieunhanvien(tf1.getText(),
                    tf2.getText(),
                    cb1.getSelectedItem().toString(),
                    cb2.getSelectedItem().toString(),
                    tf3.getText(),
                    tf4.getText(),
                    tf5.getText());
            nhanvienList.add(s);
            model.addRow(new Object[]{s.getID(),s.gethovaten(),s.getchucvu(),s.getchinhanh(),s.getsdt(),s.getdiachi(),s.getluong()});
            nvBLL.addnvBLL(tf1.getText(),
                    tf2.getText(),
                    cb1.getSelectedItem().toString(),
                    cb2.getSelectedItem().toString(),
                    tf3.getText(),
                    tf4.getText(),
                    tf5.getText());
        }
    }
    private void suaActionListener(ActionEvent e){
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
    private void xoaActionListener(ActionEvent e){
        int ques = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Hủy", JOptionPane.YES_NO_OPTION);
        if(ques==JOptionPane.YES_OPTION){
        int i = jt.getSelectedRow();
            if (i >= 0) {
                nvBLL.dltnv((String) jt.getModel().getValueAt(i,0));
                model.removeRow(i);

            }
        }
    }
}
   