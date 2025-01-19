package back_Tracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L282_ExpressionAddOperators {

    public static void main(String[] args) {
        System.out.println(addOperators("123",6));
    }

    // https://leetcode.com/problems/expression-add-operators/description/?envType=problem-list-v2&envId=backtracking
    public static List<String> addOperators(String num, int target) {
        if(num.isEmpty()){
            return new ArrayList<>();
        }
        return helper(num,target,"",0);
    }

    public static List<String> helper(String num,int target,String p,int currentValue){
        List<String> ans = new ArrayList<>();
        if(target == currentValue && num.isEmpty()){
            ans.add(p);
            return ans;
        }
        if(p.isEmpty()){
            ans.addAll(helper(num.substring(1),target,p+num.charAt(0),currentValue+num.charAt(0)-'0'));
        }else if(!num.isEmpty()){
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    ans.addAll(helper(num.substring(1), target,p+"+"+num.charAt(0),currentValue+num.charAt(0)-'0'));
                }
                if (i == 1) {
                    ans.addAll(helper(num.substring(1),target,p+"*"+num.charAt(0),evaluate(p+"*"+num.charAt(0))));
                }
                if (i == 2) {
                    ans.addAll(helper(num.substring(1),target, p+"-"+num.charAt(0),currentValue-num.charAt(0)-'0'));
                }
            }
        }
        return ans;

    }

    public static int evaluate(String expression) {

        // Stacks for numbers and operators
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                // Read the full number
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                numbers.push(num);
                // Since we incremented `i` in the loop, skip the outer increment
                continue;
            } else if (ch == '+' || ch == '-' || ch == '*') {
                // Process operators with higher precedence first
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    int b = numbers.pop();
                    int a = numbers.pop();
                    char op = operators.pop();
                    numbers.push(applyOperation(a, b, op));
                }
                operators.push(ch);
            } else {
                throw new IllegalArgumentException("Invalid character in expression: " + ch);
            }
            i++;
        }

        // Process remaining operators
        while (!operators.isEmpty()) {
            int b = numbers.pop();
            int a = numbers.pop();
            char op = operators.pop();
            numbers.push(applyOperation(a, b, op));
        }

        return numbers.pop();
    }

    // Helper method to define operator precedence
    private static int precedence(char operator) {
        switch (operator) {
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    // Helper method to perform an operation
    private static int applyOperation(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

}
