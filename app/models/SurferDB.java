package models;

import java.util.List;
import views.formdata.SurferFormData;

/**
 * A repository to store surfer information.
 * @author Rob Namahoe
 */
public class SurferDB {
  
  /**
   * A method to add a new surfer to the database.
   * @param formData Surfer Form.
   */
  public static void addSurfer(SurferFormData formData) {
    
    // Check if object exists, if not create a new one
    Surfer surfer; 
    if (!isSurfer(formData.slug)) {
      surfer = new Surfer(formData.name, formData.home, formData.country, formData.awards, formData.carouselUrl,
                          formData.bioUrl, formData.bio, formData.slug, formData.gender, 
                          formData.status, formData.footStyle);
    }
    else {
      surfer = SurferDB.getSurfer(formData.slug);  
    }
    
    Country country;
    if (!CountryDB.isCountry(formData.country)) {
      country = new Country(formData.country);
    }
    else {
      country = CountryDB.getCountry(formData.country);
    }
    
    Gender gender = new Gender();
    if (!GenderDB.isGender(formData.gender)) {
      gender = new Gender(formData.gender);
    }
    else {
      gender = GenderDB.getGender(formData.gender);
    }
    
    // Establish the relationships
    surfer.setCountry(country);
    surfer.setGender(gender);
    
    country.addSurfer(surfer);
    gender.addSurfer(surfer);
    
    country.save();
    gender.save();
    surfer.save();
    
  }
  
  /**
   * Get a surfer.
   * @param slug The slug of the surfer to retrieve.
   * @return The surfer.
   */
  public static Surfer getSurfer(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique();
  }
  
  /**
   * Get a list of all surfers.
   * @return A list of all surfers.
   */
  public static List<Surfer> getSurfers() {
    return Surfer.find().findList();
  }
  
  /**
   * Delete a specified surfer from the database.
   * @param slug The slug of the surfer to delete.
   */
  public static void deleteSurfer(String slug) {
    Surfer.find().where().eq("slug", slug).findUnique().delete();
  }
  
  /**
   * Check if a slug is already assigned to a surfer.
   * @param slug The unique identifier.
   * @return true of the slug is already associated to a surfer, false otherwise.
   */
  public static Boolean isSurfer(String slug) {
    return Surfer.find().where().eq("slug", slug).findUnique() != null;
  }
  
  /**
   * Ebean Users guide 6.7
   * 
   * Gets a list of surfers of the specified gender.
   * @param gender The gender of the surfers.
   * @return A list of surfers.
   */
  public static List<Surfer> getSurfersByGender(String gender) {
    return Surfer.find().where().eq("gender", GenderDB.getGender(gender)).findList();
  }

}
