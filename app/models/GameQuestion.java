package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
      
  private Map<String, Boolean> surfersMap = new HashMap<>();

  /**
   * Default constructor method.
   */
  public GameQuestion() {
    
    int answerIndex = randInt(SURFER_GAME_MIN, SURFER_GAME_MAX) - 1;
    List<Surfer> surfers = getGameOptions();
    
    pictureUrl = surfers.get(answerIndex).getBioUrl(); // Url of the picture of the surfer to display.
    answer = surfers.get(answerIndex).getName();       // Get the winning information.
    
    for (int i = 0; i < surfers.size(); i++) {
      surfersMap.put(surfers.get(i).getName(), (i == answerIndex));
    }
    
  }

  /**
   * Get a list of surfer names to be used as options.
   * @return A list of surfer names.
   */
  public Map<String, Boolean> getOptions() {
    return this.surfersMap;
  }
  
  /**
   * Remove white space from a surfers name so it can be used as an id.
   * @param name The surfers name.
   * @return The surfers name with white space removed.
   */
  public String getAsId(String name) {
    return name.replaceAll("\\s+", "");
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
   * @param min Minimim value
   * @param max Maximim value.  Must be greater than min.
   * @return Integer between min and max, inclusive.
   */
  public static int randInt(int min, int max) {
      Random rand = new Random();
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
