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
 * @author julia
 */
public class HomePanel extends JPanel {
    
    public HomePanel() {
        super();
        setLayout(new BorderLayout());
        
        JLabel welcome = new JLabel("Herzlich Willkommen bei Projekto!");
        welcome.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
        Font f = welcome.getFont();
        welcome.setFont(f.deriveFont(f.getSize() + 10.0f));
        welcome.setHorizontalAlignment(JLabel.CENTER);
        add(welcome, BorderLayout.NORTH);
        
        JLabel gallery = new JLabel();
        gallery.setHorizontalAlignment(SwingConstants.CENTER);
        add(gallery, BorderLayout.CENTER);
        
//        int n = 0;
//        Timer t;
//        
//        t = new Timer(2000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               
//            }
//        });
//        t.start();
        
        
        
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/pics/hangover3.jpg"));
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        gallery.setIcon(imageIcon);
        
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
}
