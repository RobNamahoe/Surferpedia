package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Game-Question Game class.
 * @author Rob Namahoe
 */
public class GameQuestion { 
  
  private static final int SURFER_GAME_MIN = 1;
  private static final int SURFER_GAME_MAX = 5;
  
  private String pictureUrl = "";
  private String answer = "";
      
  private List<Surfer> surfers = new ArrayList<Surfer>();
  
  /**
   * Default constructor method.
   */
  public GameQuestion() {
    
    int answerIndex = randInt(SURFER_GAME_MIN, SURFER_GAME_MAX) - 1;
    surfers = getGameOptions();
    
    pictureUrl = surfers.get(answerIndex).getBioUrl(); // Url of the picture of the surfer to display.
    answer = surfers.get(answerIndex).getName();       // Get the winning information.
    
  }

  /**
   * Get a list of surfer names to be used as options.
   * @return A list of surfer names.
   */
  public List<String> getOptions() {
    List<String> options = new ArrayList<String>();
    for (Surfer surfer : surfers) {
      options.add(surfer.getName());
    }
    return options;
  }
  
/**
 * Get a list of surfers (of the same gender) from the database to use as game options.  
 * @return A list of surfers.
 */
  private List<Surfer> getGameOptions() {
    Gender gender = Gender.find().orderBy("RAND()").setMaxRows(1).findList().get(0);
    return Surfer.find().where().eq("gender", gender).orderBy("RAND()").setMaxRows(SURFER_GAME_MAX).findList();
  }
  
  
  /**
   * Returns a psuedo-random number between min and max, inclusive.
   * The difference between min and max can be at most
   * <code>Integer.MAX_VALUE - 1</code>.
   *
   * @param min Minimim value
   * @param max Maximim value.  Must be greater than min.
   * @return Integer between min and max, inclusive.
   * @see java.util.Random#nextInt(int)
   */
  public static int randInt(int min, int max) {

      // Usually this can be a field rather than a method variable
      Random rand = new Random();

      // nextInt is normally exclusive of the top value,
      // so add 1 to make it inclusive
      int randomNum = rand.nextInt((max - min) + 1) + min;

      return randomNum;
  }

  /**
   * @return the pictureUrl
   */
  public String getPictureUrl() {
    return pictureUrl;
  }

  /**
   * @param pictureUrl the pictureUrl to set
   */
  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }

  /**
   * @return the answer
   */
  public String getAnswer() {
    return answer;
  }

  /**
   * @param answer the answer to set
   */
  public void setAnswer(String answer) {
    this.answer = answer;
  }

}
