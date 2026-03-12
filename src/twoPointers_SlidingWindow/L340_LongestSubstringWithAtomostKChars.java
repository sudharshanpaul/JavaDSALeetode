package twoPointers_SlidingWindow;

import java.util.HashMap;

public class L340_LongestSubstringWithAtomostKChars {

    public static void main(String[] args) {
        String str = "aaabbccd";
        System.out.println(longestSubStringKCharsLen(str, 2));
    }

    public static String longestSubStringKChars(String string, int k){
        int maxLen = 0;
        String ans = "";
        int left = 0;
        int no_of_chars = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        if(k == 0){
            return ans;
        }
        for(int right = 0; right < string.length(); right++){
            char ch = string.charAt(right);
            if(no_of_chars == k && (!map.containsKey(ch) || map.get(ch) == 0)){
                while(no_of_chars == k){
                    map.put(string.charAt(left), map.get(string.charAt(left)) - 1);
                    if(map.get(string.charAt(left)) == 0){
                        no_of_chars--;
                    }
                    left++;
                }
            }
            if(map.containsKey(ch) && map.get(ch) != 0){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
                no_of_chars++;
            }
            if((right - left + 1) > maxLen){
                ans = string.substring(left, right+1);
                maxLen = right - left +1;
            }
        }

        return ans;
    }

    public static int longestSubStringKCharsLen(String string, int k){
        int maxLen = 0;
        int left = 0;
        int no_of_chars = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        if(k == 0){
            return 0;
        }
        for(int right = 0; right < string.length(); right++){
            char ch = string.charAt(right);
            if(no_of_chars > k){
                map.put(string.charAt(left), map.get(string.charAt(left)) - 1);
                if(map.get(string.charAt(left)) == 0){
                    no_of_chars--;
                }
                left++;
            }
            if(map.containsKey(ch) && map.get(ch) != 0){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
                no_of_chars++;
            }
            if(no_of_chars <= k){
                maxLen = Math.max(maxLen, right-left+1);
            }
        }

        return maxLen;
    }
}
