package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;

/**
 * A simple representation of a user. 
 * @author Eva Shek
 */
@Entity
public class UserInfo extends Model {

  private static final long serialVersionUID = 1L;
  private static final int VIEW_HISTORY_MAX = 10;
  
  @Id
  private long id;
  
  //One of me (user) maps to many of the following (updates)
  @OneToMany(mappedBy = "user")
  private List<SurferUpdate> updates = new ArrayList<>();
  
  //One of me (user) map to many of the following (surfers)
  @OneToMany(mappedBy = "user")
  private List<PageView> views = new ArrayList<>();
  
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
   * @param dateJoined The date the user joined.
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
  public List<SurferUpdate> getUpdates() {
    return updates;
  }
  
  /**
   * Gets a list of the recently viewed surfers.
   * @return list of surfers user last viewed
   */
  public List<Surfer> getViews() {
    List<Surfer> surfers = new ArrayList<>();
    for (PageView pageView : views) {
      surfers.add(0, pageView.getSurfer());
    }
    return surfers;
  }
  
  /**
   * Retrieves only the first VIEW_HISTORY_MAX surfers.
   * @return list of surfers last viewed
   */
  public List<Surfer> getNewest() {
    if (views.size() < VIEW_HISTORY_MAX) {
      return getViews();
    }
    List<Surfer> surfers = getViews();
    return surfers.subList(0, VIEW_HISTORY_MAX);
  }

  /**
   * Checks if this is the admin account.
   * @return true if it is the admin account, false otherwise.
   */
  public boolean isAdmin() {
    return admin;
  }

  /**
   * Sets the current accout to an admin account.
   * @param admin the admin to set
   */
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

}
