package binarySearchProblems;

public class L_1095_FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {3,5,3,2,0};
        System.out.println(findInMountainArray1(3,arr));
    }
    //https://leetcode.com/problems/find-in-mountain-array/

    //Here I.m giving 2 approaches in which both time complexities are same O(logn)
    //Approach1 is so easy to understand and better in terms of space complexity
    //Approach 2 is a bit more hard to understand and it requires more space compared to approach one

    //Approach 1
    //First find the peak index and then search in left and right part seperately
    //If you find in first part return it first
    public static int findInMountainArray1(int target,int[] mountainArr){
        int peak = findPeak(mountainArr);
        int ans = agnosticBinarySearch(mountainArr,0,peak,target,true);
        if(ans==-1){
            ans = agnosticBinarySearch(mountainArr,peak,mountainArr.length-1,target,false);
        }
        return ans;
    }
    public static int findPeak(int[] mountainArr){
        int start = 0;
        int end = mountainArr.length-1;
        while(start!=end){
            int mid = start + (end-start)/2;
            if(mountainArr[mid]>=mountainArr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }



    // Approach 2
    public static int findInMountainArray(int target, int[] mountainArr) {
        int start = 0;
        int end = mountainArr.length-1;
        int ans1 = -1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mountainArr[mid]<mountainArr[mid+1] && target>mountainArr[mid]){
                start = mid+1;
            }
            else if(mountainArr[mid]>mountainArr[mid+1] && target>mountainArr[mid]){
                end = mid-1;
            }
            else if(mountainArr[mid]<mountainArr[mid+1]){
                int ans = agnosticBinarySearch(mountainArr,start,mid,target,true);
                if(ans!=-1){
                    return ans;
                }
                start = mid+1;
            }
            else{
                if(ans1==-1)
                    ans1 = agnosticBinarySearch(mountainArr,mid,end,target,false);
                end = mid-1;
            }
        }
        if(mountainArr[start]==target){
            return start;
        }else if(ans1!=-1){
            return ans1;
        }else{
            return -1;
        }
    }

    public static int agnosticBinarySearch(int[] array,int start,int end,int target,boolean isAsc) {

        while(start<=end) {
            //int middle = (start+end)/2;  int start+end exceeds if both the start and end values are too large
            int mid = start+(end-start)/2;
            if(array[mid]==target){
                return mid;
            }
            else{
                if(isAsc){
                    if(array[mid]<target){
                        start = mid+1;
                    }else{
                        end = mid-1;
                    }
                }else{
                    if(array[mid]<target){
                        end = mid-1;
                    }else{
                        start = mid+1;
                    }
                }
            }
        }
        return -1;
    }
}
