package projekto;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author julia
 */
public class MainGUI extends JFrame {
    
    private User logedUser;
    
    public MainGUI(User user) {
        super("Projekto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setExtendedState(MAXIMIZED_BOTH);

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
}
