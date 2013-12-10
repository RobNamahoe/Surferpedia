package test;

import org.junit.Test;
import play.Play;
import play.test.TestBrowser;
import play.libs.F.Callback;
import test.pages.IndexPage;
import test.pages.LoginPage;
import test.pages.NewSurferPage;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Check to see that the user can add a new surfer.
   */
  @Test
  public void testNewSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        indexPage.goToLogin();
        
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.setEmail(Play.application().configuration().getString("surferpedia.admin.email"));
        loginPage.setPassword(Play.application().configuration().getString("surferpedia.admin.password"));
        loginPage.submit();
        assertThat(indexPage.isLoggedIn()).isTrue();
        
        indexPage.goToNewSurfer();
        
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        newSurferPage.addSurfer("A B", "Honolulu, Hawaii", "USA", "Regular", "#", "#", "fjdkslnvlksf", "ab", "Male");
        
        browser.goTo(indexPage + "/surfer/ab");
        assertThat(browser.pageSource()).contains("fjdkslnvlksf");
      }
    });
  }

}
