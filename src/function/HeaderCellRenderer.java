package function;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by yifanyang on 2017/6/11.
 */
public class HeaderCellRenderer extends DefaultTableCellRenderer{
    private static final long serialVersionUID =1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                // 重载jlabel的paintComponent方法，在这个jlabel里手动画线
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.white);
                g2d.drawLine(0, 0, this.getWidth(), 0);
                g2d.drawLine(0, this.getHeight() - 1, this.getWidth(),
                        this.getHeight() - 1);
                g2d.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1,
                        this.getHeight() - 1);

                // 一定要记得调用父类的paintComponent方法，不然它只会划线，不会显示文字
                super.paintComponent(g);
            }
        };
        label.setText(value != null ? value.toString() : "unknown");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
}
