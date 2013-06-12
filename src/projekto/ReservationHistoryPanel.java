/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author julia
 */
public class ReservationHistoryPanel extends JPanel {
    
    private User user;
    private DefaultTableModel model;
    
    public ReservationHistoryPanel(User user){
    
        super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel heading = new JLabel("Benutzerprofil");
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Font f = heading.getFont();
        heading.setFont(f.deriveFont(f.getSize() + 5.0f));
        heading.setHorizontalAlignment(JLabel.CENTER);
        add(heading, BorderLayout.NORTH);
        
        JScrollPane scroll = new JScrollPane();
        add(scroll, BorderLayout.CENTER);

        String[] columnNames = {"#", "Karten", "Film", "Datum", "Uhrzeit", "Kino", "Saal"};
        model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getColumnModel().getColumn(0).setPreferredWidth(17);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(35);
        table.getColumnModel().getColumn(6).setPreferredWidth(10);
        scroll.setViewportView(table);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        
        this.user = user;
        updateHistory();
    }
    
    public void updateHistory() {
        model.setRowCount(0);
        ArrayList<String[]> list = new DBConnect().getUserReservations(user.getID());
        for(int i = 0; i < list.size(); i ++) {
            model.addRow(list.get(i));
        }
    }
}
