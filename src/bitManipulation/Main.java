package bitManipulation;

public class Main {

    public static void main(String[] args) {
        System.out.println(convertDecimal("1111"));
        System.out.println(convertBinary(0));

        int a = 10;
        int b= 20;
        swap(a, b);

        System.out.println(isISet(13, 2));
        System.out.println(isISet2(13, 2));

        System.out.println(setIBit(13, 1));
        System.out.println(clearIBit(13, 2));
        System.out.println(toggleIBit(13, 2));

        System.out.println(removelast1Bit(16));
        System.out.println(isPowerOf2(12));

        System.out.println(countNoOfSetBits(13));
        System.out.println(countNoOfSetBits2(15));
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

    // Swapping of 2 Numbers
    public static void swap(int a, int b){
        System.out.println("Initially a = "+a+ " b = "+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping a = "+a+ " b = "+b);
    }

    // Check if ith Bit is set or not
    public static boolean isISet(int num, int i){
        if(((num >> i) & 1) != 0){
            return true;
        }
        return false;
    }

    public static boolean isISet2(int num, int i){
        if(((1 << i) & num) != 0){
            return true;
        }
        return false;
    }

    // Setting the 'i' bit
    public static int setIBit(int num, int i){
        return num | (1 << i);
    }

    // Clearing the 'i' bit
    public static int clearIBit(int num, int i){
        return num & ~(1 << i);
    }

    // Toggle the 'i' bit
    public static int toggleIBit(int num, int i){
        return num ^ (1 << i);
    }

    // Remove the last set bit
    public static int removelast1Bit(int num){
        return num & (num - 1);
    }

    // is the number power of 2
    public static boolean isPowerOf2(int num){
        if((num & (num - 1)) == 0){
            return true;
        }
        return false;
    }

    // count number of set bits
    public static int countNoOfSetBits(int num){
        if(num == 0){
            return 0;
        }
        int ans = 0;
        while(num > 1){
            if((num & 1) == 1){
                ans++;
            }
            num = num >> 1;
        }
        return ans + 1;
    }

    public static int countNoOfSetBits2(int num){
        int ans = 0;
        while(num != 0){
            ans ++;
            num = num & (num - 1);
        }
        return ans;
    }
}
