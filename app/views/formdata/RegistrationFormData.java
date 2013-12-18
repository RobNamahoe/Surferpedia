package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;

/**
 * Backing class for the login form.
 */
public class RegistrationFormData {
  
  /** The name. */
  public String regName = "";
  /** The email. */
  public String regEmail = "";
  /** The password. */
  public String regPassword = "";

  /** Required for form instantiation. */
  public RegistrationFormData() {
  }

  /**
   * Validates Form<RegistrationFormData>.
   * Checks to see that name, email, and password are sufficiently supplied.
   * @return Null if invalid form, List if good input
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    if (regName == null || regName == "") {
      errors.add(new ValidationError("regName", "Name is required."));
    }
    if (regEmail == null || regEmail == "") {
      errors.add(new ValidationError("regEmail", "Email is required."));
    }
    if (regPassword == null || regPassword == "") {
      errors.add(new ValidationError("regPassword", "Password is required."));      
    }
    if (UserInfoDB.isUser(regEmail)) {
      // email exists
      errors.add(new ValidationError("regEmail", "Email already exists."));
    }
    return (errors.size() > 0) ? errors : null;
  }

}
