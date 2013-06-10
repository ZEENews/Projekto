/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("INSERT INTO \"Benutzer\" (\"Name\", \"Vorname\", \"Email\", \"Passwort\", \"Strasse\", \"Hausnummer\", \"PLZ\", \"Ort\", \"Geburtsdatum\") " + 
                             "VALUES ('" + nachname + "', '" + vorname + "', '" + email + "', '" + pw + "', '" + strasse + "', '" + hausnr + "', '" + plz + "', '" + stadt + "', '" + geburtsdatum + "')");
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
 
        String result = new String();
        
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Passwort\" FROM \"Benutzer\" WHERE \"Email\" = '" + user + "'");
            while( rs.next()){
                result = rs.getString("Passwort");
            }
                
            rs.close();
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
 
        String result = new String();
        email = email.toLowerCase();
        
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Email\" FROM \"Benutzer\" WHERE \"Email\" = '" + email + "'");
            while( rs.next()){
                result = rs.getString("Email");
            }
                
            rs.close();
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
 
        ArrayList<String> list = new ArrayList();
        
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT * FROM \"Filme\" WHERE \"Titel\" ="+movie);
            while( rs.next()){
                list.add("bla");
            }
                
            rs.close();
            database.close();
            
            return list;
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<String> getCinemas() {
        Connection database;
        
        ArrayList<String> list = new ArrayList();
        
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Name\", \"Stadt\" FROM \"Kino\"");
            while( rs.next()){
                list.add(rs.getString("Name") + " (" + rs.getString("Stadt") + ")");
            }
                
            rs.close();
            database.close();
            
            return list;
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return null;
        }
    }
    
    public int getUserID(String email) {
        Connection database;
 
        int result = -1;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Mitgliedsnummer\" FROM \"Benutzer\" WHERE \"Email\" = '" + email + "' LIMIT 1");
            while( rs.next()){
                result = rs.getInt("Mitgliedsnummer");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public String getUserLastname(int ID) {
        Connection database;
 
        String result = null;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Name\" FROM \"Benutzer\" WHERE \"Mitgliedsnummer\" = '" + ID + "' LIMIT 1");
            while( rs.next()){
                result = rs.getString("Name");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public String getUserForename(int ID) {
        Connection database;
 
        String result = null;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Vorname\" FROM \"Benutzer\" WHERE \"Mitgliedsnummer\" = '" + ID + "' LIMIT 1");
            while( rs.next()){
                result = rs.getString("Vorname");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public String getUserEmail(int ID) {
        Connection database;
 
        String result = null;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Email\" FROM \"Benutzer\" WHERE \"Mitgliedsnummer\" = '" + ID + "' LIMIT 1");
            while( rs.next()){
                result = rs.getString("Email");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public Date getUserBirthdate(int ID) {
        Connection database;
 
        Date result = null;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Geburtsdatum\" FROM \"Benutzer\" WHERE \"Mitgliedsnummer\" = '" + ID + "' LIMIT 1");
            while( rs.next()){
                result = rs.getDate("Geburtsdatum");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public String getUserStreet(int ID) {
        Connection database;
 
        String result = null;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Strasse\" FROM \"Benutzer\" WHERE \"Mitgliedsnummer\" = '" + ID + "' LIMIT 1");
            while( rs.next()){
                result = rs.getString("Strasse");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public String getUserHousenumber(int ID) {
        Connection database;
 
        String result = null;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Hausnummer\" FROM \"Benutzer\" WHERE \"Mitgliedsnummer\" = '" + ID + "' LIMIT 1");
            while( rs.next()){
                result = rs.getString("Hausnummer");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public int getUserZipcode(int ID) {
        Connection database;
 
        int result = -1;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"PLZ\" FROM \"Benutzer\" WHERE \"Mitgliedsnummer\" = '" + ID + "' LIMIT 1");
            while( rs.next()){
                result = rs.getInt("PLZ");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public String getUserCity(int ID) {
        Connection database;
 
        String result = null;
        
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery("SELECT \"Ort\" FROM \"Benutzer\" WHERE \"Mitgliedsnummer\" = '" + ID + "' LIMIT 1");
            while( rs.next()){
                result = rs.getString("Ort");
            }
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
        }
        return result;
    }
    
    public boolean setUserLastname(int ID, String value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"Name\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean setUserForename(int ID, String value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"Vorname\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean setUserEmail(int ID, String value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"Email\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean setUserBirthdate(int ID, String value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"Geburtsdatum\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean setUserPassword(int ID, String value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"Passwort\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean setUserStreet(int ID, String value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"Strasse\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean setUserHousenumber(int ID, String value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"Hausnummer\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean setUserZipcode(int ID, int value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"PLZ\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean setUserCity(int ID, String value) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("UPDATE \"Benutzer\" SET \"Ort\"='" + value + "' WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public boolean deleteUser(int ID) {
        Connection database;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 

            Statement an = database.createStatement();
            an.executeUpdate("DELETE FROM \"Benutzer\" WHERE \"Mitgliedsnummer\"='" + ID + "'");
            database.close();
            return true;

        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<String[]> getPerformances(String cinema, String city, Date date) {
        Connection database;
        
        ArrayList<String[]> list = new ArrayList();
        String statement = 
                "SELECT \"Filmname\" AS \"Film\", \"Spiellaenge\" AS \"Dauer\", \"Altersbeschraenkung\" AS \"FSK\", \"SaalNr\", \"Uhrzeit\", \"3D\", \"Vorstellungid\""
              + "FROM \"Vorstellung\""
              + "LEFT JOIN \"Saal\" ON \"Vorstellung\".\"Saalid\"=\"Saal\".\"Saalid\""
              + "LEFT JOIN \"Kino\" ON \"Saal\".\"Kinoid\"=\"Kino\".\"Kinoid\""
              + "LEFT JOIN \"Film\" ON \"Vorstellung\".\"Filmid\"=\"Film\".\"Filmid\""
              + "LEFT JOIN \"Termin\" ON \"Vorstellung\".\"Terminid\"=\"Termin\".\"Terminid\""
              + "WHERE \"Kino\".\"Name\"='" + cinema + "' AND"
              + "\"Kino\".\"Stadt\"='" + city + "' AND"
              + "\"Termin\".\"Datum\"='" + date + "'"
              + "ORDER BY \"Film\", \"Uhrzeit\"";
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            database = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbprojekt", "projekt", "geheim"); 
            Statement an = database.createStatement();
            
            ResultSet rs = an.executeQuery(statement);
            while(rs.next()) {
                
                String[] performance = new String[7];
                performance[0] = rs.getString("Film");
                performance[1] = "" + rs.getInt("Dauer");
                performance[2] = "" + rs.getInt("FSK");
                performance[3] = rs.getString("3D");
                performance[4] = "" + rs.getInt("SaalNr");
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                String time = df.format(rs.getTime("Uhrzeit"));
                performance[5] = time;
                performance[6] = "" + rs.getInt("Vorstellungid");
                
                list.add(performance);
            }
                
            rs.close();
            database.close();  
            
        } catch (Exception ex) {
            System.out.println("Keine Datenbankverbindung möglich: "
                    + ex);
        }
        return list;
    }
}
