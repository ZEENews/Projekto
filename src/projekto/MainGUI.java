package projekto;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author julia
 */
public class MainGUI extends JFrame implements ActionListener {
    
    private User logedUser;
    
    public MainGUI(User user) {
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
        tab.addTab("Reservierungen", new ReservationPanel());
        
        JTabbedPane userTab = new JTabbedPane();
        userTab.addTab("Benutzerprofil", new UserInformationPanel(user, this));
        userTab.addTab("Abgeschlossene Reservierungen", new OldReservationPanel());
        tab.addTab("Benutzer", userTab);   
        
        pack();
        setVisible(true);
        logedUser = user;
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
