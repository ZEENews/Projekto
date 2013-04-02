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

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            statement = database.createStatement();

            Statement an = database.createStatement();
            an.executeUpdate("INSERT INTO \"Benutzer\" (\"Name\", \"Vorname\", \"Email\", \"Passwort\", \"Strasse\", \"Hausnummer\", \"PLZ\", \"Ort\", \"Geburtsdatum\") " + 
                             "VALUES ('" + nachname + "', '" + vorname + "', '" + email + "', '" + pw + "', '" + strasse + "', '" + hausnr + "', '" + plz + "', '" + stadt + "', '" + geburtsdatum + "')");
            statement.close();
            database.close();
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
    }
    
    public String loginCheck(String user){
        Connection database;
        Statement statement;
 
        String result = new String();
        
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            statement = database.createStatement();
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Passwort\" FROM \"Benutzer\" WHERE \"Email\" = '" + user + "'");
            while( rs.next()){
                result = rs.getString("Passwort");
            }
                
            rs.close();
            statement.close();
            database.close();
            
            return result;
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return null;
        }

    }
}
