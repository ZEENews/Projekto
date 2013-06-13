package projekto;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Julia Krause, Tobias Gneuß
 */

public class MainGUI extends JFrame {
    
    ReservationHistoryPanel reservationHistory;

    public MainGUI(User user) {
        super("Projekto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setExtendedState(MAXIMIZED_BOTH);

        JTabbedPane tab = new JTabbedPane();
        tab.setPreferredSize(new Dimension(640, 480));
        add(tab);
        
        tab.addTab("Home", new HomePanel());
        tab.addTab("Reservierungen", new ReservationPanel(this, user));
        
        JTabbedPane userTab = new JTabbedPane();
        userTab.addTab("Benutzerprofil", new UserInformationPanel(user, this));
        reservationHistory = new ReservationHistoryPanel(user);
        userTab.addTab("Abgeschlossene Reservierungen", reservationHistory);
        tab.addTab("Benutzer", userTab);   
        
        pack();
        setVisible(true);
    }
    
    public void updateReservationHistory() {
        reservationHistory.updateHistory();
    }
}
