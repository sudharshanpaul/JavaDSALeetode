package bitManipulation;

public class Main {

    public static void main(String[] args) {
        System.out.println(convertDecimal("1111"));
        System.out.println(convertBinary(0));
    }

    // Conversion of a binary number to decimal
    public static int convertDecimal(String num){
        int ans = 0;
        int p = 1;
        for(int i=num.length()-1; i >=0; i--){
            if(num.charAt(i) == '1'){
                ans += p;
            }
            p *= 2;
        }
        return ans;
    }

    // Conversion of Decimal to binary
    public static String convertBinary(int num){
        StringBuilder ans = new StringBuilder();
        while(num > 1){
            if(num %2 == 0){
                ans.append('0');
            }else{
                ans.append('1');
            }
            num /= 2;
        }
        if(num == 1){
            ans.append('1');
        }else{
            ans.append('0');
        }
        return ans.reverse().toString();

    }
}
