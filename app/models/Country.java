package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * The Country class.
 * @author Rob Namahoe
 */
@Entity
public class Country extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  // One of me (country) maps to many of the following (surfers)
  @OneToMany(mappedBy="country")
  private List<Surfer> surfers = new ArrayList<>();
  
  private String country;

  /**
   * Default constructor method.
   */
  public Country() {
    // Default constructor method.
  }
  
  /**
   * Constructor method.
   * @param country The country.
   */
  public Country(String country) {
    this.country = country;
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for country.
   */
  public static Finder<Long, Country> find() {
    return new Finder<Long, Country>(Long.class, Country.class);
  }
  
  /**
   * Get a list of surfers.
   * @return A list of contacts.
   */
  public List<Surfer> getContacts() {
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
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(String country) {
    this.country = country;
  }
  
}
