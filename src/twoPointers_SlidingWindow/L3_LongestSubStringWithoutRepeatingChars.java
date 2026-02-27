package twoPointers_SlidingWindow;

import java.util.HashMap;

public class L3_LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring1(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        String ansString = "";
        while(right < s.length()){
            char ch = s.charAt(right);
            if(ansString.indexOf(ch) != -1){
                int index = ansString.indexOf(ch);
                ansString = ansString.substring(index+1);
                left = left + index+1;
            }
            ansString = ansString + ch+"";
            ans = Math.max(ans, (right-left+1));
            right++;
        }

        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int right = 0;
        int left = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch)+1);
            }
            map.put(ch, right);
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}
