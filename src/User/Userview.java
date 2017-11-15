package User;

import Login.LoginView;
import function.BackgroundPanel;
import function.HeaderCellRenderer;
import function.functionview;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yifanyang on 2017/6/8.
 */
public class Userview extends JFrame implements ActionListener,MouseListener {


    JMenuBar menu;
    JMenu    m1,m2,m3,m4,m5;
    JMenuItem item1,item2,item3,item4,item5;
    private static final long serialVersionUID = 1L;
    String str1;
    JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13;
    JTextField field1,field2,field3,field4,field5,field6,field7,field8,field9,field10;
    JScrollPane scoro,scoro1;
    JTextArea area1,area2;
    JButton button1,button2,button3,button4,button5;
    ResultSet rs;
    JTable table;
    boolean biaozhi=false;
    JPopupMenu jmenu;
    JMenuItem em1;
    JMenuItem em2;
    JMenuItem em3;
    JMenuItem em4;
    public  Userview(String str)
    {
        str1=str;
        // this.setUndecorated(true);
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setBounds((int) (width * 0.1), (int) (height * 0.1),
                (int) (1365 * 0.8), (int) (800 * 0.8));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/zhang.jpg").getImage());
        this.setLayout(null);
        this.setForeground(Color.black);
        menu=new JMenuBar();
        // menu.setBackground(Color.blue);
        m1=new JMenu("菜单");
        //m2=new JMenu("菜单");
        item1=new JMenuItem("注销登录");
        item1.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/zhuxiao.png"));
        item2=new JMenuItem("打印");
        item2.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/print.png"));
        item3=new JMenuItem("修改密码");
        item3.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/key.png"));
        item4=new JMenuItem("帮助");
        item4.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/help.png"));
        item5=new JMenuItem("退出");
        item5.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/delete.png"));
        m1.add(item1);
        m1.add(item3);
        m1.add(item2);
        m1.add(item4);
        m1.add(item5);
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);
        //menu.add(m1);
        menu.add(m1);
        this.setJMenuBar(menu);

        jmenu = new JPopupMenu("坏娃娃");
        jmenu.setOpaque(false);
        jmenu.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));

        em1 = new JMenuItem("全选");
        em1.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_MASK));
        em1.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/all.png"));
        jmenu.add(em1);
        em2 = new JMenuItem("复制");
        em2.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/copy.png"));
        em2.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_MASK));
        jmenu.add(em2);
        em3 = new JMenuItem("粘贴");
        em3.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/state.png"));
        em3.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
        jmenu.add(em3);
        em4 = new JMenuItem("清空");
        em4.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/cut.png"));
        jmenu.add(em4);
        jmenu.addSeparator();
        jmenu.add("-------");
        jmenu.updateUI();
        // jmenu.addm
        this.add(jmenu);
        // /////////////////////////////////////////////
        ImageIcon icon1 = new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/a-3.jpg");
        panel1=new BackgroundPanel(icon1.getImage());
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 500, 590);
        panel1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.white, 2), "个人中心"));
        //panel1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        panel1.addMouseListener(this);
        this.add(panel1);
        ImageIcon icon2 = new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/b-5.jpg");
        panel2=new BackgroundPanel(icon2.getImage());
        panel2.setLayout(new BorderLayout());
        panel2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.white, 2), ""));
        panel2.setBounds(505, 0, 580, 590);
        panel2.addMouseListener(this);
        this.add(panel2);
        label1 = new JLabel(new ImageIcon("/Users/yifanyang/Desktop/image/zhuhu-image/c.jpg"));
        panel1.add(label1);
        label1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        label1.setBounds(5, 17, 100,130);
        panel3=new JPanel();
        panel3.setOpaque(false);
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel3.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        panel3.addMouseListener(this);

        panel1.add(panel3);
        panel3.setBounds(107, 17, 385, 130);
        label2=new JLabel("用户号：");
        panel3.add(label2);
        field1=new JTextField(12);//
        panel3.add(field1);
        label3=new JLabel("用户名：");
        panel3.add(label3);
        field2=new JTextField(12);//
        panel3.add(field2);
        label4=new JLabel(" 性别：");
        panel3.add(label4);
        field3=new JTextField(12);//
        panel3.add(field3);
        label5=new JLabel("密码：");
        panel3.add(label5);
        field4=new JTextField(12);//
        panel3.add(field4);
        label6=new JLabel("类别：");
        panel3.add(label6);
        field5=new JTextField(34);//
        panel3.add(field5);
        label7=new JLabel("真实姓名：");
        panel3.add(label7);
        field6=new JTextField(54);//
        panel3.add(field6);
        label8=new JLabel("住址：");
        panel3.add(label8);
        field7=new JTextField(54);//
        panel3.add(field7);
        panel4=new JPanel();
        panel4.setOpaque(false);
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel4.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        panel4.addMouseListener(this);
        panel1.add(panel4);
        panel4.setBounds(5, 150, 487, 40);
        label9=new JLabel("手机：");
        panel4.add(label9);
        field8=new JTextField(18);//
        panel4.add(field8);
        label10=new JLabel("");
        panel4.add(label10);
        field9=new JTextField(19);//
        panel4.add(field9);
        label11=new JLabel("身份证：");
        panel4.add(label11);
        field10=new JTextField(19);//
        panel4.add(field10);
        label12=new JLabel("房子要求");
        label12.setBounds(5, 190, 100, 20);
        panel1.add(label12);
        area1=new JTextArea();
        area1.setOpaque(false);
        area1.setLineWrap(true);
        area1.addMouseListener(this);
        scoro=new JScrollPane(area1);
        scoro.setOpaque(false);
        scoro.getViewport().setOpaque(false);
        scoro.setBounds(5, 215, 487, 150);
        panel1.add(scoro);
        label13=new JLabel("个人简介");
        label13.setBounds(5, 365, 100, 20);
        panel1.add(label13);
        area2=new JTextArea();
        area2.setOpaque(false);
        area2.setLineWrap(true);
        area2.addMouseListener(this);
        scoro1=new JScrollPane(area2);
        scoro1.setOpaque(false);
        scoro1.getViewport().setOpaque(false);
        scoro1.setBounds(5, 390, 487, 150);
        panel1.add(scoro1);
        panel5=new JPanel();
        panel5.setOpaque(false);
        //panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel5.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        panel5.addMouseListener(this);

        panel1.add(panel5);
        panel5.setBounds(5, 545, 487, 40);
        panel1.add(panel5);
        button1=new JButton("修改");
        button2=new JButton("保存");
        button3=new JButton("查看合同");
        button4=new JButton("查看租金");
        button5=new JButton("刷新");
        button1.setContentAreaFilled(false);
        button2.setContentAreaFilled(false);
        button3.setContentAreaFilled(false);
        button4.setContentAreaFilled(false);
        button5.setContentAreaFilled(false);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        panel5.add(button5);
        panel5.add(button1);
        panel5.add(button2);
        panel5.add(button3);
        panel5.add(button4);

        //

        try {
            rs = LoginView.sql.executeQuery("SELECT *from user where Sno=" + str1);
            if (rs.next()) {
                field1.setText(rs.getString("用户号"));
                field2.setText(rs.getString("用户名"));
                field3.setText(rs.getString("性别"));
                field4.setText(rs.getString("密码"));
                field5.setText(rs.getString("身份"));
                field6.setText(rs.getString("真实姓名"));
                field7.setText(rs.getString("电话"));
                field8.setText(rs.getString("住址"));
                field1.setEditable(false);
                field2.setEditable(false);
                field3.setEditable(false);
                field4.setEditable(false);
                field5.setEditable(false);
                field6.setEditable(false);
                field7.setEditable(false);
                field8.setEditable(false);

                area1.setEditable(false);
                area2.setEditable(false);

                field1.setOpaque(false);
                field2.setOpaque(false);
                field3.setOpaque(false);
                field4.setOpaque(false);
                field5.setOpaque(false);
                field6.setOpaque(false);
                field7.setOpaque(false);
                field8.setOpaque(false);

            } else {
                JOptionPane.showMessageDialog(null, "个人信息获取失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {
            this.dispose();
        }
        if (e.getSource() == item3) {
            String inputValue = JOptionPane.showInputDialog("请输入新密码");

            try {
                if (inputValue.length() > 0) {
                    LoginView.sql.execute("UPDATE user set Spassword=\"" + inputValue + "\"where Sno=\"" + str1 + "\";");
                    JOptionPane.showMessageDialog(null, "密码修改成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "密码修改失败！");
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        if (e.getSource() == item5) {
            System.exit(0);
        }
        if (e.getSource() == button1) {
            field7.setEditable(true);
            field8.setEditable(true);
            area1.setEditable(true);
            area2.setEditable(true);
            field7.setOpaque(true);
            field8.setOpaque(true);
            area1.setOpaque(true);
            area2.setOpaque(true);
            biaozhi = true;
            panel1.validate();

        }
        if (e.getSource() == button2) {
            if (biaozhi) {


                String s1 = field7.getText().trim();
                String s2 = field8.getText().trim();


                try {
                    LoginView.sql.execute("update user set Saddr=\"" + s1
                            + "\"where Sno=\"" + str1 + "\";");
                    LoginView.sql.execute("update user set Stel=\"" + s2
                            + "\"where Sno=\"" + str1 + "\";");

                    // denglu.sql.execute("update Student set 生日=\""+s7+"\"where 学号=\""+str1+"\";");
                    //System.out.print(s4);

                    //
                    field7.setEditable(false);
                    field8.setEditable(false);

                    area1.setEditable(false);
                    area2.setEditable(false);
                    field7.setOpaque(false);
                    field8.setOpaque(false);

                    biaozhi = false;
                    JOptionPane.showMessageDialog(null, "个人信息修改成功！");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "数据类型不匹配！请检查！！");
                }
                panel1.validate();
            }

        }
        if (e.getSource() == button3){
            panel2.removeAll();
            JScrollPane scro;
            String str2="select * from contact  where Sno="+str1;
            table=new JTable(functionview.getrecord(str2),functionview.gengxing("contract"));
            table.setRowHeight(30);
            table.setOpaque(false);
            scro = new JScrollPane(table);
            scro.setColumnHeaderView(table.getTableHeader());
            scro.setOpaque(false);
            scro.getViewport().setOpaque(false);
            scro.getColumnHeader().setOpaque(false);
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setOpaque(false); //将渲染器设置为透明

            table.setDefaultRenderer(Object.class, render);
            table.setGridColor(Color.white);
            //
            JTableHeader header = table.getTableHeader();// 获取头部
            header.setPreferredSize(new Dimension(30, 26)); //
            header.setOpaque(false);// 设置头部为透明
            header.getTable().setOpaque(false);
            // header.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            header.setDefaultRenderer(new HeaderCellRenderer());
            TableCellRenderer headerRenderer = header.getDefaultRenderer();
            if (headerRenderer instanceof JLabel) {
                ((JLabel) headerRenderer).setHorizontalAlignment(SwingConstants.CENTER);
                ((JLabel) headerRenderer).setOpaque(false);
            }
            panel2.add(scro,BorderLayout.CENTER);
            panel2.validate();
        }

        if(e.getSource()==button4)
        {
            panel2.removeAll();
            JScrollPane scro;
            String str2="select * from rent  where Sno="+str1;
            table=new JTable(functionview.getrecord(str2),functionview.gengxing("rent"));
            table.setRowHeight(30);
            table.setOpaque(false);
            scro = new JScrollPane(table);
            scro.setColumnHeaderView(table.getTableHeader());
            scro.setOpaque(false);
            scro.getViewport().setOpaque(false);
            scro.getColumnHeader().setOpaque(false);
            scro.getVerticalScrollBar().setOpaque(false);
            DefaultTableCellRenderer render = new DefaultTableCellRenderer();
            render.setOpaque(false); //将渲染器设置为透明
            //将这个渲染器设置到fileTable里。这个设置在没有另外专门对column设置的情况下有效
            //若你对某个column特殊指定了渲染器，则对于这个column，它将不调用render渲染器
            //因此为了保证透明，如果你对column额外指定了渲染器，那么在额外的渲染器里也应该设置透明
            //
            table.setDefaultRenderer(Object.class, render);
            table.setGridColor(Color.white);
            //
            JTableHeader header = table.getTableHeader();// 获取头部
            header.setPreferredSize(new Dimension(30, 26)); //
            header.setOpaque(false);// 设置头部为透明
            header.getTable().setOpaque(false);
            // header.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            header.setDefaultRenderer(new HeaderCellRenderer());
            TableCellRenderer headerRenderer = header.getDefaultRenderer();
            if (headerRenderer instanceof JLabel) {
                ((JLabel) headerRenderer).setHorizontalAlignment(SwingConstants.CENTER);
                ((JLabel) headerRenderer).setOpaque(false);
            }
            panel2.add(scro,BorderLayout.CENTER);
            panel2.validate();



        }
        if(e.getSource()==button5)
        {
            panel2.remove(table);
            this.validate();
        }


    }






    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        Point mousepoint = MouseInfo.getPointerInfo().getLocation();
        // System.out.println(mousepoint.x+"   "+mousepoint.y);
        if (biaozhi == true) {
            if (e.getSource() == area1) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jmenu.show(this, mousepoint.x - 100, mousepoint.y - 80);
                    em4.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            area1.setText("");// TODO Auto-generated method stub
                        }
                    });
                    em1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            area1.selectAll();// TODO Auto-generated method stub
                        }
                    });
                    //
                    //
                }
            }
            if (e.getSource() == area2) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    jmenu.show(this, mousepoint.x - 100, mousepoint.y - 80);
                    em4.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            area2.setText("");// TODO Auto-generated method stub
                        }
                    });
                    em1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            area2.selectAll();// TODO Auto-generated method stub
                        }
                    });
                    //
                    //
                }

            }
        }
        // TODO Auto-generated method stub


    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

        // TODO Auto-generated method stub
        if (e.getSource() == button1) {
            button1.setContentAreaFilled(true);
        }
        if (e.getSource() == button2) {
            button2.setContentAreaFilled(true);
        }
        if (e.getSource() == button3) {
            button3.setContentAreaFilled(true);
        }
        if (e.getSource() == button4) {
            button4.setContentAreaFilled(true);
        }
        if (e.getSource() == button5) {
            button5.setContentAreaFilled(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == button1) {
            button1.setContentAreaFilled(false);
        }
        if (e.getSource() == button2) {
            button2.setContentAreaFilled(false);
        }
        if (e.getSource() == button3) {
            button3.setContentAreaFilled(false);
        }
        if (e.getSource() == button4) {
            button4.setContentAreaFilled(false);
        }
        if (e.getSource() == button5) {
            button5.setContentAreaFilled(false);
        }
    }
}
