package com.contactsunny.poc.quicksort;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] array = {3, 7, 8, 2, 1};
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("-----------------");

        quickSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("-----------------");
    }

    /**
     * Wrapper method to initiate the quick sort recursion.
     *
     * @param array The unsorted input array
     */
    private static void quickSort(int[] array) {
        // Calling the quick sort method with left and right bounds.
        quickSort(array, 0, array.length - 1);
    }

    /**
     * This method performs the actual quick sort on the given array.
     *
     * @param array The unsorted input array
     * @param left the left bound of the array
     * @param right the right bound of the array
     */
    private static void quickSort(int[] array, int left, int right) {
        // Making sure that we're not crossing the left and right bounds.
        if (left < right) {
            // Getting the index in the array where the partition has to be created.
            int partitionIndex = getPartitionIndex(array, 0, array.length - 1);
            // Calling the method recursively to perform quick sort on the left array.
            quickSort(array, left, partitionIndex - 1);
            // Calling the method recursively to perform quick sort on the right array.
            quickSort(array, partitionIndex + 1, right);
        }
    }

    /**
     * Method to derive the partition index where the array will be split for further sorting.
     *
     * @param array the unsorted input array
     * @param left the left bound
     * @param right the right bound
     *
     * @return the partition index where the array will be split
     */
    private static int getPartitionIndex(int[] array, int left, int right) {
        // Considering the right most element as the pivot element.
        int pivot = array[right];
        // Considering the element before the left most element to be the partition index.
        int partitionIndex = left - 1;

        // Iterating over all the elements from left to right
        for (int index = left; index < right; index++) {
            // If the current element is less than the pivot element
            // we'll move the partition index by one,
            // and swap the current element with the element at the partition index.
            // This way, we'll make sure that all the elements before the partition index
            // are less than the pivot. This will make sense when the partition index
            // element is swapped with the pivot.
            if (array[index] < pivot) {
                // Incrementing the partition index value
                partitionIndex++;
                // Swapping the element at the partition index with the
                // element at the index.
                int temp = array[partitionIndex];
                array[partitionIndex] = array[index];
                array[index] = temp;
            }
        }

        // Once the loop is complete, all elements before the partition element
        // are less than the pivot, and all elements after the partition element
        // are greater than the pivot. So the place for the pivot is right next to
        // partition index. Swapping the two.
        int temp = array[right];
        array[right] = array[partitionIndex + 1];
        array[partitionIndex + 1] = temp;

        // The new partition index is where the swapping happened.
        return partitionIndex + 1;
    }
}
