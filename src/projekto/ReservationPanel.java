package projekto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author julia
 */
public class ReservationPanel extends JPanel implements ActionListener, ItemListener {
    
    private JButton search;
    private JScrollPane resultPanelScroll;
    private JComboBox<String> cinema, date, genre;
    private JSpinner hour, minute;
    private JTextField title;
    private JPanel timePanel;
    private JCheckBox selectTime;
    
    public ReservationPanel() {
        super();
        setLayout(new BorderLayout());
        
        JLabel heading = new JLabel("Reservierungen");
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Font f = heading.getFont();
        heading.setFont(f.deriveFont(f.getSize() + 5.0f));
        heading.setHorizontalAlignment(JLabel.CENTER);
        add(heading, BorderLayout.NORTH);
        
        add(searchPanel(), BorderLayout.WEST);

        resultPanelScroll = new JScrollPane();
        resultPanelScroll.setVisible(false);
        add(resultPanelScroll, BorderLayout.CENTER);
    }
    
    private JPanel searchPanel() {
        JPanel alignSearchNorth = new JPanel();
        alignSearchNorth.setLayout(new BorderLayout());
        
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 10));
        searchPanel.setLayout(new GridBagLayout());
        alignSearchNorth.add(searchPanel, BorderLayout.NORTH);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 10, 5);
        c.gridx = 0;
        c.gridy = 0;
        
        JLabel searchText = new JLabel("Suche");
        searchText.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
        Font f = searchText.getFont();
        searchText.setFont(f.deriveFont(f.getSize() + 5.0f));
        searchText.setHorizontalAlignment(JLabel.CENTER);
        c.gridwidth = 2;
        searchPanel.add(searchText, c);
        
        c.gridy++;
        searchPanel.add(new JSeparator(), c);
        
        JLabel cinemaText = new JLabel("Kino:");
        c.gridy++;
        c.gridwidth = 1;
        searchPanel.add(cinemaText, c);
        
        DBConnect db = new DBConnect();
        ArrayList<String> cinemaList = db.getCinemas();
        String[] cinemaArray = cinemaList.toArray(new String[cinemaList.size()]);
        
        cinema = new JComboBox<String>(cinemaArray);
        c.gridx = 1;
        searchPanel.add(cinema, c);
        
        JLabel dateText = new JLabel("Tag:");
        c.gridx = 0;
        c.gridy++;
        searchPanel.add(dateText, c);
        
        String[] days = getDateSelection(14);
        date = new JComboBox<String>(days);
        c.gridx = 1;
        searchPanel.add(date, c);
        
        JLabel timeLabel = new JLabel("Uhrzeit:");
        c.gridx = 0;
        c.gridy++;
        searchPanel.add(timeLabel, c);
        
        selectTime = new JCheckBox("auswählen");
        selectTime.addItemListener(this);
        c.gridx = 1;
        searchPanel.add(selectTime, c);
        
        timePanel = new JPanel();
        timePanel.setVisible(false);
        timePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        c.gridy++;
        searchPanel.add(timePanel, c);
        
        SpinnerNumberModel hourModel = new SpinnerNumberModel(17, 12, 22, 1);
        hour = new JSpinner(hourModel);
        timePanel.add(hour);
        
        JLabel colon = new JLabel(":");
        timePanel.add(colon);
        
        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
        minute = new JSpinner(minuteModel);
        timePanel.add(minute);
        
        JLabel genreText = new JLabel("<html>Genre:<br><font color=\"888888\" size=\"2\">(optional)</font></html>");
        c.gridy++;
        c.gridx = 0;
        searchPanel.add(genreText, c);
        
        String[] genres = {"", "Action", "Animation", "Fantasy", "Horror", "Komödie", "Science Fiction", "Thriller"};
        genre = new JComboBox<String>(genres);
        c.gridx = 1;
        searchPanel.add(genre, c);
        
        JLabel nameText = new JLabel("<html>Film:<br><font color=\"888888\" size=\"2\">(optional)</font></html>");
        c.gridx = 0;
        c.gridy++;
        searchPanel.add(nameText, c);
        
        title = new JTextField();
        c.gridx = 1;
        searchPanel.add(title, c);
        
        search = new JButton("Suche");
        search.addActionListener(this);
        c.gridy++;
        c.gridx = 1;
        c.insets = new Insets(40, 0, 10, 5);
        searchPanel.add(search, c);
        
        return alignSearchNorth;
    }
    
    private JPanel resultPanel() {
        return new JPanel();
    }
    
    private void search() {
        
        String selectedTitle = null;
        String selectedTime = null;
        String selectedGenre = null;
        
        String selectedCinema = (String) cinema.getSelectedItem();
        String selectedCinema2 = selectedCinema.replace(')', '\0');
        StringTokenizer cinTokenizer = new StringTokenizer(selectedCinema2, "(");
        String selectedCinemaName = cinTokenizer.nextToken();
        String selectedCinemaCity = cinTokenizer.nextToken();
        
        String selectedDate = (String) date.getSelectedItem();
        String selectedDate2 = selectedDate.replace(')', '\0');
        String selectedDate3 = selectedDate2.substring(selectedDate.indexOf("(") + 1);
        
        if (selectTime.isSelected()) {
            String hou = hour.getValue().toString();
            String min = minute.getValue().toString();
            selectedTime = hou + ":" + min;
        }
        if(genre.getSelectedIndex() != 0) {
            selectedGenre = (String) genre.getSelectedItem();
        }
        String t = title.getText();
        if(!t.matches("^\\s*$")) {
            selectedTitle = t;
        }
        
        System.out.println(selectedCinemaName);
        System.out.println(selectedCinemaCity);
        System.out.println(selectedDate3);
        if(selectedTime != null) {
            System.out.println(selectedTime);
        }
        if(selectedGenre != null) {
            System.out.println(selectedGenre);
        }
        if(selectedTitle != null) {
            System.out.println(selectedTitle);
        }
        
        resultPanelScroll.setViewportView(resultPanel());
        resultPanelScroll.setVisible(true);
        revalidate();
    }
    
    private String[] getDateSelection(int quantity) {
        String[] dates = new String[quantity];
        GregorianCalendar cal = new GregorianCalendar();
        for (int i = 0; i < quantity; i++) {
            String dayOfWeek = getdayOfWeekString(cal.get(GregorianCalendar.DAY_OF_WEEK));
            String day = String.format("%02d", cal.get(GregorianCalendar.DAY_OF_MONTH));
            String month = String.format("%02d", cal.get(GregorianCalendar.MONTH) + 1);
            String year = String.format("%04d", cal.get(GregorianCalendar.YEAR));
            dates[i] = dayOfWeek + " (" + day + "." + month + "." + year + ")";
            cal.add(GregorianCalendar.DAY_OF_WEEK, 1);
        }
        
        return dates;
    }
    
    private String getdayOfWeekString(int dayOfWeek) {
        switch(dayOfWeek) {
            case 1: return "Sonntag";
            case 2: return "Montag";
            case 3: return "Dienstag";
            case 4: return "Mittwoch";
            case 5: return "Donnerstag";
            case 6: return "Freitag";
            default: return "Samstag";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(search)) {
            search();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource().equals(selectTime)) {
            if(selectTime.isSelected()) {
                timePanel.setVisible(true);
            }
            else {
                timePanel.setVisible(false);
            }
        }
    }
}
