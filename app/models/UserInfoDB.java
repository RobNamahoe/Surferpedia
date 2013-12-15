package models;

/**
 * Provides an in-memory repository for UserInfo.
 * Storing credentials in the clear is kind of bogus.
 * @author Philip Johnson
 */
public class UserInfoDB {
  
  /**
   * Define the admin credentials.
   * @param name The name of the admin.
   * @param email The admin email.
   * @param password The admin password.
   * @param dateJoined The date of joining.
   */
  public static void addAdmin(String name, String email, String password, String dateJoined) {
    if ((email != null) && (password != null) && (!adminDefined())) {
      UserInfo userInfo = new UserInfo(name, email, password, dateJoined);
      userInfo.setAdmin(true);
      userInfo.save();
    }
  }
  
  /**
   * Checks if the admin credentials are defined.
   * @return true if admin credentials are defined, false otherwise.
   */
  public static boolean adminDefined() {
    UserInfo userInfo = UserInfo.find().where().eq("admin", true).findUnique();
    return userInfo != null;
  }

  /**
   * Adds the specified user to the UserInfoDB.
   * @param name Their name.
   * @param email Their email.
   * @param password Their password. 
   * @param dateJoined The date of joining.
   */
  public static void addUserInfo(String name, String email, String password, String dateJoined) {
    UserInfo userInfo = new UserInfo(name, email, password, dateJoined);
    userInfo.save();
  }
  
  /**
   * Returns true if the email represents a known user.
   * @param email The email.
   * @return True if known user.
   */
  public static boolean isUser(String email) {
    return (UserInfo.find().where().eq("email", email).findUnique() != null);
  }

  /**
   * Returns the UserInfo associated with the email, or null if not found.
   * @param email The email.
   * @return The UserInfo.
   */
  public static UserInfo getUser(String email) {
    return UserInfo.find().where().eq("email", email).findUnique();
  }
  
  /**
   * Adds the surfer to the user's view list.
   * @param user The user viewing the page
   * @param slug The slug of the surfer page being viewed
   */
  public static void viewSurfer(UserInfo user, String slug) {
    Surfer surfer = SurferDB.getSurfer(slug);
    
    // first delete the surfer from it's spot in the user's list because user is viewing it again
    if (user.getViews().contains(surfer)) {
      user.getViews().remove(surfer);
    }
    
    // add the surfer
    user.getViews().add(surfer);
    /**for (Surfer s : user.getViews()) {
      System.out.println(s.getName());
    }*/
    user.save();
  }

  /**
   * Returns true if email and password are valid credentials.
   * @param email The email. 
   * @param password The password. 
   * @return True if email is a valid user email and password is valid for that email.
   */
  public static boolean isValid(String email, String password) {
    return ((email != null) 
            &&
            (password != null) 
            &&
            isUser(email) 
            &&
            getUser(email).getPassword().equals(password));
  }
  
}
