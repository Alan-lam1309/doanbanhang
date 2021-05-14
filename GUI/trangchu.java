/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doanbanhang.GUI;

import Doanbanhang.DAL.addaccountDAL;
import Doanbanhang.DTO.dulieuaccount;
import Doanbanhang.BLL.BLLaddaccount;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.CubicCurve2D;
import java.security.PKCS12Attribute;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quoc Phu
 */
public class trangchu {

    BLLaddaccount addBLL = new BLLaddaccount();
    Calendar cal = Calendar.getInstance();
    int r;
    String n, m;

    public trangchu() {
        disPlay();
    }

    public void disPlay() {
        JFrame j = new JFrame("GUU Store");
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setResizable(false);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(null);
        p.setBorder(BorderFactory.createLoweredBevelBorder());
        JPanel p1 = new JPanel(null);
        JPanel p2 = new JPanel(null);
        JPanel p3 = new JPanel(null);
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\background1.jpg"));
        background.setBounds(0, 0, 1680, 900);

        JButton b1 = new JButton("Quản lí Cửa Hàng", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (8) (2).jpg"));
        b1.setFont(new Font("Vẻdana", Font.PLAIN, 21));
        JButton b2 = new JButton("Quản lí Doanh Thu", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (3).png"));
        b2.setFont(new Font("Vẻdana", Font.PLAIN, 21));
        JButton b3 = new JButton("Quản lí Hàng Hóa", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (4).png"));
        b3.setFont(new Font("Vẻdana", Font.PLAIN, 21));
        JButton b4 = new JButton("Quản lí Account   ", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (9).png"));
        b4.setFont(new Font("Vẻdana", Font.PLAIN, 21));
        JButton b5=new JButton("Đăng xuất");
        b5.setFont(new Font("Vẻdana", Font.PLAIN, 20));
        JButton b6 = new JButton("Quản lí Khách Hàng", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (6).png"));
        b6.setFont(new Font("Vẻdana", Font.PLAIN, 21));
        b1.setBounds(0, 50, 301, 100);
        b2.setBounds(0, 200, 301, 100);
        b3.setBounds(0, 350, 301, 100);
        b4.setBounds(0, 500, 301, 100);
        b6.setBounds(0, 650, 301, 100);        
        b5.setBounds(50,750,200,50);
        j.add(b1);
        j.add(b2);
        j.add(b3);
        j.add(b4);
        j.add(b5);
        j.add(b6);

        JButton nvq1 = new JButton("Nhân viên", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (4).png"));
        JButton hhq1 = new JButton("Hàng hóa", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (2) (2).jpg"));
        JButton dtq1 = new JButton("Doanh thu", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (1).png"));
        JButton hdq1 = new JButton("Hóa đơn", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (3) (2).jpg"));
        JButton nvq2 = new JButton("Nhân viên", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (4).png"));
        JButton hhq2 = new JButton("Hàng hóa", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (2) (2).jpg"));
        JButton dtq2 = new JButton("Doanh thu", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (1).png"));
        JButton hdq2 = new JButton("Hóa đơn", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (3) (2).jpg"));
        JButton nvq3 = new JButton("Nhân viên", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (4).png"));
        JButton hhq3 = new JButton("Hàng hóa", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (2) (2).jpg"));
        JButton dtq3 = new JButton("Doanh thu", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (1).png"));
        JButton hdq3 = new JButton("Hóa đơn", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (3) (2).jpg"));
        JButton nvq4 = new JButton("Nhân viên", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (4).png"));
        JButton hhq4 = new JButton("Hàng hóa", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (2) (2).jpg"));
        JButton dtq4 = new JButton("Doanh thu", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (1).png"));
        JButton hdq4 = new JButton("Hóa đơn", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\download (3) (2).jpg"));

        //phần doanh thu của tổng quán//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////----------------------------------------------------------
        JLabel l1 = new JLabel("DOANH THU CỦA CHUỖI");
        l1.setFont(new Font("Vẻdana", Font.PLAIN, 50));
        l1.setBounds(330, 0, 1225, 100);

        JLabel l2 = new JLabel("Tháng: ");
        l2.setFont(new Font("Vẻdana", Font.PLAIN, 17));
        l2.setBounds(50, 150, 100, 30);
        JLabel l3 = new JLabel("Năm:   ");
        l3.setFont(new Font("Vẻdana", Font.PLAIN, 17));
        l3.setBounds(50, 200, 100, 30);
        JComboBox cb = new JComboBox();
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
        cb.setBounds(120, 150, 80, 30);
        JComboBox cb2 = new JComboBox();
        cb2.setBounds(120, 200, 80, 30);
        int i = cal.get(Calendar.YEAR), a = 0;
        while (a < 50) {
            cb2.addItem(i);
            i--;
            a++;
        }

        p1.add(cb);
        p1.add(l2);
        p1.add(l3);
        p1.add(cb2);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBounds(300, 150, 800, 600);
        p1.add(panel);

        JLabel jLabel = new JLabel();
        //////////////////////////////////////////////////////////////////////////////////////doanh thu tổng///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //phần quản lí account
        JLabel acname = new JLabel("* USERNAME: ");
        acname.setBounds(50, 100, 100, 50);
        JTextField act1 = new JTextField();
        act1.setBounds(130, 110, 150, 30);
        JLabel acpass = new JLabel("* PASSWORD: ");
        acpass.setBounds(50, 150, 100, 50);
        JTextField act2 = new JTextField();
        act2.setBounds(130, 160, 150, 30);
        JTable actb = new JTable();

        DefaultTableModel model = new DefaultTableModel();
        actb.setModel(model);
        model.addColumn("USERNAME");
        model.addColumn("PASSWORD");
        JScrollPane sc = new JScrollPane(actb);
        sc.setBounds(330, 100, 600, 600);
        Vector<dulieuaccount> dl = new Vector<dulieuaccount>();
        dl = addBLL.showlist();
        for (int ic = 0; ic < dl.size(); ic++) {
            dulieuaccount dla = dl.get(ic);
            String user = dla.getName();
            String pass = dla.getPass();
            Object[] row = {user, pass};
            model.addRow(row);
        }
        JLabel aca = new JLabel("A");
        aca.setFont(new Font("Vẻdana", Font.PLAIN, 100));
        aca.setBounds(1100, 50, 70, 90);
        JLabel acc1 = new JLabel("C");
        acc1.setFont(new Font("Vẻdana", Font.PLAIN, 100));
        acc1.setBounds(1095, 150, 85, 90);
        JLabel acc2 = new JLabel("C");
        acc2.setFont(new Font("Vẻdana", Font.PLAIN, 100));
        acc2.setBounds(1095, 250, 85, 90);
        JLabel aco = new JLabel("O");
        aco.setFont(new Font("Vẻdana", Font.PLAIN, 100));
        aco.setBounds(1095, 350, 90, 90);
        JLabel acu = new JLabel("U");
        acu.setFont(new Font("Vẻdana", Font.PLAIN, 100));
        acu.setBounds(1100, 450, 85, 90);
        JLabel acn = new JLabel("N");
        acn.setFont(new Font("Vẻdana", Font.PLAIN, 100));
        acn.setBounds(1100, 550, 85, 90);
        JLabel act = new JLabel("T");
        act.setFont(new Font("Vẻdana", Font.PLAIN, 100));
        act.setBounds(1105, 650, 85, 90);

        actb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                r = actb.getSelectedRow();
                act1.setText((String) actb.getModel().getValueAt(r, 0));
                act2.setText((String) actb.getModel().getValueAt(r, 1));
            }
        }
        );
        JButton add = new JButton("ADD", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\add (2).jpg"));
        add.setBounds(50, 250, 120, 30);
        p3.add(add);
        add.addActionListener(new ActionListener() {                            
            
            public void actionPerformed(ActionEvent e) {
                if (!act1.getText().equals("") || !act2.getText().equals("")) {
                    if (addBLL.test(act1.getText())) {
                        String user = act1.getText();
                        String pass = act2.getText();
                        Object[] row = {user, pass};
                        model.addRow(row);
                        addBLL.addacBLL(act1.getText(), act2.getText());
                        act1.setText("");
                        act2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "TÊN TÀI KHOẢN ĐÃ TỒN TẠI");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "BẠN CHƯA NHẬP THÔNG TIN");
                }
            }
        });

        JButton delete = new JButton("DELETE", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (6) (2).jpg"));
        delete.setBounds(180, 250, 120, 30);
        p3.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ques = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa account này không?", "Hủy", JOptionPane.YES_NO_OPTION);
                if (ques == JOptionPane.YES_OPTION) {
                    int r = actb.getSelectedRow();
                    if (r >= 0) {
                        String n = (String.valueOf(actb.getValueAt(r, 0)));
                        String m = (String.valueOf(actb.getValueAt(r, 1)));
                        addBLL.dltacDLL(n, m);
                        model.removeRow(r);
                        act1.setText("");
                        act2.setText("");
                    }
                }
            }
        });
        JButton update = new JButton("UPDATE", new ImageIcon("C:\\Users\\Quoc Phu\\Pictures\\doanjava\\images (7) (2).jpg"));
        update.setBounds(110, 310, 120, 30);
        p3.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!act1.getText().equals("") || !act2.getText().equals("")) {
                    if (addBLL.test(act1.getText())) {
                        int ques = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn update không?", "Hủy", JOptionPane.YES_NO_OPTION);
                        if (ques == JOptionPane.YES_OPTION) {
                            String m = (String) actb.getModel().getValueAt(r, 0);
                            addBLL.updacDLL(m, act1.getText(), act2.getText());
                            model.setValueAt(act1.getText(), r, 0);
                            model.setValueAt(act2.getText(), r, 1);
                            act1.setText("");
                            act2.setText("");
                        }
                    }
                    else{
                       JOptionPane.showMessageDialog(null,"TÊN TÀI KHOẢN ĐÃ TỒN TẠI");
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(null, "KHÔNG CÓ THÔNG TIN ĐỂ CẬP NHẬT");
                }
            }
        });

        p3.add(aca);
        p3.add(acc1);
        p3.add(acc2);
        p3.add(aco);
        p3.add(acu);
        p3.add(acn);
        p3.add(act);

        p3.add(sc);
        p3.add(acname);
        p3.add(act1);
        p3.add(acpass);
        p3.add(act2);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////quản lí account/////////////////////////////////////////
        JLabel l = new JLabel("Welcome admin to our store :))");
        l.setBounds(10, 15, 1000, 200);
        l.setFont(new Font("Vẻdana", Font.PLAIN, 50));

        JLabel lchinhanh1 = new JLabel("Chi nhánh quận 1");
        lchinhanh1.setFont(new Font("Vẻdana", Font.PLAIN, 30));
        lchinhanh1.setBounds(200, 50, 500, 50);
        p.add(lchinhanh1);
        p.add(nvq1);
        nvq1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlinhanvien();
            }
        });
        p.add(hhq1);
        p.add(hdq1);
        hdq1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new quanlyhoadon();
            }

        });
        p.add(dtq1);
        dtq1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlydoanhthu();
            }
        });
        nvq1.setBounds(110, 150, 180, 70);
        hhq1.setBounds(110, 240, 180, 70);
        hdq1.setBounds(350, 150, 180, 70);
        dtq1.setBounds(350, 240, 180, 70);

        JLabel lchinhanh2 = new JLabel("Chi nhánh quận 10");
        lchinhanh2.setFont(new Font("Vẻdana", Font.PLAIN, 30));
        lchinhanh2.setBounds(730, 50, 500, 50);
        p.add(lchinhanh2);
        p.add(nvq2);
        nvq2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlinhanvien();
            }
        });
        p.add(hhq2);
        p.add(hdq2);
        hdq2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new quanlyhoadon();
            }

        });
        p.add(dtq2);
        dtq2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlydoanhthu();
            }
        });
        nvq2.setBounds(110, 560, 180, 70);
        hhq2.setBounds(110, 650, 180, 70);
        hdq2.setBounds(350, 560, 180, 70);
        dtq2.setBounds(350, 650, 180, 70);

        JLabel lchinhanh3 = new JLabel("Chi nhánh quận Gò vấp");
        lchinhanh3.setFont(new Font("Vẻdana", Font.PLAIN, 30));
        lchinhanh3.setBounds(160, 450, 500, 50);
        p.add(lchinhanh3);
        p.add(nvq3);
        nvq3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlinhanvien();
            }
        });
        p.add(hhq3);
        p.add(hdq3);
        hdq3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new quanlyhoadon();
            }

        });
        p.add(dtq3);
        dtq3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlydoanhthu();
            }
        });
        nvq3.setBounds(650, 150, 180, 70);
        hhq3.setBounds(650, 240, 180, 70);
        hdq3.setBounds(890, 150, 180, 70);
        dtq3.setBounds(890, 240, 180, 70);

        JLabel lchinhanh4 = new JLabel("Chi nhánh quận 9");
        lchinhanh4.setFont(new Font("Vẻdana", Font.PLAIN, 30));
        lchinhanh4.setBounds(730, 450, 500, 50);
        p.add(lchinhanh4);
        p.add(nvq4);
        nvq4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlinhanvien();
            }
        });
        p.add(hhq4);
        p.add(hdq4);
        hdq4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new quanlyhoadon();
            }

        });
        p.add(dtq4);
        dtq4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlydoanhthu();
            }
        });
        nvq4.setBounds(650, 560, 180, 70);
        hhq4.setBounds(650, 650, 180, 70);
        hdq4.setBounds(890, 560, 180, 70);
        dtq4.setBounds(890, 650, 180, 70);

        p.setVisible(false);
        p1.setBackground(Color.blue);
        p1.setVisible(false);
        p2.setBackground(Color.yellow);
        p2.setVisible(false);
        p3.setVisible(false);
        p.setBounds(300, 15, 1225, 815);
        p1.setBounds(300, 15, 1225, 815);
        p2.setBounds(300, 15, 1225, 815);
        p3.setBounds(300, 15, 1225, 815);

        p1.add(l1);

        j.add(p);
        j.add(p1);
        j.add(p2);
        j.add(p3);
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p.setVisible(true);
                p2.setVisible(false);
                p3.setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(false);
                new quanlydoanhthu();
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p.setVisible(false);
                p2.setVisible(true);
                p3.setVisible(false);

            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                p.setVisible(false);
                p3.setVisible(true);
                p2.setVisible(false);

            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new trangbanhang();
                j.dispose();
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new quanlykhachhang();
            }
        });

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(background);
        j.setVisible(true);

    }
}
