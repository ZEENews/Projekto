/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author julia
 */
public class ReservationHistoryPanel extends JPanel {
    
    User user;
    
    public ReservationHistoryPanel(User user){
    
    super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        
        JScrollPane scroll = new JScrollPane();
        add(scroll, BorderLayout.CENTER);
        
        this.user = user;
    }
    
    public void updateHistory() {
        
    }
}
