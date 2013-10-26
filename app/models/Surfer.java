package models;

/**
 * The surfer class.
 * @author Rob Namahoe
 */
public class Surfer {

  private String name = "";
  private String home = "";
  private String awards = "";
  private String carouselUrl = "";
  private String bioUrl = "";
  private String bio = "";
  private String slug = "";
  private String type = "";
  private String status = "";
  
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
   * @param awards Titles and other surfing awards.
   * @param carouselUrl URL to be presented on the home page carousel.
   * @param bioUrl URL to the picture to be presented in the bio page.
   * @param bio A description of the surfer.
   * @param slug Letters and digits to be used to identify this surfer.
   * @param type Male, Female, Grom - for placement in the menu bar.
   * @param status New or existing surfer.
   */
  public Surfer(String name, String home, String awards, String carouselUrl, 
                String bioUrl, String bio, String slug, String type, String status) {
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselUrl = carouselUrl;
    this.bioUrl = bioUrl;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
    this.status = status;
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
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
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

}
