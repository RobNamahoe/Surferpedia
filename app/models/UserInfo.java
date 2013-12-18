package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
@Entity
public class UserInfo extends Model {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;
  
  //One of me (user) maps to many of the following (updates)
  @OneToMany(mappedBy = "user")
  private List<Updates> updates = new ArrayList<>();
  
  //One of me (user) map to many of the following (surfers)
  @OneToMany(mappedBy = "user")
  private List<Surfer> views = new ArrayList<>();
  
  private String name;
  private String email;
  private String password;
  private String dateJoined;
  private boolean admin = false;
  
  /**
   * Creates a new UserInfo instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */
  public UserInfo(String name, String email, String password, String dateJoined) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.dateJoined = dateJoined;
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for updates.
   */
  public static Finder<Long, UserInfo> find() {
    return new Finder<Long, UserInfo>(Long.class, UserInfo.class);
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the dateJoined
   */
  public String getDateJoined() {
    return dateJoined;
  }

  /**
   * @param dateJoined the dateJoined to set
   */
  public void setDateJoined(String dateJoined) {
    this.dateJoined = dateJoined;
  }
  
  /**
   * @return updates made by user
   */
  public List<Updates> getUpdates() {
    return updates;
  }
  
  /**
   * @return list of surfers user last viewed
   */
  public List<Surfer> getViews() {
    return views;
  }
  
  /**
   * Retrieves only the first 10 surfers.
   * @return list of surfers last viewed
   */
  public List<Surfer> getNewest() {
    System.out.println("-----NEWEST-----");
    for (Surfer s : views) {
      System.out.println(s.getName());
    }
    if (views.size() < 10) {
      return views;
    }
    return views.subList(0, 10);
  }

  /**
   * @return the admin
   */
  public boolean isAdmin() {
    return admin;
  }

  /**
   * @param admin the admin to set
   */
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }
  
  public void addView(Surfer surfer) {
    views.add(0, surfer);
  }
  
  public void removeView(Surfer surfer) {
    views.remove(surfer);
  }

}
