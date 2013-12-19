package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Eva Shek
 */
public class LoginPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public LoginPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Surferpedia: Login");
  }

  /**
   * Login to the surferpedia application.
   * @param email The email of the user logging in.
   * @param password The password of the user logging in.
   */
  public void login(String email, String password) {
    fill("#email").with(email);
    fill("#password").with(password);
    submit("#loginsubmit");
  }
  
  /**
   * Register for an account.
   * @param name The name of the new user.
   * @param email The email of the new user.
   * @param password The password of the new user.
   */
  public void register(String name, String email, String password) {
    fill("#regName").with(name);
    fill("#regEmail").with(email);
    fill("#regPassword").with(password);
    submit("#regsubmit");
  }

}
