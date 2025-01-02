package arrayProblems.arrays2D;

import java.util.Arrays;

public class L2559_CountVowelStringsInRange {

    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};
        System.out.println(queries.length);
        System.out.println(Arrays.toString(vowelStrings1(words,queries)));

    }

    //https://leetcode.com/problems/count-vowel-strings-in-ranges/?envType=daily-question&envId=2025-01-02

    public static int[] vowelStrings1(String[] words,int[][] queries){
        int[] prefixSum = new int[words.length];
        for(int i=0;i<words.length;i++){
            if(i==0 && isVowelString(words[i])){
                prefixSum[0] = 1;
            }
            else if(i==0){
                continue;
            }
            else if(isVowelString(words[i])){
                prefixSum[i] = prefixSum[i-1] + 1;
            }else{
                prefixSum[i] = prefixSum[i-1];
            }
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==0){
                ans[i] = prefixSum[queries[i][1]] ;
            }else{
                ans[i] = prefixSum[queries[i][1]] - prefixSum[queries[i][0]-1] ;
            }
        }

        return ans;
    }


    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int j=0;
        for(int[] range:queries){
            for(int i=range[0];i<=range[1];i++){
                if(isVowelString(words[i])){
                    ans[j]+=1;
                }
            }
            j++;
        }

        return ans;
    }
    public static boolean isVowelString(String str){
        return (str.startsWith("a") || str.startsWith("e")||str.startsWith("i")||str.startsWith("o")||str.startsWith("u")) &&
                (str.endsWith("a") || str.endsWith("e")||str.endsWith("i")||str.endsWith("o")||str.endsWith("u"));
    }

}
