package stacks_queues.leetcodeProblems;

import java.util.Stack;

public class L901_OnlineStockPlan {

    public static void main(String[] args) {

    }
}

class StockSpanner {

    private Stack<Node> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while(!stack.isEmpty() && stack.peek().value <= price){
            int value = stack.pop().no_of_pops;
            ans += value;
        }
        Node node = new Node(price, ans);
        stack.push(node);
        return ans;
    }

    class Node{
        int value;
        int no_of_pops;
        public Node(int value, int no_of_pops){
            this.value = value;
            this.no_of_pops = no_of_pops;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
