/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Projekto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String use = "";
        LookAndFeelInfo[] available = UIManager.getInstalledLookAndFeels();
        for(LookAndFeelInfo info : available) {
            if(info.toString().contains("Nimbus")) {
                use = info.toString();
            }
        }
        try {
            UIManager.setLookAndFeel(use);
        }
        catch (ClassNotFoundException ex) {}
        catch (InstantiationException ex) {}
        catch (IllegalAccessException ex) {} 
        catch (UnsupportedLookAndFeelException ex) {}
        //new LoginScreen();
        new MainGUI(new User(1));
    }
}
