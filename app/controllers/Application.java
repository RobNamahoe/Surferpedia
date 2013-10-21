package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;


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
 
  public static Result newSurfer() {
    return ok(Index.render(""));
  }
  
  public static Result getSurfer(String slug) {
    return ok(Index.render(""));
  }
  
  public static Result deleteSurfer(String slug) {
    return ok(Index.render(""));
  }
  
  public static Result manageSurfer(String slug) {
    return ok(Index.render(""));
  }
  
  public static Result postSurfer() {
    return ok(Index.render(""));
  }
}
