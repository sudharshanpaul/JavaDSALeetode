package back_Tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L22_GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));

    }

    // https://leetcode.com/problems/generate-parentheses/description/?envType=problem-list-v2&envId=backtracking
    public static List<String> generateParenthesis(int n) {
        if(n==0){
            return new ArrayList<String>();
        }
        HashSet<String> strs = new HashSet<>();
        strs.addAll(helper("()",n-1));
        List<String> ans = new ArrayList<>();
        ans.addAll(strs);
        return ans;
    }

    public static List<String> helper(String str,int n){
        List<String> ans = new ArrayList<>();
        if(n == 0){
            ans.add(str);
            return ans;
        }
        for(int i=0;i<=str.length()/2;i++){
            ans.addAll(helper(str.substring(0,i)+"()"+str.substring(i),n-1));
        }

        return ans;
    }

}
