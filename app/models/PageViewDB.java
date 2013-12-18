package models;

import java.util.List;

/**
 * A repository to store information on a page view.
 * @author Eva Shek
 */
public class PageViewDB {

  /**
   * Adds a page view to the database.
   * @param view PageView made by user on surfer page
   */
  public static void addView(PageView view) {
    view.save();
  }
  
  /**
   * Remove the page view associated with the supplied user and surfer.
   * @param user User the viewed page
   * @param surfer Surfer page viewed
   */
  public static void removeView(UserInfo user, Surfer surfer) {
    PageView.find().where().eq("user", user).eq("surfer", surfer).findUnique().delete();
  }
  
  /**
   * Gets the views made by the user.
   * @param user User viewing pages
   * @return List of views
   */
  public static List<PageView> getViewsByUser(UserInfo user) {
    return PageView.find().where().eq("user", user).findList();
  }
  
  /**
   * Gets the views made to the surfer page.
   * @param surfer Surfer page being viewed
   * @return List of views
   */
  public static List<PageView> getSurferViews(Surfer surfer) {
    return PageView.find().where().eq("surfer", surfer).findList();
  }
}
