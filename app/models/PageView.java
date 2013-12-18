package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * A simple representation of a surfer page view.
 * @author Eva Shek
 */
@Entity
public class PageView extends Model {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;
  
  @ManyToOne
  private Surfer surfer;
  
  @ManyToOne
  private UserInfo user;
  
  /**
   * Default constructor.
   */
  public PageView() {
    
  }
  
  /**
   * Constructor for page views.
   * @param surfer Surfer viewed
   * @param user User viewing
   */
  public PageView(Surfer surfer, UserInfo user) {
    this.surfer = surfer;
    this.user = user;
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for updates.
   */
  public static Finder<Long, PageView> find() {
    return new Finder<Long, PageView>(Long.class, PageView.class);
  }

  /**
   * @return the surfer
   */
  public Surfer getSurfer() {
    return surfer;
  }

  /**
   * @param surfer the surfer to set
   */
  public void setSurfer(Surfer surfer) {
    this.surfer = surfer;
  }

  /**
   * @return the user
   */
  public UserInfo getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(UserInfo user) {
    this.user = user;
  }
  
}
