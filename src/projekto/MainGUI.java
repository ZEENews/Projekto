package projekto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author julia
 */
public class MainGUI extends JFrame {
    
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
        
        tab.addTab("Home", homeScreen());
        tab.addTab("Aktuelle Reservierungen", reservationScreen());
        tab.addTab("Archiv", archivScreen());
        tab.addTab("Benutzer", userScreen());   
        
        pack();
        setVisible(true);
    }
    
    private JPanel homeScreen() {
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        
        JLabel welcome = new JLabel("Herzlich Willkommen bei Projekto!");
        welcome.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
        Font f = welcome.getFont();
        welcome.setFont(f.deriveFont(f.getSize() + 10.0f));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();
        content.add(scrollPane, BorderLayout.CENTER);
        
        JPanel space = new JPanel();
        space.setLayout(new BorderLayout());
        space.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
        scrollPane.setViewportView(space);
        
        JTextArea text = new JTextArea("Hallo Tobi");
        text.setBackground(new Color(255, 0, 160));
        text.setForeground(Color.BLACK);
        text.setEditable(false);
        space.add(text, BorderLayout.CENTER);
        
        content.add(welcome, BorderLayout.NORTH);
        return content;
    }
    
    private JPanel reservationScreen() {
        JPanel content = new JPanel();
        return content;
    }
    
    private JPanel archivScreen() {
        JPanel content = new JPanel();
        return content;
    }
    
    private JPanel userScreen() {
        JPanel content = new JPanel();
        return content;
    }
}
