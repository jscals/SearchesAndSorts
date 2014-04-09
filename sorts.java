
public class sorts<T extends Comparable<T>> {
      

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
    public T[] insertionSort(T[] arr){

        for(int i = 1; i < arr.length; i++){
            T temp = arr[i]; 
            int j;

            for(j = i - 1; j >= 0 && temp.compareTo(arr[j]) < 0; j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp; 
        }
        return arr;
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
    public T[] selectionSort(T[] arr){

        for(int i = 0; i < arr.length - 1; i++){

            for(int j = i + 1; j < arr.length; j++){
                if(arr[j].compareTo(arr[i]) < 0){
                        T temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                }
            }
        }
        return arr;
    }

    
    /* Method that sorts a given array using the Bubble Sort algorithm. 
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
    public T[] bubbleSort(T[] arr){

        int length = arr.length;
        boolean swapped = true;

        while(swapped){
            swapped = false;

            for(int i = 1; i < length - 1; i++){
                
                if(arr[i - 1].compareTo(arr[i]) > 0){
                        T temp = arr[i];
                        arr[i] = arr[i-1];
                        arr[i-1] = temp;
                }
                swapped = true;
            }
            length--; 
        }
        return arr;
    }
}
	



    /***********************************************************************
     * 
     * Efficient sorts, those with average (and generally worst case) complexity 
     * of O(nlogn). Overhead is large for small data sets, and
     * may perform poorly on already sorted data.
     * 
     ************************************************************************/

    