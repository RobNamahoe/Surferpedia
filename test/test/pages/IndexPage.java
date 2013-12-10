package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in index page.
 * @author Eva Shek
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
   * Check that login page is accessed when link clicked.
   */
  public void goToLogin() {
    find("#login").click();
  }
  
  /**
   * Check that new contact page is accessed when link clicked.
   */
  public void goToNewSurfer() {
    find("#newsurfer").click();
  }
  
  /**
   * Check for whether user is logged in.
   * @return true if the newcont element is found, false otherwise
   */
  public boolean isLoggedIn() {
    return !find("#newsurfer").isEmpty();
  }
  
  /**
   * Check for whether user is logged out.
   * @return true if the newcont element is not found, false otherwise
   */
  public boolean isLoggedOut() {
    return find("#newsurfer").isEmpty();
  }
  
  /**
   * Logging out.
   */
  public void logout() {
    find("#logout").click();
  }
}