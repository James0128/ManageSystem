package Login;

import User.Userview;
import admin.adminView;
import houseowner.OwnerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


/**
 * Created by yifanyang on 2017/6/8.
 */
public class event implements ActionListener,MouseListener,MouseMotionListener{
    Point pressedPoint;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginView.button1){
            if (LoginView.box.getSelectedItem() == "住户"){
                try {
                    new Userview(LoginView.str);
                    LoginView.rs1 = LoginView.sql.executeQuery("SELECT * FROM user where Sno="+ LoginView.field1.getText().trim());
                    System.out.print("sasas");
                    if (LoginView.rs1.next()){
                        if (new String(LoginView.passwordText.getPassword()).equals(LoginView.rs1.getString(3))){
                           LoginView.str =LoginView.field1.getText().trim();


                           LoginView.frame.dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,"密码错误！请重新输入！");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"住户不存在！请重新输入!");
                    }
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,"请输入住户号!");
                }
            }
            if (LoginView.box.getSelectedItem() == "房主"){
                try {
                    new OwnerView(LoginView.str);
                    LoginView.rs1= LoginView.sql.executeQuery("SELECT  * FROM user WHERE 用户号="
                    + LoginView.field1.getText().trim());

                    if (LoginView.rs1.next()){
                        if (new String(LoginView.passwordText.getPassword()).equals(LoginView.rs1.getString(3))){
                            System.out.print("登录成功");
                            LoginView.str= LoginView.field1.getText().trim();

                            LoginView.frame.dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,"密码错误，请重新输入！");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"租户不存在，请重新输入");
                    }
                } catch (SQLException e1) {
                   JOptionPane.showMessageDialog(null,"请输入租户号号");
                }
            }
            if (LoginView.box.getSelectedItem() == "管理员"){
                new adminView(LoginView.str);
                LoginView.frame.dispose();

            }
        }
        if (e.getSource() == LoginView.button2){

            zhuceView frm = new zhuceView();
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setBounds(100, 100, 300, 120);
            frm.setVisible(true);


    }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == LoginView.zuixiaohua){
            LoginView.frame.setExtendedState(Frame.ICONIFIED);
        }
        if (e.getSource() == LoginView.guanbi){
            LoginView.frame.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == LoginView.frame){
            pressedPoint = e.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getSource() == LoginView.zuixiaohua){
            LoginView.zuixiaohua.setOpaque(true);
            LoginView.zuixiaohua.setBackground(Color.blue);
            LoginView.zuixiaohua.setBorder(BorderFactory.createLineBorder(Color.white,1));

        }
        if (e.getSource() == LoginView.guanbi){
            LoginView.guanbi.setOpaque(true);
            LoginView.guanbi.setBackground(Color.red);
            LoginView.guanbi.setBorder(BorderFactory.createLineBorder(Color.white,1));

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == LoginView.zuixiaohua){
            LoginView.zuixiaohua.setOpaque(false);
            LoginView.zuixiaohua.setForeground(Color.white);
            LoginView.zuixiaohua.setBorder(null);
        }
        if (e.getSource()==LoginView.guanbi){
            LoginView.guanbi.setOpaque(true);
            LoginView.guanbi.setForeground(Color.white);
            LoginView.guanbi.setBorder(null);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (e.getSource() instanceof  Component){
            Point point = e.getPoint();//获取当前坐标
            Point locationPoint = LoginView.frame.getLocationOnScreen();//获取窗体坐标
            int x = locationPoint.x+ point.x- pressedPoint.x;
            int y = locationPoint.y + point.y -pressedPoint.y;
            LoginView.frame.setLocation(x,y);//计算移动后的新标
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
