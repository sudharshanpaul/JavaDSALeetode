package strings_Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L916WordSubSets {
    public static void main(String[] args) {

        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","oo"};
        System.out.println(wordSubsets(words1,words2));

    }

    // https://leetcode.com/problems/word-subsets/?envType=daily-question&envId=2025-01-10
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String word:words2) {
            int[] freq=getCharFrequency(word);
            for(int i=0;i<26;i++){
                maxFreq[i] = Math.max(maxFreq[i],freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String word:words1){
            int[] freq =getCharFrequency(word);
            if(isExist(freq,maxFreq)){
                ans.add(word);
            }
        }
        return ans;
    }

    public static int[] getCharFrequency(String word){
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }
        return freq;
    }

    public static boolean isExist(int[] wordFreq,int[] maxFreq){
        for(int i=0;i<26;i++){
            if(wordFreq[i]<maxFreq[i]){
                return false;
            }
        }
        return true;
    }


    // This is also a possible solution but iit also takes 0(n^3) i.e. huge amount of time
    public static List<String> wordSubsets2(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        for(String str:words1){
            if(isSubSetExist(str,words2)){
                ans.add(str);
            }
        }
        return ans;
    }

    public static boolean isSubSetExist(String word,String[] words){
        int[] charFreq = new int[26];
        for(int i=0;i<word.length();i++){
            charFreq[word.charAt(i)-'a']++;
        }
        for(String str:words){
            int[] wordFreq = new int[26];
            for(int i=0;i<str.length();i++){
                wordFreq[str.charAt(i)-'a']++;
            }
            for(int i=0;i<wordFreq.length;i++){
                if(wordFreq[i]==0){
                    continue;
                }else{
                    if(charFreq[i]<wordFreq[i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    // This is a possible solution but this takes huge amount of time
    public static List<String> wordSubsets1(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        for(String str:words1){
            if(isSubSets(str,words2)){
                ans.add(str);
            }
        }
        return ans;
    }

    public static boolean isSubSets(String word,String[] list){
        for(String str:list){
            HashSet<Integer> sub = new HashSet<>();
            for(int i=0;i<str.length();i++){
                boolean isTrue=true;
                for(int j=0;j<word.length();j++){
                    if(str.charAt(i)==word.charAt(j) && !sub.contains(j)){
                        sub.add(j);
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue){
                    return false;
                }
            }
            if(sub.size()!=str.length()){
                return false;
            }
        }
        return true;
    }
}
