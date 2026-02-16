package stacks_queues.leetcodeProblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class L402_RemoveKElements {

    public static void main(String[] args) {

    }

    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        String ans = "";
        int i=0;
        for(char ch: num.toCharArray()){
            int digit = ch - '0';
            while(!stack.isEmpty() && i < k && stack.getLast() > digit){
                stack.removeLast();
                i++;
            }
            stack.addLast(digit);
        }
        while(!stack.isEmpty() && i < k){
            stack.removeLast();
            i++;
        }
        while(!stack.isEmpty()){
            ans = ans + stack.removeFirst().toString();
        }
        while(ans.startsWith("0")){
            ans = ans.substring(1);
        }

        return (!ans.isEmpty())?ans:"0";
    }
}
