/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author krauseju
 */
public class InfoTextField extends JTextField implements  FocusListener {
    
    private boolean isEmpty;
    private String infoText;
    
    public InfoTextField(String infoText, int size) {
        super(size);
        addFocusListener(this);
        isEmpty = true;
        setText(infoText);
        setForeground(Color.GRAY);
        this.infoText = infoText;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(isEmpty) {
            setText("");
            setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(getText().equals("")) {
            isEmpty = true;
            setText(infoText);
            setForeground(Color.GRAY);
        }
        else {
            isEmpty = false;
        }
    }
}
