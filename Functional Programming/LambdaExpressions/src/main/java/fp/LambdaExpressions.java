package fp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class LambdaExpressions {
    /**
     * Return a binary operator that computes the sum of two Integer objects.
     */
    public static Object sumOfIntegers() {
        // TODO
        BinaryOperator<Integer> f = (x, y) -> x + y;
        return f;
    }

    /**
     * Return a predicate that tests whether a String is empty.
     */
    public static Object isEmptyString() {
        // TODO
        Predicate<String> f = s -> s.isEmpty();
        return f;
    }

    /**
     * Return a predicate that tests whether an Integer is an odd number.
     */
    public static Object isOddNumber() {
        // TODO
        Predicate<Integer> f = x -> x%2 == 1;
        return f;
    }

    /**
     * Return a function that computes the mean of a List of Double objects.
     * If the list is empty, an IllegalArgumentException must be thrown.
     */
    public static Object computeMeanOfListOfDoubles() {
        // TODO
        Function<List<Double>, Double> f = list -> {
            if (list.isEmpty()) throw new IllegalArgumentException();
            double sum = 0;
            for (double x : list) sum += x;
            return sum/list.size();
        };
        return f;
    }

    /**
     * Remove the even numbers from a list of Integer objects.
     */
    public static void removeEvenNumbers(List<Integer> lst) {
        // TODO
        lst.removeIf(x -> x%2 == 0);
    }

    /**
     * Return a function that computes the factorial of an Integer.
     * If the number is zero, the factorial equals 1 by convention.
     * If the number is negative, an IllegalArgumentException must be thrown.
     */
    public static Object computeFactorial() {
        // TODO
        UnaryOperator<Integer> f = x -> {
            if (x < 0) throw new IllegalArgumentException();
            int factorial = 1;
            for (int i = 1; i <= x; i++) factorial *= i;
            return factorial;
        };
        return f;
    }

    /**
     * Return a function that converts a list of String objects to lower case.
     */
    public static Object listOfStringsToLowerCase() {
        // TODO
        UnaryOperator<List<String>> f = list -> {
            for (int i = 0; i < list.size(); i++){
                list.set(i, list.get(i).toLowerCase());
            }
            return list;
        };
        return f;
    }

    /**
     * Return a function that concatenates two String objects.
     */
    public static Object concatenateStrings() {
        // TODO
        BinaryOperator<String> f = (a, b) -> a + b;
        return f;
    }

    public static class MinMaxResult {
        private int minValue;
        private int maxValue;

        MinMaxResult(int minValue,
                     int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        int getMinValue() {
            return minValue;
        }

        int getMaxValue() {
            return maxValue;
        }
    }

    /**
     * Return a function that computes the minimum and maximum values in a list.
     * The content of the Optional must be present if and only if the list is non-empty.
     */
    public static Function<List<Integer>, Optional<MinMaxResult>> computeMinMax() {
        // TODO
        return list -> {
            if (list.isEmpty()) return Optional.empty();
            int minValue = list.get(0);
            int maxValue = list.get(0);
            for (int x : list){
                minValue = Math.min(minValue, x);
                maxValue = Math.max(maxValue, x);
            }
            return Optional.of(new MinMaxResult(minValue, maxValue));
        };
    }

    /**
     * Return a function that, given a String object and a character, counts
     * the number of occurrences of the character inside the string.
     */
    public static Object countInstancesOfLetter() {
        // TODO
        BiFunction<String, Character, Integer> f = (s, c) -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == c) count ++;
            }
            return count;
        };
        return f;
    }
}
