import java.util.Arrays;

/**
 * Class containing all the sorting algorithms from 61B to date.
 *
 * You may add any number instance variables and instance methods
 * to your Sorting Algorithm classes.
 *
 * You may also override the empty no-argument constructor, but please
 * only use the no-argument constructor for each of the Sorting
 * Algorithms, as that is what will be used for testing.
 *
 * Feel free to use any resources out there to write each sort,
 * including existing implementations on the web or from DSIJ.
 *
 * All implementations except Distribution Sort adopted from Algorithms, 
 * a textbook by Kevin Wayne and Bob Sedgewick. Their code does not
 * obey our style conventions.
 */
public class MySortingAlgorithms {

    /**
     * Java's Sorting Algorithm. Java uses Quicksort for ints.
     */
    public static class JavaSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            Arrays.sort(array, 0, k);
        }

        @Override
        public String toString() {
            return "Built-In Sort (uses quicksort for ints)";
        }        
    }

    /** Insertion sorts the provided data. */
    public static class InsertionSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            //This algorithm works as follows.
            //For all entries
            for(int i = 0; i < k; i++){
                for(int j = i; j > 0; j--){
                    if(array[j] < array[j-1]){
                        
                        //XOR SWAP IF DIFFERENT
                        if(array[j-1] != array[j])
                        {
                            array[j-1] = array[j-1] ^ array[j];
                            array[j]   = array[j-1] ^ array[j];
                            array[j-1] = array[j-1] ^ array[j];
                        }
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "Insertion Sort";
        }
    }

    /**
     * Selection Sort for small K should be more efficient
     * than for larger K. You do not need to use a heap,
     * though if you want an extra challenge, feel free to
     * implement a heap based selection sort (i.e. heapsort).
     */
    public static class SelectionSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            /* Slower than insertion sort, 
             * since it searches the array for the next smallest integer.
             *  Whereas insertion sort actually 
             *  just swaps if and only if there is an inversion to an adjacent element.
             *  Both are intuitive. However, I think insertion sort should be aptly
             *  named "swap" sort. Selection sort derives its name from selecting
             *  the next best element with which to replace a given element;
             *  Both act to decrease inversions on each iteration.
             *  That is to invent a sorting algorithm is to do so in a manner
             *  such that there is a guarenteed negative net inversion count on
             *  every iterate. */
            
            //Loop over the array
            for(int i = 0; i < k; i++){
                //Then select an element and find the next smallest element
                int min = i;
                for(int j = i+1; j < k; j++) {
                    min = array[min] > array[j] ? //If the 'min' is not the minest.
                          min = j //set min to the smaller elem.
                        : min; //otherwise, min remains the same.
                }
                
                //Now put the smallest element where it should be!
                if(array[min] != array[i]){
                    array[i] = array[i] ^ array[min];
                    array[min] = array[i] ^ array[min];
                    array[i] = array[i] ^ array[min];
                }
            }
            
        }

        @Override
        public String toString() {
            return "Selection Sort";
        }
    }

    /** Your mergesort implementation. An iterative merge
      * method is easier to write than a recursive merge method.
      * Note: I'm only talking about the merge operation here,
      * not the entire algorithm, which is easier to do recursively.
      */
    public static class MergeSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {            
            mergeSort(array, 0, array.length, new int[array.length]);
        }

        // may want to add additional methods

        private void mergeSort(int[] array, int left, int right, int[] js) {
            int mid = (right + left)/2;
            if(right - left > 1){
                //Split left
                mergeSort(array,left,mid,js);
                //split right
                mergeSort(array,mid,right,js);
                //Combine into JS
                merge(array, left, mid, right, js);
                System.arraycopy(js, left, array, left, right-left);
            }
            
            
        }

        private void merge(int[] array, int left, int mid, int right,
                int[] js) {
            
            //Iterate over two different indexing variables, and stop when they both reach the end.
            for(int l = left, r = mid; l < mid || r < right;){
                //If the right indexer is at its end or if it is not and the left element is less
                if((r == right) || (l < mid && array[l] < array[r]))
                {
                    //Use the left
                    js[l+r-mid] = array[l];
                    l++;
                }
                //If the left indexer is at its end or if it is not and the right element is less than or equal
                else if((l == mid) ||  (r < right && array[l] >= array[r])){
                    //use the right
                    js[l+r-mid] = array[r];
                    r++;
                }
            }
        }

        @Override
        public String toString() {
            return "Merge Sort";
        }
    }

    /**
     * Your Distribution Sort implementation.
     * You should create a count array that is the
     * same size as the value of the max digit in the array.
     */
    public static class DistributionSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            // TODO: to be implemented
        }

        // may want to add additional methods

        @Override
        public String toString() {
            return "Distribution Sort";
        }
    }

    /** Your Heapsort implementation.
     */
    public static class HeapSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            // TODO   
        }

        @Override
        public String toString() {
            return "Heap Sort";
        }        
    }

    /** Your Quicksort implementation.
     */
    public static class QuickSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            // TODO   
        }

        @Override
        public String toString() {
            return "Quicksort";
        }        
    }

    /*
     * Your LSD Sort implementation, treating ints
     * as a sequence of 8 bit characters. Or if you want 
     * to do less bit-hacking, you can treat them as strings
     * of decimal digits.
     */
    public static class LSDSort implements SortingAlgorithm {
        @Override
        /** For an example implementation, see Kevin Wayne and 
          * Bob Sedgewick's Algorithms textbook.
          *
          * http://algs4.cs.princeton.edu/51radix/LSD.java.html
          */
        public void sort(int[] a, int k) {
            // TODO
        }

        @Override
        public String toString() {
            return "LSD Sort";
        }
    }

    /**
     * Tricky: Your MSD Sort implementation, treating ints
     * as a string of 8 bit characters.
     */
    public static class MSDSort implements SortingAlgorithm {
        @Override
        /** For an example implementation, see Kevin Wayne and 
          * Bob Sedgewick's Algorithms textbook.
          *
          * http://algs4.cs.princeton.edu/51radix/MSD.java.html
          */
        public void sort(int[] a, int k) {
            // TODO
        }

        @Override
        public String toString() {
            return "MSD Sort";
        }
    }

    // swap a[i] and a[j]
    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}


