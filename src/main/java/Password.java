import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    public static boolean validatePassword(String password) {
        boolean[] isValid = new boolean[6];

        isValid[0] = checkLength(password);
        isValid[1] = checkCapitalLetters(password);
        isValid[2] = checkLowerCaseLetter(password);
        isValid[3] = checkNumber(password);
        isValid[4] = checkSpaces(password);
        isValid[5] = checkSpecialCharacter(password);

        return overAllCheck(isValid);
    }

    private static boolean overAllCheck(boolean[] isValid) {

        for (int i = 0; i<isValid.length;i++ ){
            if (!isValid[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean checkLength(String password) {
        int minimumLength = 8;
        return password.length() >= minimumLength;
    }

    private static boolean checkCapitalLetters(String password) {
        char ch;
        for (int i = 0; i<password.length();i++ ){
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkLowerCaseLetter(String password) {
        char ch;
        for (int i = 0; i<password.length();i++ ){
            ch = password.charAt(i);
            if (Character.isLowerCase(ch)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkNumber(String password) {
        char ch;
        for (int i = 0; i<password.length();i++ ){
            ch = password.charAt(i);
            if (Character.isDigit(ch)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkSpecialCharacter(String password) {

        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(password);

        return m.find();
    }


    private static boolean checkSpaces(String password) {

        if (password.contains(" ")) {
            return false;
        }
        return true;
    }
}
