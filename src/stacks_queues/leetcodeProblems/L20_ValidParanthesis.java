package stacks_queues.leetcodeProblems;

import java.util.Stack;

public class L20_ValidParanthesis {

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if(ch == '['){
                stack.push(']');

            }else{
                if(stack.isEmpty() || stack.pop() != ch){
                    return false;
                }
            }

        }

        return stack.isEmpty();

    }

    // Brute - Force
    public static boolean isValid1(String s){
         Stack<Character> stack = new Stack<>();
         for(int i=0; i<s.length(); i++){
             char c = s.charAt(i);
             if(stack.isEmpty()){
                 stack.push(c);
             }else{
                 if(c == ')' && stack.peek()=='('){
                     stack.pop();
                 }else if(c == '}' && stack.peek()=='{'){
                     stack.pop();
                 }else if(c == ']' && stack.peek()=='['){
                     stack.pop();
                 }else{
                     stack.push(c);
                 }
             }
         }

         return stack.isEmpty();
    }
}
