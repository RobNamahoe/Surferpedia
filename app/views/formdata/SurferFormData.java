package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Surfer;
import models.SurferDB;

/**
 * Surfer form data.
 * @author Rob Namahoe
 */
public class SurferFormData {

  /** The surfers name. **/
  public String name = "";
  /** The surfers home. **/
  public String home = "";
  /** The surfers awards. **/
  public String awards = "";
  /** The url to the pic to be used in the carousel. **/
  public String carouselUrl = "";
  /** The url to the pic to be used on the bio page. **/
  public String bioUrl = "";
  /** The surfers bio. **/
  public String bio = "";
  /** The surfers slug. **/
  public String slug = "";
  /** The surfers type. **/
  public String type = "";
  /** Is this a new entry? **/
  public String status = "";
  
  /**
   * Default constructor method.
   */
  public SurferFormData() {
    // Default constructor method.
  }

  /**
   * Constructor method.
   * @param surfer An existing surfer.
   */
  public SurferFormData(Surfer surfer) {
    this.name = surfer.getName();
    this.home = surfer.getHome();
    this.awards = surfer.getAwards();
    this.carouselUrl = surfer.getCarouselUrl();
    this.bioUrl = surfer.getBioUrl();
    this.bio = surfer.getBio();
    this.slug = surfer.getSlug();
    this.type = surfer.getType();
    this.status = surfer.getStatus();
  }

  /**
   * Constructor method - used to initialize database.
   * @param name The name of the surfer.
   * @param home The home of the surfer.
   * @param awards Awards or titles the surfer has won.
   * @param carouselUrl The url to the carousel image.
   * @param bioUrl The url to the bio image.
   * @param bio The surfers bio.
   * @param slug The surfers slug.
   * @param type The surfers type - Male, female, grom.
   */
  public SurferFormData(String name, String home, String awards, String carouselUrl, String bioUrl, String bio,
                        String slug, String type) {
    this.name = name;
    this.home = home;
    this.awards = awards;
    this.carouselUrl = carouselUrl;
    this.bioUrl = bioUrl;
    this.bio = bio;
    this.slug = slug;
    this.type = type;
    this.status = "existing";
  }
  
  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationErrors if problems are found.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required."));
    }
    
    if (home == null || home.length() == 0) {
      errors.add(new ValidationError("home", "Home is required."));
    }
    
    if (carouselUrl == null || carouselUrl.length() == 0) {
      errors.add(new ValidationError("carouselUrl", "Carousel URL is required."));
    }
    
    if (bioUrl == null || bioUrl.length() == 0) {
      errors.add(new ValidationError("bioUrl", "Bio URL is required."));
    }
    
    if (bio == null || bio.length() == 0) {
      errors.add(new ValidationError("bio", "Bio paragraph is required."));
    }
    
    if (slug == null || slug.length() == 0) {
      errors.add(new ValidationError("slug", "Slug is required."));
    }
           
    if (!status.equals("existing") && SurferDB.slugExists(slug)) {
      errors.add(new ValidationError("slug", "Slug is already in use. Choose another."));
    }
    else {
      if (!slug.matches("[A-Za-z0-9]+")) {
        errors.add(new ValidationError("slug", "Invalid entry. Alphanumeric characters only."));
      }
    }
    
    if (!SurferTypes.isType(type)) {
      errors.add(new ValidationError("type", "Surfer type is invalid."));
    }
    
    return errors.isEmpty() ? null : errors;
    
  }

}

