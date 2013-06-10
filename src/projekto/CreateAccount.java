/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;


public class CreateAccount extends JFrame implements ActionListener {

    private JButton register, cancel;
    private UserInputPanel userInput;
    
    public CreateAccount() {
        
        super("Account erstellen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(0, 10));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(4, 5, 0, 4);
        
        userInput = new UserInputPanel();
        userInput.setBorder(BorderFactory.createTitledBorder("Account erstellen"));
        cp.add(userInput, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        cp.add(buttonPanel, BorderLayout.SOUTH);
        
        register = new JButton("Register");
        register.addActionListener(this);
        buttonPanel.add(register);
        
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        buttonPanel.add(cancel);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(register)) {
            boolean successful = userInput.saveUser();
            
            if (successful) {                          
                JOptionPane.showMessageDialog(null, "Account wurde erfolgreich erstellt.", "Account erstellt", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new LoginScreen();
            }
        }
        if (ae.getSource().equals(cancel)) {
            dispose();
            new LoginScreen();
        }
    }
}