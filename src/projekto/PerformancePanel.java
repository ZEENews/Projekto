package projekto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
 * @author julia
 */
public class PerformancePanel extends JPanel {
    
    public PerformancePanel(ArrayList<String[]> performances) {
        super();
        setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        setLayout(new BorderLayout());
        
        JPanel alignNorth = new JPanel();
        alignNorth.setLayout(new GridBagLayout());
        add(alignNorth, BorderLayout.NORTH);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = -1;
        c.insets = new Insets(0, 0, 10, 0);
        
        MovieCard oldMovieCard = null;
        for(int i = 0; i < performances.size(); i++) {
            String[] performance = performances.get(i);
            
            String title = performance[0];
            String length = performance[1];
            String fsk = performance[2];
            String threeD = performance[3];
            String room = performance[4];
            String time = performance[5];
            String id = performance[6];
            
            if(oldMovieCard != null && oldMovieCard.getTitle().equals(title)) {
                oldMovieCard.addPerformance(new String[]{room, time}, id);
                continue;
            }
            oldMovieCard = new MovieCard(title, length, fsk, threeD);
            oldMovieCard.addPerformance(new String[]{room, time}, id);
            c.gridy++;
            alignNorth.add(oldMovieCard, c);
        }
    }
}
