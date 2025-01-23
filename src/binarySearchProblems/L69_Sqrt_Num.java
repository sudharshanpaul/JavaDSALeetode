package binarySearchProblems;

public class L69_Sqrt_Num {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    // https://leetcode.com/problems/sqrtx/?envType=problem-list-v2&envId=binary-search
    public static int mySqrt(int x) {
        int start = 0;
        int end = x;
        while(start <= end){
            int mid = start + (end-start)/2;
            if((long)mid*mid <= x){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }

}
