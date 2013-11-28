package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * A repository to store surfer information.
 * @author Rob Namahoe
 */
public class SurferDB {

  private static Map<String, Surfer> surfers = new HashMap<>();
  
  /**
   * A method to add a new surfer to the database.
   * @param formData Surfer Form.
   * @return The new surfer.
   */
  public static Surfer addSurfer(SurferFormData formData) {
    Surfer surfer = new Surfer(formData.name, formData.home, formData.awards, formData.carouselUrl,
                               formData.bioUrl, formData.bio, formData.slug, formData.type, 
                               formData.status, formData.footStyle);
    surfer.setStatus("existing");
    surfers.put(formData.slug, surfer);
    return surfer;
  }
  
  /**
   * Get a surfer.
   * @param slug The slug of the surfer to retrieve.
   * @return The surfer.
   */
  public static Surfer getSurfer(String slug) {
    return surfers.get(slug);
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
   * @param slug The slug of the surfer to delete.
   */
  public static void deleteSurfer(String slug) {
    surfers.remove(slug);
  }
  
  /**
   * Check if a slug is already assigned to a surfer.
   * @param slug The unique identifier.
   * @return true of the slug is already associated to a surfer, false otherwise.
   */
  public static Boolean slugExists(String slug) {
    return surfers.containsKey(slug);
  }
  
}
