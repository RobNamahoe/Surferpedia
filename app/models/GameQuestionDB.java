package models;

/**
 * A repo to store game stats.
 * @author Rob Namahoe
 */
public class GameQuestionDB { 

  private static int wins;
  private static int losses;
  
  private static GameQuestion currentQuestion;
  
  /**
   * Get a new game question.
   * @return A new game question.
   */
  public static GameQuestion getNextQuestion() {
    currentQuestion = new GameQuestion();
    return currentQuestion;
  }
    
  /**
   * Reset number of wins and losses.
   */
  public static void resetStats() {
    wins = 0;
    losses = 0;
  }
  
  /**
   * Increment the wins total by one.
   */
  public static void addWin() {
    wins++;
  }
  
  /**
   * Increment the losses total by one.
   */
  public static void addLoss() {
    losses++;
  }
  
  /**
   * @return the wins
   */
  public static int getWins() {
    return wins;
  }
  
  /**
   * @param wins the wins to set
   */
  public static void setWins(int wins) {
    GameQuestionDB.wins = wins;
  }
  
  /**
   * @return the losses
   */
  public static int getLosses() {
    return losses;
  }
  
  /**
   * @param losses the losses to set
   */
  public static void setLosses(int losses) {
    GameQuestionDB.losses = losses;
  }

  /**
   * @return the currentQuestion
   */
  public static GameQuestion getCurrentQuestion() {
    return currentQuestion;
  }

  /**
   * @param currentQuestion the currentQuestion to set
   */
  public static void setCurrentQuestion(GameQuestion currentQuestion) {
    GameQuestionDB.currentQuestion = currentQuestion;
  }
  
}
