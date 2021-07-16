import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    public static boolean[] validatePasswordList(String[] listOfPaswords) {
        boolean[] validatedList = new boolean[listOfPaswords.length];

        for(int i = 0; i < listOfPaswords.length; i++){
            validatedList[i] = validatePassword(listOfPaswords[i]);
        }

        return validatedList;
    }

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
        if(password.length() >= minimumLength) {

            return true;
        }
        MessageService.messageLengthCheck();
        return false;
    }

    private static boolean checkCapitalLetters(String password) {
        char ch;
        for (int i = 0; i<password.length();i++ ){
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)){
                return true;
            }
        }
        MessageService.messageCapitalCheck();
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
        MessageService.messageLowercasehCheck();
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
        MessageService.messageNumbersCheck();
        return false;
    }

    private static boolean checkSpecialCharacter(String password) {

        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(password);
        if (m.find()) {
            return true;
        }
        MessageService.messageSpecialCharCheck();
        return false;
    }


    private static boolean checkSpaces(String password) {

        if (password.contains(" ")) {
            MessageService.messageNoSpacesCheck();
            return false;
        }
        return true;
    }
}
