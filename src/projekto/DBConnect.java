/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

    public DBConnect() {
    }

    /**
     * Funktion um einen Benutzer zu erstellen
     * für die Registrierung
     * 
     * @param email
     * @param vorname
     * @param nachname
     * @param geburtsdatum
     * @param strasse
     * @param hausnr
     * @param stadt
     * @param plz
     * @param pw
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
    
    /**
     * Passwortabfrage für Login
     * 
     * @param user
     * @return
     */
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
    
    public boolean emailCheck(String email){
        Connection database;
        Statement statement;
 
        String result = new String();
        email = email.toLowerCase();
        
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            statement = database.createStatement();
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Email\" FROM \"Benutzer\" WHERE \"Email\" = '" + email + "'");
            while( rs.next()){
                result = rs.getString("Email");
            }
                
            rs.close();
            statement.close();
            database.close();
            
            System.out.println("res " + result);
            System.out.println("em " + email);
            
            
            if(result.equalsIgnoreCase(email)){
                return true;
            }else{
                return false;
            } 
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: " + ex.getMessage());
            return false;
        }

    }
    
    /**
     * Funktion um Liste von Filmen abzufragen
     * 
     * @param movie
     * @return
     */
    public ArrayList getMovies(String movie){
        Connection database;
        Statement statement;
 
        ArrayList<String> list = new ArrayList();
        
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            statement = database.createStatement();
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT * FROM \"Filme\" WHERE \"Titel\" ="+movie);
            while( rs.next()){
                list.add("bla");
            }
                
            rs.close();
            statement.close();
            database.close();
            
            return list;
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return null;
        }
    }
}
