package tests;

import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import tests.pages.IndexPage;
import tests.pages.LoginPage;
import tests.pages.ManageSurferPage;
import tests.pages.NameTheSurferPage;
import tests.pages.SearchResultsPage;
import tests.pages.ShowSurferPage;
import tests.pages.UpdatesPage;
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
   * Ensure a user can login and logout of the system.
   */
  @Test
  public void testLoginLogout() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
                
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();

        indexPage.logout();
        assertThat(indexPage.isLoggedIn()).isFalse();
      }
    });
  }
  
  /**
   * Ensure a user can access the Name The Surfer Game page.
   */
  @Test
  public void testNameTheSurfer() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
                
        indexPage.goToNameTheSurfer();
        NameTheSurferPage nameTheSurferPage = new NameTheSurferPage(browser.getDriver(), PORT);
        nameTheSurferPage.isAt();

      }
    });
  }
  
  /**
   * Ensure that the Search function works.
   */
  @Test
  public void testSearch() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();

        // Test search by name
        indexPage.searchSurfers("John Florence", "", "");
        assertThat(browser.pageSource()).contains("John John Florence");
        
        // Test search by gender
        indexPage.searchSurfers("", "Female", "");
        assertThat(browser.pageSource()).contains("Results: 10 surfers found");
        
        // Test search by country
        indexPage.searchSurfers("", "", "Australia");
        assertThat(browser.pageSource()).contains("Results: 4 surfers found");
        
      }
    });
  }
  
  /**
   * Ensure Delete function works.
   */
  @Test
  public void testDelete() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        // Login to application
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();

        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();

        // Search for a surfer
        indexPage.searchSurfers("John Florence", "", "");
        SearchResultsPage searchResultsPage = new SearchResultsPage(browser.getDriver(), PORT);
        searchResultsPage.isAt();
        // Ensure expected result is displayed
        assertThat(browser.pageSource()).contains("John John Florence");
        
        // Go to the surfers profile
        searchResultsPage.goToSurferProfile("jjflorence");
        ShowSurferPage showSurferPage = new ShowSurferPage(browser.getDriver(), PORT);
        showSurferPage.isAt();
        
        // Delete the surfer
        showSurferPage.deleteSurfer();
        
        // Search for the same surfer; should return no results
        indexPage.searchSurfers("John Florence", "", "");
        searchResultsPage.isAt();
        assertThat(browser.pageSource()).contains("Sorry, no matches found.");
        
        indexPage.goToUpdates();
        
        // Updates page should also show that the surfer has been deleted.
        UpdatesPage updatesPage = new UpdatesPage(browser.getDriver(), PORT);
        updatesPage.isAt();
        assertThat(browser.pageSource()).contains("Delete");
        assertThat(browser.pageSource()).contains("John John Florence");

      }
    });
  }
  
  /**
   * Ensure Edit function works.
   */
  @Test
  public void testEdit() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        // Login to application
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();

        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        
        loginPage.login();
        assertThat(indexPage.isLoggedIn()).isTrue();

        // Search for a surfer
        indexPage.searchSurfers("John Florence", "", "");
        SearchResultsPage searchResultsPage = new SearchResultsPage(browser.getDriver(), PORT);
        searchResultsPage.isAt();
        // Ensure expected result is displayed
        assertThat(browser.pageSource()).contains("John John Florence");
        
        // Go to the surfers profile
        searchResultsPage.goToSurferProfile("jjflorence");
        ShowSurferPage showSurferPage = new ShowSurferPage(browser.getDriver(), PORT);
        showSurferPage.isAt();
        
        // Click link to edit surfer information
        showSurferPage.editSurfer();
        
        ManageSurferPage manageSurferPage = new ManageSurferPage(browser.getDriver(), PORT);
        manageSurferPage.isAt();
        
        manageSurferPage.setHome("Kahului, Maui");
        manageSurferPage.submitChanges();
        
        // Check that changes are displayed on Show Surfer page
        assertThat(browser.pageSource()).contains("Kahului, Maui");
        
        // Ensure changes were added to Updates page
        indexPage.goToUpdates();
        UpdatesPage updatesPage = new UpdatesPage(browser.getDriver(), PORT);
        updatesPage.isAt();
        assertThat(browser.pageSource()).contains("Edit");
        assertThat(browser.pageSource()).contains("John John Florence");
        
      }
    });
  }
  
  
}
