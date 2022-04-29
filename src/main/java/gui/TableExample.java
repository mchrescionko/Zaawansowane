package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class JTableTest {



    public static void main(String[] argv) throws Exception {
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("Languages");
        tableModel.addColumn("liczba uczniów");
        tableModel.insertRow(0, new Object[]{"CSS", 1});
        tableModel.insertRow(0, new Object[]{"HTML5"});
        tableModel.insertRow(0, new Object[]{"JavaScript"});
        tableModel.insertRow(0, new Object[]{"jQuery"});
        tableModel.insertRow(0, new Object[]{"AngularJS"});
        tableModel.insertRow(0, new Object[]{4});
        tableModel.insertRow(0, new Object[]{6});
        class RedYellowRenderer extends DefaultTableCellRenderer {
            RedYellowRenderer() {
                setHorizontalAlignment(CENTER);
            }

            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component c = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column
                );

                if (row == 0 && table.getRowCount() > 1) {
                    c.setBackground(Color.YELLOW);
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                }

                return c;
            }
        }
        table.setDefaultRenderer(Object.class, new RedYellowRenderer());


//        tableModel.insertRow(1, new Object[] {5,6});
        tableModel.insertRow(tableModel.getRowCount(), new Object[]{"ExpressJS"});
        JFrame f = new JFrame();
        f.setSize(550, 350);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }
}