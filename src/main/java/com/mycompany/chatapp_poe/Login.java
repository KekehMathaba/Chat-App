package com.mycompany.chatapp_poe;

public class Login {
     
   //Add Variables
     private String storedUsername;
     private String storedPassword;
     private String storedPhoneNumber;
     
     
     //Getters and Setters
     public String getStoredUsername() {
        return storedUsername;
    }

    public void setStoredUsername(String storedUsername) {
        this.storedUsername = storedUsername;
    }

    public String getStoredPassword() {
        return storedPassword;
    }

    public void setStoredPassword(String storedPassword) {
        this.storedPassword = storedPassword;
    }

    public String getStoredPhoneNumber() {
        return storedPhoneNumber;
    }

    public void setStoredPhoneNumber(String storedPhoneNumber) {
        this.storedPhoneNumber = storedPhoneNumber;
    }
     
   //Username Check Method
    public boolean checkUserName(String username) {
    return username.contains("_") && username.length() <= 5;
}
    //Password Check Method
    //Password complexity validation using character checks (Oracle, 2023; W3Schools, 2024)
   public boolean checkPasswordComplexity(String password) {

    boolean lengthCheck = password.length() >= 8;
    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;

    for (int i = 0; i < password.length(); i++) {
        char ch = password.charAt(i);

        if (Character.isUpperCase(ch)) {
            hasCapital = true;
        }

        if (Character.isDigit(ch)) {
            hasNumber = true;
        }

        if (!Character.isLetterOrDigit(ch)) {
            hasSpecial = true;
        }
    }
return lengthCheck && hasCapital && hasNumber && hasSpecial;
    }

    //Phone Number Check Method 
    //Regex pattern used for phone validation (Oracle, 2023; Regular-Expressions.info, 2024)
    public boolean checkCellPhoneNumber(String phoneNumber) {
    return phoneNumber.matches("^\\+27\\d{9}$");
}
  
  //Register User Method
  // Input validation based on software engineering best practices (Sommerville, 2016)
  public String RegisterUser (String username, String password, String phoneNumber){
      
      if (!checkUserName (username)){
          return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
      }
      if (!checkPasswordComplexity (password)) {
          return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
      }
      if (!checkCellPhoneNumber (phoneNumber)) {
          return "Cell phone number incorrectly formatted or does not contain international code.";
      }
      storedUsername = username;
      storedPassword = password;
      storedPhoneNumber = phoneNumber;
  
      return "User registered successfully. ";  
  } 
  
  //Login Method
  //Authentication logic inspired by security best practices (OWASP, 2023)
   public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
   } 
    
 //Login Status
    public String returnLoginStatus(String username, String password) {

        if (loginUser(username, password)) {
            return "Welcome Back! It is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
}
 
/*REFERENCE LIST

1. Eck, D., 2022. Introduction to Programming Using Java. Available at: https://math.hws.edu/javanotes/ [Accessed 11 Apr. 2026].

2.Oracle, 2023. String Class (Java Platform SE). Available at: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html [Accessed 12 Apr. 2026].

3.Oracle, 2023. Pattern (Java Platform SE Documentation). Available at: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html [Accessed 13 Apr. 2026].

4.OWASP, 2023. Authentication Cheat Sheet. Available at: https://cheatsheetseries.owasp.org/ [Accessed 13 Apr. 2026].

5. Sommerville, I., 2016. Software Engineering. 10th ed. Pearson. 
*/