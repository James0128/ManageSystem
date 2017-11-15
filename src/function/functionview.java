package function;

import Login.LoginView;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by yifanyang on 2017/6/11.
 */
public class functionview {
    public static ResultSet rs;
    public static int hang;
    public static int lie;
    public static Object[][] getrecord(String str1)
    {
        Object a[][] = null;
        //ResultSet rs;
        String str;
        str=str1;
        try
        {
            rs = LoginView.sql.executeQuery(str);
            System.out.println("SQL语句正确。");
            lie=rs.getMetaData().getColumnCount();
            hang=0;
            while(rs.next())
            {
                hang++;
            }
            //System.out.println(hang);
            a=new Object[hang][lie];
            rs.first();
            int j;
            for(j=0;j<hang;j++)
            {
                for(int i=1;i<=lie;i++)
                {
                    a[j][i-1]=rs.getObject(i);

                }
                rs.next();
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog( null ,"数据异常") ;
        }
        return a;
    }
    public static Object[] gengxing(String str)
    {
        String st=str;
        Object []b=null;
        try
        {
            rs = LoginView.sql.executeQuery("select * from  " + st);
            ResultSetMetaData rsmd=rs.getMetaData();   //总列数
            int size=rsmd.getColumnCount();
            b=new Object[size];
            for(int i=1;i<=size;i++)
            {
                b[i - 1] = rsmd.getColumnName(i);
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog( null ,"数据异常") ;

        }
        return b;
    }

}
