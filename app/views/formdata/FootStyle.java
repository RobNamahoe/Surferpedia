package views.formdata;

import java.util.ArrayList;
import java.util.List;
/**
 * Footstyle Types.
 * @author Rob Namahoe
 */
public class FootStyle {
 
 
  /**
   * Returns A newly initialized Map of footstyle types with selected type indicated.
   * @return A footstyle type map.
   */
  public static List<String> getTypes() {
    List<String> types = new ArrayList<>();
    types.add("Regular");
    types.add("Goofy");
    return types;
  }
   
  
}
