/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Julia Krause
 */

public class MovieCard extends JPanel implements MouseListener {
    
    private String title;
    private DefaultTableModel model;
    private JTable table;
    private ArrayList<String> performanceIDs;
    private MainGUI mainGUI;
    private User user;
    private String date;
            
    public MovieCard(String title, String length, String fsk, String type, String date, MainGUI mainGUI, User user) {
        super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel performanceCard = new JPanel();
        performanceCard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        performanceCard.setLayout(new BorderLayout(0, 10));
        add(performanceCard, BorderLayout.NORTH);
        
        JPanel info = new JPanel();
        info.setLayout(new GridBagLayout());
        performanceCard.add(info, BorderLayout.NORTH);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;

        JLabel movieTitle = new JLabel(title);
        Font f = movieTitle.getFont();
        movieTitle.setFont(f.deriveFont(f.getSize2D() + 15.0f));
        info.add(movieTitle, c);

        JLabel movieLength = new JLabel("Dauer: " + length + "min");
        c.gridy++;
        info.add(movieLength, c);

        JLabel movieFsk = new JLabel("FSK: " + fsk);
        c.gridy++;
        info.add(movieFsk, c);

        JLabel movieThreeD = new JLabel("3D: " + type);
        c.gridy++;
        info.add(movieThreeD, c);

        String[] columnNames = {"Saal", "Uhrzeit"};

        model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        tablePanel.setLayout(new BorderLayout());
        performanceCard.add(tablePanel, BorderLayout.CENTER);

        table = new JTable(model);
        table.addMouseListener(this);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablePanel.add(table, BorderLayout.CENTER);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tablePanel.add(tableHeader, BorderLayout.NORTH);
        
        this.title = title;
        this.mainGUI = mainGUI;
        this.user = user;
        this.date = date;
        this.performanceIDs = new ArrayList<String>();
    }
    
    public void addPerformance(String[] performance, String performanceID) {
        model.addRow(performance);
        performanceIDs.add(performanceID);
    }
    
    public String getTitle() {
        return title;
    }

    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {
        int r = table.rowAtPoint(me.getPoint());
        if (r >= 0 && r < table.getRowCount()) {
            table.setRowSelectionInterval(r, r);
        } else {
            table.clearSelection();
        }

        int rowindex = table.getSelectedRow();
        if (rowindex < 0) {
            return;
        }

        if (me.getButton() == 1 && me.getComponent() instanceof JTable && me.getClickCount() >= 2) {
            String time = (String) table.getValueAt(rowindex, 1);
            mainGUI.setEnabled(false);
            
            ReservationScreen reserve = new ReservationScreen(mainGUI, performanceIDs.get(rowindex), title, date, time, user);
            reserve.setAlwaysOnTop(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
}
