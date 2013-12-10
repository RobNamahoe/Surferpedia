package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Illustration of the Page Object Pattern in New Contact page.
 * @author Eva Shek
 */
public class NewSurferPage extends FluentPage {
  private String url;
  
  /**
   * Create the NewContactPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewSurferPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Add new contact");
  }

  /**
   * Adding a contact.
   * @param fName First name
   * @param lName Last name
   * @param number Telephone number
   * @param type Telephone type
   */
  public void addSurfer(String name, String home, String country, String footStyle, String carUrl, String bioUrl,
      String bio, String slug, String type) {
    fill("#name").with(name);
    fill("#home").with(home);
    fill("#country").with(country);
    find("div", withId("footStyles")).find("input", withId(footStyle)).click();
    fill("#carouselUrl").with(carUrl);
    fill("#bioUrl").with(bioUrl);
    fill("#bio").with(bio);
    fill("#slug").with(slug);
    find("select", withId("gender")).find("option", withId(type)).click();
    submit("#submit");
  }

}