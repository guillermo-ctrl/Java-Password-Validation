public class Password {

    public static boolean validatePassword(String password) {
        boolean[] isValid = new boolean[6];

        isValid[0] = checkLength(password);
        isValid[1] = checkCapitalLetters(password);
        isValid[2] = true;
        isValid[3] = true;
        isValid[4] = true;
        isValid[5] = true;

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
}
