package arrayProblems.striverSheet.easy;

public class GFG_Largest_Elemet_in_Array {

    // https://www.geeksforgeeks.org/problems/largest-element-in-array4009/1
    public static int largest(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE;
        for(int num:arr){
            if(num > largest){
                largest = num;
            }
        }

        return largest;
    }
}
