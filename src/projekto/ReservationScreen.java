package projekto;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ReservationScreen extends JFrame implements ActionListener {
    
    private JButton ok, cancel, ack;
    private JSpinner ticketCount;
    private MainGUI mainGUI;
    private User user;
    private int performanceID;
    
    private JComboBox<String> ticketType;
    private JPanel card2;
    
    public ReservationScreen(MainGUI mainGUI, String performanceID, String title, String date, String time, User user) {
        super("Reservierung");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Container cp = getContentPane();
        cp.setLayout(new CardLayout());
        
        JPanel card1 = new JPanel();
        card1.setLayout(new BorderLayout());
        cp.add(card1, "send Reservation");
        
        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        content.setLayout(new GridBagLayout());
        card1.add(content, BorderLayout.NORTH);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.gridwidth = 2;
        
        JLabel movieTitle = new JLabel(title);
        Font f = movieTitle.getFont();
        movieTitle.setFont(f.deriveFont(f.getSize2D() + 10.0f));
        content.add(movieTitle, c);
        
        JLabel movieDate = new JLabel(date);
        c.gridy++;
        content.add(movieDate, c);
        
        JLabel movieTime = new JLabel(time);
        c.gridy++;
        c.insets = new Insets(0, 0, 30, 0);
        content.add(movieTime, c);
        
        JLabel userName = new JLabel(user.getForename() + " " + user.getLastname());
        c.gridy++;
        c.insets = new Insets(0, 0, 0, 0);
        content.add(userName, c);
        
        JLabel userEmail = new JLabel(user.getEmail());
        c.gridy++;
        c.insets = new Insets(0, 0, 30, 0);
        content.add(userEmail, c);
        
        JLabel countLabel = new JLabel("Ticketanzahl:");
        c.gridwidth = 1;
        c.gridy++;
        c.insets = new Insets(0, 0, 0, 10);
        content.add(countLabel, c);
        
        SpinnerNumberModel countModel = new SpinnerNumberModel(1, 1, 8, 1);
        ticketCount = new JSpinner(countModel);
        c.gridx++;
        c.insets = new Insets(0, 0, 0, 0);
        content.add(ticketCount, c);
        
        JLabel typeLabel = new JLabel("Platzart:");
        c.gridx = 0;
        c.gridy++;
        c.insets = new Insets(0, 0, 0, 10);
        content.add(typeLabel, c);
        
        String[] ticketTypes = {"Parkett", "Loge"};
        ticketType = new JComboBox<String>(ticketTypes);
        c.gridx++;
        c.insets = new Insets(0, 0, 0, 0);
        content.add(ticketType, c);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        card1.add(buttonPanel, BorderLayout.SOUTH);
        
        ok = new JButton("Reservieren");
        ok.addActionListener(this);
        buttonPanel.add(ok);
        
        cancel = new JButton("Abbrechen");
        cancel.addActionListener(this);
        buttonPanel.add(cancel);
        
        pack();
        Dimension d = getPreferredSize();
        System.out.println(d.width);
        if (d.width < 300) {
            setSize(new Dimension(300, d.height));
        }
        setVisible(true);
        
        card2 = new JPanel();
        card2.setLayout(new BorderLayout());
        cp.add(card2, "summary");
      
        this.mainGUI = mainGUI;
        this.user = user;
        this.performanceID = Integer.parseInt(performanceID);
    }
    
    public void reserve(int amount, String type) {
        DBConnect db = new DBConnect();
        if(!db.previousReservation(user.getID(), performanceID)) {
            int available = db.getAvailableTickets(performanceID, type);
            System.out.println(available);
            if(available >= amount) {
                db.reserveTickets(performanceID, user.getID(), type, amount);
                //Ausgabe erfolgreiche reservierung und so
            }
            else {
                //nichts mehr frei
            }
        }
        else {
            //bereits karten reserviert
        }
        mainGUI.updateReservationHistory();
    }
    
    public void close() {
        mainGUI.setEnabled(true);
        dispose();
        mainGUI.toFront();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(ok)) {
            int amount = Integer.parseInt(ticketCount.getValue().toString());
            String type = ticketType.getSelectedItem().toString();
            reserve(amount, type);
            System.out.println(amount + "x " + type);
        }
        else if(ae.getSource().equals(cancel)) {
            close();
        }
    }
}
