package models;

/**
 * A model for updates.
 * @author Rob Namahoe
 *
 */
public class Updates {
  
  private String date;
  private String action;
  private String name;
  
  /**
   * Default constructor.
   */
  public Updates() {
    
  }
  
  /**
   * Constructor for updates.
   * @param date The date.
   * @param action The action done.
   * @param name The surfers name.
   */
  public Updates(String date, String action, String name) {
    this.date = date;
    this.action = action;
    this.name = name;
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
}
