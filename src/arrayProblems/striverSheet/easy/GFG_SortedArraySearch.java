package arrayProblems.striverSheet.easy;

public class GFG_SortedArraySearch {

    // https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1

    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start) + (end-start)/2;
            if(arr[mid] == k){
                return true;
            }else if(arr[mid] > k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return false;
    }
}
