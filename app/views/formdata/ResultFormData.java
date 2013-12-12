package views.formdata;

/**
 * Result form data.
 * @author Eva Shek
 */
public class ResultFormData {
  
  /** Go to this page. */
  public int goToThis = 1;
  /** Total pages. */
  public int pages = 1;
  /** Total surfers */
  public int numSurfers = 0;
  /** Surfer's name. */
  public String name = "";
  /** Surfer's gender. */
  public String gender = "";
  /** Surfer's country. */
  public String country = "";
  
  /**
   * Default constructor.
   */
  public ResultFormData() {
    
  }
  
  /**
   * Constructor method - used to retain the original results of the query throughout pages.
   * @param goToThis Go to this page.
   * @param pages Total number of pages of 15 or less surfers.
   * @param numSurfers Total number of surfers found.
   * @param name Full/partial name of surfer
   * @param gender Gender category
   * @param country Country of origin
   */
  public ResultFormData(int goToThis, int pages, int numSurfers, String name, String gender, String country) {
    this.goToThis = goToThis;
    this.pages = pages;
    this.numSurfers = numSurfers;
    this.name = name;
    this.gender = gender;
    this.country = country;
  }
  
}
