package strings_Problems;

import java.util.Arrays;

public class L14_LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    //https://leetcode.com/problems/longest-common-prefix/
    // Generally this takes less amount of time Max time is for Sorting which is 0(nlogn)

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int i=0;
        while(i<Math.min(str1.length(),str2.length())){
            if(str1.charAt(i) == str2.charAt(i)){
                i++;
            }else{
                break;
            }
        }

        return str1.substring(0,i);
    }


    // This is a possible solution but it takes large amount of time - 0(n^2)
    public static String longestCommonPrefix1(String[] strs) {
        String ans = "";
        int minLength = Integer.MAX_VALUE;
        for(String str:strs){
            if(str.length()<minLength){
                minLength = str.length();
            }
        }

        for(int i=0; i<minLength;i++){
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=ch){
                    return ans;
                }
            }
            ans += ch;
        }


        return ans;
    }

}
