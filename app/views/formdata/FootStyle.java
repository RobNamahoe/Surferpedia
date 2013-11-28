package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Footstyle Types.
 * @author rckndn
 *
 */
public class FootStyle {
 
 
  /**
   * Returns A newly initialized Map of footstyle types with selected type indicated.
   * @param footstyleType The selected footstyle type.
   * @return A footstyle type map.
   */
  public static List<String> getTypes() {
    List<String> types = new ArrayList<>();
    types.add("Regular");
    types.add("Goofy");
    return types;
  }
   
  
}
