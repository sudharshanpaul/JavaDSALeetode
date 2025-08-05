package arrayProblems.striverSheet.easy;

public class GFG_SecondLargest_in_Array {

    // https://www.geeksforgeeks.org/problems/second-largest3735/1
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = -1;
        int secLargest = -1;
        for(int num : arr){
            if(largest == -1){
                largest = num;
            }else if(num > largest){
                secLargest = largest;
                largest = num;
            }else if(num > secLargest && num != largest){
                secLargest = num;
            }
        }

        return (secLargest == largest)?-1:secLargest;
    }
}
