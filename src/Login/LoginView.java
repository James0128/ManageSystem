package Login;

import function.BackgroundPanel;
import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;

/**
 * Created by yifanyang on 2017/6/8.
 */
public class LoginView {
    static JFrame frame;
    static Connection con;
    public static Statement sql;//连接数据库
    static ResultSet rs1;
    static String str;
    static JPanel beijing;
    static  JPanel jPanel1,jPanel2,jpanel3,jPanel4;
    static JLabel label1,guanbi,zuixiaohua;
    static JLabel label2;
    static JButton button1,button2;
    static JTextField field1;
    static JPasswordField passwordText;
    static JComboBox box;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        event listener = new event();
        frame = new JFrame();//登录窗体
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);//去掉默认边框
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);

        frame.addMouseListener(listener);
        frame.addMouseMotionListener(listener);
        frame.setIconImage(new ImageIcon(("/Users/yifanyang/Desktop/image/denglu-image/zhang.jpg")).getImage());

        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        frame.setLocation((int) (1000 - frame.getWidth()) / 2,
                (int) (500 - frame.getHeight()) / 2);// 屏幕剧中
        beijing = new BackgroundPanel(new ImageIcon("/Users/yifanyang/Desktop/image/denglu-image/c.gif").getImage());

        beijing.setOpaque(false);
        beijing.setLayout(null);
        beijing.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        beijing.setBorder(BorderFactory.createTitledBorder("租房管理系统"));
        guanbi = new JLabel("X");
        zuixiaohua = new JLabel("--");
        zuixiaohua.setBounds(600 - 40, 0, 20, 20);
        zuixiaohua.setForeground(Color.white);
        // zuixiaohua.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        zuixiaohua.addMouseListener(listener);
        guanbi.setBounds(600 - 20, 0, 20, 20);
        guanbi.setForeground(Color.white);
        // guanbi.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        guanbi.addMouseListener(listener);
        beijing.add(zuixiaohua);
        beijing.add(guanbi);
        frame.add(beijing, BorderLayout.CENTER);

        jPanel1 = new JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        jPanel1.setBounds(350, 150, 235, 130);


        label1 = new JLabel("用户名");
        label1.setForeground(Color.white);
        label1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        jPanel1.add(label1);
        box = new JComboBox();
        box.addItem("住户");
        box.addItem("房主");
        box.addItem("管理员");
        box.setForeground(Color.blue);
        box.setBounds(50, 10, 80, 20);
        box.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        jPanel1.add(box);

        field1 = new JTextField("001");
        field1.setBounds(130, 10, 100, 20);
        field1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        field1.addActionListener(listener);
        field1.setForeground(Color.blue);
        jPanel1.add(field1);
        label2 = new JLabel("密码:");
        label2.setForeground(Color.white);
        label2.setBounds(5, 50, 40, 20);
        label2.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        jPanel1.add(label2);
        passwordText = new JPasswordField("123", 10);
        passwordText.setBounds(50, 50, 180, 20);
        passwordText.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        passwordText.addActionListener(listener);
        jPanel1.add(passwordText);
        button1 = new JButton(new ImageIcon(
                "/Users/yifanyang/Desktop/image/denglu-image/denglu.jpg"));
        button2 = new JButton(
                new ImageIcon("/Users/yifanyang/Desktop/image/denglu-image/zhuce.jpg"));
        button1.setBounds(50, 100, 70, 20);
        button2.setBounds(160, 100, 70, 20);
        button1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        button2.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        jPanel1.add(button1);
        jPanel1.add(button2);
        beijing.add(jPanel1);
        label1.setBounds(5, 10, 40, 20);

        frame.validate();

      new   SQLserver().ConnectSQL();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//                System.out.print("驱动加载成功");
//        } catch (ClassNotFoundException e) {
//           JOptionPane.showMessageDialog(null,"MySQL驱动加载失败！请检查");
//        }
//
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123");
//            sql= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            System.out.println("数据库连接成功");
//        } catch (SQLException e) {
//            System.out.println("数据库连接异常！");
//            JOptionPane.showMessageDialog(null, "MySQL数据源连接失败！请检查！");
//        }
//
//    }
    }
}
