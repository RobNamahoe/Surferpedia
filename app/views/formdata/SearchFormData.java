package views.formdata;

/**
 * Search form data.
 * @author Eva Shek
 */
public class SearchFormData {
  
  /** Surfer's name. */
  public String name = "";
  /** Surfer's gender. */
  public String gender = "";
  /** Surfer's country. */
  public String country = "";
  
  /**
   * Default constructor.
   */
  public SearchFormData() {
    
  }
  
  /**
   * Constructor method - used to get user query.
   * @param name Full/partial name of surfer
   * @param gender Gender category
   * @param country Country of origin
   */
  public SearchFormData(String name, String gender, String country) {
    this.name = name;
    this.gender = gender;
    this.country = country;
  }
  
}
