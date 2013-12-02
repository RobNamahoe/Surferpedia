import models.SurferDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
import views.formdata.SurferFormData;

/**
 * Global settings for the Play Application.
 * 
 * @author Rob Namahoe
 */
public class Global extends GlobalSettings {

  /**
   * Initialize the database with 3 surfers.
   * 
   * @param app The Play application.
   */
  public void onStart(Application app) {

    String name = "";
    String home = "";
    String country = "";
    String awards = "";
    String carouselUrl = "";
    String bioUrl = "";
    String slug = "";
    String type = "";
    String bio = "";
    String footStyle = "";

    String adminEmail = Play.application().configuration().getString("surferpedia.admin.email");
    String adminPassword = Play.application().configuration().getString("surferpedia.admin.password");

    System.out.println(adminEmail + "  " + adminPassword);

    UserInfoDB.addAdmin("Administrator", adminEmail, adminPassword);

    // John John Florence
    name = "John John Florence";
    home = "Honolulu, Hawaii";
    country = "USA";
    awards = "2003 1st NSSA Nationals Open Mini Grom";
    carouselUrl = "http://snowbrains.com/wp-content/uploads/2013/05/981517-john-john-florence.jpg";
    bioUrl = "http://beckersurf.com/blog/wp-content/uploads/2013/08/JOHNJOHN-AI-AWARD-TEAHUPOO-2013.jpg";
    slug = "jjflorence";
    type = "Male";
    bio =
        "JJ Florence (born 18 October 1992, Honolulu, Hawaii) is a Hawaiian surfer. John John Florence, "
            + "the oldest of three children, grew up in Hale'iwa, in an ocean-side house at the Banzai Pipeline. "
            + "He resides with his mother, Alexandra, and his two younger brothers Nathan and Ivan. He was "
            + "introduced to surfing by Alexandra, who is a surfer herself. Florence claims he rode a surf board "
            + "at the age of six months, wearing a life vest on his father John's board; he was riding on his own "
            + "by the age of three. He is known now for his spectacular aerial abilities.";

    footStyle = "Regular";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Ezekiel Lau";
    home = "Honolulu, Hawaii";
    country = "USA";
    awards = "ASP 4-Star HIC Pro Champion";
    footStyle = "Goofy";
    bioUrl = "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2011/02/ezekiel-lau.jpg";
    carouselUrl = "http://farm5.staticflickr.com/4073/4766299193_64be477cc8_z.jpg";
    slug = "ezekiellau";
    bio =
        "Ezekiel Lau (better known as Zeke) is coming of age as a surfer and competitor right in front of our eyes with some impressive and creative surfing. Zeke is known for having a unique blend of style, speed, and power. Ezekiel sets himself apart as a private school student at Kamehameha Schools (an Institution for students of Hawaiian Ancestry) while pursuing a competitive surfing career in which he claimed 4 National Titles. Surfing is his passion and he hopes you will developa passion for watching him as he comes up in rank as the next generation of surfing’s’ finest.";
    type = "Male";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Joel Parkinson";
    home = "Nambour, Queensland";
    country = "Australia";
    awards = "2012 Billabong Pipeline Masters Winner";
    footStyle = "Regular";
    bioUrl = "http://upload.wikimedia.org/wikipedia/commons/f/ff/Joelparkinson.jpg";
    carouselUrl = "http://www.surf-shop.org/wp-content/uploads/2013/02/joel-parkinson.jpg";
    slug = "joelparkinson";
    type = "Male";
    bio = "Joel Parkinson is an Australian surfer who competes on the ASP (Association Of Surfing Professionals) World Tour. After twelve years competing at the elite level on the ASP World Championship Tour, a stretch that saw him win eleven elite ASP World Title Events, plus nine additional ASP tour events, and achieve runner-up second place to the ASP World Title four times, Parkinson won his only ASP World Championship Tour Surfing Title on 14 December 2012 in Hawaii at the Banzai Pipeline during the ASP World Tours' final event for 2012–the Billabong Pipeline Masters. Parkinson hung on in a grueling back and forth battle with eleven-time ASP World Title holder, Kelly Slater, to get his first World Title, as well as go on to win the highly-coveted Pipeline Masters, only after Slater lost his semi-final heat toJosh Kerr, of Queensland, Australia. Parkinson beat Kerr in the finals of the event, which was his seventh top-five placing for the year, and his first event title win for 2012.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Jeremy Flores";
    home = "Reunion Island";
    country = "France";
    awards = "2009 ISA World Champion";
    footStyle = "Regular";
    bioUrl = "http://1.bp.blogspot.com/-15lZmzc6nD4/Tl06QEFQChI/AAAAAAAAAqs/gCMC1_7kh0s/s1600/22.jpg";
    carouselUrl = "http://cdn2.coresites.mpora.com/surfeurope_new/wp-content/uploads/2013/09/Jeremy-Flores1.jpg";
    slug = "jeremyflores";
    type = "Male";
    bio = "Jérémy Florès (born Reunion Island, April 27, 1988) is a French surfer who grew up on Reunion Island, France, where he began surfing at the age of 3. He continued his surfing development on family trips to Australia, Europe and Hawaii, all the while maintaining his education through correspondence courses. He turned professional in 2007, the same year in which he was awarded 'Rookie of the Year' by the ASP, and in 2010 he won the prestigious Billabong Pipeline Masters in Hawaii.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    // Females
    name = "Kelia Moniz";
    home = "Hawaii";
    country = "USA";
    awards = "ASP Longboard World Title";
    carouselUrl =
        "http://4.bp.blogspot.com/_tPLV5CkprP4/TRFKxIZIlbI/AAAAAAAAAKo/ZZJVtwpj3b0/"
            + "s1600/20101218_PipeLine-010.jpg";
    bioUrl = "http://www1.pictures.zimbio.com/gi/DVF+Loves+ROXY+Launch+hiadGWypmZUl.jpg";
    slug = "keliamoniz";
    type = "Female";
    bio =
        "Multi-talented Japanese, Hawaiian, Portuguese, Chinese, Irish beauty Kelia Moniz grew up in a surfing <p>"
            + "family </p>that spends more time in the water than on land. Raised with four brothers and an ex-professional "
            + "surfer for a father, Kelia (known by friends and family as Sister) definitely knows how to surf with "
            + "the boys. She proved her merit last year by being the only girl to make it to the semifinals in the "
            + "noseriding event at the Corona Hawaiian Open.";

    footStyle = "Goofy";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Carissa Moore";
    home = "Honolulu, Hawaii";
    country = "USA";
    footStyle = "Regular";
    awards =
        "2013 ASP Womens World Champion, 2011 ASP Womens World Champion, The US Glamour Award for Woman of the Year";
    carouselUrl =
        "http://image1.redbull.com/rbcom/010/2012-09-19/1331576671326_1/0010/1/1500/1000/1/carissa-moore-in-mexico-2010.jpg";
    bioUrl = "http://media.outsideonline.com/images/719*488/Gallery_CarissaMoore3_08052011.jpg";
    slug = "carissamoore";
    type = "Female";
    bio =
        "At only 17, Carissa has already tallied quite an impressive competitive record. She is the most decorated "
            + "surfer in NSSA history, with 11 National titles. In 2008, she re-wrote the record books with her win at "
            + "the 6-Star WQS Reef Hawaiian Pro at Haleiwa, becoming the youngest competitor in ASP history to take top "
            + "podium honors at a Vans Triple Crown event. In 2007, Carissa proved she can compete and win at the next "
            + "level, twice toppling Layne Beachley, the ranking legend on the women's tour and seven-time ASP World "
            + "Champ - all on her way to a second place finish at the Roxy Pro Gold Coast. Even more, surfing may have "
            + "finally found a girl who can not only play with, but also beat the boys. As a 14-year-old in '07, Carissa "
            + "beat out 57 of Hawaii's best boys 16 and Under, to become the first-ever female winner of a Quiksilver "
            + "King of the Groms regional event. A year prior, she took down a stacked field that included future ISA "
            + " World Junior Champion, Keanu Aising, in the Boys 14 and Under division of a Rip Curl Gromsearch event. "
            + "And perhaps the cherry on top of it all - the girl scored a perfect 10 in a men's WQS contest.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    // Kaulana Apo
    name = "Kaulana Apo";
    home = "Oahu, Hawaii";
    country = "USA";
    awards = "";
    carouselUrl = "http://www.surfermag.com/hot-100/img/grm10.jpg";
    bioUrl = "http://2.bp.blogspot.com/_IMTICxzEzp4/SJaw9VFQ1UI/AAAAAAAAAnY/RVzUwE8A-eI/s320/kaulana.jpg";
    slug = "kaulanaapo";
    type = "Grom";
    bio =
        "Goofy footer from Ewa Beach Having honed his polished surf style on the rippable peaks of Kewalo "
            + "Basin, Kaulana Apo is quickly headed for big things. And it might not just be surfing. Kaulana "
            + "is focused on doing well in school, and is interested in art. While a lot of junior surfers have "
            + "one track minds, Kaulana is a unique and creative talent.";

    footStyle = "Regular";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Kyuss King";
    home = "Byron Bay";
    country = "Australia";
    awards = "2011 U12 NSW State Titles Champion";
    footStyle = "Regular";
    bioUrl = "http://emerysurfboards.com/australia/wp-content/uploads/2011/05/Kyuss-Bali-May-June-2010-sml.jpg";
    carouselUrl = "http://kyussking.com/au/wp-content/uploads/2011/12/banner44.jpg";
    slug = "kyussking";
    type = "Male";
    bio =
        "At the age of 4 Kyuss featured on the front cover of the local newspaper surfing across a green face solo out the Pass and with a stance that true of a grounded point surfer. Kyuss’s surfing talents were soon noticed by the surf brands and was sponsored by Volcom at the age of 6. Kyuss loved competing and went on to win many national junior events over the past years and recently claimed the 2011 U12 NSW State Titles Championship and added 2 perfect 10 point rides at state level.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Jake Marshall";
    home = "Encinitas, CA";
    country = "USA";
    awards = "2013 King of the Groms";
    footStyle = "Regular";
    bioUrl = "http://www.nssa.org/photogallery/gallery/West_Coast_Championships/JakeMarshallperfect10web.jpg";
    carouselUrl = "http://www.surfingamerica.org/wp-content/uploads/2011/01/JakeMarshall_MG_3530-3.jpg";
    slug = "jakemarshall";
    type = "Grom";
    bio =
        "Many young surfers have the potential to make an impact on our sport, but none look more poised to do so than Jake Marshall. Raised on the rippable beachbreaks and reefs of San Diego’s North County, Jake has developed a solid base of smooth rail work as well as the kind of flair that few 14-year-old surfers can match. His progression is due in no small part to the numerous world-class talents in his neighborhood that have taught him a thing or two about tearing Seaside apart.";
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Sebastian Williams";
    home = "Oaxaca, Mexico";
    country = "Mexico";
    awards = "2nd at 2013 RVCA Junior Surf Series";
    footStyle = "Regular";
    bioUrl = "http://www.uaposurf.com/wp-content/uploads/2011/11/sebsatiandempsey.jpg";
    carouselUrl = "http://www.uaposurf.com/wp-content/uploads/2011/11/Sebastiancutback.jpg";
    slug = "sebastianwilliams";
    type = "Grom";
    bio =
        "Mexican surfing supergrom, Sebastian Williams, 12, looks set to make a huge impression amongst South Africa’s top junior surfers when he competes in the inaugural RVCA Junior Series in Jeffreys Bay from 22-24 March.  On his first trip to the country with his father, former Durbanite Tim Williams, Sebastian had everyone who saw him surfing in Cape Town on the weekend asking, 'Who is that kid?', with his phenomenal talent in the waves, cutting edge equipment and mature attitude. Rated in the prestigious Surfer Mag ‘Hot 100 Groms’ list in both 2011 and 2012, Sebastian already has a signature range of Firewire surfboards (the Sebastian Williams Pro Model), a signature deckpad by Sticky Bumps (the Williams), endorses Futures Fins and has his own YouTube channel (YouTube.com/SebastianSurfer) which has received more than 70 000 views since 2009.";
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Nomme Mignot";
    home = "French Basque";
    country = "France";
    awards = "1st King of the Groms 2012";
    footStyle = "Goofy";
    bioUrl = "http://media.melty.fr/article-1042978-ajust_930/nomme-mignot.jpg";
    carouselUrl = "http://isawjsc.com/2013/wp-content/gallery/event_day_3_selected/fra_nomme_mignot4_tweddle.jpg";
    slug = "nommemignot";
    type = "Grom";
    bio =
        "Whilst born in Panama, the formative years of Nomme Mignot’s life was spent was onboard his nomadic parents’ yacht, sailing and surfing the waves of the South Pacific, Central America, South America, the Caribbean, Australia, Europe and North America. Eventually finding a home on dry land in the Mexican surf village of Sayulita, Nayarit, Nomme began to hone his skills at a young age alongside some of the top professional surfers in Mexico, as well as his elder cousin Diego. The result is an exceptional well-rounded athlete, both in and out of the water. Although a natural wit, in any of the three languages he speaks fluently, it is his results in the ocean that have seen him earmarked as a future star. In 2012 he came fifth in the  ISA World Championships as well as winning the French King Of The Groms title, all while improving his ranking on the ASP European Junior Series.  Nomme represents of a new generation of surfers, one that combines powerful carves and progressive aerials, comfortable in any waves, anywhere. Our advice is to look out for Nomme Mignot, it is a name that will be a big part in pushing the sport of surfing.";
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Quincy Davis";
    home = "Montauk, New York";
    country = "USA";
    awards = "2009: 1st, Volcom Qualifying Series (Girls)";
    footStyle = "Regular";
    bioUrl = "http://www.oakley.com/a/56/ef/BAh7CGkKIgo0NjJ4MGkLbCsHPSN2UGkIaQPQ4wI.jpg";
    carouselUrl = "http://www.oakley.com/a/3f/3b/BAh7CGkKIgo4MDB4MGkLbCsHO16OUGkIaQMhBAM.jpg";
    slug = "quincydavis";
    type = "Grom";
    bio =
        "Quincy was born in Montauk, New York; at just 7-years-old she started surfing. With the shore as her backyard, Quincy spent long summer days at the beach with her family who were always surfing. After becoming bored of swimming and running around she decided to give surfing a try.[2] She picked it up quickly with the help of her brother and father teaching her[3] and she never stopped. She started attending local surf events with older friends and would sometimes compete herself but always against the boys because there weren't any other girls in her age division. Her amateur career started when she came home with trophies and her mother decided to enter her into more events. Quincy accredits her family and friends for her constant surfing inspiration and support. Her family has a home in Rincon, Puerto Rico where they spend their winters.[4] Splitting her time between her two homes, Quincy enjoys traveling and competing worldwide and hopes to one day qualify for the ASP Women’s WCT. Like most young women, Quincy has passions outside of the surf world that include music, Christmas movies and all things fashion. In 2013, Quincy collaborated with her sponsor Volcom, inspiring and designing a clothing collection for Spring and Fall.";
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Kalani David";
    home = "North Shore";
    country = "USA";
    awards = "Pipe Pro Jr Champion";
    footStyle = "Regular";
    bioUrl = "http://www.jackenglish.com/data/photos/458_1kalani_david_1.jpg";
    carouselUrl = "http://stwww.surfermag.com/files/2013/11/PP86801__AK_2832.jpg";
    slug = "kalanidavid";
    type = "Grom";
    bio =
        "The 14-year-old Costa-Rica-born-Hawaiian-pro-skater-slash-pro-surfer is looking very uncomfortable seated across from me at a roadside eatery in Bali. The World Junior Championships are on and as of yesterday, he is now the highest ranked surfer in the world for his age (having lost out in Round 4 to one of the event favorite's, Conner Coffin). His strengths are airs and his weaknesses are definitely turns. He's working on turns. He's been filming a lot lately, and has some footage of his turns, so he wants to improve that. If he could combine more rail surfing with airs, he thinks he'd do a lot better. As David confronts the painstaking decision of whether to pursue a career in skating or surfing, you might think the injury toll alone would be enough to make up his mind. But you'd be wrong. 'If it was life or death, and I had to choose skating or surfing, I'd choose death,' he says.";
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Kolohe Andino";
    home = "San Clemente, CA";
    country = "USA";
    awards = "Current ASP WT member";
    footStyle = "Regular";
    bioUrl = "http://26398e5a36ad91b5a363-88e7b269e17a6ac7041f918fba6da517.r63.cf4.rackcdn.com/Andino_800_800_83.jpg";
    carouselUrl = "http://i.telegraph.co.uk/multimedia/archive/01932/boy-in-barrel_1932060i.jpg";
    slug = "koloheandino";
    type = "Grom";
    bio =
        "Kolohe Andino (born March 22, 1994 in San Clemente, California) is an American surfer. He began to surf at age 10 and holds the record for the most National Scholastic Surfing Association championships won by a male competitor. He won both the ASP 6-Star Quicksilver Brazil Open of Surfing and the Vans Pier Classic world tour events in 2011. Andino's sponsors include Oakley eyewear and Hurley wetsuits and clothing.";
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Coco Ho";
    home = "Honolulu, Hawaii";
    country = "USA";
    awards = "2010 Supergirl Pro Junior 1st place";
    footStyle = "Regular";
    bioUrl = "http://www.beachbrother.com/beachblog/wp-content/uploads/2011/06/coco-ho-interview-300x320.jpg";
    carouselUrl =
        "http://a.espncdn.com/combiner/i?img=/media/motion/2013/0429/actn_130429_Real_Women_Coco_Ho/actn_130429_Real_Women_Coco_Ho.jpg&w=530";
    slug = "cocoho";
    type = "Grom";
    bio =
        "Coco Malia Camille Hapaikekoa Ho (born April 28, 1991) is a professional Hawaiian surfer born in Honolulu, Hawaii. She began surfing at 7-years-old, following in the footsteps of her family. In 2009 she was the youngest female ever to qualified for the Association of Surfing Professionals Woman’s World Tour. Today, Coco has won over 25 surfing awards and has been voted a top three fan favorite in Surfer magazine’s Surfer Poll.";
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Elliot Ivarra";
    home = "Saint Barthelemy";
    country = "France";
    awards = "2012 Quiksilver King of the Groms";
    footStyle = "Goofy";
    bioUrl =
        "http://www.elliot-ivarra.book-rider.com/uploads/thumbnails/uploads/profil/a77b5e5848dcb248534edece7ab224c9a853188a_800x600.png";
    carouselUrl = "http://farm8.staticflickr.com/7076/7364657992_51ab5a08e7_z.jpg";
    slug = "elliotivarra";
    type = "Grom";
    bio =
        "Elliot Ivarra, 16, was born in Saint Martin, but lives in Saint Barthelemy Island. French surfer Elliot Ivarra won the European final of the Quiksilver King of the Groms in 3 feet fun waves at Ericeira, Portugal. The young french surfer had won his ticket for the Quiskslver King Of the Groms Euro Final thanks to his first place in trials yesterday. This place allowed him to compete in the main event. In Ericeira, the Frenchman ruled this final heat of competition with several backside tricks scoring to fun waves 5.83 pts then a last one 7.43 pts for a final score of 13.50 pts. His domination upon Europe's best 16 and under surfers was unquestionable even if the young French kid Nomme Mignot battled hard for the crown until the very last seconds of the heat. As he was leading the final, Nomme, from Surfing French Team, let Elliot the victory. None the less, both of them will fly to France to take part to the Quiksilver King of the Groms International final to be held during the Quiksilver Pro France - an ASP World Tour event- (From September 27th to October 8th) gathering the world's best surfers on the Landes coast. An extraordinary experience for these two groms.";
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

  }
}
