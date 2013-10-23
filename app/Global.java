import models.SurferDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;

/**
 * Global settings for the Play Application.
 * @author rckndn
 */
public class Global extends GlobalSettings {
  
  /**
   * Initialize the database with 3 surfers.
   * @param app The Play application.
   */
  public void onStart(Application app) {
    String carouselUrl = "http://www.vanssurf.com/images/team/john-john/john-h.jpg";
    String bioUrl = "http://beckersurf.com/blog/wp-content/uploads/2013/08/JOHNJOHN-AI-AWARD-TEAHUPOO-2013.jpg";
    String bio = "";
    
    // JJ Florence
    bio = "John John Florence , the oldest of three children, grew up in Hale'iwa, in an ocean-side house at the "
          + "Banzai Pipeline. He resides with his mother, Alexandra, and his two younger brothers Nathan and Ivan. He was "
          + "introduced to surfing by Alexandra, who is a surfer herself. Florence claims he rode a surf board at the age "
          + "of six months, wearing a life vest on his father John's board; he was riding on his own by the age of three. "
          + "Florence became well known in the winter of late 2005 and early 2006 when he became the youngest ever "
          + "surfer to compete in the Vans Triple Crown of Surfing. He had previously won five amateur awards, the 2003 1st "
          + "NSSA Nationals Open Mini Grom, the 2005 1st NSSA Nationals Open Boy's, the 2005 NSSA Open Boys and the "
          + "Explorer Menehune Champion. He did not pass the first round, but he did score higher than Shane Dorian, a "
          + "professional surfer twenty years Florence's senior. Afterwards, Florence said he was pretty scared but that "
          + "he was happy with how [he] did. Surfer Kelly Slater has said of Florence John John's going to know the "
          + "waves on North Shore like no one we've ever seen before. Singer Jack Johnson, who grew up in the same town as "
          + "Florence, said he is a little unprecedented";
    SurferDB.addSurfer(new SurferFormData("John Florence", "Maui", "", carouselUrl, bioUrl, bio, "jjflorence", "Male"));
    
    // Kelia Moniz
    carouselUrl = "http://cdn.rsvlts.com/wp-content/uploads/2013/02/Kelia-Moniz-03.jpg";
    bioUrl = "http://www1.pictures.zimbio.com/gi/DVF+Loves+ROXY+Launch+hiadGWypmZUl.jpg";
    bio = "Multi-talented Japanese, Hawaiian, Portuguese, Chinese, Irish beauty Kelia Moniz grew up in a surfing "
          + "family that spends more time in the water than on land. Raised with four brothers and an ex-professional "
          + "surfer for a father, Kelia (known by friends and family as Sister) definitely knows how to surf with the boys. "
          +"She proved her merit last year by being the only girl to make it to the semifinals in the noseriding event at "
          + "the Corona Hawaiian Open.";

    SurferDB.addSurfer(new SurferFormData("Kelia Moniz", "Kauai", "", carouselUrl, bioUrl, bio, "kmoniz", "Female"));
    
    // Kaulana Apo
    carouselUrl = "http://www.surfermag.com/hot-100/img/grm10.jpg";
    bioUrl = "http://2.bp.blogspot.com/_IMTICxzEzp4/SJaw9VFQ1UI/AAAAAAAAAnY/RVzUwE8A-eI/s320/kaulana.jpg";
    bio = "Watching 11-year-old Kaulana Apo (Oahu, Hawaii) tackle the largest South Shore swell to hit the Islands "
          + "this year is a window on the future. Sitting down with him and his parents on shore leaves little doubt "
          + "that this kid has everything it takes to make it big.";
        
    SurferDB.addSurfer(new SurferFormData("Kaulana Apo", "Oahu, Hawaii", "", carouselUrl, bioUrl, bio, "kapo", "Grom"));
  }
}
