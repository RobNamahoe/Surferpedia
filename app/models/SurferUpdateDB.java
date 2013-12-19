package models;

import java.util.List;

/**
 * A repository that stores update information.
 * @author Rob Namahoe
 */
public class SurferUpdateDB {
  
  /**
   * Add an update log.
   * @param surferUpdate Update information.
   */
  public static void addUpdate(SurferUpdate surferUpdate) {
    surferUpdate.save();
  }
  
  /**
   * Retrieves a List of updates.
   * @return list of updates.
   */
  public static List<SurferUpdate> getUpdates() {
    return SurferUpdate.find().all();
  }
  
  /**
   * Retrieve all the updates associated with the user's email.
   * @param user The user
   * @return list of updates.
   */
  public static List<SurferUpdate> getUpdatesByUser(UserInfo user) {
    return SurferUpdate.find().where().eq("user", user).findList();
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
  public static List<SurferUpdate> getUpdatesByUserAndAction(UserInfo user, String action) {
    return SurferUpdate.find().where().eq("user", user).eq("action", action).findList();
  }
}
