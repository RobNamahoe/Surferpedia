package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A repository to store country information.
 * @author Rob Namahoe
 */
public class CountryDB {

  /**
   * Adds a country to the database if it does not already exist.
   * @param countryToAdd The country to add.
   */
  public static void addCountry(String countryToAdd) {
    if (!isCountry(countryToAdd)) {
      Country country = new Country(countryToAdd);
      country.save();
    }
  }
  
  /**
   * Returns true if the country already exists in the database.
   * @param country The name of the country.
   * @return True if the country is known.
   */
  public static boolean isCountry(String country) {
    return Country.find().where().eq("country", country).findUnique() != null;
  }
  
/**
 * Gets the requested country, if it exists.
 * @param country The country to return.
 * @return The requested country.
 */
  public static Country getCountry(String country) {
    return Country.find().where().eq("country", country).findUnique();
  }
  
  /**
   * Gets a list of all countries associated with surfers in the system.
   * @return List of countries.
   */
  public static List<Country> getCountries() {
    return Country.find().orderBy("country").setDistinct(true).findList();
  }
  
  /**
   * Returns a list of country options for a drop down menu.
   * @return Map of countries.
   */
  public static Map<String, Boolean> getCountryMap() {
    List<Country> countries = getCountries();
    Map<String, Boolean> countryMap = new HashMap<>();
    for (Country country : countries) {
      countryMap.put(country.getCountry(), false);
    }
    return countryMap;
  }
  
  /**
   * Delete a country from the database.
   * @param country The country to delete.
   */
  public static void deleteCountry(Country country) {
    country.delete();
  }
  
}
