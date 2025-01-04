package strings_Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L1930_Unique3LengthPalindromeStrings {

    public static void main(String[] args) {

        String str = "bbcbaba";
        System.out.println(countPalindromicSubsequence(str));

    }

    //https://leetcode.com/problems/unique-length-3-palindromic-subsequences/submissions/1497323850/?envType=daily-question&envId=2025-01-04
    public static int countPalindromicSubsequence(String s){

        HashSet<String> ans = new HashSet<String>();
        int count = 0;
        for(int i=0;i<s.length()-2;i++){
            if(ans.contains(s.charAt(i)+"")) continue;;
            for(int j=s.length()-1;j>=i+2;j--){
                if(s.charAt(i)==s.charAt(j)){
                    ans.add(s.charAt(i)+"");
                    count += noOfUnique(s,i,j);
                    break;
                }
            }
        }
        return count;
    }

    public static int noOfUnique(String s,int i,int j){
        HashSet<String> ans = new HashSet<>();
        for(int start = i+1; start<j;start++){
            ans.add(s.charAt(start)+"");
        }
        return ans.size();
    }

    //It exceeds the time limit
    public static int countPalindromicSubsequence1(String s) {

        HashSet<String> ans = new HashSet<>();

        for(int i=0;i<=s.length()-3;i++){
            for(int j=i+1;j<=s.length()-2;j++){
                for(int k=j+1;k<s.length();k++){
                    if(s.charAt(i)!=s.charAt(k)) continue;
                    ans.add(s.charAt(i)+"" + s.charAt(j) + s.charAt(k));
                }
            }
        }
        return ans.size();
    }





}
