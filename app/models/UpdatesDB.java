package models;

import java.util.List;

/**
 * A repository that stores update information.
 * @author Rob Namahoe
 */
public class UpdatesDB {
  
  /**
   * Add an update log.
   * @param surferUpdate Update information.
   */
  public static void addUpdate(Updates surferUpdate) {
    surferUpdate.save();
  }
  
  /**
   * Retrieves a List of updates.
   * @return list of updates.
   */
  public static List<Updates> getUpdates() {
    return Updates.find().all();
  }
  
  /**
   * Retrieve all the updates associated with the user's email.
   * @param user The user
   * @return list of updates.
   */
  public static List<Updates> getUpdatesByUser(UserInfo user) {
    return Updates.find().where().eq("user", user).findList();
  }
  
  /**
   * Retrieve all the updates associated with the user's email.
   * @param user The user
   * @return list of updates.
   */
  public static int getNumOfUpdatesByUser(UserInfo user) {
    return getUpdatesByUser(user).size();
  }
  
  /**
   * Retrieves all the updates associated with the user's email and the action specified.
   * @param user The user
   * @param action Action made (CUD)
   * @return list of updates
   */
  public static List<Updates> getUpdatesByUserAndAction(UserInfo user, String action) {
    return Updates.find().where().eq("user", user).eq("action", action).findList();
  }
}
