package models;

/**
 * A repository to store gender information.
 * @author Rob Namahoe
 *
 */
public class GenderDB {

  /**
   * Adds a gender to the database if it does not already exist.
   * @param genderToAdd The gender to add.
   */
  public static void addGender(String genderToAdd) {
    if (!isGender(genderToAdd)) {
      Gender gender = new Gender(genderToAdd);
      gender.save();
    }
  }
  
  /**
   * Returns true if the gender already exists in the database.
   * @param gender The name of the gender.
   * @return True if the gender is known.
   */
  public static boolean isGender(String gender) {
    return Gender.find().where().eq("gender", gender).findUnique() != null;
  }
  
  /**
   * Gets the requested gender, if it exists.
   * @param gender The gender to return.
   * @return The requested gender.
   */
    public static Gender getGender(String gender) {
      return Gender.find().where().eq("gender", gender).findUnique();
    }
    
}
