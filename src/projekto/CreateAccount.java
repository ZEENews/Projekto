/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

/**
 *
 * @author Julia
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class CreateAccount extends JFrame implements ActionListener {

    private JButton register, cancel;
    private JTextField mail, geburtsdatum, vorname, nachname, strasse,hausnummer, plz, ort;
    private JPasswordField password, confirmPw;
    private Border standardBorder;
    private Color standardColor;

    public CreateAccount() {
        super("Create Account");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        Container cp = getContentPane();
        //cp.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(4, 5, 0, 4);
        
        JPanel reg = new JPanel();
        reg.setLayout(new GridBagLayout());
        reg.setBorder(BorderFactory.createTitledBorder("Create Account"));
        cp.add(reg);
        
        JLabel vornameLabel = new JLabel("Vorname:");
        reg.add(vornameLabel, c);
        
        vorname = new JTextField(15);
        standardBorder = vorname.getBorder();
        standardColor = vorname.getBackground();
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(vorname, c);
        
        JLabel nachnameLabel = new JLabel("Nachname:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy++;
        reg.add(nachnameLabel, c);
        
        nachname= new JTextField(15);
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(nachname, c);
        
        JLabel geburtsdatumLabel = new JLabel("Geburtsdatum:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy++;
        reg.add(geburtsdatumLabel, c);
        
        geburtsdatum = new JTextField(15);
        geburtsdatum.setToolTipText("DD.MM.YYYY");
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(geburtsdatum, c);
        
        JLabel strasseLabel = new JLabel("Straße:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy++;
        reg.add(strasseLabel, c);
        
        strasse = new JTextField(15);  
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(strasse, c);
        
        JLabel hausnummerLabel = new JLabel("Hausnummer:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy++;
        reg.add(hausnummerLabel, c);
        
        hausnummer = new JTextField( 15);
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(hausnummer, c);
        
        JLabel plzLabel = new JLabel("PLZ:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy++;
        reg.add(plzLabel, c);
        
        plz = new JTextField(15);
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(plz, c);
        
        JLabel ortLabel = new JLabel("Ort:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy++;
        reg.add(ortLabel, c);
        
        ort = new JTextField(15);
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(ort, c);
        
        JLabel emailLabel = new JLabel("E-mail:");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy++;
        reg.add(emailLabel, c);
        
        mail = new JTextField(15);
        mail.setToolTipText("beispiel@domain.de");
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(mail, c);
        
        JLabel passwordLabel = new JLabel("Passwort:");
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 1;
        reg.add(passwordLabel, c);
        
        password = new JPasswordField(15);
        password.setToolTipText("Mindestens 6 Zeichen!");
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(password, c);
        
        JLabel confirmLabel = new JLabel("Confirm Password:");
        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 1;
        reg.add(confirmLabel, c);
        
        confirmPw = new JPasswordField(15);
        c.gridx = 1;
        c.gridwidth = 2;
        reg.add(confirmPw, c);
        
        register = new JButton("Register");
        register.addActionListener(this);
        c.insets = new Insets(5, 5, 5, 0);
        c.gridwidth = 1;
        c.gridy++;
        reg.add(register, c);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        c.gridx = 2;
        c.insets = new Insets(5, 1, 5, 4);
        reg.add(cancel, c);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(register)) {
            String email = mail.getText();
            String vname = vorname.getText();
            String nname = nachname.getText();
            String geb = geburtsdatum.getText();
            String str = strasse.getText();
            String hnr = hausnummer.getText();
            String postleitzahl = plz.getText();
            String stadt = ort.getText();
            String pw = new String(password.getPassword());
            String pw2 = new String(confirmPw.getPassword());
//            mail.setBorder(standardBorder);
//            vorname.setBorder(standardBorder);
//            nachname.setBorder(standardBorder);
//            geburtsdatum.setBorder(standardBorder);
//            strasse.setBorder(standardBorder);
//            hausnummer.setBorder(standardBorder);
//            plz.setBorder(standardBorder);
//            ort.setBorder(standardBorder);
//            password.setBorder(standardBorder);
//            confirmPw.setBorder(standardBorder);
            mail.setBackground(standardColor);
            vorname.setBackground(standardColor);
            nachname.setBackground(standardColor);
            geburtsdatum.setBackground(standardColor);
            strasse.setBackground(standardColor);
            hausnummer.setBackground(standardColor);
            plz.setBackground(standardColor);
            ort.setBackground(standardColor);
            password.setBackground(standardColor);
            confirmPw.setBackground(standardColor);
            
            boolean valid = true;
            
            if (email.equals("")) {
                valid = false;
                //mail.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                mail.setBackground(new Color(255, 175, 175));
            }
            if (vname.equals("")||!vname.matches("[a-zA-Z]+")) {
                valid = false;
                //vorname.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                vorname.setBackground(new Color(255, 175, 175));
            }
            if (nname.equals("")||!nname.matches("[a-zA-Z]+")) {
                valid = false;
                //nachname.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                nachname.setBackground(new Color(255, 175, 175));
            }
            if (geb.equals("")||!geb.matches("[0-3][0-9].[0-1][0-9].[1-2][0-9]{3}")) {
                valid = false;
                //geburtsdatum.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                geburtsdatum.setBackground(new Color(255, 175, 175));
            }
            if (str.equals("")||!str.matches("[a-zA-Z]+-?([a-zA-Z]+)?-?([a-zA-Z]+)?")) {
                valid = false;
                //strasse.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                strasse.setBackground(new Color(255, 175, 175));
            }
            if (hnr.equals("")||!hnr.matches("[0-9]+[a-z]?")) {
                valid = false;
                //hausnummer.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                hausnummer.setBackground(new Color(255, 175, 175));
            }
            if (postleitzahl.equals("")||!postleitzahl.matches("[0-9]{5}")) {
                valid = false;
                //plz.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                plz.setBackground(new Color(255, 175, 175));
            }
            if (stadt.equals("")||!stadt.matches("[a-zA-Z]+")) {
                valid = false;
                //ort.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                ort.setBackground(new Color(255, 175, 175));
            }
            if (pw.equals("")) {
                valid = false;
                //password.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                password.setBackground(new Color(255, 175, 175));
            }
            if (pw2.equals("")) {
                //confirmPw.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                confirmPw.setBackground(new Color(255, 175, 175));
            }
            if (valid) {
                if (false) {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "E-mail adress already in use.", "Invalid E-mail adress", JOptionPane.ERROR_MESSAGE);
                }
                if (!pw.equals(pw2)) {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Password does not match.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                }
                if (valid) {
                    DBConnect db = new DBConnect();
                    db.createUser(email, vname, nname, geb, str, hnr, stadt, postleitzahl, pw);  //Diese Zeile ist neu
                    //DBConnector.getInstance().createUser(name, pw);
                    JOptionPane.showMessageDialog(null, "Account successfully created.", "Account created", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new LoginScreen();
                }
            }
        }
        if (e.getSource().equals(cancel)) {
            dispose();
            new LoginScreen();
        }
    }
}