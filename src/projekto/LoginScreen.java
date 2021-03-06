/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Julia Krause
 */
 
public class LoginScreen extends JFrame implements ActionListener, KeyListener {

    private JButton login, register, cancel;
    private JTextField mail;
    private JPasswordField password;
    private Color standardColor;

    public LoginScreen() {
        super("Login");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(4, 5, 0, 4);
        JLabel nameLabel = new JLabel("E-mail:");
        cp.add(nameLabel, c);
        mail = new JTextField(15);
        standardColor = mail.getBackground();
        mail.addKeyListener(this);
        c.gridx = 1;
        c.gridwidth = 3;
        cp.add(mail, c);
        JLabel passwordLabel = new JLabel("Passwort:");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        cp.add(passwordLabel, c);
        password = new JPasswordField(15);
        password.addKeyListener(this);
        c.gridx = 1;
        c.gridwidth = 3;
        cp.add(password, c);
        login = new JButton("Login");
        login.addActionListener(this);
        c.insets = new Insets(5, 5, 5, 0);
        c.gridwidth = 1;
        c.gridy = 2;
        cp.add(login, c);
        register = new JButton("Registrieren");
        register.addActionListener(this);
        c.gridx = 2;
        cp.add(register, c);
        cancel = new JButton("Abbrechen");
        cancel.addActionListener(this);
        c.gridx = 3;
        c.insets = new Insets(5, 5, 5, 4);
        cp.add(cancel, c);
        pack();
        setVisible(true);
    }

    /**
     * *
     */
    public boolean authenticate(String user, String password) {
        DBConnect db = new DBConnect();
        String result = db.loginCheck(user);  
        if(result.equals(password)){
            return true;
        }else{
            return false;
        }
    }  

    /**
     * *
     */
    public void login() {
        mail.setBackground(standardColor);
        password.setBackground(standardColor);
        boolean valid = true;
        String name = mail.getText();
        String pw = new String(password.getPassword());
        if (name.equals("")) {
            valid = false;
            mail.setBackground(new Color(255, 175, 175));
        }
        if (pw.equals("")) {
            valid = false;
            password.setBackground(new Color(255, 175, 175));
        }
        if (valid) {
            if (authenticate(name, pw)) {
                dispose();
                DBConnect db = new DBConnect();
                int userID = db.getUserID(name);
                new MainGUI(new User(userID));
            } else {
                JOptionPane.showMessageDialog(null, "Ungültige E-Mail Adresse oder Passwort.", "Login fehlgeschlagen", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(login)) {
            login();
        }
        else if (e.getSource().equals(cancel)) {
            System.exit(0);
        }
        else {
            dispose();
            new CreateAccount();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            login();
        }
    }
}
