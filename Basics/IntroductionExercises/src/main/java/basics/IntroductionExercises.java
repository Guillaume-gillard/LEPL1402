package basics;

public class IntroductionExercises {

    public static int variable = 0;

    public static int[] squares;

    /*
     * Function that bound variable to value
     */
    public static void attribute(int value){
        variable = value;
    }

    /*
     * Function that return the addition of the two parameters
     */
    public static int add(int a, int b){

        return a +b;
    }

    /*
     * return true is a and b are equal
     */
    public static boolean equalsIntegers(int a, int b){

        return a == b;
    }

    /*
     * Function that return the max between a and b in one line
     * You must use a ternary operation
     */
    public static int max(int a, int b){

        return a > b ? a : b;
    }

    /*
     * Function that return the middle value.
     * If a > b > c, the function must return b.
     * If two value are equals, return -1.
     */
    public static int middleValue(int a, int b, int c){
        if (a == b || b == c || a == c) return -1;
        if ((b > a && a > c) || (c > a && a > b)) return a;
        if ((a > b && b > c) || (c > b && b > a)) return b;
        return c;

    }
    /*
     * This function must return :
     * "Good morning, sir!" if str is "Morning"
     * "Good evening, sir!" if str is "Evening"
     * "Hello, sir!" otherwise
     * Use a switch case statement
     * Your implementation must be case sensitive
     * And you should not use if/else!
     */
    public static String greetings(String str){
        return (str == "Morning" || str == "Evening") ? "Good " + str.toLowerCase() + ", sir!" : "Hello, sir!";
    }

    /*
     * This function must return a new array of length 3
     * The first element of this new array is the last element of a
     * The second element is the first element of a
     * The last element is the middle element of a
     */
    public static int[] lastFirstMiddle(int[] a){
        int len = a.length;
        int[] newarray = {a[len-1], a[0], a[len/2]};
        return newarray;
    }

    /*
     * This function must return the sum of the elements of array using a for loop
     */
    public static int sum(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    /*
     * return the maximum element of array using a while loop
     */
    public static int maxArray(int[] array){
        int max = 0;
        int count = 0;
        while (count < array.length){
            if (array[count] > max){
                max = array[count];
            }
            count += 1;
        }
        return max;
    }


    /**
     * Assign to the variable square, the square of the
     * parameters.
     *
     * Let assume that the program is invoked with the following
     * line:
     *  java IntroductionExercises 0 3 4 5
     *
     * The arguments of the program are 0, 3, 4 and 5.
     * After the execution of the main, the variable squares
     * should be:
     *  squares = [0, 9, 16, 25]
     *
     * If an exception occurs when converting an argument to
     * an integer, put 0 at the corresponding index. For example
     *
     *  java IntroductionExercise 0 3.1 4 5
     *
     * would yield
     *
     *  squares = [0, 0, 16, 25]
     *
     * because 3.1 can not be converted to an integer
     * */
    public static void main(String... args){
        squares = new int[args.length];
        for (int i = 0; i < args.length; i++ ){
            try {
                int number = Integer.parseInt(args[i]);
                squares[i] = (int) Math.pow(number, 2);
            } catch (NumberFormatException e) {
                squares[i] = 0;
            }
        }
    }
}