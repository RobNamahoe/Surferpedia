package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Rob Namahoe
 * @author Eva Shek
 */
public class ShowSurferPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public ShowSurferPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: ShowSurfer");
  }

  /**
   * Delete the current surfer.
   */
  public void deleteSurfer() {
    find("#delete").click();
    find("#modalconfirm").click();
  }
  
  /**
   * Edit the current surfer.
   */
  public void editSurfer() {
    find("#edit").click();
  }
  
  /**
   * Navigate to the Profile page.
   */
  public void goToProfile() {
    find("#navbutton").click();
    find("#useroptions").click();
    find("#profile").click();
  }
  
}
