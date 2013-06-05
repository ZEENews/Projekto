package projekto;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
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
        
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel space = new JPanel();
        space.setLayout(new BorderLayout());
        space.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
        scrollPane.setViewportView(space);
        
        JTextPane text = new JTextPane();
        text.setText("Hallo Tobi\nWie geht es dir?");
        text.setEditable(false);
        space.add(text, BorderLayout.CENTER);
        
        StyledDocument doc = text.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
}
