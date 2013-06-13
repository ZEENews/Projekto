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
 * @author Julia Krause
 */
public class OldReservationPanel extends JPanel {
    
    public OldReservationPanel(){
    
    super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        
        JScrollPane scroll = new JScrollPane();
        add(scroll, BorderLayout.CENTER);
    }
    
}
