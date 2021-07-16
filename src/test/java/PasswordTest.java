import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {


    @Test
    @DisplayName("Password validation: Length should be minimum 8 chars.")
    public void testPasswordLength() {

        // GIVEN
        String testPassword = "123abcDEF%&/";

        // WHEN
        boolean actual = Password.validatePassword(testPassword);

        // THEN
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password validation: Checks failiure in case of less than 8 chars")
    public void testPasswordTooShort() {

        // GIVEN
        String testPassword = "1aB/";
        // WHEN

        boolean actual = Password.validatePassword(testPassword);

        // THEN
        assertFalse(actual);
    }

    @Test
    @DisplayName("Password validation: Must contain minimum one capital letter")
    public void testPasswordCapitalLetter() {

        // GIVEN
        String testPassword = "123abcdef%&/";

        // WHEN
        boolean actual = Password.validatePassword(testPassword);

        // THEN
        assertFalse(actual);
    }

    @Test
    @DisplayName("Password validation: Must contain minimum one lower case letter")
    public void testPasswordLowerCaseLetter() {

        // GIVEN
        String testPassword = "123ABCDEF%&/";

        // WHEN
        boolean actual = Password.validatePassword(testPassword);

        // THEN
        assertFalse(actual);
    }

    @Test
    @DisplayName("Password validation: Must contain minimum one number")
    public void testPasswordNumber() {

        // GIVEN
        String testPassword = "xxxabcDEF%&/";

        // WHEN
        boolean actual = Password.validatePassword(testPassword);

        // THEN
        assertFalse(actual);
    }

    @Test
    @DisplayName("Password validation: Must contain minimum one special character")
    public void testPasswordSpecialCharacter() {

        // GIVEN
        String testPassword = "123abcDEFxxx";

        // WHEN
        boolean actual = Password.validatePassword(testPassword);

        // THEN
        assertFalse(actual);

    }

    @Test
    @DisplayName("Password validation: May not contain spaces")
    public void testPasswordNoSpaces() {

        // GIVEN
        String testPassword = "123abc DEF%&/";

        // WHEN
        boolean actual = Password.validatePassword(testPassword);

        // THEN
        assertFalse(actual);
    }

}