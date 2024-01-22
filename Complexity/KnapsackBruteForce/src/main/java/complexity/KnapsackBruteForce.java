package complexity;

public class KnapsackBruteForce {

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int capacity = 50;

        int maxValue = knapsack(items, capacity);
        System.out.println("Maximum value: " + maxValue);
    }

    static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    /**
     * Returns the maximum value that can be put in a knapsack with the given capacity.
     * Each item can only be selected once. If you pack an item it consumes its weight in the capacity
     * Your algorithm should implement a brute-force appraoch with a time comlexity
     * of O(2^n) where n is the number of items.
     * @param items
     * @param capacity
     * @return
     */
    public static int knapsack(Item[] items, int capacity) {
        //TODO
        return knapsack(items, capacity, 0);
    }

    public static int knapsack(Item[] items, int remainingCapacity, int currentIndex){
        if (currentIndex == items.length || remainingCapacity <= 0) return 0;
        // Excluding current item
        int excludeValue = knapsack(items, remainingCapacity, currentIndex + 1);
        // Including current item
        int includeValue = 0;
        int currentWeight = items[currentIndex].weight;
        if (currentWeight <= remainingCapacity){
            includeValue = items[currentIndex].value + knapsack(items, remainingCapacity - currentWeight, currentIndex + 1);
        }
        return Math.max(excludeValue, includeValue);
    }
}
