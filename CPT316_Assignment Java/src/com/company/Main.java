package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int lines;  //variable declaration

        File_Reader read = new File_Reader();   // Object creation for the File_Reader class
        lines = read.read_numlines();   // Read the number of lines in the text file
        String[] words = new String[lines]; // Create an array
        read.print_array(words);    // Print the strings from the text file to the array

        double startTime = System.nanoTime(); // Starting time of the quick sort

        quickSort(words, 0, lines-1);   // Method call

        double elapsedTime = System.nanoTime() - startTime;   // Time taken for the quick sort
        double totalTime = elapsedTime / 1000;  // Conversion of the time taken into microseconds
        System.out.println("The program took " + totalTime + " microseconds to execute.");

        read.print_file(words);

    }

    static void quickSort(String[] arr, int low, int high)
    {
        // base case - stop if the index is pointing to the same element
        if (low >= high) {
            return;
        }

        int leftPointer = partition(arr, low, high);    // call partition function to swap the elements before pivot

        quickSort(arr, low, leftPointer-1); // recursively do sorting for left of the pivot

        quickSort(arr, leftPointer+1, high);    // recursively do sorting for right of the pivot
    }

    static int partition(String[] arr, int low, int high)
    {
        String pivot = arr[high];   // Select the last element as a pivot

        int highIndex = high;

        //traverse the array
        while (low < high)
        {
            // move low to the right until an element bigger than the pivot is found
            while (arr[low].compareToIgnoreCase(pivot) <= 0 && low < high)
            {
                low++;
            }

            // move high to the left until an element smaller than the pivot is found
            while (arr[high].compareToIgnoreCase(pivot) >= 0 && low < high)
            {
                high--;
            }

            swap(arr, low, high);   // swap the elements
        }

        swap(arr, low, highIndex);  //swap the place of the pivot

        return low; // return the position of the pivot
    }

    static void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
