package twoPointers_SlidingWindow;

import java.util.HashMap;

public class L76_MinimumWindowSubString {

    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        int left = 0;
        int startIndex = -1;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }
        }

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                count = (map.get(ch) > 0)? count+1:count;
                map.put(ch, map.get(ch)-1);
            }

            while(count == t.length() && left<s.length()){
                if(minLength > (right-left+1)){
                    startIndex = left;
                    minLength = right-left+1;
                }
                char c = s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                    count = (map.get(c) > 0)? count - 1: count;
                }
                left++;
            }
        }

        return (startIndex == -1)? "": s.substring(startIndex, startIndex+minLength);

    }

    public String minWindow1(String s, String t) {
        int left = 0;
        String ans = "";
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char ch: t.toCharArray()){
            if(tmap.containsKey(ch)){
                tmap.put(ch, tmap.get(ch)+1);
            }else{
                tmap.put(ch, 1);
            }
        }
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(tmap.containsKey(ch) && map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
                if(map.get(ch) <= tmap.get(ch)){
                    len++;
                }
            }else if(tmap.containsKey(ch) && !map.containsKey(ch)){
                map.put(ch, 1);
                len++;
            }
            while(len == t.length()){
                if(ans.length() > (right-left+1) || ans.isEmpty()){
                    ans = s.substring(left, right+1);
                }
                char c = s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)-1);
                    if(map.get(c) < tmap.get(c)) len--;
                    if(map.get(c) == 0){
                        map.remove(c);
                    }
                }
                left++;
            }
        }
        return ans;
    }
}
