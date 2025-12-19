package bitManipulation.leecodeProblems;

public class L29_Divide2Numbers {

    public static void main(String[] args) {

    }

    public static int divide(int dividend, int divisor) {
        boolean sign = sign(dividend, divisor);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long ans = 0;

        while(a >= b){
            long temp = 1;
            while(b*temp*2 <= a){
                temp *= 2;
            }
            ans += temp;
            a -= (b*temp);
        }

        if(ans > (long)Integer.MAX_VALUE && sign){
            return Integer.MAX_VALUE;
        }
        if(ans < (long)Integer.MIN_VALUE && !sign){
            return Integer.MIN_VALUE;
        }

        return (sign)? (int)ans: (int)(-1*ans);
    }

    public static boolean sign(int num1, int num2){
        return (num1>=0) == (num2>=0);
    }
}
