package twoPointers_SlidingWindow;

import java.util.HashMap;

public class L904_Fruits_into_bucket {

    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        int left = 0;
        int no_of_fruits = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < fruits.length; right++){
            if(no_of_fruits == 2 && (!map.containsKey(fruits[right]) || map.get(fruits[right]) == 0)){
                while(no_of_fruits == 2){
                    map.put(fruits[left], map.get(fruits[left])-1);
                    if(map.get(fruits[left]) == 0){
                        no_of_fruits--;
                    }
                    left++;
                }
            }
            if(map.containsKey(fruits[right]) && map.get(fruits[right]) != 0){
                map.put(fruits[right], map.get(fruits[right])+1);
            }else{
                map.put(fruits[right], 1);
                no_of_fruits++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
