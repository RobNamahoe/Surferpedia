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
    UserInfoDB.addAdmin("Administrator", adminEmail, adminPassword);

    // Males
    type = "Male";
    
    name = "John John Florence";
    home = "Honolulu, Hawaii";
    country = "USA";
    awards = "2003 1st NSSA Nationals Open Mini Grom";
    footStyle = "Regular";
    carouselUrl = "http://snowbrains.com/wp-content/uploads/2013/05/981517-john-john-florence.jpg";
    bioUrl = "http://beckersurf.com/blog/wp-content/uploads/2013/08/JOHNJOHN-AI-AWARD-TEAHUPOO-2013.jpg";
    slug = "jjflorence";
    bio = "JJ Florence (born 18 October 1992, Honolulu, Hawaii) is a Hawaiian surfer. John John Florence, "
        + "the oldest of three children, grew up in Hale'iwa, in an ocean-side house at the Banzai Pipeline. "
        + "He resides with his mother, Alexandra, and his two younger brothers Nathan and Ivan. He was "
        + "introduced to surfing by Alexandra, who is a surfer herself. Florence claims he rode a surf board "
        + "at the age of six months, wearing a life vest on his father John's board; he was riding on his own "
        + "by the age of three. He is known now for his spectacular aerial abilities.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Ezekiel Lau";
    home = "Honolulu, Hawaii";
    country = "USA";
    awards = "2012 ASP World Junior Championship (2nd place)";
    footStyle = "Regular";
    bioUrl = "http://i.cdn-surfline.com/surfnews/images/2011/11_november/hic_pro_final/full/"
           + "EzekielLauPodium_BernieBaker.jpg";
    carouselUrl = "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2012/06/zeke-lau-carey47.jpg";
    slug = "ezekiellau";
    bio = "Ezekiel Lau (better known as Zeke) is coming of age as a surfer and competitor right in front of our "
        + "eyes with some impressive and creative surfing. Zeke is known for having a unique blend of style, " 
        + "speed, and power. Ezekiel sets himself apart as a private school student at Kamehameha Schools "
        + "(an Institution for students of Hawaiian Ancestry) while pursuing a competitive surfing career "
        + "in which he claimed 4 National Titles. Surfing is his passion and he hopes you will develop a " 
        + "passion for watching him as he comes up in rank as the next generation of surfing’s’ finest.";

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
    bio = "Joel Parkinson is an Australian surfer who competes on the ASP (Association Of Surfing Professionals) "
        + "World Tour. After twelve years competing at the elite level on the ASP World Championship Tour, a "
        + "stretch that saw him win eleven elite ASP World Title Events, plus nine additional ASP tour events, " 
        + "and achieve runner-up second place to the ASP World Title four times, Parkinson won his only ASP World " 
        + "Championship Tour Surfing Title on 14 December 2012 in Hawaii at the Banzai Pipeline during the ASP "
        + "World Tours' final event for 2012–the Billabong Pipeline Masters. Parkinson hung on in a grueling " 
        + "back and forth battle with eleven-time ASP World Title holder, Kelly Slater, to get his first World " 
        + "Title, as well as go on to win the highly-coveted Pipeline Masters, only after Slater lost his " 
        + "semi-final heat toJosh Kerr, of Queensland, Australia. Parkinson beat Kerr in the finals of the " 
        + "event, which was his seventh top-five placing for the year, and his first event title win for 2012.";

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
    bio = "Jérémy Florès (born Reunion Island, April 27, 1988) is a French surfer who grew up on Reunion Island, " 
        + "France, where he began surfing at the age of 3. He continued his surfing development on family trips to " 
        + "Australia, Europe and Hawaii, all the while maintaining his education through correspondence courses. "
        + "He turned professional in 2007, the same year in which he was awarded 'Rookie of the Year' by the ASP, "
        + "and in 2010 he won the prestigious Billabong Pipeline Masters in Hawaii.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "CJ Hobgood";
    home = "Melbourne, Florida";
    country = "USA";
    awards = "2001 ASP Men's World Champion";
    footStyle = "Goofy";
    bioUrl = "http://cdn.surf.transworld.net/files/2009/07/15/fiji-081386.jpg";
    carouselUrl = "http://www.steveryan.com.au/wp-content/uploads/galleries/post-59/full/"
                + "C%20J%20Hobgood%20Teahupoo%201%20Steve%20Ryan.jpg";
    slug = "cjhobgood";
    bio = "Clifton James 'C.J.' Hobgood (born July 6, 1979 in Melbourne, Florida) is an Association of Surfing "
        + "Professionals (ASP) World Championship surfer. C.J. has a twin brother, Damien Hobgood. They both "
        + "compete in top-tier professional surfing events around the world. C.J. entered his first surfing " 
        + "contest in 1989 and made the Open Boys final. He placed second in a national competition the following "
        + "year. He won several other championships and in 1998 he was selected as the model for the new National "
        + "Scholastic Surfing Association logo. In 1999, CJ was the Association Surfer Professionals Rookie of "
        + "the Year.[1] In 2001 he won the ASP World Championship. He currently resides in Satellite Beach, "
        + "Florida with his wife and daughter, near his younger brother Travis, his younger sister Marissa, and "
        + "his parents. Along with surfing, C.J. also plays tennis, and his filmography includes Noah's Ark, The "
        + "Outsiders produced by Walkingonwater.org, Down the Barrel (2007), Inaugural Hobgood Challenge (2007), "
        + "Somewhere, Anywhere, Everywhere. He has recently won the 2007 US Open of Surfing. He has also recently "
        + "won the O'Neill World Cup of Surfing at Sunset Beach, Part of the Van's Triple Crown of Surfing "
        + "Competition, in Hawaii in 2008.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Rabbit Kekai";
    home = "Honolulu, Hawaii";
    country = "USA";
    awards = "1973, 1980, 1984, 1988 United States Surfing Champion";
    footStyle = "Regular";
    bioUrl = "http://cdn.business.transworld.net/wp-content/blogs.dir/1/files/2012/07/Rabbit_press-release-copy2.jpg";
    carouselUrl = "http://encyclopediaofsurfing.com/wp-content/uploads/2012/08/Rabbit_Kekai_Queens.jpg";
    slug = "rabbitkekai";
    bio = "Born November 11th, 1920, Rabbit Kekai rode his first wave in 1925. For more than eighty years the "
        + "ocean has been his playground, his home and his own personal arena of excellence. He is an icon and "
        + "mainstay in surfing's elite history. Rabbit obtained international notoriety in the newsreels of the "
        + "40's and 50's when the rest of the world was first introduced to men riding wooden planks in the "
        + "pristine waters and surf of the Hawaiian Islands. His contest record is unparalleled and he is still "
        + "winning contests around the globe. His knowledge of the sea has made him a Master Waterman and he has "
        + "successfully competed in paddleboard racing, tandem surfing, canoeing, outriggers and surfing contests. "
        + "At 80, Rabbit is still one of the toughest competitors you'll ever face in a heat. His life and "
        + "exploits have made him an icon in the sport, but anyone who has ever met this man has found a truly "
        + "humble and most generous person. Having long been considered the King of Hawaiian Surf Lore, Rabbit "
        + "is the ultimate storyteller. He weaves stories of legendary surf and the people who mastered the sport.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Kelly Slater";
    home = "Cocoa Beach, Florida";
    country = "USA";
    awards = "11-time World Surfing Champion, Laureus World Sports Award for Action Sportsperson of the Year";
    footStyle = "Regular";
    bioUrl = "http://ilarge.listal.com/image/4729736/936full-kelly-slater.jpg";
    carouselUrl = "http://stabmag.com/wp-content/uploads/2013/04/Kelly2.jpg";
    slug = "kellyslater";
    bio = "Robert Kelly Slater (born February 11, 1972, Cocoa Beach, Florida, US) is an American professional "
        + "surfer known for his competitive prowess and style. He has been crowned ASP World Champion a record "
        + "11 times, including 5 consecutive titles from 1994-98. He is the youngest (at age 20) and the oldest "
        + "(at age 39) to win the title. Upon winning his 5th world title in 1997, Slater passed Australian "
        + "surfing legend Mark Richards to become the most successful champion in the history of the sport. "
        + "In 2007 he also became the all-time leader in career event wins by winning the Boost Mobile Pro event "
        + "at Lower Trestles near San Clemente, California. The previous record was held by Slater's childhood "
        + "hero, 3-time world champion Tom Curren.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Sunny Garcia";
    home = "Maili, Hawaii";
    country = "USA";
    awards = "2000 ASP WCT World Champion, 6-time Triple Crown of Surfing Title";
    footStyle = "Regular";
    bioUrl = "http://uemurasurfboards.com/wp-content/uploads/2012/09/Screen-shot-2012-09-04-at-12.10.19-PM.png";
    carouselUrl = "http://images.fineartamerica.com/images-medium-large/sunny-garcia-surfing-at-bowls-paul-topp.jpg";
    slug = "sunnygarcia";
    bio = "Sunny Garcia was born Vincent Sennen Garcia on January 14, 1970 in Ma'ili, on the Westside of Oahu, "
        + "Hawaii. He grew up in Wai'anae and after leaving school, debuted on the 1986 Gotcha Pro at Sandy "
        + "Beach, Oahu, beating the 1984 champ Tom Carroll. His top surfing achievement was becoming the ASP "
        + "WCT World Champion in 2000 but Garcia also holds the record for most WQS event wins, 22, and holds "
        + "six Triple Crown of Surfing titles. In addition, he was the second professional surfer to win over "
        + "$1 million in prize money. He initially retired in 2005 but is now competing again, although in 2008, "
        + "his hopes for ASP World Tour qualification were dashed with early elimination in the O'Neill World "
        + "Cup of Surfing.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Adriano De Souza";
    home = "Guaruja, Sao Paulo";
    country = "Brasil";
    awards = "2009, 2011, 2012 ASP Mens World Title (5th place)";
    footStyle = "Regular";
    bioUrl = "http://4.bp.blogspot.com/-QH0CyNqHvTs/UZp5rVm69_I/AAAAAAAB2H0/Goh27iKVwJM/s1600/"
           + "adriano-de-souza-portrait.jpg";
    carouselUrl = "http://encyclopediaofsurfing.com/wp-content/uploads/2013/03/De-Souza_Bielmann.jpg";
    slug = "adrianodesouza";
    bio = "Adriano De Souza rode his first wave at eight years old and eight years later the surf world would "
        + "take notice of this young, talented surfer at the Billabong ASP World Junior Championships. At the "
        + "2004 event, he defeated opponents four years his senior and was named the youngest ASP World Junior "
        + "Champion ever at 16. Spectators observed his fast, energetic surfing and he quickly became known as "
        + "one of the most exciting surfers to watch. In 2005, he won the ASP WQS by the widest margin in "
        + "history. That win took him into his first year on the ASP World Tour where he finished an impressive "
        + "18th in the world. Although his style is more conducive to smaller beachbreaks, he is showing his "
        + "competitors that he can also handle big wave surf, giving his country hope that he has what it takes "
        + "to transition from a junior champion to something much more. To date, he's one of the most ferocious "
        + "competitors the sport has ever seen and it shows in the ratings, with consistent top 10 overall "
        + "finishes since 2008, positioning himself as a serious contender for a world title.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Eddie Aikau";
    home = "Kahului, Maui, Hawaii";
    country = "USA";
    awards = "1971 Lifeguard of the Year";
    footStyle = "Regular";
    bioUrl = "http://upload.wikimedia.org/wikipedia/en/a/ae/Eddie_Aikau.jpg";
    carouselUrl = "http://www.eddieaikaufoundation.org/photos/p02.jpg";
    slug = "eddieaikau";
    bio = "Edward Ryon Makuahanai Aikau was a well-known Hawaiian "
        + "lifeguard and surfer. As the first lifeguard at Waimea Bay on the island of Oahu, he saved many lives "
        + "and became famous for surfing the big Hawaiian surf, winning several awards including the 1977 Duke "
        + "Kahanamoku Invitational Surfing Championship. Born in Kahului, Maui, Aikau was the third child of "
        + "Solomon and Henrietta Aikau. Aikau first learned how to surf at Kahului Harbor on its shorebreak. He "
        + "moved to Oahu with his family in 1959, and at the age of 16 left school and started working at the "
        + "Dole pineapple cannery; The paycheck allowed Aikau to buy his first surfboard. In 1968, he became the "
        + "first lifeguard hired by the City & County of Honolulu to work on the North Shore. The City & County "
        + "of Honolulu gave Aikau the task of covering all of the beaches between Sunset and Haleiwa. Not one life "
        + "was lost while he served as lifeguard of Waimea Bay, as he braved waves that often reached 30 feet "
        + "(9.1 m) high or more. In 1971, Aikau was named Lifeguard of the Year.";
    
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    
    // Females
    type = "Female";
    
    name = "Kelia Moniz";
    home = "Hawaii";
    country = "USA";
    awards = "ASP Longboard World Title";
    footStyle = "Goofy";
    carouselUrl = "http://4.bp.blogspot.com/_tPLV5CkprP4/TRFKxIZIlbI/AAAAAAAAAKo/ZZJVtwpj3b0/"
                + "s1600/20101218_PipeLine-010.jpg";
    bioUrl = "http://www1.pictures.zimbio.com/gi/DVF+Loves+ROXY+Launch+hiadGWypmZUl.jpg";
    slug = "keliamoniz";
    bio = "Multi-talented Japanese, Hawaiian, Portuguese, Chinese, Irish beauty Kelia Moniz grew up in a surfing "
        + "family that spends more time in the water than on land. Raised with four brothers and an ex-professional "
        + "surfer for a father, Kelia (known by friends and family as Sister) definitely knows how to surf with "
        + "the boys. She proved her merit last year by being the only girl to make it to the semifinals in the "
        + "noseriding event at the Corona Hawaiian Open.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Carissa Moore";
    home = "Honolulu, Hawaii";
    country = "USA";
    footStyle = "Regular";
    awards = "2013 ASP Womens World Champion, 2011 ASP Womens World Champion, The US Glamour Award for "
           + "Woman of the Year";
    carouselUrl = "http://image1.redbull.com/rbcom/010/2012-09-19/1331576671326_1/0010/1/1500/1000/1/"
                + "carissa-moore-in-mexico-2010.jpg";
    bioUrl = "http://media.outsideonline.com/images/719*488/Gallery_CarissaMoore3_08052011.jpg";
    slug = "carissamoore";
    bio = "At only 17, Carissa has already tallied quite an impressive competitive record. She is the most decorated "
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

    name = "Paige Hareb";
    home = "New Plymouth, New Zealand";
    country = "New Zealand";
    awards = "2013 ASP Womens Star Ranking (8th place), Drug Aware Pro Margaret River (2008) ASP 6-Star";
    footStyle = "Goofy";
    bioUrl = "http://www.ultimatenzsoccer.com/Personalities/26f555ff0.jpg";
    carouselUrl = "http://surf.co.nz/media/uploads/2011/06/Paige_Hareb_WSG2011_.jpg";
    slug = "paigehareb";
    bio = "As the lone (and first-ever) New Zealander on Tour, Paige Hareb possesses the rare combination of "
        + "innate talent, good looks, and understated charisma that have ushered her on a peerless path from "
        + "local standout to worldwide phenomenon. In her rookie year on Tour, the dynamic goofyfooter made her "
        + "mark with a semifinal finish at Snapper, as well as quarterfinal finishes at Bells and Peru. In 2009, "
        + "she also used her local connections and star-power to help bring the first World Tour event in ASP "
        + "history to New Zealand in April this year. Though Paige is a bit on the quiet side, her quick, light "
        + "backside hack and her arsenal of progressive maneuvers speak for themselves—loudly.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Tyler Wright";
    home = "Lennox Head, New South Wales";
    country = "Australia";
    awards = "2012 ASP Womens World Title (4th place), 2011 ASP Womens World Title (4th place)";
    footStyle = "Regular";
    bioUrl = "http://media.melty.fr/article-957237-ajust_930/l-australienne-tyler-wright.jpg";
    carouselUrl = "http://www.elitismstyle.com/blogazine/wp-content/uploads/2013/05/tyler-wright.jpg";
    slug = "tylerwright";
    bio = "Following in the footsteps of older brother Owen, 16-year old Aussie Tyler Wright detonated "
        + "mind-boggling performances on the ASP World Ranking to finish at No. 3 overall and solidify her "
        + "position on the Top 17 at only 16 years of age. Wright’s title as a childhood prodigy is due to an "
        + "impressive list of accolades including her win at the Beachley Classic at just 14 years of age, "
        + "making her the youngest surfer of all time to win an ASP World Tour event. The young powerhouse "
        + "showed she’s only just begun however; as she went on to clinch the O’Neill World Cup of Surfing "
        + "last year, showing the remainder of this year’s Top 17 that she’ll be a dangerous draw in 2011.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Bianca Buitendag";
    home = "Victoria Bay, South Africa";
    country = "South Africa";
    awards = "2012 ASP Womens Star Ranking (2nd place), 2011 Billabong ASP World Junior Surfing Champion";
    footStyle = "Goofy";
    bioUrl = "http://a0.twimg.com/profile_images/378800000115523669/82d7e344b5c14bf9217bc63be8536621.jpeg";
    carouselUrl = "http://www.zigzag.co.za/wp-content/gallery/womens-day/9bianca3.jpg";
    slug = "biancabuitendag";
    bio = "Bianca grew up in a Surfing family with two brothers, surfing from age 7.  She learned to surf in "
        + "the beach breaks of the Strand as well as at the Jongensfontein point break.  The family then moved "
        + "to Victoria Bay when she was age 11.  It was here that Bianca started focusing more on competitive "
        + "surfing.  Bianca soon stood out at a young age winning the Billabong u/20 girls finals at age 13 as "
        + "well as coming 9th at Mr Price WQS at age 14.  By the year 2009 Bianca won every single contest she "
        + "entered in South Africa. - See more at: http://www.biancabuitendag.com/me/#sthash.w1bOthGP.dpuf";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Sofia Mulanovich";
    home = "Lima, Peru";
    country = "Peru";
    awards = "2004 ASP Women’s World Champion";
    footStyle = "Regular";
    bioUrl = "http://www.fanphobia.net/uploads/actors/16940/sofia-mulanovich-profile-picture.jpg";
    carouselUrl = "http://a4.espncdn.com/photo/2013/0924/as_surf_riss_2048.jpg";
    slug = "sofiamulanovich";
    bio = "Professional surfer Sofia Mulanovich grew up in Punta Hermosa, a small town outside of Lima, where she "
        + "rode a body board at 5 and graduated to a short board by age 9. At 12, she sharpened her lethal backside "
        + "skills on Peru's many perfect lefts. Encouraged and nurtured by her family and friends, Sofia's "
        + "natural surfing talent soon gave way to major results as she charged against the boys in local "
        + "competitions. She turned pro in 1999 at the age of 16, already well into five consecutive Peruvian "
        + "National Championships and scored a sponsorship from ROXY that same year. Nicknamed 'La Gringa' "
        + "back home for her blue eyes and blond-streaked hair, Sofia has drive, graciousness and uncanny "
        + "natural surf ability in her DNA, all the makings of a true athletic hero. Fearless Sofia is known "
        + "for her persistence and commitment to the sport of surfing. Sofia's turn on the world stage began "
        + "with an impressive year on the World Qualifying Series in 2002, ultimately earning her a spot on "
        + "the World Championship tour. Ever determined, she nabbed the 2003 WCT Rookie of the Year title with "
        + "her hard-charging style, finishing the season with a top-ten ranking. 2004 started off with an "
        + "auspicious win. In Salinas, Ecuador she took the title of 2004 ISA World Champion, propelling the "
        + "Peruvian teams standing to an unprecedented fourth place with her win. This marked the beginning of "
        + "greatness for Sofia and her country. She rocked the 2004 WCT season with three consecutive wins in "
        + "Fiji, Tahiti and France and second places at the US Open and the ROXY Pro in Haleiwa.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Nikki van Dijk";
    home = "Phillip Island, Australia";
    country = "Australia";
    awards = "ASP 6-Star Pantin Classic Galicia Pro Champion";
    footStyle = "Regular";
    bioUrl = "http://farm6.staticflickr.com/5100/5584076462_a2fc01a97b.jpg";
    carouselUrl = "http://surfersinsuits.com.au/wp-content/uploads/2013/02/Screen-shot-2013-02-13-at-11.10.54-AM.jpg";
    slug = "nikkivandijk";
    bio = "Nikki's Dad taught her to surf on the beaches of Phillip Island, where she has grown (is still growing) "
        + "up. At the tender age of 10 Nikki was talent spotted by Rip Curl and in 2007 was the youngest ever "
        + "State Junior Champion, taking out the Quiksilver State Championships at just 12 years of age. At "
        + "14, Nikki won the local trials for a wildcard to compete in the main event of the Rip Curl "
        + "Women’s Pro in 2009. After surfing her way to 9th place she was knocked out by team mate Steph "
        + "Gilmore. Now 15, Nikki has been concentrating on the Pro Junior Series and is aiming for the "
        + "World Tour one day.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Karina Petroni";
    home = "American Canal Zone, Isthmus of Panama";
    country = "Panama";
    awards = "N/A";
    footStyle = "Regular";
    bioUrl = "http://farm3.staticflickr.com/2194/2030449665_d2b3bb4651_b.jpg";
    carouselUrl = "http://neverquitnever.com/wordpress/wp-content/uploads/2-karina-indonesia1.jpg";
    slug = "karinapetroni";
    bio = "Articulate, driven and vivacious, Karina is 22 years old and has made quite a name for herself in the "
        + "international surf world. Surfing since she was two and competing since she was nine years old, Karina "
        + "holds numerous wins including winning the Eastern, U.S. and National Championship titles in the same "
        + "year, and has back-to-back silver medals in the World Jr Games. Karina was, and still is, the last "
        + "female from the East Coast of America to qualify for the ASP World Championship Tour. From a very "
        + "young age, Karina has been endorsed by many labels such as Roxy,Vans, Body Glove, Chevrolet, "
        + "SoBe/Pepsi, Oakley, Casio and more. As she entertains the offers that are pouring in, she is very "
        + "selective and meticulous about her image and the sponsors she represents.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Pauline Ado";
    home = "Bayonne, France";
    country = "France";
    awards = "Caixanova Surfing Girls Pantin (2007) ASP 3-Star, 2013 ASP Womens World Title (9th place)";
    footStyle = "Regular";
    bioUrl = "http://cdn2.coresites.mpora.com/cooler_new/wp-content/uploads/2012/07/Pauline-Ado-portrait.jpg";
    carouselUrl = "http://blog.surf-prevention.com/wp-content/uploads/2011/12/pauline-ado.jpg";
    slug = "paulineado";
    bio = "Pauline Ado was not born into a surfing family – but she was born of the generation where anything is "
        + "possible. At the tender age of eight, Pauline asked her parents for a surfboard. She loved the feeling "
        + "of being in the ocean and the challenge of taking on its ever-shifting moods. Ironically she hated "
        + "competition. That is, until she started winning. Pauline was 10 when she scalped her first victory and "
        + "it wasn’t long before sponsorship deals were flooding her mailbox and she was jetting off to exotic "
        + "surf breaks to trade waves with her surfing idols. At 13, Pauline was selected to represent the French "
        + "Junior Surfing Team. Two years later, she would make surfing history, winning the ISA World Games, "
        + "producing the first World Title for France. A perfectionist by nature, Pauline’s meticulous preparation "
        + "and precision-technique earned her an ASP World Junior Title in 2008, putting European women’s surfing "
        + "firmly on the world map. Balancing a rigorous competition schedule with the increasing demands of her "
        + "senior school year, Pauline opted to finish her studies via correspondence, allowing her to focus "
        + "exclusively on her dream of qualifying for the Elite ASP Women’s World Title Tour. Pauline’s thirst "
        + "for victory, coupled with a flair for tactical surfing, has seen her pierce the Top Ten in her "
        + "rookie season. In 2011 Pauline set another benchmark by qualifying as the first ever European woman "
        + "for a second year in the prestigious ASP World Tour. She says: 'I try to surf with people better "
        + "than me as motivation, to push me to grow. I watch some of the top girls and try to work out their "
        + "strategies, what type of maneuvers score them the highest points, and then I build that into my "
        + "own performances.'";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    name = "Megan Abubo";
    home = "Hartford, Connecticut";
    country = "USA";
    awards = "2004 WCT Rip Curl Malibu Pro";
    footStyle = "Regular";
    bioUrl = "http://farm3.static.flickr.com/2120/2037051178_13ee5c327f.jpg";
    carouselUrl = "http://www.lat34.com/_/Photo/_/megan_abubo05hornbaker.jpg";
    slug = "meganabubo";
    bio = "Growing up in Hawaii, Megan quickly became one of the 'beach boys' and worked her way to a spot on "
        + "the World Championship Tour ranks in 1998. She has been on the WCT ever since and in 2000 she was "
        + "runner up for the world title. She has had many victories both in and out of the water. In October "
        + "2004 Megan won the WCT Rip Curl Malibu Pro and shot from 14th to 9th in the ratings. In 2002, she "
        + "won the WCT Figueira Pro in Portugal, and in 2001 she won the WCT Roxy Pro in Fiji. Throughout her "
        + "career she has had 5 other WCT victories.";

    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
    
    // Groms
    type = "Grom";
    
    name = "Kaulana Apo";
    home = "Oahu, Hawaii";
    country = "USA";
    awards = "N/A";
    footStyle = "Goofy";
    carouselUrl = "http://www.surfermag.com/hot-100/img/grm10.jpg";
    bioUrl = "http://2.bp.blogspot.com/_IMTICxzEzp4/SJaw9VFQ1UI/AAAAAAAAAnY/RVzUwE8A-eI/s320/kaulana.jpg";
    slug = "kaulanaapo";
    bio = "Goofy footer from Ewa Beach Having honed his polished surf style on the rippable peaks of Kewalo "
        + "Basin, Kaulana Apo is quickly headed for big things. And it might not just be surfing. Kaulana "
        + "is focused on doing well in school, and is interested in art. While a lot of junior surfers have "
        + "one track minds, Kaulana is a unique and creative talent.";
    
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
    bio = "At the age of 4 Kyuss featured on the front cover of the local newspaper surfing across a green face "
        + "solo out the Pass and with a stance that true of a grounded point surfer. Kyuss’s surfing talents "
        + "were soon noticed by the surf brands and was sponsored by Volcom at the age of 6. Kyuss loved "
        + "competing and went on to win many national junior events over the past years and recently claimed "
        + "the 2011 U12 NSW State Titles Championship and added 2 perfect 10 point rides at state level.";

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
    bio = "Many young surfers have the potential to make an impact on our sport, but none look more poised to "
        + "do so than Jake Marshall. Raised on the rippable beachbreaks and reefs of San Diego’s North County, "
        + "Jake has developed a solid base of smooth rail work as well as the kind of flair that few 14-year-old "
        + "surfers can match. His progression is due in no small part to the numerous world-class talents in his "
        + "neighborhood that have taught him a thing or two about tearing Seaside apart.";
    
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
    bio = "Mexican surfing supergrom, Sebastian Williams, 12, looks set to make a huge impression amongst South "
        + "Africa’s top junior surfers when he competes in the inaugural RVCA Junior Series in Jeffreys Bay "
        + "from 22-24 March. On his first trip to the country with his father, former Durbanite Tim Williams, "
        + "Sebastian had everyone who saw him surfing in Cape Town on the weekend asking, 'Who is that kid?', "
        + "with his phenomenal talent in the waves, cutting edge equipment and mature attitude. Rated in the "
        + "prestigious Surfer Mag ‘Hot 100 Groms’ list in both 2011 and 2012, Sebastian already has a signature "
        + "range of Firewire surfboards (the Sebastian Williams Pro Model), a signature deckpad by Sticky Bumps "
        + "(the Williams), endorses Futures Fins and has his own YouTube channel (YouTube.com/SebastianSurfer) "
        + "which has received more than 70 000 views since 2009.";
    
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
    bio = "Whilst born in Panama, the formative years of Nomme Mignot’s life was spent was onboard his nomadic "
        + "parents’ yacht, sailing and surfing the waves of the South Pacific, Central America, South America, "
        + "the Caribbean, Australia, Europe and North America. Eventually finding a home on dry land in the " 
        + "Mexican surf village of Sayulita, Nayarit, Nomme began to hone his skills at a young age alongside " 
        + "some of the top professional surfers in Mexico, as well as his elder cousin Diego. The result is an "
        + "exceptional well-rounded athlete, both in and out of the water. Although a natural wit, in any of "
        + "the three languages he speaks fluently, it is his results in the ocean that have seen him earmarked "
        + "as a future star. In 2012 he came fifth in the  ISA World Championships as well as winning the French "
        + "King Of The Groms title, all while improving his ranking on the ASP European Junior Series.  Nomme "
        + "represents of a new generation of surfers, one that combines powerful carves and progressive aerials, "
        + "comfortable in any waves, anywhere. Our advice is to look out for Nomme Mignot, it is a name that will "
        + "be a big part in pushing the sport of surfing.";
    
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
    bio = "Quincy was born in Montauk, New York; at just 7-years-old she started surfing. With the shore as her "
        + "backyard, Quincy spent long summer days at the beach with her family who were always surfing. After "
        + "becoming bored of swimming and running around she decided to give surfing a try.[2] She picked it up "
        + "quickly with the help of her brother and father teaching her[3] and she never stopped. She started "
        + "attending local surf events with older friends and would sometimes compete herself but always against "
        + "the boys because there weren't any other girls in her age division. Her amateur career started when "
        + "she came home with trophies and her mother decided to enter her into more events. Quincy accredits "
        + "her family and friends for her constant surfing inspiration and support. Her family has a home in "
        + "Rincon, Puerto Rico where they spend their winters.[4] Splitting her time between her two homes, "
        + "Quincy enjoys traveling and competing worldwide and hopes to one day qualify for the ASP Women’s "
        + "WCT. Like most young women, Quincy has passions outside of the surf world that include music, "
        + "Christmas movies and all things fashion. In 2013, Quincy collaborated with her sponsor Volcom, "
        + "inspiring and designing a clothing collection for Spring and Fall.";
    
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
    bio = "The 14-year-old Costa-Rica-born-Hawaiian-pro-skater-slash-pro-surfer is looking very uncomfortable "
        + "seated across from me at a roadside eatery in Bali. The World Junior Championships are on and as of "
        + "yesterday, he is now the highest ranked surfer in the world for his age (having lost out in Round 4 "
        + "to one of the event favorite's, Conner Coffin). His strengths are airs and his weaknesses are "
        + "definitely turns. He's working on turns. He's been filming a lot lately, and has some footage "
        + "of his turns, so he wants to improve that. If he could combine more rail surfing with airs, he "
        + "thinks he'd do a lot better. As David confronts the painstaking decision of whether to pursue a "
        + "career in skating or surfing, you might think the injury toll alone would be enough to make up "
        + "his mind. But you'd be wrong. 'If it was life or death, and I had to choose skating or surfing, "
        + "I'd choose death,' he says.";
    
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
    bio = "Kolohe Andino (born March 22, 1994 in San Clemente, California) is an American surfer. He began to "
        + "surf at age 10 and holds the record for the most National Scholastic Surfing Association championships "
        + "won by a male competitor. He won both the ASP 6-Star Quicksilver Brazil Open of Surfing and the Vans "
        + "Pier Classic world tour events in 2011. Andino's sponsors include Oakley eyewear and Hurley wetsuits "
        + "and clothing.";
    
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
    carouselUrl = "http://a.espncdn.com/combiner/i?img=/media/motion/2013/0429/actn_130429_Real_Women_Coco_Ho/"
                + "actn_130429_Real_Women_Coco_Ho.jpg&w=530";
    slug = "cocoho";
    bio = "Coco Malia Camille Hapaikekoa Ho (born April 28, 1991) is a professional Hawaiian surfer born in "
        + "Honolulu, Hawaii. She began surfing at 7-years-old, following in the footsteps of her family. In "
        + "2009 she was the youngest female ever to qualified for the Association of Surfing Professionals "
        + "Woman’s World Tour. Today, Coco has won over 25 surfing awards and has been voted a top three fan "
        + "favorite in Surfer magazine’s Surfer Poll.";
    
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }

    name = "Elliot Ivarra";
    home = "Saint Barthelemy";
    country = "France";
    awards = "2012 Quiksilver King of the Groms";
    footStyle = "Goofy";
    bioUrl = "http://www.elliot-ivarra.book-rider.com/uploads/thumbnails/uploads/profil/"
           + "a77b5e5848dcb248534edece7ab224c9a853188a_800x600.png";
    carouselUrl = "http://farm8.staticflickr.com/7076/7364657992_51ab5a08e7_z.jpg";
    slug = "elliotivarra";
    bio = "Elliot Ivarra, 16, was born in Saint Martin, but lives in Saint Barthelemy Island. French surfer "
        + "Elliot Ivarra won the European final of the Quiksilver King of the Groms in 3 feet fun waves at "
        + "Ericeira, Portugal. The young french surfer had won his ticket for the Quiskslver King Of the Groms "
        + "Euro Final thanks to his first place in trials yesterday. This place allowed him to compete in the "
        + "main event. In Ericeira, the Frenchman ruled this final heat of competition with several backside "
        + "tricks scoring to fun waves 5.83 pts then a last one 7.43 pts for a final score of 13.50 pts. His "
        + "domination upon Europe's best 16 and under surfers was unquestionable even if the young French kid "
        + "Nomme Mignot battled hard for the crown until the very last seconds of the heat. As he was leading "
        + "the final, Nomme, from Surfing French Team, let Elliot the victory. None the less, both of them will "
        + "fly to France to take part to the Quiksilver King of the Groms International final to be held during "
        + "the Quiksilver Pro France - an ASP World Tour event- (From September 27th to October 8th) gathering "
        + "the world's best surfers on the Landes coast. An extraordinary experience for these two groms.";
    
    if (!SurferDB.isSurfer(slug)) {
      SurferDB.addSurfer(new SurferFormData(name, home, country, awards, carouselUrl, bioUrl, bio, slug, type,
          footStyle));
    }
  }
}
