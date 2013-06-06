/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UserPanel extends JPanel {

    public UserPanel() {
        
        super();
        setLayout(new BorderLayout());
        
        
        JTabbedPane tab = new JTabbedPane();
        add(tab);


        tab.addTab("Benutzerprofil", new UserInformationPanel());
        tab.addTab("Abgeschlossene Reservierungen", new OldReservationPanel());
      
    }
}
