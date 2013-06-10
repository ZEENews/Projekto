package projekto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class UserInformationPanel extends JPanel implements ActionListener {
    
    private JButton save, cancel, editData, modifyPassword, deleteAccount;
    private UserInputPanel userInput;
    private JPanel editPasswordPanel, components;
    private JPasswordField oldPassword, newPassword, confirmPw;
    
    private final int MODE_EDIT_USER = 0;
    private final int MODE_VIEW_USER = 1;
    private final int MODE_CHANGE_PASSWORD = 2;
    
    private User user;
    private MainGUI mainGUI;
    private Color standardColor;
    private Color failureColor = new Color(255, 175, 175);
    private int mode = MODE_VIEW_USER;
    
    public UserInformationPanel(User user, MainGUI parent) {

        super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel heading = new JLabel("Benutzerprofil");
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Font f = heading.getFont();
        heading.setFont(f.deriveFont(f.getSize() + 5.0f));
        heading.setHorizontalAlignment(JLabel.CENTER);
        add(heading, BorderLayout.NORTH);
        
        JScrollPane scroll = new JScrollPane();
        add(scroll, BorderLayout.CENTER);
        
        components = new JPanel();
        components.setLayout(new BorderLayout());
        scroll.setViewportView(components);
        
        userInput = new UserInputPanel(user);
        userInput.setEditable(false);
        userInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
        components.add(userInput, BorderLayout.WEST);
        
        editPasswordPanel = new JPanel();
        editPasswordPanel.setLayout(new GridBagLayout());
        editPasswordPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 5, 15);
        c.gridx = 0;
        c.gridy = 0;
                
        JLabel oldPasswordLabel = new JLabel("Altes Passwort:");
        editPasswordPanel.add(oldPasswordLabel, c);
        
        oldPassword = new JPasswordField(15);
        standardColor = oldPassword.getBackground();
        c.gridx++;
        editPasswordPanel.add(oldPassword, c);
        
        JLabel newPasswordLabel = new JLabel("Neues Passwort:");
        c.gridx = 0;
        c.gridy++;
        editPasswordPanel.add(newPasswordLabel, c);
        
        newPassword = new JPasswordField(15);
        c.gridx++;
        editPasswordPanel.add(newPassword, c);
        
        JLabel confirmPwLabel = new JLabel("Passwort bestätigen:");
        c.gridx = 0;
        c.gridy++;
        editPasswordPanel.add(confirmPwLabel, c);
        
        confirmPw = new JPasswordField(15);
        c.gridx++;
        editPasswordPanel.add(confirmPw, c);
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        components.add(buttonPanel, BorderLayout.SOUTH);
        
        editData = new JButton("Bearbeiten");
        editData.addActionListener(this);
        buttonPanel.add(editData);
        
        modifyPassword = new JButton("Passwort ändern");
        modifyPassword.addActionListener(this);
        buttonPanel.add(modifyPassword);
        
        deleteAccount = new JButton("Account löschen");
        deleteAccount.addActionListener(this);
        buttonPanel.add(deleteAccount);
        
        save = new JButton("Speichern");
        save.setVisible(false);
        save.addActionListener(this);
        buttonPanel.add(save);
        
        cancel = new JButton("Abbrechen");
        cancel.setVisible(false);
        cancel.addActionListener(this);
        buttonPanel.add(cancel);
        
        this.user = user;
        this.mainGUI = parent;
    }
    
    private void editUser() {
        editData.setVisible(false);
        modifyPassword.setVisible(false);
        deleteAccount.setVisible(false);
        save.setVisible(true);
        cancel.setVisible(true);

        userInput.setEditable(true);
        
        mode = MODE_EDIT_USER;
    }
    
    private void editPassword() {
        editData.setVisible(false);
        modifyPassword.setVisible(false);
        deleteAccount.setVisible(false);
        save.setVisible(true);
        cancel.setVisible(true);

        components.remove(userInput);
        components.add(editPasswordPanel, BorderLayout.WEST);
        components.validate();
        components.repaint();
        
        mode = MODE_CHANGE_PASSWORD;
    }
    
    private void abortEditUser() {
        editData.setVisible(true);
        modifyPassword.setVisible(true);
        deleteAccount.setVisible(true);
        save.setVisible(false);
        cancel.setVisible(false);

        userInput.setEditable(false);
        mode = MODE_VIEW_USER;
    }
    
    private void abortEditPassword() {
        editData.setVisible(true);
        modifyPassword.setVisible(true);
        deleteAccount.setVisible(true);
        save.setVisible(false);
        cancel.setVisible(false);
        
        oldPassword.setText("");
        newPassword.setText("");
        confirmPw.setText("");
        
        components.remove(editPasswordPanel);
        components.add(userInput, BorderLayout.WEST);
        components.validate();
        components.repaint();
        
        mode = MODE_VIEW_USER;
    }
    
    private void saveUserData() {
        boolean valid = userInput.saveUser();
        abortEditUser();
    }
    
    private void saveUserPassword() {
        String oldPasswordInput = new String(oldPassword.getPassword());
        String newPasswordInput = new String(newPassword.getPassword());
        String confirmInput = new String(confirmPw.getPassword());
        String savedPassword = new DBConnect().loginCheck(user.getEmail());
        boolean valid = true;
        if(!oldPasswordInput.equals(savedPassword)) {
            valid = false;
            oldPassword.setBackground(failureColor);
        }
        else {
            oldPassword.setBackground(standardColor);
        }    
        if(newPasswordInput.equals("")||confirmInput.equals("")||!newPasswordInput.equals(confirmInput)||newPasswordInput.length() < 6) {
            valid = false;
            newPassword.setBackground(failureColor);
            confirmPw.setBackground(failureColor);
        }
        else {
            newPassword.setBackground(standardColor);
            confirmPw.setBackground(standardColor);
        }
        if(valid) {
            user.setPassword(newPasswordInput);
            abortEditPassword();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(editData)) {
            editUser();
        }
        else if(ae.getSource().equals(modifyPassword)) {
            editPassword();
        }
        else if(ae.getSource().equals(deleteAccount)) {
            Object[] options = {"Abbrechen", "OK"};
            int answer = JOptionPane.showOptionDialog(null,
                "Account wirklich löschen?",
                "Account löschen",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);
            if(answer == 1) {
                user.delete();
                JOptionPane.showMessageDialog(null, "Account wurde erfolgreich gelöscht.", "Account gelöscht", JOptionPane.INFORMATION_MESSAGE);
                mainGUI.dispose();
                new LoginScreen();
            }
        }
        else if(ae.getSource().equals(save)) {
            if(mode == MODE_EDIT_USER) {
                saveUserData();
            }
            else if(mode == MODE_CHANGE_PASSWORD) {
                saveUserPassword();
            }
        }
        else if(ae.getSource().equals(cancel)) {
            if(mode == MODE_EDIT_USER) {
                abortEditUser();
            }
            else if(mode == MODE_CHANGE_PASSWORD) {
                abortEditPassword();
            }
        }
    }
}
