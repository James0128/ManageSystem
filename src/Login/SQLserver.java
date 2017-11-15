package Login;

import javax.swing.*;
import java.sql.*;

/**
 * Created by yifanyang on 2017/6/9.
 */
public class SQLserver {
    Connection con;
    PreparedStatement ps;
    public static Statement sql;//连接数据库
    ResultSet rs;
    String user,pwd;

    //将连接数据库的方法封装为一个方法
    public void ConnectSQL()
    {
               try {
            Class.forName("com.mysql.jdbc.Driver");
              System.out.println("驱动加载成功");
       } catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null,"MySQL驱动加载失败！请检查");
       }

        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/manage", "root", "123");
            sql= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            System.out.println("数据库连接异常！");
            JOptionPane.showMessageDialog(null, "MySQL数据源连接失败！请检查！");
        }

    }


    //注册用户的方法
    public void UserRegis(String a,String b,String c,String d)
    {
        //创建火箭车
        try {
            ps=con.prepareStatement("insert into users values(?,?,?,?)");
            ps.setString(1,a);
            ps.setString(2,b);
            ps.setString(3,c);
            ps.setString(4,d);

            //执行
            int i=ps.executeUpdate();
            if(i==1)
            {
                JOptionPane.showMessageDialog(null, "注册成功","提示消息",JOptionPane.WARNING_MESSAGE);

            }else
            {
                JOptionPane.showMessageDialog(null, "注册失败","提示消息",JOptionPane.ERROR_MESSAGE);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //  登录验证方法
    public void SQLverify(String a,String b)
    {
        try {
            ps=con.prepareStatement("select * from users where 用户名=? and 密码=? ");
            ps.setString(1, a);
            ps.setString(2, b);

            // ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集
            rs = ps.executeQuery();

            if(rs.next())
            {
                user = rs.getString(1);
                pwd = rs.getString(2);
                JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);
                System.out.println("成功获取到密码和用户名from数据库");
                System.out.println(user + "\t" + pwd + "\t");
            }else
            {
                JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //注册验证方法，判断用户名是否已经存在
    public void ZhuceVerify(String a)
    {
        try {
            ps=con.prepareStatement("select * from users where 用户名=?");
//          System.out.println(ps);
            ps.setString(1, a);

            rs=ps.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "该用户名已经存在", "提示信息", JOptionPane.WARNING_MESSAGE);
            }else
            {
//              进行注册
                zhuceView ui=new zhuceView();
                this.UserRegis(ui.jtf1.getText(),ui.jtf2.getText(),ui.jtf3.getText(),ui.jtf4.getText());
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }





}


