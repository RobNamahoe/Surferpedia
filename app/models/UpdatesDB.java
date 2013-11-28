package models;

import java.util.ArrayList;
import java.util.List;

/**
 * A repository that stores update information.
 * @author Rob Namahoe
 *
 */
public class UpdatesDB {
  
  private static List<Updates> updates = new ArrayList<>();
  
  /**
   * Add an update log.
   * @param surferUpdate Update information.
   */
  public static void addUpdate(Updates surferUpdate) {
    updates.add(surferUpdate);
  }
  
  /**
   * Retrieves a List of updates.
   * @return list of updates.
   */
  public static List<Updates> getUpdates() {
    return updates;
  }
}
