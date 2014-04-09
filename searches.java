
public class searches<T extends Comparable<T>>{

    /* Performs search for item on sorted array.
    * --Sets hi and low indices and checks the midpoint. 
    * --If target is > than mid, it sets the new LOW one MORE than mid.
    * --If target is < than mid, it sets the new HI one LESS than mid.
    * --Otherwise, target is equal to mid and we return its position.
    * --If we have adjusted our hi and low to the point of increasing low to equal hi
    * 	 or lowering hi to equal low, then the target was not in array so return -1;
    * 
    * Worst case - O(logn)
    * Best case - O(1)
    *
    * @param key: A value to search for of type T. 
    * @param arr: The array of objects to search through of type T. 
    * @return The integer representing the found object's index. -1 if not found.  
    *
    */
    public  int binarySearch(T key, T[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if  (key.compareTo(arr[mid]) < 0) hi = mid - 1;
            else if (key.compareTo(arr[mid]) > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    
    /* Performs search for first occurrance of item within array.
    * --Iterates linearly through array until element found, return position. 
    * --If not found and end is reached, not present so return -1; 
    * 
    * Worst case - O(n)
    * Best case - O(1)
    * 
    * @param key: An value of type T to search for.
    * @param arr: The array to search through of type T. 
    * @return The integer representing the found object's index. -1 if not found.
    */
    public int sequentialSearch(T key, T[] arr){
        for(int i = 0; i < arr.length; i++){
        	if(arr[i].equals(key)){
        		return i;
        	}
        }
        return -1; 
    }

}