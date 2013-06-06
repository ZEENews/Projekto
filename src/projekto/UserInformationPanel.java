/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UserInformationPanel extends JPanel {

    public UserInformationPanel() {

        super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JScrollPane scroll = new JScrollPane();
        add(scroll, BorderLayout.CENTER);

        JPanel alignWestPanel = new JPanel();
        alignWestPanel.setLayout(new BorderLayout());
        scroll.setViewportView(alignWestPanel);
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout());
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        alignWestPanel.add(infoPanel, BorderLayout.WEST);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 10, 5);
        c.gridx = 0;
        c.gridy = 0;

        JLabel lastName = new JLabel("Nachname:");
        infoPanel.add(lastName, c);

        JLabel name = new JLabel("Vorname:");
        c.gridy++;
        infoPanel.add(name, c);

        JLabel email = new JLabel("Email:");
        c.gridy++;
        infoPanel.add(email, c);

        JLabel birthdate = new JLabel("Geburtsdatum:");
        c.gridy++;
        infoPanel.add(birthdate, c);

        JLabel password = new JLabel("Passwort:");
        c.gridy++;
        infoPanel.add(password, c);

        JLabel street = new JLabel("Strasse:");
        c.gridy++;
        infoPanel.add(street, c);

        JLabel housenr = new JLabel("Hausnummer:");
        c.gridy++;
        infoPanel.add(housenr, c);

        JLabel plz = new JLabel("PLZ:");
        c.gridy++;
        infoPanel.add(plz, c);

        JLabel city = new JLabel("Ort:");
        c.gridy++;
        infoPanel.add(city, c);


    }
}
