/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Tobias Gneuß
 */

public class Date {

    public boolean isDateCorrect(String date) {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setLenient(false);
        try {
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
