package controllers;

import java.util.HashMap;
import java.util.Map;
import models.SurferDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.ShowSurfer;
import views.html.ManageSurfer;

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
   * Returns ManageSurfer view configured to add a new surfer.
   * @return The page to add a new surfer.
   */
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    surferTypesMap = SurferTypes.getTypes();
    return ok(ManageSurfer.render("NewSurfer", formData, surferTypesMap));
  }
  
  /**
   * Displays the ShowSurfer form for the requested surfer.
   * @param slug The unique identifier for the surfer to display.
   * @return ShowSurfer page for the requested surfer with form data.
   */
  public static Result getSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ShowSurfer.render(formData));
  }
  
/**
 * Handles the deleting of a surfer from the database.
 * @param slug The unique identifier for the surfer to delete.
 * @return The application homepage.
 */
  public static Result deleteSurfer(String slug) {
    SurferDB.deleteSurfer(slug);
    return ok(Index.render(""));
  }
  
  /**
   * Handles the editing/managing of surfer data.
   * @param slug The unique identifier for the surfer to display.
   * @return ShowSurfer page for requested surfer with form data.
   */
  public static Result manageSurfer(String slug) {
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    surferTypesMap = SurferTypes.getTypes(data.type);
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render("ManageSurfer", formData, surferTypesMap));
  }
  
  /**
   * Handles the posting of form data by the user with validation.
   * @return ShowSurfer page with form data if successful, ManageSurfer page otherwise.
   */
  public static Result postSurfer() {
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      surferTypesMap = SurferTypes.getTypes();
      return badRequest(ManageSurfer.render("ManageSurfer", formData, surferTypesMap));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.addSurfer(data);
      return ok(ShowSurfer.render(formData));
    }
  }
  
}
