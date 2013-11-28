package controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import models.SurferDB;
import models.Updates;
import models.UpdatesDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.FootStyle;
import views.formdata.LoginFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.Login;
import views.html.ShowSurfer;
import views.html.ManageSurfer;
import views.html.ShowUpdates;
import play.mvc.Security;
import views.formdata.LoginFormData;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the surferpedia home page. 
   * @return The resulting surferpedia home page. 
   */
  public static Result index() {
    return ok(Index.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
 
  /**
   * Returns ManageSurfer view configured to add a new surfer.
   * @return The page to add a new surfer.
   */
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    SurferFormData data = new SurferFormData();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    surferTypesMap = SurferTypes.getTypes();
    return ok(ManageSurfer.render("NewSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
                                   formData, surferTypesMap, FootStyle.getTypes()));
  }
  
  /**
   * Displays the ShowSurfer form for the requested surfer.
   * @param slug The unique identifier for the surfer to display.
   * @return ShowSurfer page for the requested surfer with form data.
   */
  public static Result getSurfer(String slug) {
    SurferFormData data = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> formData = Form.form(SurferFormData.class).fill(data);
    return ok(ShowSurfer.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }
  
/**
 * Handles the deleting of a surfer from the database.
 * @param slug The unique identifier for the surfer to delete.
 * @return The application homepage.
 */
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug) {
 
    Date date = new Date();
    String name = SurferDB.getSurfer(slug).getName();
    UpdatesDB.addUpdate(new Updates(date.toString(), "Delete", name));

    SurferDB.deleteSurfer(slug);
    return ok(Index.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
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
    return ok(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
                                   formData, surferTypesMap, FootStyle.getTypes()));
  }
  
  
  /**
   * Displays the updates page.
   * @return the update page.
   */
  public static Result showUpdates() {
    return ok(ShowUpdates.render("Updates", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
                                  UpdatesDB.getUpdates()));
  }
  
  /**
   * Handles the posting of form data by the user with validation.
   * @return ShowSurfer page with form data if successful, ManageSurfer page otherwise.
   */
  @Security.Authenticated(Secured.class)
  public static Result postSurfer() {
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    Form<SurferFormData> formData = Form.form(SurferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      surferTypesMap = SurferTypes.getTypes();
      return badRequest(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
                                             formData, surferTypesMap, FootStyle.getTypes()));
    }
    else {
      SurferFormData data = formData.get();

      Date date = new Date();
      String action = SurferDB.slugExists(data.slug) ? "Edit" : "Create";
      UpdatesDB.addUpdate(new Updates(date.toString(), action, data.name));
      
      SurferDB.addSurfer(data);
      return ok(ShowSurfer.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
}
