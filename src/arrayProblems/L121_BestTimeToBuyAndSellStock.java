package arrayProblems;

public class L121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit2(prices));
        int[] prices2= {7,6,4,3,1};
        System.out.println(maxProfit2(prices2));
    }
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    // This is one of the approach but it is bad in time complexity
    public static int maxProfit(int[] prices) {
        //Let the profit be 0
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>profit){
                    //Comparing every element with the next elements if the difference
                    // is more than profit then profit is changed
                    profit = prices[j]-prices[i];
                }
            }
        }
        return profit;
    }
    public static int maxProfit2(int[] prices){
        int profit = 0;
        for(int i=0;i<prices.length-1;i++){
            int max=findMax(prices,i+1);
            if(prices[max]-prices[i]>profit){
                profit  = prices[max]-prices[i];
            }
        }
        return profit;
    }
    public static int findMax(int[] prices,int start){
        int max = start;
        for(int i=start+1;i<prices.length;i++){
            if(prices[i]>prices[max]){
                max = i;
            }
        }
        return max;
    }

    //Approach 3
    public static int maxProfit3(int[] prices){
        int[] diff = new int[prices.length-1];
        for(int i=1;i<prices.length;i++){
            diff[i-1] = prices[i]-prices[i-1];
        }
        int maxDiff = findMax(diff,0);

        return 0;
    }
}
