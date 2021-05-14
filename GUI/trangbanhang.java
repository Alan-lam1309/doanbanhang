/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.GUI;

import Doanbanhang.BLL.thanhtoanBLL;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.lang.model.util.AbstractTypeVisitor14;
import javax.swing.*;
import org.xml.sax.ext.Attributes2;

/**
 *
 * @author Quoc Phu
 */
public class trangbanhang {

    JFrame j = new JFrame("GUU STORE0");
    thanhtoanBLL ttBLL = new thanhtoanBLL();

    public trangbanhang() {
        j.setSize(500, 450);
        j.setResizable(false);
        j.setLayout(null);

        j.setLocationRelativeTo(null);

        JLabel idsp = new JLabel("Mã số sản phẩm: ");
        idsp.setBounds(20, 60, 300, 30);
        idsp.setFont(new Font("aaaa", Font.PLAIN, 21));
        JLabel tenkhachhang = new JLabel("Tên khách hàng: ");
        tenkhachhang.setBounds(20, 100, 300, 30);
        tenkhachhang.setFont(new Font("tenkhachhang", Font.PLAIN, 21));
        JLabel sdt = new JLabel("Số điện thoại: ");
        sdt.setBounds(20, 140, 300, 30);
        sdt.setFont(new Font("tenkhachhang", Font.PLAIN, 21));
        JLabel diachi = new JLabel("Địa chỉ: ");
        diachi.setBounds(20, 180, 300, 30);
        diachi.setFont(new Font("tenkhachhang", Font.PLAIN, 21));
        JLabel email = new JLabel("Email: ");
        email.setBounds(20, 220, 300, 30);
        email.setFont(new Font("tenkhachhang", Font.PLAIN, 21));
        JTextField bt1 = new JTextField();
        bt1.setBounds(180, 60, 300, 30);
        JTextField bt2 = new JTextField();
        bt2.setBounds(180, 100, 300, 30);
        JTextField bt3 = new JTextField();
        bt3.setBounds(180, 140, 300, 30);
        JTextField bt4 = new JTextField();
        bt4.setBounds(180, 180, 300, 30);
        JTextField bt5 = new JTextField();
        bt5.setBounds(180, 220, 300, 30);
        j.add(idsp);
        j.add(bt1);
        j.add(tenkhachhang);
        j.add(bt2);
        j.add(sdt);
        j.add(bt3);
        j.add(diachi);
        j.add(bt4);
        j.add(email);
        j.add(bt5);
        JLabel l1 = new JLabel("Tồng tiền: ");
        l1.setBounds(20, 255, 100, 30);
        j.add(l1);
        JLabel l2 = new JLabel("Thành tiền: ");
        l2.setBounds(280, 255, 150, 30);
        j.add(l2);
        bt1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {

                l1.setText("Tổng tiền: " + ttBLL.hientongtien(bt1.getText()));
                l2.setText("Thành tiền: " + ttBLL.hientongtien(bt1.getText()));

            }
        });

        JButton b1 = new JButton("Thanh Toán", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (1).png"));
        b1.setBounds(100, 300, 120, 30);
        j.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ques = JOptionPane.showConfirmDialog(null, "Xác nhận thanh toán?", "Hủy", JOptionPane.YES_NO_OPTION);
                if (ques == JOptionPane.YES_OPTION) {
                    String tong = String.valueOf(ttBLL.hientongtien(bt1.getText()));
                    if (bt1.getText() != "" && bt2.getText() != "" && bt3.getText() != "") {
                        ttBLL.thanhtoan(bt2.getText(), bt1.getText(), tong, tong);
                        if (ttBLL.test(bt2.getText(), bt3.getText())) {
                            ttBLL.ttaddkh(bt2.getText(), bt3.getText(), bt4.getText(), bt5.getText());
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Chưa nhập đủ thông tin!!!");
                            }
                }
            }
        });

        JButton b2 = new JButton("Clean", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (4) (2).jpg"));
        b2.setBounds(230, 300, 120, 30);
        j.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ques = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn dọn dẹp?", "Hủy", JOptionPane.YES_NO_OPTION);
                if (ques == JOptionPane.YES_OPTION) {
                    bt1.setText("");
                    bt2.setText("");
                    bt3.setText("");
                    bt4.setText("");
                    bt5.setText("");

                }
            }
        });
        JButton b3 = new JButton("Đăng nhập vào admin", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (5) (2).jpg"));
        b3.setBounds(130, 350, 200, 30);
        j.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Dangnhap();
                j.dispose();
            }
        }
        );
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }

}
