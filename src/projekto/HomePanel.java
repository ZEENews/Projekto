package projekto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Julia Krause, Tobias Gneuß
 */
public class HomePanel extends JPanel {

    private String[] bildernamen = {"afterearth", "croods", "darkness", "epic", "gatsby", "tw", "thehangover3"};
    private int picNumber = 0;
    private JLabel gallery = new JLabel();

    public HomePanel() {
        super();
        setLayout(new BorderLayout());

        JLabel welcome = new JLabel("Herzlich Willkommen bei Projekto!");
        welcome.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
        Font f = welcome.getFont();
        welcome.setFont(f.deriveFont(f.getSize() + 10.0f));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        add(welcome, BorderLayout.NORTH);
        add(gallery, BorderLayout.CENTER);
        gallery.setHorizontalAlignment(SwingConstants.CENTER);
        bildSetzen();
        
        Timer t;
        t = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bildSetzen();
            }
        });
        t.start();




//        JScrollPane scrollPane = new JScrollPane();
//        add(scrollPane, BorderLayout.CENTER);
//        
//        JPanel space = new JPanel();
//        space.setLayout(new BorderLayout());
//        space.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
//        scrollPane.setViewportView(space);
//        
//        JTextPane text = new JTextPane();
//        text.setText("Hallo Tobi\nWie geht es dir?");
//        text.setEditable(false);
//        space.add(text, BorderLayout.CENTER);
//        
//        StyledDocument doc = text.getStyledDocument();
//        SimpleAttributeSet center = new SimpleAttributeSet();
//        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
//        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    private void bildSetzen() {
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().
                getResource("/pics/" + bildernamen[picNumber] + ".jpg"));
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        gallery.setIcon(imageIcon);
        picNumber++;
        if (picNumber == bildernamen.length) {
            picNumber = 0;
        }
    }
}
