package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Florence;
import views.html.Moniz;
import views.html.Apo;
import views.html.Abubo;
import views.html.Ho;


/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the surferpedia home page. 
   * @return The resulting surferpedia home page. 
   */
  public static Result index() {
    return ok(Index.render(""));
  }
  
  /**
   * Returns John John Florence's Page.
   * @return The John John florence Page.
   */
  public static Result florence() {
    return ok(Florence.render(""));
  }
  
  /**
   * Returns Kelia Moniz's Page.
   * @return The Kelia Moniz Page.
   */
  public static Result moniz() {
    return ok(Moniz.render(""));
  }
  
  /**
   * Returns Kaulana Apo's Page.
   * @return The Kaulana Apo Page.
   */
  public static Result apo() {
    return ok(Apo.render(""));
  }
  
  /**
   * Returns Megan Abubo's Page.
   * @return The Megan Abubo Page.
   */
  public static Result abubo() {
    return ok(Abubo.render(""));
  }
  
  /**
   * Returns Michael Ho's Page.
   * @return The Michael Ho Page.
   */
  public static Result ho() {
    return ok(Ho.render(""));
  }
  
}
