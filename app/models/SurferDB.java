package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * A repository to store surfer information.
 * @author rckndn
 */
public class SurferDB {

  private static Map<String, Surfer> surfers = new HashMap<>();
  
  /**
   * A method to add a new surfer to the database.
   * @param formData Surfer Form.
   * @return The new surfer.
   */
  public static Surfer addSurfer(SurferFormData formData) {
    //long id = (formData.id == 0) ? surfers.size() + 1 : formData.id;
    Surfer surfer = new Surfer(formData.slug, formData.name, formData.home, formData.awards, formData.carouselUrl,
                               formData.bioUrl, formData.bio, formData.slug, formData.type);
    surfers.put(formData.slug, surfer);
    System.out.println(formData.name + " added");
    return surfer;
  }
  
  /**
   * Get a surfer.
   * @param id The id of the surfer to retrieve.
   * @return The surfer.
   */
  public static Surfer getSurfer(String id) {
    return surfers.get(id);
  }
  
  /**
   * Get a list of all surfers.
   * @return A list of all surfers.
   */
  public static List<Surfer> getSurfers() {
    return new ArrayList<>(surfers.values());
  }
  
  /**
   * Delete a specified surfer from the database.
   * @param id The id of the surfer to delete.
   */
  public static void deleteSurfer(String id) {
    surfers.remove(id);
  }  
  
}
