package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

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
    System.out.println("Start: IndexPage.goToLogin()");
    System.out.println("1");
    find("#logout").click();
    System.out.println("2");
    find("#login").click();
    System.out.println("End: IndexPage.goToLogin()");
  }
  
  /**
   * Returns true if we are logged in (ie. the logout link exists).
   * @return true if we are logged into the application.
   */
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }
  
  
}
