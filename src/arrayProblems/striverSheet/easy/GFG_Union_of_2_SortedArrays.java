package arrayProblems.striverSheet.easy;

import java.util.ArrayList;

public class GFG_Union_of_2_SortedArrays {

    // https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0, j=0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                if(!isExist(ans, a[i])){
                    ans.add(a[i]);
                }
                i++;
            }else if(a[i] == b[j]){
                if(!isExist(ans, b[j])){
                    ans.add(b[j]);
                }
                j++;
                i++;
            }else{
                if(!isExist(ans, b[j])){
                    ans.add(b[j]);
                }
                j++;
            }
        }

        while(i < a.length){
            if(!isExist(ans, a[i])){
                ans.add(a[i]);
            }
            i++;
        }
        while(j < b.length){
            if(!isExist(ans, b[j])){
                ans.add(b[j]);
            }
            j++;
        }

        return ans;
    }

    public static boolean isExist(ArrayList<Integer> ans, int val){
        if(ans.size() == 0){
            return false;
        }
        return val == ans.get(ans.size()-1);
    }
}
