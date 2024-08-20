package binarySearchProblems;

public class L_744_SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        System.out.println(nextGreatestLetter(letters,'z'));
    }

    // https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/1361358008/
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }else{
                end = mid-1;
            }
        }
        return letters[start%letters.length];
    }
}
