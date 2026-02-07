package stacks_queues.leetcodeProblems;

import java.util.*;

public class L735_AsteroidCollision {
    public static void main(String[] args) {
        int[] ast = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(ast)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int num: asteroids){
            if(stack.isEmpty() && num < 0){
                list.add(num);
            }else if(num > 0){
                stack.push(num);
            }else{
                while((!stack.isEmpty() && Math.abs(num)>stack.peek())){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    list.add(num);
                }else if(stack.peek() == Math.abs(num)){
                    stack.pop();
                }
            }
        }

        int[] ans = new int[list.size() + stack.size()];
        int i;
        for(i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        for(int j = ans.length-1; j>=i; j--){
            ans[j] = stack.pop();
        }
        return ans;
    }

    public int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int num: asteroids){
            if(num > 0){
                stack.push(num);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(num)>stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(num);
                }else if(Math.abs(num) == stack.peek()){
                    stack.pop();
                }
            }
        }
        int[] ans = new int[stack.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int num: asteroids){
            if(num > 0){
                stack.add(num);
            }else{
                while(!stack.isEmpty() && stack.getLast() > 0 && Math.abs(num)>stack.getLast()){
                    stack.removeLast();
                }
                if(stack.isEmpty() || stack.getLast() < 0){
                    stack.add(num);
                }else if(Math.abs(num) == stack.getLast()){
                    stack.removeLast();
                }
            }
        }
        int[] ans = new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.removeFirst();
        }
        return ans;
    }
}
