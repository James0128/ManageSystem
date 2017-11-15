package houseowner;

import Login.LoginView;
import function.BackgroundPanel;
import function.functionview;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yifanyang on 2017/6/9.
 */
public class OwnerView extends JFrame implements ActionListener,FocusListener,TableModelListener{

    private static final long serialVersionUID= 259398076898141185L;
    String str;
    JMenuBar menu;
    JMenu m1,m2,m3,m4,m5;
    JLabel label1,label2,label3,label4;
    JPanel panel,panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9;
    JTextField text1,text2;
    JButton button1,button2;
    static ResultSet rs;
    ResultSet rs1;
    ResultSet rs3;
    JTextField cx1,cx2,cx3,cx4,lr1,lr2,sc1;
    JComboBox  cxbox1;
    JButton cxbutton1,lrbutton1,scbutton1,scbutton2;
    JTable table;
    JScrollPane scoro,scoro1;
    Object fangchan[][] = null;
    JMenuItem item1,item2,item3;
    JComboBox box;
    public OwnerView(String str1)
    {

        this.str=str1;
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setBounds((int)(width*0.1),(int)(height*0.1), (int)(1366*0.8),(int)(768*0.8) );
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setIconImage(new ImageIcon("/Users/yifanyang/Desktop/image/owner-image/zhang.jpg")
                .getImage());
        //
        menu= new JMenuBar();
        m1=new JMenu ("菜单");
        m2=new JMenu ("退出");
        // m3 = new JMenu("打印");
        menu.add(m1);
        menu.add(m2);
        item1=new JMenuItem("修改密码");
        item1.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/owner-image/key.png"));
        item2=new JMenuItem("退出");
        item2.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/owner-image/delete.png"));
        item3 = new JMenuItem("打印");
        item3.setIcon(new ImageIcon("/Users/yifanyang/Desktop/image/owner-image/print.png"));
        m1.add(item1);
        m1.add(item2);
        m1.add(item3);
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        this.setJMenuBar(menu);
        //
        ImageIcon icon1 = new ImageIcon("/Users/yifanyang/Desktop/image/owner-image/a.jpg");
        panel1=new BackgroundPanel(icon1.getImage());
        panel1.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        this.add(panel1,BorderLayout.WEST);
        //
        text1=new JTextField(15);
        text2=new JTextField(15);

        panel2=new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel2.setPreferredSize(new Dimension(500,getHeight()));
        panel2.setOpaque(false);
        panel2.add(new JLabel(" 姓名："));
        text1.setEditable(false);
        text1.setOpaque(false);
        panel2.add(text1);
        panel2.add(new JLabel("用户号："));
        text2.setEditable(false);
        text2.setOpaque(false);
        panel2.add(text2);
        panel2.add(new JLabel("       合同：    "));
        box=new JComboBox();
        box.setOpaque(false);
        panel2.add(box);

        panel1.add(panel2);
        //.........................................................

        ImageIcon icon3=new ImageIcon("/Users/yifanyang/Desktop/image/owner-image/image3.jpg");
        panel=new BackgroundPanel(icon3.getImage());
        panel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panel.setPreferredSize(new Dimension(550,getHeight()));
        panel.setLayout(new BorderLayout());
        table=new JTable(100,4);
        scoro =new JScrollPane(table);
        scoro.setPreferredSize(new Dimension(500,getHeight()));
        panel.add(scoro,BorderLayout.CENTER);
        this.add(panel,BorderLayout.EAST);


        //............................................................
        panel3=new JPanel();
        panel3.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panel3.setBorder(BorderFactory.createTitledBorder("查询"));
        panel3.setPreferredSize(new Dimension(480,150));
        panel3.setOpaque(false);
        //..................................
        panel3.setLayout(null);
        // /////////////////////////////////
        label1 = new JLabel("请选择：");
        panel3.add(label1);
        label1.setBounds(10, 20, 50, 20);

        cxbox1=new JComboBox();
        cxbox1.addItem(" 用户号 ");
        cxbox1.addItem(" 姓名 ");
        panel3.add(cxbox1);
        cxbox1.setBounds(60, 20, 100, 20);
        cx1=new JTextField(20);
        cx1.setOpaque(false);
        panel3.add(cx1);
        cx1.setBounds(170, 20, 100, 20);
        // panel3.add(new JLabel("====================="));
        cxbutton1=new JButton("  查询  ");
        cxbutton1.addActionListener(this);
        cxbutton1.setBounds(350, 20, 100, 20);
        panel3.add(cxbutton1);




        //............................................
        panel2.add(panel3);
        //
        panel4=new JPanel();
        panel4.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panel4.setBorder(BorderFactory.createTitledBorder("录入"));
        panel4.setPreferredSize(new Dimension(480,150));
        panel4.setLayout(null);
        panel4.setOpaque(false);
        // //////////////////////////////////////
        label2 = new JLabel("学号：");
        panel4.add(label2);
        label2.setBounds(10, 20, 50, 20);
        lr1=new JTextField(15);
        lr1.setOpaque(false);
        lr1.addFocusListener(this);
        lr1.setBounds(70, 20, 100, 20);
        panel4.add(lr1);
        label3 = new JLabel("合同");
        label3.setBounds(180, 20, 50, 20);
        panel4.add(label3);
        lr2=new JTextField(15);
        lr2.setOpaque(false);
        lr2.setBounds(230, 20, 100, 20);
        panel4.add(lr2);
        lr2.addFocusListener(this);


        lrbutton1=new JButton("  录入  ");
        lrbutton1.addActionListener(this);
        lrbutton1.setBounds(350, 20, 100, 20);
        panel4.add(lrbutton1);


        //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        panel2.add(panel4);
        //
        panel5=new JPanel();
        panel5.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panel5.setBorder(BorderFactory.createTitledBorder("删除"));
        panel5.setPreferredSize(new Dimension(480,150));
        panel5.setLayout(null);
        panel5.setOpaque(false);

        label4 = new JLabel("用户号：");
        panel5.add(label4);
        label4.setBounds(10, 20, 50, 20);
        sc1=new JTextField(15);
        sc1.setOpaque(false);
        sc1.addFocusListener(this);
        sc1.setBounds(70, 20, 100, 20);
        panel5.add(sc1);
        scbutton1=new JButton(" 删除 ");
        scbutton2=new JButton("全部删除");
        scbutton1.setBounds(350, 20, 100, 20);
        scbutton2.setBounds(350, 100, 100, 20);
        scbutton2.addActionListener(this);
        scbutton1.addActionListener(this);
        panel5.add(scbutton1);
        // panel5.add(new JLabel("=========================="));
        panel5.add(scbutton2);
        panel2.add(panel5);
        //
        button1=new JButton("查看全部");
        button2=new JButton("租金");
        button1.addActionListener(this);
        button2.addActionListener(this);
        panel2.add(new JLabel("                                                                       "));
        panel2.add(new JLabel("                                                   "));
        panel2.add(button1);
        panel2.add(button2);

        //
        ImageIcon icon2=new ImageIcon("image1.jpg");
        panel6=new BackgroundPanel(icon2.getImage());
        this.add(panel6,BorderLayout.CENTER);
        //
        try {
            rs = LoginView.sql.executeQuery("select * from teacher where 教师号="
                    + str1);
            rs.next();
            //System.out.println(rs.getString(1));
            text1.setText(rs.getString("姓名"));
            text2.setText(rs.getString("教师号"));
            rs1 = LoginView.sql.executeQuery("select 课程名   from course where 教师号="
                    + str1);
            while(rs1.next())
            {
                ;
                box.addItem(rs1.getString(1));
            }


        } catch (SQLException e1)
        {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog( null ,"信息获取失败！！");
            this.validate();
        }





        //
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==cxbutton1)//查询
        {
            panel.removeAll();
            if(cxbox1.getSelectedItem()==" 用户号 ")
            {
                if(cx1.getText().length()==0)
                {
                    JOptionPane.showMessageDialog( null ,"请输入用户号！");
                    this.validate();
                }
                else
                {
                    Object a[] = { "用户号", "姓名", "合同" };
                    String str = "select 用户号,  姓名,  " + box.getSelectedItem()
                            + "  from sc where  学号=" + cx1.getText().trim();
                    table = new JTable(functionview.getrecord(str), a);
                    table.setRowHeight(30);
                    //

                    //
                    scoro = new JScrollPane(table);
                    panel.add(scoro,BorderLayout.CENTER);
                    this.validate();
                }

            }
            if(cxbox1.getSelectedItem()==" 姓名 ")
            {
                if(cx1.getText().length()==0)
                {
                    JOptionPane.showMessageDialog( null ,"请输入姓名！");
                    this.validate();
                }
                else
                {
                    Object a[] = { "学号", "姓名", "成绩" };
                    String str = "select 学号,  姓名,  " + box.getSelectedItem()
                            + "  from sc where  姓名='" + cx1.getText().trim()
                            + "'";
                    // String
                    // str="select *  from sc where  姓名="+cx1.getText().trim();
                    table = new JTable(functionview.getrecord(str), a);
                    table.setRowHeight(30);
                    scoro = new JScrollPane(table);
                    panel.add(scoro,BorderLayout.CENTER);
                    this.validate();
                }
            }

        }
        if(e.getSource()==lrbutton1)
        {
            String str1,str2;
            str1=lr1.getText().trim();
            str2=lr2.getText().trim();
            try
            {
                LoginView.sql.execute("update sc set  " + box.getSelectedItem()
                        + "=" + str2 + " where 学号=" + str1);
                button1.doClick();
            }
            catch (SQLException e1)
            {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog( null ,"输入异常！重新输入") ;
                this.validate();

            }
        }
        if(e.getSource()==scbutton1)//删除当前
        {
            String str;
            str=sc1.getText();
            try
            {
                LoginView.sql.execute("update sc set " + box.getSelectedItem()
                        + "=0 where 学号=" + str);
                button1.doClick();
            }
            catch (SQLException e1)
            {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog( null ,"当前学号不存在！");
                this.validate();
            }

        }
        if(e.getSource()==scbutton2)//全部删除
        {
            try
            {

                if(JOptionPane.showConfirmDialog(null, "此操作不可恢复！确认删除全部成绩吗？", null,JOptionPane.YES_NO_CANCEL_OPTION )==JOptionPane.YES_OPTION)
                {
                    LoginView.sql.execute("update sc set " + box.getSelectedItem()
                            + "=0");
                    button1.doClick();
                }
            }
            catch (SQLException e1)
            {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog( null ,"删除异常！");
                this.validate();

            }

        }
        if(e.getSource()==button1)//查看全部
        {
            panel.removeAll();
            Object ss[]={"学号","姓名","成绩"};
            String str="select 学号,姓名,"+box.getSelectedItem()+" from sc";
            Object d[][]=functionview.getrecord(str);
            DefaultTableModel zz = new MyModel(d,ss);
            table = new JTable(zz);
            // table1.setGridColor(Color.white);
            zz.addTableModelListener(this);
            table.setRowHeight(30);
            table.setCellSelectionEnabled(true);
            table.setAutoCreateRowSorter(true);
            scoro = new JScrollPane(table);
            panel.add(scoro,BorderLayout.CENTER);
            this.validate();
        }
        if(e.getSource()==button2)//单科排名
        {
            panel.removeAll();
            String str = "select 学号,姓名," + box.getSelectedItem()
                    + ",@counter:=@counter+1 AS Rank from sc order by "
                    + box.getSelectedItem() + " desc";
            String ss[] = { "学号", "姓名", "成绩", "名次" };
            Object c[][]=functionview.getrecord(str);
            int i=c.length;
            for(int j=0;j<i;j++)
            {
                c[j][3]=j+1;
            }
            table = new JTable(c, ss);
            table.setAutoCreateRowSorter(true);
            // table4.setGridColor(Color.red);
            table.setRowHeight(30);
            table.setEnabled(false);
            scoro = new JScrollPane(table);
            panel.add(scoro,BorderLayout.CENTER);
            this.validate();
        }
        // TODO Auto-generated method stub
        if(e.getSource()==item1)
        {
            String inputValue = JOptionPane.showInputDialog("请输入新密码");
            try
            {
                if(inputValue!=null)
                {
                    LoginView.sql.execute("update teacher set 密码=\"" + inputValue
                            + "\"where 教师号=\"" + str + "\";");
                }
                else
                {

                }
            }
            catch (SQLException e1)
            {
                // TODO Auto-generated catch block
            }
        }	// TODO Auto-generated method stub
        if(e.getSource()==item2)
        {
            this.dispose();
            System.exit(0);
        }
        if (e.getSource() == item3) {
            try {
                table.print();
            } catch (PrinterException e1) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(null, "初始化失败！！");
            }
        }


    }
    @Override
    public void focusGained(FocusEvent e)
    {
        // TODO Auto-generated method stub
        button1.doClick();
    }
    @Override
    public void focusLost(FocusEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void tableChanged(TableModelEvent e)
    {

        int rr,cc;
        String vv ,v1;
        rr = table.getSelectedRow(); // 取表格tab中的当前行号
        cc = table.getSelectedColumn(); // 取表格tab中的当前列号
        vv = ((String) table.getValueAt(rr, cc)).trim(); // 取表格tab中的第rr行、cc列的单元格的数据值
        //System.out.println("当前行是"+rr+"当前列是"+cc+"数据值是"+vv);
        try
        {
            rs = LoginView.sql.executeQuery("select * from sc ");
            rs.absolute(rr+1);
            v1=rs.getString(1);
            LoginView.sql.execute("update sc set  " + box.getSelectedItem() + "="
                    + vv + " where 学号=" + v1);
        }
        catch (SQLException e1)
        {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog( null ,"更新异常！");
            this.validate();
        }
        this.validate();

    }

}
class MyModel extends DefaultTableModel {
    /**
     *
     */
    private static final long serialVersionUID = 8077956701855597367L;
    public MyModel(Object[][] rowData, Object[] columns)
    {
        super(rowData, columns);
    }
    @Override
    public boolean isCellEditable(int row, int col)
    {

        if (col == 0||col==1) {return false;}

        else
        {
            return true;
        }

    }
}

