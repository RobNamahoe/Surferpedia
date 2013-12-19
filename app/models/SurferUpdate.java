package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * A model for updates.
 * @author Rob Namahoe
 */
@Entity
public class SurferUpdate extends Model {
  
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  @ManyToOne
  private UserInfo user;
  
  private String date;
  private String action;
  private String name;
  private String slug;
  
  /**
   * Default constructor.
   */
  public SurferUpdate() {
    // Default constructor method.
  }
  
  /**
   * Constructor for updates.
   * @param user The user info.
   * @param date The date.
   * @param action The action done.
   * @param name The surfers name.
   * @param slug The surfers slug.
   */
  public SurferUpdate(UserInfo user, String date, String action, String name, String slug) {
    this.user = user;
    this.date = date;
    this.action = action;
    this.name = name;
    this.slug = slug;
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for updates.
   */
  public static Finder<Long, SurferUpdate> find() {
    return new Finder<Long, SurferUpdate>(Long.class, SurferUpdate.class);
  }
  
  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }
  
  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }
  
  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }
  
  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = action;
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
   * @return the user object
   */
  public UserInfo getUser() {
    return user;
  }
  
  /**
   * @param user the UserInfo to set
   */
  public void setUser(UserInfo user) {
    this.user = user;
  }

  /**
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }

  /**
   * @param slug the slug to set
   */
  public void setSlug(String slug) {
    this.slug = slug;
  }
}
