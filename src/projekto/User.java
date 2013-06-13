/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projekto;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Tobias Gneuß
 */
public class User {
    
    private int ID;
    private String lastname = null;
    private String forename = null;
    private String email = null;
    private Date birthdate = null;
    private String street = null;
    private String housenr = null;
    private int zipcode = -1;
    private String city = null;
 
   public User(int ID) {
       this.ID = ID;
   }
   
   public int getID() {
       return ID;
   }
   
   public String getLastname() {
       if(lastname == null) {
           lastname = new DBConnect().getUserLastname(ID);
       }
       return lastname;
   }
   
   public void setLastname(String value) {
       boolean successful = new DBConnect().setUserLastname(ID, value);
       if(successful) {
           this.lastname = value;
       }
   }
   
   public String getForename() {
       if(forename == null) {
           forename = new DBConnect().getUserForename(ID);
       }
       return forename;
   }
   
   public void setForename(String value) {
       boolean successful = new DBConnect().setUserForename(ID, value);
       if(successful) {
           this.forename = value;
       }
   }
   
   public String getEmail() {
       if(email == null) {
           email = new DBConnect().getUserEmail(ID);
       }
       return email;
   }
   
   public void setEmail(String value) {
       boolean successful = new DBConnect().setUserEmail(ID, value);
       if(successful) {
           this.email = value;
       }
   }
   
   public Date getBirthdate() {
       if(birthdate == null) {
           birthdate = new DBConnect().getUserBirthdate(ID);
       }
       return birthdate;
   }
   
   public void setBirthdate(Date value) {
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       String date = format.format(value);
       System.out.println(value);
       boolean successful = new DBConnect().setUserBirthdate(ID, date);
       if(successful) {
           this.birthdate = value;
       }
   }
   
   public String getStreet() {
       if(street == null) {
           street = new DBConnect().getUserStreet(ID);
       }
       return street;
   }
   
   public void setStreet(String value) {
       boolean successful = new DBConnect().setUserStreet(ID, value);
       if(successful) {
           this.street = value;
       }
   }
   
   public String getHousenumber() {
       if(housenr == null) {
           housenr = new DBConnect().getUserHousenumber(ID);
       }
       return housenr;
   }
   
   public void setHousenumber(String value) {
       boolean successful = new DBConnect().setUserHousenumber(ID, value);
       if(successful) {
           this.housenr = value;
       }
   }
   
   public int getZipcode() {
       if(zipcode == -1) {
           zipcode = new DBConnect().getUserZipcode(ID);
       }
       return zipcode;
   }
   
   public void setZipcde(int value) {
       boolean successful = new DBConnect().setUserZipcode(ID, value);
       if(successful) {
           this.zipcode = value;
       }
   }
   
   public String getCity() {
       if(city == null) {
           city = new DBConnect().getUserCity(ID);
       }
       return city;
   }
   
   public void setCity(String value) {
       boolean successful = new DBConnect().setUserCity(ID, value);
       if(successful) {
           this.city = value;
       }
   }
   
   public void setPassword(String password) {
       boolean successful = new DBConnect().setUserPassword(ID, password);
   }
   
   public void delete() {
       new DBConnect().deleteUser(ID);
   }
}
