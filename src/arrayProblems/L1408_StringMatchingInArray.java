package arrayProblems;

import java.util.ArrayList;
import java.util.List;

public class L1408_StringMatchingInArray {

    public static void main(String[] args) {

        String[] words = {"mass","as","hero","superhero"};
        System.out.println(stringMatching(words));

    }


    // https://leetcode.com/problems/string-matching-in-an-array/submissions/1500647664/?envType=daily-question&envId=2025-01-07
    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(isSubStringElement(words,i)){
                ans.add(words[i]);
            }
        }

        return ans;
    }

    public static boolean isSubStringElement(String[] arr,int index){
        for(int i=0;i<arr.length;i++){
            if(i==index) continue;
            else{
                 if(arr[i].contains(arr[index])) return true;
            }
        }
        return false;
    }

    public static List<String> stringMatching2(String[] words) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i==j) continue;
                else{
                    if(words[j].contains(words[i])){
                        ans.add(words[i]);
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
