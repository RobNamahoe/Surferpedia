package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Surfer Types.
 * @author rckndn
 */
public class SurferTypes {

  private static String[] types = {"Male", "Female", "Groms"};
  
  /**
   * Returns a newly initialized map of surfer types.
   * @return A surfer type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> surferTypeMap = new HashMap<>();
    for (String type: types) {
      surferTypeMap.put(type, false);
    }
    return surferTypeMap;
  }
  
  /**
   * Returns A newly initialized Map of surfer types with selected type indicated.
   * @param surferType The selected surfer type.
   * @return A surfer type map.
   */
  public static Map<String, Boolean> getTypes(String surferType) {
    Map<String, Boolean> surferTypeMap = getTypes();
    surferTypeMap.put(surferType, true);
    return surferTypeMap;
  }
  
  /**
   * Returns true if surferType is a valid surfer type.
   * @param surferType The selected surfer type.
   * @return true if the surferType is valid, false otherwise.
   */
  public static Boolean isType(String surferType) {
    return SurferTypes.getTypes().keySet().contains(surferType);
  }
  
}
