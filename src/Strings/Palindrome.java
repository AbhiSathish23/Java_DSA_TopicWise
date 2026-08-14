package Strings;

public class Palindrome {
    public static void main(String[] args) {
        String str = "A man0, a plan, a canal: Pa0nama";
        System.out.println(stringPalindrome(str));
    }

    public static boolean stringPalindrome(String str) {
//        String alphanumericStr = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isAlphanumeric = Character.isLetterOrDigit(ch);

            if (isAlphanumeric) {
                sb.append(ch);
            }
        }
       String alphanumericStr = sb.toString().toLowerCase();
        int left = 0;
        int right = alphanumericStr.length() - 1;
            while (left < right) {
                if (alphanumericStr.charAt(left) == alphanumericStr.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        return true;
    }
}
