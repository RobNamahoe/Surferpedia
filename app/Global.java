import models.SurferDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;

/**
 * Global settings for the Play Application.
 * @author Rob Namahoe
 */
public class Global extends GlobalSettings { 
  
  /**
   * Initialize the database with 3 surfers.
   * @param app The Play application.
   */
  public void onStart(Application app) { 
    
    String name = "";
    String home = "";
    String awards = "";
    String carouselUrl = "";
    String bioUrl = "";
    String slug = "";
    String type = "";
    String bio = "";
    String footStyle = "";
    
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    
    // John John Florence
    name = "John John Florence";
    home = "Honolulu, Hawaii";
    awards = "2003 1st NSSA Nationals Open Mini Grom";
    carouselUrl = "http://snowbrains.com/wp-content/uploads/2013/05/981517-john-john-florence.jpg";
    bioUrl = "http://beckersurf.com/blog/wp-content/uploads/2013/08/JOHNJOHN-AI-AWARD-TEAHUPOO-2013.jpg";
    slug = "jjflorence";
    type = "Male";
    bio = "JJ Florence (born 18 October 1992, Honolulu, Hawaii) is a Hawaiian surfer. John John Florence, "
        + "the oldest of three children, grew up in Hale'iwa, in an ocean-side house at the Banzai Pipeline. "
        + "He resides with his mother, Alexandra, and his two younger brothers Nathan and Ivan. He was " 
        + "introduced to surfing by Alexandra, who is a surfer herself. Florence claims he rode a surf board " 
        + "at the age of six months, wearing a life vest on his father John's board; he was riding on his own " 
        + "by the age of three. He is known now for his spectacular aerial abilities.";
    
    footStyle = "Regular";
    SurferDB.addSurfer(new SurferFormData(name, home, awards, carouselUrl, bioUrl, bio, slug, type, footStyle));
    
    // Kelia Moniz
    name = "Kelia Moniz";
    home = "Hawaii";
    awards = "ASP Longboard World Title";
    carouselUrl = "http://4.bp.blogspot.com/_tPLV5CkprP4/TRFKxIZIlbI/AAAAAAAAAKo/ZZJVtwpj3b0/"
                  + "s1600/20101218_PipeLine-010.jpg";
    bioUrl = "http://www1.pictures.zimbio.com/gi/DVF+Loves+ROXY+Launch+hiadGWypmZUl.jpg";
    slug = "kmoniz";
    type = "Female";
    bio = "Multi-talented Japanese, Hawaiian, Portuguese, Chinese, Irish beauty Kelia Moniz grew up in a surfing "
          + "family that spends more time in the water than on land. Raised with four brothers and an ex-professional "
          + "surfer for a father, Kelia (known by friends and family as Sister) definitely knows how to surf with " 
          + "the boys. She proved her merit last year by being the only girl to make it to the semifinals in the " 
          + "noseriding event at the Corona Hawaiian Open.";

    footStyle = "Goofy";
    SurferDB.addSurfer(new SurferFormData(name, home, awards, carouselUrl, bioUrl, bio, slug, type, footStyle));
    
    // Kaulana Apo
    name = "Kaulana Apo";
    home = "Oahu, Hawaii";
    awards = "";
    carouselUrl = "http://www.surfermag.com/hot-100/img/grm10.jpg";
    bioUrl = "http://2.bp.blogspot.com/_IMTICxzEzp4/SJaw9VFQ1UI/AAAAAAAAAnY/RVzUwE8A-eI/s320/kaulana.jpg";
    slug = "kapo";
    type = "Grom";
    bio = "Goofy footer from Ewa Beach Having honed his polished surf style on the rippable peaks of Kewalo " 
          + "Basin, Kaulana Apo is quickly headed for big things. And it might not just be surfing. Kaulana " 
          + "is focused on doing well in school, and is interested in art. While a lot of junior surfers have "
          + "one track minds, Kaulana is a unique and creative talent.";
        
    footStyle = "Regular";
    SurferDB.addSurfer(new SurferFormData(name, home, awards, carouselUrl, bioUrl, bio, slug, type, footStyle));
  }
}
