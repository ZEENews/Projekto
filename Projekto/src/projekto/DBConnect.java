/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.sql.*;

public class DBConnect {

    public DBConnect() {
    }
   
    /*
    public static void main(String[] args) throws SQLException {
    Connection database;
    Statement statement;
    
    try {
    Class.forName("org.postgresql.Driver").newInstance();
    database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projekto", "tobi", "mr26franzi");
    statement = database.createStatement();

    
    //statement.close();
    //database.close();
    } catch (Exception ex) {
    System.out.println("Keine Datenbankverbindung möglich: "
    + ex.getMessage());
    }   
    }
     */

    public void createUser(String email, String vorname, String nachname, String geburtsdatum, String strasse, String hausnr, String stadt, String plz, String pw) {
        Connection database;
        Statement statement;
        //String nr = this.erzeugeNr();       //da erzeug ich eine zufällige 4stellige nummer
        
        //System.out.println(nr+" "+name+" "+adresse);

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim");
            statement = database.createStatement();

            Statement an = database.createStatement();
            //an.executeUpdate("INSERT INTO \"Kino\" (\"KinoNr\", \"Name\", \"Adresse\") VALUES (" + nr + ", '" + name + "', '" + adresse + "')"); //diese zeile muss dementsprechend verändert werden (Benutzer)
            an.executeUpdate("INSERT INTO \"Benutzer\" (\"Name\", \"Vorname\", \"Email\", \"Passwort\", \"Strasse\", \"Hausnummer\", \"PLZ\", \"Ort\", \"Geburtsdatum\") " + 
                             "VALUES ('" + nachname + "', '" + vorname + "', '" + email + "', '" + pw + "', '" + strasse + "', '" + hausnr + "', '" + plz + "', '" + stadt + "', '" + geburtsdatum + "')");
            statement.close();
            database.close();
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
    }
    
    /*
    public static String erzeugeNr()
	{
	    int nr = (int) (Math.random()*10000);
	    if (nr < 1) return "0000";
	    if (nr < 10) return "000"+nr;
	    if (nr < 100) return "00"+nr;
	    if (nr < 1000) return "0"+nr;
	    return ""+nr;
	}
        */
}
