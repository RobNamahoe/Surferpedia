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
public class ManageSurferPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public ManageSurferPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: ManageSurfer");
  }

  /**
   * Set the name of the surfer.
   * @param name The name of the surfer.
   */
  public void setName(String name) {
    fill("#name").with(name);
  }
  
  /**
   * Set the home of the surfer.
   * @param home The home of the surfer.
   */
  public void setHome(String home) {
    fill("#home").with(home);
  }
  
  /**
   * Set the country of the surfer.
   * @param country The country of the surfer.
   */
  public void setCountry(String country) {
    fill("#country").with(country);
  } 
  
  /**
   * Set the awards the surfer has won.
   * @param awards The surfers awards.
   */
  public void setAwards(String awards) {
    fill("#awards").with(awards);
  }
  
  /**
   * Select the surfers footstyle.
   * @param footStyle The surfers footstyle.
   */
  public void setFootStyle(String footStyle) {
    find("div", withId("footStyles")).find("input", withId(footStyle)).click();
  }
  
  /**
   * Set the carousel url of the surfer.
   * @param url The url to the carousel image.
   */
  public void setCarouselUrl(String url) {
    fill("#carouselUrl").with(url);
  }
  
  /**
   * Set the bio url of the surfer.
   * @param url The url to the bio image.
   */
  public void setBioUrl(String url) {
    fill("#bioUrl").with(url);
  }
  
  /**
   * Set the surfers biography.
   * @param bio The surfers biography.
   */
  public void setBio(String bio) {
    fill("#bio").with(bio);
  }
  
  /**
   * Select the surfers gender.
   * @param gender The surfers gender.
   */
  public void selectGender(String gender) {
    find("select", withId().equalTo("gender")).find("option", withText().equalTo(gender)).click();
  }
  
  /**
   * Submit the changes.
   */
  public void submitChanges() {
    submit("#submit");
  }

}
