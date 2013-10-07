package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Page1;
import views.html.JohnJohnFlorence;
import views.html.KeliaMoniz;
import views.html.KaulanaApo;
import views.html.Megan;
/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result page1() {
    return ok(Page1.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result johnjohnflorence() {
    return ok(JohnJohnFlorence.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result keliamoniz() {
    return ok(KeliaMoniz.render("Welcome to Page1."));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result kaulanaapo() {
    return ok(KaulanaApo.render("Welcome to Page1."));
    
  }
  
  public static Result megan() {
    return ok(Megan.render("Welcome to Page1."));
    
  }
  
  
  
}
