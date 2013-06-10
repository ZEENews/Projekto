package projekto;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author julia
 */
public class UserInputPanel extends JPanel {
    
    private JTextField lastname, forename, email, birthdate, street, housenr, zipcode, city;
    private JPasswordField password, confirmPw;
    private User user = null;
    private Color standardColor;
    private Color failureColor = new Color(255, 175, 175);
    
    public static final int MODE_REGISTRATION = 0;
    public static final int MODE_EDIT = 1;
    
    public UserInputPanel() {
        super();
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 5, 15);
        c.gridx = 0;
        c.gridy = 0;

        JLabel lastnameText = new JLabel("Nachname:");
        add(lastnameText, c);
        
        lastname = new JTextField(15);
        standardColor = lastname.getBackground();
        c.gridx++;
        add(lastname, c);

        JLabel surnameText = new JLabel("Vorname:");
        c.gridx = 0;
        c.gridy++;
        add(surnameText, c);
        
        forename = new JTextField();
        c.gridx++;
        add(forename, c);

        JLabel emailText = new JLabel("Email:");
        c.gridx = 0;
        c.gridy++;
        add(emailText, c);
        
        email = new JTextField();
        c.gridx++;
        add(email, c);

        JLabel birthdateText = new JLabel("Geburtsdatum:");
        c.gridx = 0;
        c.gridy++;
        add(birthdateText, c);

        birthdate = new JTextField();
        c.gridx++;
        add(birthdate, c);

        JLabel streetText = new JLabel("Strasse:");
        c.gridx = 0;
        c.gridy++;
        add(streetText, c);
        
        street = new JTextField();
        c.gridx++;
        add(street, c);

        JLabel housenrText = new JLabel("Hausnummer:");
        c.gridx = 0;
        c.gridy++;
        add(housenrText, c);

        housenr = new JTextField();
        c.gridx++;
        add(housenr, c);
        
        JLabel zipcodeText = new JLabel("PLZ:");
        c.gridx = 0;
        c.gridy++;
        add(zipcodeText, c);

        zipcode = new JTextField();
        c.gridx++;
        add(zipcode, c);
        
        JLabel cityText = new JLabel("Ort:");
        c.gridx = 0;
        c.gridy++;
        add(cityText, c);

        city = new JTextField();
        c.gridx++;
        add(city, c);
        
        JLabel passwordText = new JLabel("Passwort:");
        c.gridx = 0;
        c.gridy++;
        add(passwordText, c);

        password = new JPasswordField(15);
        password.setToolTipText("Mindestens 6 Zeichen!");
        c.gridx++;
        add(password, c);

        JLabel confirmText = new JLabel("Passwort bestätigen:");
        c.gridx = 0;
        c.gridy++;
        add(confirmText, c);

        confirmPw = new JPasswordField(15);
        confirmPw.setToolTipText("Mindestens 6 Zeichen!");
        c.gridx++;
        add(confirmPw, c);
    }
    
    public UserInputPanel(User u) {
        super();
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 5, 15);
        c.gridx = 0;
        c.gridy = 0;

        JLabel lastnameText = new JLabel("Nachname:");
        add(lastnameText, c);
        
        lastname = new JTextField(u.getLastname(), 15);
        standardColor = lastname.getBackground();
        c.gridx++;
        add(lastname, c);

        JLabel surnameText = new JLabel("Vorname:");
        c.gridx = 0;
        c.gridy++;
        add(surnameText, c);
        
        forename = new JTextField(u.getForename(), 15);
        c.gridx++;
        add(forename, c);

        JLabel emailText = new JLabel("Email:");
        c.gridx = 0;
        c.gridy++;
        add(emailText, c);
        
        email = new JTextField(u.getEmail(), 15);
        c.gridx++;
        add(email, c);

        JLabel birthdateText = new JLabel("Geburtsdatum:");
        c.gridx = 0;
        c.gridy++;
        add(birthdateText, c);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");
        birthdate = new JTextField(format.format(u.getBirthdate()), 15);
        c.gridx++;
        add(birthdate, c);

        JLabel streetText = new JLabel("Strasse:");
        c.gridx = 0;
        c.gridy++;
        add(streetText, c);
        
        street = new JTextField(u.getStreet(), 15);
        c.gridx++;
        add(street, c);

        JLabel housenrText = new JLabel("Hausnummer:");
        c.gridx = 0;
        c.gridy++;
        add(housenrText, c);

        housenr = new JTextField(u.getHousenumber(), 15);
        c.gridx++;
        add(housenr, c);
        
        JLabel zipcodeText = new JLabel("PLZ:");
        c.gridx = 0;
        c.gridy++;
        add(zipcodeText, c);

        zipcode = new JTextField("" + u.getZipcode(), 15);
        c.gridx++;
        add(zipcode, c);
        
        JLabel cityText = new JLabel("Ort:");
        c.gridx = 0;
        c.gridy++;
        add(cityText, c);

        city = new JTextField(u.getCity(), 15);
        c.gridx++;
        add(city, c);

        this.user = u;
    }
    
    public void setEditable(boolean editable) {
        lastname.setEditable(editable);
        forename.setEditable(editable);
        email.setEditable(editable);
        birthdate.setEditable(editable);
        street.setEditable(editable);
        housenr.setEditable(editable);
        zipcode.setEditable(editable);
        city.setEditable(editable);
        if(user == null) {
            password.setEditable(editable);
            confirmPw.setEditable(editable);
        }
        
        lastname.setFocusable(editable);
        forename.setFocusable(editable);
        email.setFocusable(editable);
        birthdate.setFocusable(editable);
        street.setFocusable(editable);
        housenr.setFocusable(editable);
        zipcode.setFocusable(editable);
        city.setFocusable(editable);
        if(user == null) {
            password.setFocusable(editable);
            confirmPw.setFocusable(editable);
        }
        
        if(editable) {
            lastname.requestFocus();
        }
        else {
            if(user != null) {
                lastname.setText(user.getLastname());
                forename.setText(user.getForename());
                email.setText(user.getEmail());
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY");
                birthdate.setText(format.format(user.getBirthdate()));
                street.setText(user.getStreet());
                housenr.setText(user.getHousenumber());
                zipcode.setText("" + user.getZipcode());
                city.setText(user.getCity());
            }
            
            lastname.setBackground(standardColor);
            forename.setBackground(standardColor);
            email.setBackground(standardColor);
            birthdate.setBackground(standardColor);
            street.setBackground(standardColor);
            housenr.setBackground(standardColor);
            zipcode.setBackground(standardColor);
            city.setBackground(standardColor);
            if(user == null) {
                password.setBackground(standardColor);
                confirmPw.setBackground(standardColor);
            }
        }
    }
    
    private boolean checkInputWithoutUser() {
        boolean valid = true;
        
        String lastnameInput = lastname.getText();
        String forenameInput = forename.getText();
        String emailInput = email.getText();
        String birthdateInput = birthdate.getText();
        String streetInput = street.getText();
        String housenrInput = housenr.getText();
        String zipcodeInput = zipcode.getText();
        String cityInput = city.getText();
        String passwordInput = new String(password.getPassword());
        String confirmInput = new String(confirmPw.getPassword());

        DBConnect db = new DBConnect();
        boolean dateformat;
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setLenient(false);
        try {
            df.parse(birthdateInput);
            dateformat = true;
        } catch (ParseException e) {
            dateformat = false;
        }
        if (lastnameInput.equals("")||!lastnameInput.matches("[a-zA-Zßäüö]+")) {
            valid = false;
            lastname.setBackground(failureColor);
        }
        else {
            lastname.setBackground(standardColor);
        }
        if (forenameInput.equals("")||!forenameInput.matches("[a-zA-Zßäüö]+")) {
            valid = false;
            forename.setBackground(failureColor);
        }
        else {
            forename.setBackground(standardColor);
        }
        if (emailInput.equals("")||db.emailCheck(emailInput)||!emailInput.matches("^[a-zA-z0-9]+[a-zA-Z0-9._-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")||emailInput.matches(("[.-_]{2}"))) {
            valid = false;
            email.setBackground(failureColor);
        }
        else {
            email.setBackground(standardColor);
        }
        if (birthdateInput.equals("")||!dateformat||!birthdateInput.matches("[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}")) {
            valid = false;
            birthdate.setBackground(failureColor);
        }
        else {
            birthdate.setBackground(standardColor);
        }
        if (streetInput.equals("")||!streetInput.matches("[a-zA-Zßäüö-]+ ?([a-zA-Zßäüö-]+)? ?([a-zA-Zßäüö-]+)?")) {
            valid = false;
            street.setBackground(failureColor);
        }
        else {
            street.setBackground(standardColor);
        }
        if (housenrInput.equals("")||housenrInput.length() > 8||!housenrInput.matches("^[0-9]+[a-zA-Z]?$")) {
            valid = false;    
            housenr.setBackground(failureColor);
        }
        else {
            housenr.setBackground(standardColor);
        }
        if (zipcodeInput.equals("")||!zipcodeInput.matches("[0-9]{5}")) {
            valid = false;
            zipcode.setBackground(failureColor);
        }
        else {
            zipcode.setBackground(standardColor);
        }
        if (cityInput.equals("")||!cityInput.matches("[a-zA-Zßäüö]+")) {
            valid = false;
            city.setBackground(failureColor);
        }
        else {
            city.setBackground(standardColor);
        }
        if(passwordInput.equals("")||confirmInput.equals("")||!passwordInput.equals(confirmInput)||passwordInput.length() < 6) {
            valid = false;
            password.setBackground(failureColor);
            confirmPw.setBackground(failureColor);
        }
        else {
            password.setBackground(standardColor);
            confirmPw.setBackground(standardColor);
        }
        return valid;
    }
    
    private boolean checkInputWithUser() {
        boolean valid = true;
        
        String lastnameInput = lastname.getText();
        String forenameInput = forename.getText();
        String emailInput = email.getText();
        String birthdateInput = birthdate.getText();
        String streetInput = street.getText();
        String housenrInput = housenr.getText();
        String zipcodeInput = zipcode.getText();
        String cityInput = city.getText();

        DBConnect db = new DBConnect();
        boolean dateformat;
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setLenient(false);
        try {
            df.parse(birthdateInput);
            dateformat = true;
        } catch (ParseException e) {
            dateformat = false;
        }
        if (!lastnameInput.equals(user.getLastname()) && (lastnameInput.equals("")||!lastnameInput.matches("[a-zA-Zßäüö]+"))) {
            valid = false;
            lastname.setBackground(failureColor);
        }
        else {
            lastname.setBackground(standardColor);
        }
        if (!forenameInput.equals(user.getForename()) && (forenameInput.equals("")||!forenameInput.matches("[a-zA-Zßäüö]+"))) {
            valid = false;
            forename.setBackground(failureColor);
        }
        else {
            forename.setBackground(standardColor);
        }
        if (!emailInput.equals(user.getEmail()) && (emailInput.equals("")||db.emailCheck(emailInput)||!emailInput.matches("^[a-zA-z0-9]+[a-zA-Z0-9._-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")||emailInput.matches(("[.-_]{2}")))) {
            valid = false;
            email.setBackground(failureColor);
        }
        else {
            email.setBackground(standardColor);
        }
        
        if (!birthdateInput.equals(df.format(user.getBirthdate())) && (birthdateInput.equals("")||!dateformat||!birthdateInput.matches("[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}"))) {
            valid = false;
            birthdate.setBackground(failureColor);
        }
        else {
            birthdate.setBackground(standardColor);
        }
        if (!streetInput.equals(user.getStreet()) && (streetInput.equals("")||!streetInput.matches("[a-zA-Zßäüö-]+ ?([a-zA-Zßäüö-]+)? ?([a-zA-Zßäüö-]+)?"))) {
            valid = false;
            street.setBackground(failureColor);
        }
        else {
            street.setBackground(standardColor);
        }
        if (!housenrInput.equals(user.getHousenumber()) && (housenrInput.equals("")||housenrInput.length() > 8||!housenrInput.matches("^[0-9]+[a-zA-Z]?$"))) {
            valid = false;    
            housenr.setBackground(failureColor);
        }
        else {
            housenr.setBackground(standardColor);
        }
        if (!zipcodeInput.equals("" + user.getZipcode()) && (zipcodeInput.equals("")||!zipcodeInput.matches("[0-9]{5}"))) {
            valid = false;
            zipcode.setBackground(failureColor);
        }
        else {
            zipcode.setBackground(standardColor);
        }
        if (cityInput.equals(user.getCity()) && (cityInput.equals("")||!cityInput.matches("[a-zA-Zßäüö]+"))) {
            valid = false;
            city.setBackground(failureColor);
        }
        else {
            city.setBackground(standardColor);
        }
        return valid;
    }

    public boolean saveUser() {
        if(user == null) {
            if(checkInputWithoutUser()) {
                
                new DBConnect().createUser(email.getText(), forename.getText(), lastname.getText(), birthdate.getText(), street.getText(), housenr.getText(), city.getText(), zipcode.getText(), new String(password.getPassword()));
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if(checkInputWithUser()) {
                String lastnameInput = lastname.getText();
                String forenameInput = forename.getText();
                String emailInput = email.getText();
                String birthdateInput = birthdate.getText();
                String streetInput = street.getText();
                String housenrInput = housenr.getText();
                String zipcodeInput = zipcode.getText();
                String cityInput = city.getText();
                
                if(!user.getLastname().equals(lastnameInput)) {
                    user.setLastname(lastnameInput);
                }
                if(!user.getForename().equals(forenameInput)) {
                    user.setForename(forenameInput);
                }
                if(!user.getEmail().equals(emailInput)) {
                    user.setEmail(emailInput);
                }
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                if(!df.format(user.getBirthdate()).equals(birthdateInput)) {
                    try {
                        user.setBirthdate(new Date(df.parse(birthdateInput).getTime()));
                    } catch (ParseException ex) {
                        System.out.println("Date parsen ist fehlgeschlagen" + ex);
                    }
                }
                if(!user.getStreet().equals(streetInput)) {
                    user.setStreet(streetInput);
                }
                if(!user.getHousenumber().equals(housenrInput)) {
                    user.setHousenumber(housenrInput);
                }
                if(!zipcodeInput.equals("" + user.getZipcode())) {
                    user.setZipcde(Integer.parseInt(zipcodeInput));
                }
                if(!user.getCity().equals(cityInput)) {
                    user.setCity(cityInput);
                }
                return true;
            }
            else {
                
                return false;
            }
        }
    }
}
