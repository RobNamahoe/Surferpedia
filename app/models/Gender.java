package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;

/**
 * The gender class.
 * @author Rob Namahoe
 */
@Entity
public class Gender extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  // One of me (gender) maps to many of the following (surfers)
  @OneToMany(mappedBy = "gender")
  private List<Surfer> surfers = new ArrayList<>();
  
  private String gender;

  /**
   * Default constructor method.
   */
  public Gender() {
    // Default constructor method.
  }
  
  /**
   * Constructor method.
   * @param gender Male, Female, Grom.
   */
  public Gender(String gender) {
    this.gender = gender;
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for gender.
   */
  public static Finder<Long, Gender> find() {
    return new Finder<Long, Gender>(Long.class, Gender.class);
  }
  
  /**
   * Get a list of surfers.
   * @return A list of surfers.
   */
  public List<Surfer> getSurfers() {
    return this.surfers;
  }
  
  /**
   * Add a surfer to the list of surfers.
   * @param surfer The surfer to add.
   */
  public void addSurfer(Surfer surfer) {
    this.surfers.add(surfer);
  }
  
  /**
   * @return the gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender the gender to set
   */
  public void setGender(String gender) {
    this.gender = gender;
  }
}
