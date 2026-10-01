package com.mycompany.chatapp_poe;

//Unit testing implemented using JUnit framework (JUnit, 2023)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {
    
    Login login = new Login();

//Assertions such as assertEquals and assertTrue used for testing (JUnit, 2023; Baeldung, 2024)
//Test cases designed using software testing principles (Myers et al., 2011)    
    //Username Tests
    @Test
    public void testUsernameCorrect() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrect() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    //Password Tests
    @Test
    public void testPasswordCorrect() {
        assertTrue(login.checkPasswordComplexity("Ch&i&sec@ke99!"));
    }

    @Test
    public void testPasswordIncorrect() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    //Phone Number Tests
    @Test
    public void testPhoneCorrect() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testPhoneIncorrect() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    //Register User Tests (assertEquals)
    @Test
    public void testRegisterSuccess() {
        String result = login.RegisterUser("kyl_1", "Ch&i&sec@ke99!", "+27838968976");
        assertEquals("User registered successfully. ", result);
    }

    @Test
    public void testRegisterFailUsername() {
        String result = login.RegisterUser("kyle!!!!!!", "Ch&i&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testRegisterFailPassword() {
        String result = login.RegisterUser("kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testRegisterFailPhone() {
        String result = login.RegisterUser("kyl_1", "Ch&i&sec@ke99!", "08966553");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", result);
    }

    //Login Tests
    @Test
    public void testLoginSuccess() {
        login.RegisterUser("kyl_1", "Ch&i&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&i&sec@ke99!"));
    }

    @Test
    public void testLoginFail() {
        login.RegisterUser("kyl_1", "Ch&i&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrong", "wrong"));
    }

    //Login Status Test
    @Test
    public void testReturnLoginStatusSuccess() {
        login.RegisterUser("kyl_1", "Ch&i&sec@ke99!", "+27838968976");
        String message = login.returnLoginStatus("kyl_1", "Ch&i&sec@ke99!");
        assertEquals("Welcome Back! It is great to see you again.", message);
    }

    @Test
    public void testReturnLoginStatusFail() {
        String message = login.returnLoginStatus("wrong", "wrong");
        assertEquals("Username or password incorrect, please try again.", message);
    }
}


/*REFERENCE LIST

1. GeeksforGeeks, 2024. JUnit Tutorial. Available at: https://www.geeksforgeeks.org/junit-tutorial/ [Accessed 14 Apr. 2026].

2. Baeldung, 2024. Guide to JUnit Assertions. Available at: https://www.baeldung.com/junit-assertions [Accessed 14 Apr. 2026].

3. Myers, G., Sandler, C. and Badgett, T., 2011. The Art of Software Testing. 3rd ed. Wiley.
*/
