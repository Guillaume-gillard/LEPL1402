package basics;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {


    /**
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurence of the delimiter.
     *          If there is no occurence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String [] split(String str, char delimiter){
        //counting the number of splitted part
        int length = 1;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == delimiter) length ++;
        }
        String [] splitted = new String[length];

        boolean isSplitted = false;
        int startInterval = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i) == delimiter){
                if (i + 1 == str.length()) {
                    splitted[count] = str.substring(startInterval, i);
                    splitted[count+1] = "";
                    return splitted;
                }
                splitted[count] = str.substring(startInterval, i);
                startInterval = i+1;
                count ++;
                isSplitted = true;
            }
        }
        if (isSplitted) return splitted;
        return new String[]{str};
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == sub.charAt(count)) count++;
            else count = 0;
            if (count == sub.length()) return i - count + 1;
        }
        return -1;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str){
        String lowercase_str = "";
        for (int i = 0; i < str.length(); i++) {
            char current_char = str.charAt(i);
            // checking if uppercase or not to just convert uppercase letters
            if (current_char >= 'A' && current_char <= 'Z') lowercase_str += (char) (current_char + 32);
            else lowercase_str += current_char;
        }
        return lowercase_str;
    }


    /**
     * Check if a string is a palyndrome
     *
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str){
         for (int i = 0; i < str.length(); i++){
             if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
         }
         return true;
    }
}