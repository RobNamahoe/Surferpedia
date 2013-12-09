package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

/**
 * Game Question form data.
 * @author Rob Namahoe
 */
public class GameQuestionFormData {

  /** The users choice. **/
  public String selection = "";
  
  /**
   * Default constructor method.
   */
  public GameQuestionFormData() {
    // Default constructor method.
  }
 
  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationErrors if problems are found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if (selection == null || selection.length() == 0) {
      errors.add(new ValidationError("selection", "This cannot be blank. Choose a surfer and try again."));
    }
    
    return errors.isEmpty() ? null : errors;
    
  }

}

