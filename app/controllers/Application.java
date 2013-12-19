package controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.GameQuestion;
import models.GameQuestionDB;
import models.CountryDB;
import models.Surfer;
import models.SurferDB;
import models.SurferSearch;
import models.SurferUpdate;
import models.SurferUpdateDB;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.FootStyle;
import views.formdata.LoginFormData;
import views.formdata.RegistrationFormData;
import views.formdata.SearchFormData;
import views.formdata.SurferFormData;
import views.formdata.SurferTypes;
import views.html.Index;
import views.html.Login;
import views.html.NameTheSurfer;
import views.html.Profile;
import views.html.ShowSurfer;
import views.html.ManageSurfer;
import views.html.ShowUpdates;
import views.html.SearchResults;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  private static final int CAROUSEL_MAX = 3;
  
  /**
   * Returns the surferpedia home page. 
   * @return The resulting surferpedia home page. 
   */
  public static Result index() {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    return ok(Index.render("Index", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
                           searchForm, surferTypesMap, countryMap, SurferDB.getSurfersRandom(CAROUSEL_MAX)));
  } 
  
  /**
   * Return the Name-That-Surfer Game page.
   * @return The resulting game page.
   */
  public static Result nameTheSurfer() {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    GameQuestionDB.resetStats();
    return ok(NameTheSurfer.render("NameTheSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
                                   searchForm, surferTypesMap, countryMap, GameQuestionDB.getNextQuestion()));    
  } 
  
  /**
   * Checks the users answer to the game question. Updates wins and losses accordingly. 
   * Also generates new question when appropriate.
   * @param answer The users answer to the game question.
   * @return The resulting game page.
   */
  public static Result checkGameAnswer(String answer) {

    GameQuestion question = GameQuestionDB.getCurrentQuestion();
    
    if (answer.equals(question.getAnswer())) {
      GameQuestionDB.addWin();
    }
    else {
      GameQuestionDB.addLoss();
    }
    
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    return ok(NameTheSurfer.render("NameTheSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
              searchForm, surferTypesMap, countryMap, GameQuestionDB.getNextQuestion()));  
  }

  /**
   * Returns ManageSurfer view configured to add a new surfer.
   * @return The page to add a new surfer.
   */
  @Security.Authenticated(Secured.class)
  public static Result newSurfer() {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMapSearch = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    SurferFormData surferFormData = new SurferFormData();
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).fill(surferFormData);
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    surferTypesMap = SurferTypes.getTypes();
    return ok(ManageSurfer.render("NewSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
                                  searchForm, surferTypesMapSearch, countryMap, surferForm, surferTypesMap,
                                  FootStyle.getTypes()));
  }
  
  /**
   * Displays the ShowSurfer form for the requested surfer.
   * @param slug The unique identifier for the surfer to display.
   * @return ShowSurfer page for the requested surfer with form data.
   */
  public static Result getSurfer(String slug) {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    SurferFormData surferFormData = new SurferFormData(SurferDB.getSurfer(slug));
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).fill(surferFormData);
    
    if (Secured.isLoggedIn(ctx())) {
      UserInfoDB.viewSurfer(Secured.getUserInfo(ctx()), slug);
    }
    return ok(ShowSurfer.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), searchForm,
                                surferTypesMap, countryMap, surferForm));
  }
  
/**
 * Handles the deleting of a surfer from the database.
 * @param slug The unique identifier for the surfer to delete.
 * @return The application homepage.
 */
  @Security.Authenticated(Secured.class)
  public static Result deleteSurfer(String slug) {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    Date date = new Date();
    String name = SurferDB.getSurfer(slug).getName();
    SurferUpdateDB.addUpdate(new SurferUpdate(Secured.getUserInfo(ctx()), date.toString(), "Delete", name, slug));

    SurferDB.deleteSurfer(slug);
    return ok(Index.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
                           searchForm, surferTypesMap, countryMap, SurferDB.getSurfersRandom(CAROUSEL_MAX)));
  }
  
  /**
   * Handles the editing/managing of surfer data.
   * @param slug The unique identifier for the surfer to display.
   * @return ShowSurfer page for requested surfer with form data.
   */
  @Security.Authenticated(Secured.class)
  public static Result manageSurfer(String slug) {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMapSearch = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    SurferFormData surferFormData = new SurferFormData(SurferDB.getSurfer(slug));
    surferTypesMap = SurferTypes.getTypes(surferFormData.gender);
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).fill(surferFormData);
    return ok(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), 
                                   searchForm, surferTypesMapSearch, countryMap, surferForm, surferTypesMap,
                                   FootStyle.getTypes()));
  }
  
  
  /**
   * Displays the updates page.
   * @return the update page.
   */
  @Security.Authenticated(Secured.class)
  public static Result showUpdates() {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    return ok(ShowUpdates.render("Updates", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), searchForm,
                                 surferTypesMap, countryMap, SurferUpdateDB.getUpdates()));
  }
  
  /**
   * Handles the posting of form data by the user with validation.
   * @return ShowSurfer page with form data if successful, ManageSurfer page otherwise.
   */
  @Security.Authenticated(Secured.class)
  public static Result postSurfer() {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMapSearch = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    Map<String, Boolean> surferTypesMap = new HashMap<>();
    Form<SurferFormData> surferForm = Form.form(SurferFormData.class).bindFromRequest();
    if (surferForm.hasErrors()) {
      surferTypesMap = SurferTypes.getTypes();
      return badRequest(ManageSurfer.render("ManageSurfer", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
                                            searchForm, surferTypesMapSearch, countryMap, surferForm, surferTypesMap,
                                            FootStyle.getTypes()));
    }
    else {
      SurferFormData surferFormData = surferForm.get();

      Date date = new Date();
      String action = SurferDB.isSurfer(surferFormData.slug) ? "Edit" : "Create";
      SurferUpdateDB.addUpdate(new SurferUpdate(Secured.getUserInfo(ctx()), date.toString(), action, surferFormData.name,
                                      surferFormData.slug));
      SurferDB.addSurfer(surferFormData);
      
      if (Secured.isLoggedIn(ctx())) {
        UserInfoDB.viewSurfer(Secured.getUserInfo(ctx()), surferFormData.slug);
      }
      
      return ok(ShowSurfer.render("", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), searchForm,
                surferTypesMapSearch, countryMap, surferForm));
    }
  }
  
  /**
   * Displays the logged in user's profile page where they can see the date they joined, the list of surfer pages
   * they helped create and edit, and their view history.
   * @return the Profile page.
   */
  @Security.Authenticated(Secured.class)
  public static Result showProfile() {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    UserInfo currentUser = Secured.getUserInfo(ctx());
    
    return ok(Profile.render("My Profile", Secured.isLoggedIn(ctx()), currentUser, searchForm, surferTypesMap,
        countryMap, SurferUpdateDB.getNumOfUpdatesByUser(currentUser), 
        SurferUpdateDB.getUpdatesByUserAndAction(currentUser, "Create"),
        SurferUpdateDB.getUpdatesByUserAndAction(currentUser, "Edit"), currentUser.getNewest()));
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    Form<LoginFormData> loginForm = Form.form(LoginFormData.class);
    Form<RegistrationFormData> regForm = Form.form(RegistrationFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), searchForm,
              surferTypesMap, countryMap, loginForm, regForm));
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
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> loginForm = Form.form(LoginFormData.class).bindFromRequest();
    Form<RegistrationFormData> regForm = Form.form(RegistrationFormData.class);

    if (loginForm.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), searchForm,
                        surferTypesMap, countryMap, loginForm, regForm));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", loginForm.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Processes a registration form submission from a new user. 
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with no defined contacts. 
   */
  public static Result postReg() {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    
    // Get the submitted form data from the request object, and run validation.
    Form<RegistrationFormData> regForm = Form.form(RegistrationFormData.class).bindFromRequest();
    Form<LoginFormData> loginForm = Form.form(LoginFormData.class);

    if (regForm.hasErrors()) {
      flash("regerror", "* Please correct errors.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          searchForm, surferTypesMap, countryMap, loginForm, regForm));
    }
    else {
      // registration info OK, so now we set the session variable and create the user in the database.
      Date date = new Date();
      session().clear();
      session("email", regForm.get().regEmail);
      UserInfoDB.addUserInfo(regForm.get().regName, regForm.get().regEmail, regForm.get().regPassword, date.toString());
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
  
  /**
   * Query the database for a surfer matching the search criteria.
   * @return Redirect to displaySearchPage with 1 parameter to display first page of results.
   */
  public static Result postSearch() {
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).bindFromRequest();
    SearchFormData searchFormData = searchForm.get();
    SurferSearch.queryDatabase(searchFormData);
    return redirect(routes.Application.displaySearchPage(1));
  }
  
  /**
   * Display the specified results page.
   * @param pageNum The page to display.
   * @return The result page.
   */
  public static Result displaySearchPage(int pageNum) {
    SearchFormData searchFormData = new SearchFormData();
    Form<SearchFormData> searchForm = Form.form(SearchFormData.class).fill(searchFormData);
    Map<String, Boolean> surferTypesMap = SurferTypes.getTypes();
    Map<String, Boolean> countryMap = CountryDB.getCountryMap();
    List<Surfer> matched = SurferSearch.getSurfersInPage(pageNum - 1);
    return ok(SearchResults.render("Search results", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        SurferSearch.getSurferCount(), SurferSearch.getPageCount(), pageNum, searchForm, surferTypesMap, 
        countryMap, matched));
  }
  
}
