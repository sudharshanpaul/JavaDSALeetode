package mathsForDSA;

public class L50_CalculatingPower {
    public static void main(String[] args) {
        System.out.println(myPow(2,-2));
    }

    public static double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n==-1){
            return 1/x;
        }
        if(n>1){
            double result = myPow(x,n/2);
            if(n%2 == 0){
                return result * result;
            }else{
                return result * result * x;
            }
        }else{
            double result = myPow(x,n/2);
            if(n%2==0){
                return result*result;
            }else{
                return result*result*1/x;
            }
        }
    }
}
