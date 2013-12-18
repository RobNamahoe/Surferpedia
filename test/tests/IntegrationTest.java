package tests;

import models.SurferDB;
import org.junit.Test;
import play.Play;
import play.test.TestBrowser;
import play.libs.F.Callback;
import tests.pages.IndexPage;
import tests.pages.LoginPage;
import tests.pages.ManageSurferPage;
import tests.pages.NameTheSurferPage;
import tests.pages.NewSurferPage;
import tests.pages.ProfilePage;
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
        
        String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
        String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");
        loginPage.login(adminEmail, adminPassword);
        assertThat(indexPage.isLoggedIn()).isTrue();

        indexPage.logout();
        assertThat(indexPage.isLoggedIn()).isFalse();
      }
    });
  }
  
  /**
   * Ensure a user can register for an account.
   */
  @Test
  public void testRegistration() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        
        loginPage.register("Y Z", "y@z.com", "password");
        assertThat(indexPage.isLoggedIn()).isTrue();
        
        indexPage.logout();
        assertThat(indexPage.isLoggedIn()).isFalse();
        
        indexPage.goToLogin();
        loginPage.isAt();
        loginPage.login("y@z.com", "password");
        assertThat(indexPage.isLoggedIn()).isTrue();
      }
    });
  }
  
  /**
   * Ensure that a user is automatically redirected to the login page if they try to
   * access a secured page.
   */
  @Test
  public void testAuthorization() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        
        // go to pages that only a logged in user is able to view
        browser.goTo("http://localhost:" + PORT + "/new");
        loginPage.isAt();
        
        browser.goTo("http://localhost:" + PORT + "/updates");
        loginPage.isAt();
        
        browser.goTo("http://localhost:" + PORT + "/profile");
        loginPage.isAt();
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
   * Ensure that the Search by name function works.
   */
  @Test
  public void testSearchByName() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();

        // Test search by name
        indexPage.searchSurfers("John Florence", "", "");
        assertThat(browser.pageSource()).contains("John John Florence");
        
      }
    });
  }
  
  
  /**
   * Ensure that the Search by gender function works.
   */
  @Test
  public void testSearchByGender() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        
        // Test search by gender
        indexPage.searchSurfers("", "Female", "");
        assertThat(browser.pageSource()).contains("Results: 10 surfers found");
        
      }
    });
  }
  
  
  /**
   * Ensure that the Search by country function works.
   */
  @Test
  public void testSearchByCountry() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        
        // Test search by country
        indexPage.searchSurfers("", "", "Australia");
        assertThat(browser.pageSource()).contains("Results: 4 surfers found");
        
      }
    });
  }
  
  /**
   * Ensure that the Search function works when all fields are empty.
   */
  @Test
  public void testSearchBlank() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();

        // Test search by name
        indexPage.searchSurfers("", "", "");
        assertThat(browser.pageSource()).contains("Results: " + SurferDB.getSurfers().size() + " surfers found");
        
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
        
        String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
        String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");
        loginPage.login(adminEmail, adminPassword);
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
        
        String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
        String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");
        loginPage.login(adminEmail, adminPassword);
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
  
  /**
   * Ensure New function works.
   */
  @Test
  public void testNew() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        // Login to application
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();

        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        
        String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
        String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");
        loginPage.login(adminEmail, adminPassword);
        assertThat(indexPage.isLoggedIn()).isTrue();
        
        indexPage.goToNew();
        
        NewSurferPage newSurferPage = new NewSurferPage(browser.getDriver(), PORT);
        newSurferPage.isAt();
        
        newSurferPage.setName("Jacqueline Silva");
        newSurferPage.setHome("Florianopolis, Brazil");
        newSurferPage.setCountry("Brazil");
        newSurferPage.setAwards("1996 Brazilian Amateur Champion, 2001 World Champion in the World Qualifying Series");
        newSurferPage.setFootStyle("Regular");
        newSurferPage.setCarouselUrl("http://resources0.news.com.au/images/2011/04/19/1226041/"
                                     + "413516-jacqueline-silva.jpg");
        newSurferPage.setBioUrl("http://www.sportsresgate.com.br/imagens/news/original/"
                                + "jacqueline-silva-03122010132401.jpg");
        newSurferPage.setBio("Jacqueline Silva is considered to be a pioneer in women's Brazilian surfing and "
                             + "has garnered the best results from someone from Brazil, male or female. She "
                             + "began at a time when there were no female categories in Brazilian surfing " 
                             + "championships. Among her notable accomplishments was winning the 1996 Brazilian " 
                             + "Amateur Champion and World Champion in the World Qualifying Series in 2001. In "
                             + "2004 she became the first Brazilian to ever win an event in the World Championship "
                             + "Tour when she won the open at Australia’s Gold Coast.");
        newSurferPage.setSlug("jacquelinesilva");
        newSurferPage.selectGender("Female");
        newSurferPage.submitChanges();
        
        ShowSurferPage showSurferPage = new ShowSurferPage(browser.getDriver(), PORT);
        showSurferPage.isAt();
        
        assertThat(browser.pageSource()).contains("Jacqueline Silva");
        
        // Ensure changes were added to Updates page
        indexPage.goToUpdates();
        UpdatesPage updatesPage = new UpdatesPage(browser.getDriver(), PORT);
        updatesPage.isAt();
        assertThat(browser.pageSource()).contains("Create");
        assertThat(browser.pageSource()).contains("Jacqueline Silva");

      }
    });
  }
  
  /**
   * Ensure that a user can see that they have recently viewed a particular surfer page.
   */
  @Test
  public void testProfileViews() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        
        String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
        String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");
        loginPage.login(adminEmail, adminPassword);
        assertThat(indexPage.isLoggedIn()).isTrue();
        
        indexPage.goToProfile();
        ProfilePage profilePage = new ProfilePage(browser.getDriver(), PORT);
        profilePage.isAt();
        // user has not made any surfer page views yet
        assertThat(browser.pageSource()).contains("Need help browsing?");
        
        // search for surfer
        profilePage.searchSurfers("Eddie Aikau", "", "");
        SearchResultsPage searchResultsPage = new SearchResultsPage(browser.getDriver(), PORT);
        searchResultsPage.isAt();
        // Ensure expected result is displayed
        assertThat(browser.pageSource()).contains("Eddie Aikau");
        
        searchResultsPage.goToSurferProfile("eddieaikau");
        ShowSurferPage showSurferPage = new ShowSurferPage(browser.getDriver(), PORT);
        showSurferPage.isAt();
        
        // user can see that they viewed surfer's page
        showSurferPage.goToProfile();
        profilePage.isAt();
        assertThat(browser.pageSource()).contains("http://upload.wikimedia.org/wikipedia/en/a/ae/Eddie_Aikau.jpg");
      }
    });
  }
 
  /**
   * Ensure that a user can see that they have recently edited a particular surfer page in their profile page.
   */
  @Test
  public void testProfileEdits() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        
        IndexPage indexPage = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(indexPage);
        indexPage.isAt();
        
        indexPage.goToLogin();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        
        String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
        String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");
        loginPage.login(adminEmail, adminPassword);
        assertThat(indexPage.isLoggedIn()).isTrue();
        
        indexPage.goToProfile();
        ProfilePage profilePage = new ProfilePage(browser.getDriver(), PORT);
        profilePage.isAt();
        // user has not made any edits to surfers yet
        assertThat(browser.pageSource()).contains("No surfers edited by you.");
        
        // search for surfer
        profilePage.searchSurfers("Bianca Buitendag", "", "");
        SearchResultsPage searchResultsPage = new SearchResultsPage(browser.getDriver(), PORT);
        searchResultsPage.isAt();
        // Ensure expected result is displayed
        assertThat(browser.pageSource()).contains("Bianca Buitendag");
        
        searchResultsPage.goToSurferProfile("biancabuitendag");
        ShowSurferPage showSurferPage = new ShowSurferPage(browser.getDriver(), PORT);
        showSurferPage.isAt();
        showSurferPage.editSurfer();
        
        ManageSurferPage manageSurferPage = new ManageSurferPage(browser.getDriver(), PORT);
        manageSurferPage.isAt();
        manageSurferPage.setHome("Kahului, Maui");
        manageSurferPage.submitChanges();
        showSurferPage.isAt(); // redirects to surfer page
        
        // user can see that they have updated a surfer page
        showSurferPage.goToProfile();
        profilePage.isAt();
        assertThat(browser.pageSource()).contains("Bianca Buitendag");
      }
    });
  }
}
