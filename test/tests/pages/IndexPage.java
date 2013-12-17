package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: Index");
  }

  /**
   * Click on the login link.
   */
  public void goToLogin() {
    find("#navbutton").click();
    find("#login").click();
  }
  
  /**
   * Click on the Updates link.
   */
  public void goToUpdates() {
    find("#navbutton").click();
    find("#updates").click();
  }
  
  /**
   * Click on the Name The Surfer Game link.
   */
  public void goToNameTheSurfer() {
    find("#navbutton").click();
    find("#game").click();
  }
  
  /**
   * Click on the logout link.
   */
  public void logout() {
    find("#navbutton").click();
    find("#logout").click();
  }
  
  /**
   * Returns true if we are logged in (ie. the logout link exists).
   * @return true if we are logged into the application.
   */
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }

  /**
   * Search the database for a surfer.
   * @param name The name of the surfer to search.
   * @param gender The gender of the surfer to search.
   * @param country The country of the surfer to search.
   */
  public void searchSurfers(String name, String gender, String country) {
    find("#navbutton").click();
    fill("#name").with(name);
    // Find the menu with id "gender", and click the menu item equal to the passed gender string.
    find("select", withId().equalTo("gender")).find("option", withText().equalTo(gender)).click();
    // Find the menu with id "country", and click the menu item equal to the passed country string.
    find("select", withId().equalTo("country")).find("option", withText().equalTo(country)).click();
    submit("#submitsearch");
  }
  
}
