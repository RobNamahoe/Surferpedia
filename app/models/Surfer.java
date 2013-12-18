package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import play.db.ebean.Model;

/**
 * The surfer class.
 * @author Rob Namahoe
 */
@Entity
public class Surfer extends Model {

  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  
  // Many of me (surfers) maps to one of the following (country)
  @ManyToOne
  private Country country;
  
  // Many of me (surfers) maps to one of the following (gender)
  @ManyToOne
  private Gender gender;
  
  // One of me (surfers) maps to many of the following (user)
  @OneToMany(mappedBy = "surfer", cascade = CascadeType.ALL)
  private List<PageView> views = new ArrayList<>();
    
  //This marks a property that is mapped to a Clob/Blob/Longvarchar or Longvarbinary.
  @Lob
  private String bio = "";
  
  private String name = "";
  private String home = "";
  private String awards = "";
  private String carouselUrl = "";
  private String bioUrl = "";
  private String slug = "";
  private String status = "";
  private String footStyle = "";
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for Surfers.
   */
  public static Finder<Long, Surfer> find() {
    return new Finder<Long, Surfer>(Long.class, Surfer.class);
  }
  
  /**
   * Default constructor method.
   */
  public Surfer() {
    // Default constructor method.
  }

  /**
   * Constructor method.
   * @param name The name of the surfer.
   * @param home Where this surfer hails from.
   * @param country The country of origin of surfer.
   * @param awards Titles and other surfing awards.
   * @param carouselUrl URL to be presented on the home page carousel.
   * @param bioUrl URL to the picture to be presented in the bio page.
   * @param bio A description of the surfer.
   * @param slug Letters and digits to be used to identify this surfer.
   * @param gender Male, Female, Grom - for placement in the menu bar.
   * @param status New or existing surfer.
   * @param footStyle 
   */
  public Surfer(String name, String home, String country, String awards, String carouselUrl, 
                String bioUrl, String bio, String slug, String gender, String status, String footStyle) {
    this.name = name;
    this.home = home;
    this.country = new Country(country);
    this.awards = awards;
    this.carouselUrl = carouselUrl;
    this.bioUrl = bioUrl;
    this.bio = bio;
    this.slug = slug;
    this.gender = new Gender(gender);
    this.status = status;
    this.footStyle = footStyle;
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
   * @return the home
   */
  public String getHome() {
    return home;
  }

  /**
   * @param home the home to set
   */
  public void setHome(String home) {
    this.home = home;
  }

  /**
   * @return the awards
   */
  public String getAwards() {
    return awards;
  }

  /**
   * @param awards the awards to set
   */
  public void setAwards(String awards) {
    this.awards = awards;
  }

  /**
   * @return the carouselUrl
   */
  public String getCarouselUrl() {
    return carouselUrl;
  }

  /**
   * @param carouselUrl the carouselUrl to set
   */
  public void setCarouselUrl(String carouselUrl) {
    this.carouselUrl = carouselUrl;
  }

  /**
   * @return the bioUrl
   */
  public String getBioUrl() {
    return bioUrl;
  }

  /**
   * @param bioUrl the bioUrl to set
   */
  public void setBioUrl(String bioUrl) {
    this.bioUrl = bioUrl;
  }

  /**
   * @return the bio
   */
  public String getBio() {
    return bio;
  }

  /**
   * @param bio the bio to set
   */
  public void setBio(String bio) {
    this.bio = bio;
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

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return the footStyle
   */
  public String getFootStyle() {
    return footStyle;
  }

  /**
   * @param footStyle the footStyle to set
   */
  public void setFootStyle(String footStyle) {
    this.footStyle = footStyle;
  }

  /**
   * @return the country
   */
  public Country getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(Country country) {
    this.country = country;
  }

  /**
   * @return the gender
   */
  public Gender getGender() {
    return gender;
  }

  /**
   * @param gender the gender to set
   */
  public void setGender(Gender gender) {
    this.gender = gender;
  }
  
  /**
   * @return list of users that viewed page
   */
  public List<UserInfo> getViews() {
    List<UserInfo> users = new ArrayList<>();
    for (PageView pageView : views) {
      users.add(pageView.getUser());
    }
    return users;
  }

}
