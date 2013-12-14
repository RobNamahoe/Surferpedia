package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A repository that stores update information.
 * @author Rob Namahoe
 *
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
  
}
