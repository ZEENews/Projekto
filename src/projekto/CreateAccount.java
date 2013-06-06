/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CreateAccount extends JFrame implements ActionListener {

    private JButton register, cancel;
    private JTextField mail, geburtsdatum, vorname, nachname, strasse,hausnummer, plz, ort;
    private JPasswordField password, confirmPw;
    private Color standardColor;
    private Date date = new Date();
    
    public CreateAccount() {
        super("Create Account");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        Container cp = getContentPane();
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
        mail.setToolTipText("<html>beispiel@domain.de<br>Bitte keine Umlaute benutzen!</html>");
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
            
            DBConnect db = new DBConnect();
            
            boolean valid = true;
            
            if (email.equals("")||db.emailCheck(email)||!email.matches(".*@.*")) {
                valid = false;
               
                mail.setBackground(new Color(255, 175, 175));
            }
            if (vname.equals("")||!vname.matches("[a-zA-Zßäüö]+")) {
                valid = false;
                vorname.setBackground(new Color(255, 175, 175));
            }
            if (nname.equals("")||!nname.matches("[a-zA-Zßäüö]+")) {
                valid = false;
                nachname.setBackground(new Color(255, 175, 175));
            }
            if (geb.equals("")||!date.isDateCorrect(geb)||!geb.matches("[0-9]{1,2}.[0-9]{1,2}.[0-9]{2,4}")) {
                valid = false;
                geburtsdatum.setBackground(new Color(255, 175, 175));
            }
            if (str.equals("")||!str.matches("[a-zA-Zßäüö-]+ ?([a-zA-Zßäüö-]+)? ?([a-zA-Zßäüö-]+)?")) {
                valid = false;
                strasse.setBackground(new Color(255, 175, 175));
            }
            if (hnr.equals("")||!hnr.matches("[0-9]+[a-z]?")) {
                valid = false;    
                hausnummer.setBackground(new Color(255, 175, 175));
            }
            if (postleitzahl.equals("")||!postleitzahl.matches("[0-9]{5}")) {
                valid = false;
                plz.setBackground(new Color(255, 175, 175));
            }
            if (stadt.equals("")||!stadt.matches("[a-zA-Zßäüö]+")) {
                valid = false;
                ort.setBackground(new Color(255, 175, 175));
            }
            if (pw.equals("")) {
                valid = false;
                password.setBackground(new Color(255, 175, 175));
            }
            if (pw2.equals("")) {                
                confirmPw.setBackground(new Color(255, 175, 175));
            }
            if (pw.length()<6 && valid){
                password.setBackground(new Color(255, 175, 175));
                confirmPw.setBackground(new Color(255, 175, 175));
                JOptionPane.showMessageDialog(null, "Password too short!", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                valid = false;
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
                    email = email.toLowerCase();
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