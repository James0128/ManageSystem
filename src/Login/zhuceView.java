package Login;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yifanyang on 2017/6/9.
 */
public class zhuceView  extends JFrame implements ActionListener {
    JFrame jf;
    JPanel jp;
    JLabel jl1,jl2,jl3,jl4;
    JTextField jtf1,jtf2,jtf3,jtf4;
    JButton jb1,jb2;

    public zhuceView()
    {
        //初始化组件
        jf=new JFrame();
        jp=new JPanel();
        jl1=new JLabel("请输入用户名：");
        jtf1=new JTextField(10);
        jtf1.setToolTipText("用户名必须为3-6位字母_或者数字");
        jl2=new JLabel("请输入密码：");
        jtf2=new JTextField(10);
        jtf2.setToolTipText("密码必须为6位字母_或者数字");
        jl3=new JLabel("请输入姓名：");
        jtf3=new JTextField(10);
        jtf3.setToolTipText("姓名必须汉字2-4位");
        jl4=new JLabel("请输入身份证号：");
        jtf4=new JTextField(16);
        jtf4.setToolTipText("");

        jb1=new JButton("返回");
        jb1.setToolTipText("点我返回登录界面");
        jb2=new JButton("注册");
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp.setLayout(new GridLayout(7,2));

        jp.add(jl1);
        jp.add(jtf1);

        jp.add(jl2);
        jp.add(jtf2);

        jp.add(jl3);
        jp.add(jtf3);

        jp.add(jl4);
        jp.add(jtf4);

        jp.add(jb1);
        jp.add(jb2);

        this.add(jp);
        this.setTitle("注册界面");
        this.setBounds(200, 100, 250, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      this.setResizable(false);



    }





    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="返回")
        {
            this.dispose();
            new LoginView();


        }else if(e.getActionCommand()=="注册")
        {
            //调用注册方法
            this.zhuce();

        }

    }
    public void zhuce()
    {
        String regex1="\\w{3,6}"; //用户名必须是3-6位
        boolean flag1=jtf1.getText().matches(regex1);

        String regex2="\\w{6}"; //密码必须是6位
        boolean flag2=jtf2.getText().matches(regex2);

        String regex3="[\\u4e00-\\u9fa5]{2,4}"; //姓名必须是汉字2-4个字
        boolean flag3=jtf3.getText().matches(regex3);

        String regex4="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";  //18位身份证号
        boolean flag4=jtf4.getText().matches(regex4);


        if(flag1==false)
        {
            JOptionPane.showMessageDialog(null, "用户名填写错误,必须为3-6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf1.setText("");
        }else if(flag2==false)
        {
            JOptionPane.showMessageDialog(null, "密码填写错误,必须为6位字母_或者数字", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf2.setText("");
        }else if(flag3==false)
        {
            JOptionPane.showMessageDialog(null, "姓名填写错误,必须汉字2-4位", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf3.setText("");
        }else if(flag4==false)
        {
            JOptionPane.showMessageDialog(null, "身份证填写错误,必须为18位身份证", "提示信息", JOptionPane.WARNING_MESSAGE);
            jtf4.setText("");
        }else
        {
            //调用注册方法/先检查要注册的用户名是否存在
            SQLserver ss=new SQLserver();
            ss.ConnectSQL();
            ss.ZhuceVerify(jtf1.getText());

//          ss.UserRegis(jtf1.getText(),jtf2.getText(),jtf3.getText(), jtf4.getText());
            this.jtf1.setText("");
            this.jtf2.setText("");
            this.jtf3.setText("");
            this.jtf4.setText("");

        }
    }

}

