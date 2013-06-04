package projekto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author julia
 */
public class MainGUI extends JFrame implements ActionListener {
    
    public MainGUI() {
        super("Projekto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setExtendedState(MAXIMIZED_BOTH);
        
        //JPanel background = new JPanel();
        //background.setLayout(new BorderLayout());
        //background.setPreferredSize(new Dimension(640, 480));
        //add(background);

        JTabbedPane tab = new JTabbedPane();
        tab.setPreferredSize(new Dimension(640, 480));
        add(tab);
        
        tab.addTab("Home", new HomePanel());
        tab.addTab("Aktuelle Reservierungen", new ReservationPanel());
        tab.addTab("Archiv", archivScreen());
        tab.addTab("Benutzer", userScreen());   
        
        pack();
        setVisible(true);
    }
    
    private JPanel archivScreen() {
        JPanel content = new JPanel();
        return content;
    }
    
    private JPanel userScreen() {
        JPanel content = new JPanel();
        return content;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
