package twoPointers_SlidingWindow;

public class L1423_MaximumPointsCards {

    public static void main(String[] args) {

    }

    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = cardPoints.length;
        int sum = 0;
        for(left = 0; left < k; left++){
            sum += cardPoints[left];
        }
        int ans = sum;
        while(left>0){
            sum -= cardPoints[--left];
            sum += cardPoints[--right];
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public int maxScore2(int[] cardPoints, int k) {
        int sum = 0;
        int right = 0;
        int left = 0;
        for(right = 0; right < cardPoints.length-k; right++){
            sum += cardPoints[right];
        }
        int minSum = sum;
        int arrSum = sum;
        while(right < cardPoints.length && left < cardPoints.length){
            arrSum += cardPoints[right];
            sum -= cardPoints[left];
            sum += cardPoints[right];
            left++;
            right++;
            minSum = Math.min(minSum, sum);
        }


        return arrSum - minSum;
    }
}
