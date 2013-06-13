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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;

public class ReservationScreen extends JFrame implements ActionListener, WindowListener {
    
    private JButton ok, cancel;
    private JSpinner ticketCount;
    private JLabel number;
    private MainGUI mainGUI;
    private User user;
    private int performanceID;
    private Container cp;
    
    private JComboBox ticketType;
    
    public ReservationScreen(MainGUI mainGUI, String performanceID, String title, String date, String time, User user) {
        super("Reservierung");
        addWindowListener(this);
        setResizable(false);
        
        cp = getContentPane();
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
        ticketType = new JComboBox(ticketTypes);
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
        
        JPanel card2 = new JPanel();
        card2.setLayout(new BorderLayout());
        card2.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        cp.add(card2, "summary");
        
        JLabel success = new JLabel("Reservierung erfolgreich!");
        success.setHorizontalAlignment(JLabel.CENTER);
        Font f2 = success.getFont();
        success.setFont(f2.deriveFont(f2.getSize2D() + 7.0f));
        card2.add(success, BorderLayout.NORTH);
        
        JPanel info = new JPanel();
        info.setLayout(new GridBagLayout());
        card2.add(info, BorderLayout.CENTER);
        
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.NONE;
        c2.gridx = 0;
        c2.gridy = 0;
        c2.weightx = 1;
        c2.insets = new Insets(0, 0, 5, 0);
        
        JLabel numberInfo = new JLabel("Ihre Reservierungsnummer:");
        info.add(numberInfo, c2);
        
        number = new JLabel();
        f = number.getFont();
        number.setFont(f.deriveFont(f.getSize2D() + 10.0f));
        c2.gridy++;
        info.add(number, c2);
        
        JPanel alignRight = new JPanel();
        alignRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        card2.add(alignRight, BorderLayout.SOUTH);
        
        JButton close = new JButton("Schließen");
        close.addActionListener(this);
        alignRight.add(close);
        
        JPanel card3 = errorPanel("Sie haben bereits Karten für diese Vorstellung reserviert.");
        cp.add(card3, "errorPreviousReservation");
        
        JPanel card4 = errorPanel("Es sind nicht mehr genug Karten für diese Vorstellung vorhanden.");
        cp.add(card4, "errorTicketsUnavailable");
        
        this.mainGUI = mainGUI;
        this.user = user;
        this.performanceID = Integer.parseInt(performanceID);
    }
    
    private JPanel errorPanel(String message) {
        JPanel errorPanel = new JPanel();
        errorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        errorPanel.setLayout(new BorderLayout(0, 10));
        
        JLabel error = new JLabel("Fehler:");
        Font f = error.getFont();
        error.setFont(f.deriveFont(f.getSize2D() + 7.0f));
        errorPanel.add(error, BorderLayout.NORTH);
        
        JTextPane p = new JTextPane();
        p.setText(message);
        p.setBorder(null);
        p.setBackground(null);
        p.setEditable(false);
        p.setOpaque(false);
        errorPanel.add(p, BorderLayout.CENTER);
        
        JPanel alignRight = new JPanel();
        alignRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        errorPanel.add(alignRight, BorderLayout.SOUTH);
        
        JButton close = new JButton("Schließen");
        close.addActionListener(this);
        alignRight.add(close);
        
        return errorPanel;
    }
    
    public void reserve(int amount, String type) {
        DBConnect db = new DBConnect();
        CardLayout layout = (CardLayout) cp.getLayout();
        if(!db.previousReservation(user.getID(), performanceID)) {
            int available = db.getAvailableTickets(performanceID, type);
            System.out.println(available);
            if(available >= amount) {
                int reservationNumber = db.reserveTickets(performanceID, user.getID(), type, amount);
                number.setText("" + reservationNumber);
                //Ausgabe erfolgreiche reservierung und so
                layout.show(cp, "summary");
                mainGUI.updateReservationHistory();
            }
            else {
                //nichts mehr frei
                layout.show(cp, "errorTicketsUnavailable");
            }
        }
        else {
            //bereits karten reserviert
            layout.show(cp, "errorPreviousReservation");
        }
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
        }
        else if(ae.getSource().equals(cancel)) {
            close();
        }
        else {
            close();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {}

    @Override
    public void windowClosing(WindowEvent we) {
        close();
    }

    @Override
    public void windowClosed(WindowEvent we) {}

    @Override
    public void windowIconified(WindowEvent we) {}

    @Override
    public void windowDeiconified(WindowEvent we) {}

    @Override
    public void windowActivated(WindowEvent we) {}

    @Override
    public void windowDeactivated(WindowEvent we) {}
}
