package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    // Function to get maximum value of items in the knapsack
    public static double getMaxValue(int[] value, int[] weight, int capacity) {
        int n = value.length;
        
        // Create a 2D array to store index and value-to-weight ratio
        double[][] ratio = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            ratio[i][0] = i; // Store index
            ratio[i][1] = (double) value[i] / weight[i]; // Store ratio (value/weight)
        }

        // Sort the ratio array in descending order based on the value-to-weight ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> -o[1])); // Use negative to sort in descending order

        double totalValue = 0.0; // Total value of items in the knapsack

        // Process sorted items based on the value-to-weight ratio
        for (int i = 0; i < n; i++) {
            int index = (int) ratio[i][0]; // Get the original index of the item

            // If the item can fully fit into the knapsack
            if (weight[index] <= capacity) {
                capacity -= weight[index];        // Reduce remaining capacity
                totalValue += value[index];       // Add full value of the item
            } else {
                // Take a fraction of the item that fits in the knapsack
                totalValue += value[index] * ((double) capacity / weight[index]);
                break; // Knapsack is now full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Arrays representing values and weights of items
        int[] value = {60, 100, 120,200};
        int[] weight = {10, 20, 30,50};
        int capacity = 50; // Capacity of the knapsack

        // Calculate the maximum value we can obtain
        double maxValue = getMaxValue(value, weight, capacity);

        // Print the result
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
