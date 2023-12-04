package basics;

public class PatternMatching {

    /**
     * Look for one sequence of characters (the pattern) in an input
     * string, and return the position of the pattern in the string
     * (if present). If the pattern is present multiple times in the
     * string, the function must return the leftmost occurrence of the
     * pattern (i.e. the occurrence whose index is the lowest). The
     * function must be case-sensitive (i.e. <code>Hello</code> is not
     * the same as <code>hello</code>).
     * @param pattern The pattern to look for.
     * @param value The string to look in.
     * @result The index of the leftmost occurrence of the pattern in
     * the string. Must be <code>-1</code> if the pattern is absent
     * from the string.
     **/
    public static int find(String pattern, String value) {
        int count = 0;
        for (int i = 0; i < value.length(); i++){
            if (pattern.charAt(i) == pattern.charAt(count)){
                count += 1;
            }
            else {
                count = 0;
                if (pattern.charAt(i) == pattern.charAt(count)){
                    count += 1;
                }
            }
            if (count == pattern.length()){
                System.out.println("Match at "+ (i - count));
                return i - count;
            }
        }
        return -1;
    }
}