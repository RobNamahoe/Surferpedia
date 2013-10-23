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
 
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    surferTypesMap = SurferTypes.getTypes();
    return ok(ManageSurfer.render("NewSurfer", formData, surferTypesMap));
  }
  
  public static Result getSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ShowSurfer.render(formData));
  }
  
  public static Result deleteSurfer(String slug) {
    return ok(Index.render(""));
  }
  
  public static Result manageSurfer(String slug) {
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    surferTypesMap = SurferTypes.getTypes(data.type);
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ManageSurfer.render("ManageSurfer", formData, surferTypesMap));
  }
  
  public static Result postSurfer() {
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors found!");
      surferTypesMap = SurferTypes.getTypes();
      return badRequest(ManageSurfer.render("ManageSurfer", formData, surferTypesMap));
    }
    else {
      SurferFormData data = formData.get();
      SurferDB.addSurfer(data);
      System.out.format("%s, %s, %s%n", data.name, data.slug);
      return ok(ShowSurfer.render(formData));
    }
  }
}
