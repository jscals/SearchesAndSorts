
public class Sorts<T extends Comparable<T>> {
      

   /******************************************************
    * 
    * Simple sorts, efficient on small data sets.
    * 
    ******************************************************/

    /*
     * Method that sorts a given array using the Insertion Sort algorithm.
     * Generally faster than selection sort.
     * (fewer comparisions, good performace on almost sorted data.)
     * 
     * - Starting at the beginning of the array, compare the 2nd item with 
     *   the 1st, swap if smaller.
     * - Then compare 3rd with the 2nd, if smaller swap. Then compare it again 
     *   with the 1st and swap again if needed.
     * - Repeat this process increasing the position once after each swapping 
     *   process so a new element is being compared with all those previous. 
     * 
     * You are INSERTING the new item into its proper spot in all 
     * elements to its left. 
     *   
     *  Best-- O(n)
     *  Average, Worst-- O(n^2)
     *
     * @param arr The array of generic objects to sort. 
     * @return The sorted array.
    */
    public void insertionSort(T[] arr){

        for(int i = 1; i < arr.length; i++){
            T temp = arr[i]; 
            int j;

            for(j = i - 1; j >= 0 && temp.compareTo(arr[j]) < 0; j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp; 
        }
    }


   /*
    * Method that sorts a given array using the Selection Sort algorithm. 
    *
    * - Assumes first index contains minimum. Check each successive item after 
    *   to see if it is minimum, if it is swap with first item. 
    * - Move to second item and so on until this has been done to whole array 
    *   and it is sorted. 
    * 
    * You are SELECTING the current smallest item and 
    * putting it at the beginning. 
    * 
    * Best, Average, Worst-- O(n^2)
    *
    * @param arr The array of generic objects to sort. 
    * @return The sorted array.
    */
    public void selectionSort(T[] arr){

        for(int i = 0; i < arr.length - 1; i++){

            for(int j = i + 1; j < arr.length; j++){
                if(arr[j].compareTo(arr[i]) < 0){
                        T temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                }
            }
        }
    }

    
   /* 
    * Method that sorts a given array using the Bubble Sort algorithm. 
    * 
    * - Start at 2nd element of array and compare ajacent elements throughout. 
    * - Swap if the element on the left is > element on the right. (i-1 > i) 
    * - After one iteration, the biggest number will 'bubble' to the end. 
    * - Omit the last (aka greatest) item and repeat until no more swaps needed.
    * 
    * Big numbers BUBBLE to the end of the array. 
    * 
    * Best-- O(n)
    * Average, Worst-- O(n^2)
    *
    * @param arr The array of generic objects to sort. 
    * @return The sorted array.
    */
    public void bubbleSort(T[] arr){

        int length = arr.length;
        boolean swapped = true;

        while(swapped){
            swapped = false;

            for(int i = 1; i < length; i++){
                
                if(arr[i - 1].compareTo(arr[i]) > 0){
                        T temp = arr[i];
                        arr[i] = arr[i-1];
                        arr[i-1] = temp;
                }
                swapped = true;
            }
            length--; 
        }
    }

	



    /***********************************************************************
     * 
     * Efficient sorts, those with average (and generally worst case) complexity 
     * of O(nlogn). Overhead is large for small data sets, and
     * may perform poorly on already sorted data.
     * 
     * 
     ************************************************************************/

    
   /* 
    * Method that sorts the given array using the Mege Sort algorithm
    * 
    * Comparision based sorting algorithm. (divide and conquer)
    * - Uses a helper function sort() to recursively split the list into 
    *   smaller lists until only one element is left.
    * - Uses the helper function merge() to merge each small list until they are 
    *   combined into one sorted list. 
    * 
    * best, average, worst-- O(nlogn)
    *
    * @param arr The array to be sorted
    * @return The sorted array
   */
    public void mergeSort(T[] arr){
        sort(arr, 0, arr.length - 1);
    }
    
    private void sort(T[] arr, int low, int high){
        if(low < high){
            int mid = low + (high - low) / 2;
            sort(arr, low, mid); //left array
            sort(arr, mid + 1, high); //right array
            merge(arr, low, mid, high); //merge them together
        }
    }
    
    private void merge(T[] arr, int low, int mid, int high){
        Object[] helper = new Object[arr.length];
        int i = 0;
        int l = low;
        int r = mid + 1;
        
        //Put the smallest element into helper array until all
        //elements from both (or either) are used.
        while(l <= mid && r <= high){
            if(arr[l].compareTo(arr[r]) < 0){
                helper[i] = arr[l]; 
                i++; l++;
            }
            else{
                helper[i] = arr[r]; 
                i++; r++;
            }
        }
        
        //If one array ran out of elements before the other, add the rest from 
        //the other. 
        if(l > mid){
            while(r <= high){
                helper[i] = arr[r]; 
                i++; r++;
            } 
        }
        if(r > high){
            while(l <= mid){
                helper[i] = arr[l]; 
                i++; l++;
            }
        }
        
        //Put the sorted elements from helper back into array.
        for(int count = 0; count < arr.length; count++){
            arr[count] = (T) helper[count]; 
        }
    }
    
    
    
}