package models;

import java.util.List;
import views.formdata.SearchFormData;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.PagingList;
import com.avaje.ebean.Query;

/**
 * 
 * @author Rob Namahoe
 * @author Eva Shek
 */
public class SurferSearch {
  
  private static final int PAGINATION_MAX = 15;
  private static PagingList<Surfer> pages;
  
  /**
   * Query the database for surfers matching the search criteria.
   * @param data The search criteria.
   */
  public static void queryDatabase(SearchFormData data) {
    
    // If all three parameters are empty, then return all surfers.
    // Do this first so we can differentiate between no matches vs no parameters.
    if (data.name.equals("") && data.gender.equals("") && data.country.equals("")) {
      pages = Surfer.find().findPagingList(PAGINATION_MAX);
      SurferSearch.setPages(pages);
      return;
    }
    
    Query<Surfer> query = Ebean.createQuery(Surfer.class);
    
    if (!data.name.equals("")) {
      query.where().icontains("name", data.name);
    }
    if (!data.gender.equals("")) {
      query.where().eq("gender", GenderDB.getGender(data.gender));
    }
    if (!data.country.equals("")) {
      query.where().eq("country", CountryDB.getCountry(data.country));
    }
    
    pages = query.findPagingList(PAGINATION_MAX);
    SurferSearch.setPages(pages);
 
  }

  /**
   * @param results The pages to set
   */
  public static void setPages(PagingList<Surfer> results) {
    pages = results;
  }
  
  /**
   * Get the specified results page.
   * @param page The page to retrieve.
   * @return The specified results page.
   */
  public static List<Surfer> getSurfersInPage(int page) {
    return pages.getPage(page).getList();
  }
  
  /**
   * Get the total number of pages of results.
   * @return The number of result pages.
   */
  public static int getPageCount() {
    return pages.getTotalPageCount();
  }
  
  /**
   * Get the total number of results (surfers).
   * @return The number of surfers.
   */
  public static int getSurferCount() {
    return pages.getTotalRowCount();
  }
 
}
